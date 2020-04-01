package gate.creole.ontology.util;

import gate.Gate;
import gate.GateConstants;
import gate.creole.AbstractResource;
import gate.creole.ResourceData;
import gate.creole.metadata.AutoInstance;
import gate.creole.metadata.CreoleResource;
import gate.gui.ActionsPublisher;
import gate.gui.MainFrame;
import gate.resources.img.svg.RefreshIcon;
import gate.swing.XJFileChooser;
import gate.util.ExtensionFileFilter;
import gate.util.Files;
import gate.util.GateRuntimeException;
import gate.util.persistence.PersistenceManager;
import gate.util.persistence.UpgradeXGAPP;

import org.apache.log4j.Logger;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;
import org.jdom.xpath.XPath;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@CreoleResource(tool = true, name = "Upgrade old saved application", isPrivate = true, autoinstances = @AutoInstance)
public class UpgradeOntologyXGAPP extends AbstractResource implements ActionsPublisher {

  private static final Logger log = Logger.getLogger(UpgradeOntologyXGAPP.class);

  @Override
  public List<Action> getActions() {
    return Arrays.asList(new UpgradeAction());
  }

  private static class UpgradeAction extends AbstractAction {

    private static XMLOutputter outputter =
            new XMLOutputter(Format.getPrettyFormat());


    UpgradeAction() {
      super("Upgrade old saved application", new RefreshIcon(24, 24));
      putValue(GateConstants.MENU_PATH_KEY, new String[] { "Ontologies" });
      putValue(Action.SHORT_DESCRIPTION, "Fix references to the old pre-8.5 " +
              "Ontology plugin in a saved application so it will load into this version " +
              "of GATE.  You may also need to \"Upgrade Xgapp\" in the usual way.");
    }

    @SuppressWarnings("unchecked")
    @Override
    public void actionPerformed(ActionEvent event) {
      ResourceData rd = Gate.getCreoleRegister().get("gate.creole.ontology.impl.sesame.OWLIMOntology");
      if(rd == null) {
        // this should not be possible
        throw new GateRuntimeException("Ontology plugin not loaded!");
      }
      URL ontologyPluginCreoleXml = rd.getXmlFileUrl();
      final File ontologyPluginDir;
      try {
        ontologyPluginDir = Files.fileFromURL(ontologyPluginCreoleXml).getParentFile();
      } catch(IllegalArgumentException ex) {
        log.error("Upgrade not possible - Ontology plugin loaded from a non-file: URL");
        return;
      }

      XJFileChooser fileChooser = MainFrame.getFileChooser();

      ExtensionFileFilter filter = new ExtensionFileFilter(
              "GATE Application files (.gapp, .xgapp)", ".gapp", ".xgapp");
      fileChooser.resetChoosableFileFilters();
      fileChooser.addChoosableFileFilter(filter);
      fileChooser.setFileFilter(filter);
      fileChooser.setDialogTitle("Select an XGapp to Upgrade");
      fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
      fileChooser.setResource("lastapplication");

      if(fileChooser.showOpenDialog(
              MainFrame.getInstance()) != XJFileChooser.APPROVE_OPTION)
        return;

      try {
        File originalXGapp = fileChooser.getSelectedFile().getCanonicalFile();

        MainFrame.lockGUI("Fixing references to Ontology plugin");
        new Thread(() -> {
          final List<UpgradeXGAPP.UpgradePath> upgrades;
          final Document doc;
          try {
            try {
              SAXBuilder builder = new SAXBuilder(false);
              doc = builder.build(originalXGapp);

              XPath xpath = XPath.newInstance(
                      "/*/urlList/localList/gate.util.persistence.PersistenceManager-URLHolder" +
                              "[urlString = '$gatehome$plugins/Ontology' " +
                              "or urlString = '$gatehome$plugins/Ontology/' " +
                              "or urlString = '$gateplugins$Ontology' " +
                              "or urlString = '$gateplugins$Ontology/']");
              List<Element> ontologyPluginElements = xpath.selectNodes(doc);

              if(ontologyPluginElements == null || ontologyPluginElements.isEmpty()) {
                JOptionPane.showMessageDialog(MainFrame.getInstance(),
                        "The selected app does not reference the pre-GATE-8.5 Ontology plugin " +
                                "- it may already have been upgraded.",
                        "Upgrade XGapp", JOptionPane.INFORMATION_MESSAGE);
                return;
              }

              String ontologyPluginRelpath = PersistenceManager.URLHolder.relativize(originalXGapp, ontologyPluginDir);

              List<UpgradeXGAPP.UpgradePath> upgradePaths = ontologyPluginElements.stream().map((elt) ->
                new OntologyPluginUpgradePath(elt, ontologyPluginRelpath)
              ).collect(Collectors.toList());

              UpgradeXGAPP.upgrade(doc, upgradePaths);

              if(!originalXGapp
                      .renameTo(new File(originalXGapp.getAbsolutePath() + ".bak"))) {
                System.err.println("unable to back up existing xgapp");
                return;
              }

              try(FileOutputStream out = new FileOutputStream(originalXGapp)) {
                outputter.output(doc, out);
              }
            } catch(Exception e) {
              log.error("Problem parsing GAPP file", e);
              return;
            }
          } finally {
            MainFrame.unlockGUI();
          }
        }).start();
      } catch(IOException e) {
        log.error("Can't canonicalise file " + fileChooser.getSelectedFile(), e);
      }
    }
  }

  private static class OntologyPluginUpgradePath extends UpgradeXGAPP.UpgradePath {
    private String newPluginPath;
    public OntologyPluginUpgradePath(Element oldEntry, String newPluginPath) {
      super(oldEntry, oldEntry.getChildText("urlString"), null, null, null, null, null);
      this.setUpgradeStrategy(UpgradeStrategy.UPGRADE);
      this.newPluginPath = newPluginPath;
    }

    @Override
    public String newPathFor(String urlSuffix) {
      return newPluginPath +
              (!(newPluginPath.endsWith("/") || newPluginPath.endsWith("$")) && !urlSuffix.startsWith("/") ? "/" : "")
              + urlSuffix;
    }

    @Override
    protected Element getNewElement() {
      Element newElement = (Element)getOldElement().clone();
      newElement.getChild("urlString").setText(newPluginPath);
      return newElement;
    }
  }
}
