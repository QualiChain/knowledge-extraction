package services.annotation;
import java.util.*;

import gate.creole.gazetteer.Gazetteer;
import gate.creole.ontology.Ontology;

import java.io.*;
import java.net.*;


import gate.*;
import gate.creole.*;
import gate.util.*;

/**
 * Class to get all data from the document using GATE modules. 
 *
 */
public class GateResources {

	private static Corpus corpus;
	private Ontology ontology;
	private Gazetteer gaz;
	private CorpusController skillann;
	private static GateResources instance = null;



	/**
	 * Singleton constructor to initialize GATE. This takes a couple of seconds,
	 * and we do not want to do this for each instance
	 * @throws GateException
	 * @throws IOException
	 * @throws URISyntaxException
	 */
	protected GateResources(String gateHome) throws GateException, IOException, URISyntaxException{
		Gate.setGateHome(new File(gateHome));
		File GateHome = Gate.getGateHome();
		Properties props = System.getProperties();
		props.setProperty("M2_SETTINGS_XML", String.valueOf(new File(gateHome,"settings.xml")));
		Gate.setUserConfigFile(new File(GateHome,"gate.xml"));
		File pluginsHome = new File(GateHome,"plugins");
		Gate.setPluginsHome(pluginsHome);
		Gate.init();
		ontology = loadOntology();
		gaz = createGazetteerOntologyBased(ontology);
		SkillAnnotationApp skillannotator = new SkillAnnotationApp();
		skillann = skillannotator.createResources(gaz);
		Out.prln("Processing resources are loaded");

	}

	/**
	 * Generates a singleton instance
	 * @return
	 * @throws GateException
	 * @throws URISyntaxException
	 * @throws IOException
	 */


	public static GateResources getInstance(String gateHome) throws GateException, IOException, URISyntaxException{
		if(instance == null){
			instance = new GateResources(gateHome);
		}

		return instance;
	}

	public static GateResources getInstance() throws GateException, IOException, URISyntaxException{
		return instance;

	}
	
	private void setCorpus() {
		skillann.setCorpus(corpus);
	}

	public Corpus getCorpus(){
		return corpus;
	}

	public void execute() throws GateException {

		skillann.execute();
		Out.prln("Main Pipe Line Executed.");
	}
	
	/**
	 * Builds corpus with URL
	 * @param u
	 * @throws ResourceInstantiationException
	 */
	public void buildCorpusWithDoc(URL u, String type) throws Exception {

		corpus = (Corpus) Factory.createResource("gate.corpora.CorpusImpl");
		//corpus.clear();
		FeatureMap params = Factory.newFeatureMap();
		params.put("sourceUrl", u);
		params.put("preserveOriginalContent", false);
		params.put("collectRepositioningInfo", false);
	    params.put("markupAware", true);
	    params.put("encoding", "windows-1252");
		Out.prln("Creating Gate document for " + u);
		Document d = (Document) Factory.createResource("gate.corpora.DocumentImpl", params);
//		d.setName(file.getName());
		if (type.equals(Consts.JOB_POST_TYPE) || type.equals(Consts.JOB_WATCH_TYPE)) {
			d.getFeatures().put("docType", "jobPost");
		} else if (type.equals(Consts.COURSE_TYPE)) {
			d.getFeatures().put("docType", "courseDescription");
		} else if (type.equals(Consts.CV_TYPE)){
			d.getFeatures().put("docType", "cv");
		} else {
			throw new Exception("File type not recognized");
		}
		corpus.add(d);
		setCorpus();
	}


	/**
	 * Gets specific annotations
	 * @param type
	 * @return
	 */
	public AnnotationSet getAnnotations(String type){
		if(corpus.iterator().hasNext()){
			Document doc = corpus.iterator().next();
			
			return doc.getAnnotations().get(type);
		}
		else
			return null;
	}

	
	/**
	 * Gets string from annotation
	 * @param annot
	 * @return
	 * @throws Exception
	 */
	public String getContentFromAnnot(Annotation annot) throws Exception{	
		//return (String)annot.getFeatures().get(Constants.STRING);
		return corpus.get(0).getContent().getContent(annot.getStartNode().getOffset().longValue(),annot.getEndNode().getOffset().longValue()).toString();
	}
	
	public String getContentByBoundary(long startOffset, long endOffset) throws Exception{	
		//return (String)annot.getFeatures().get(Constants.STRING);
		return corpus.get(0).getContent().getContent(startOffset,endOffset).toString();
	}	

	public void freeResources(){
		corpus.cleanup();
		Factory.deleteResource(corpus);
		
	}

	private Ontology loadOntology() throws ResourceInstantiationException {

		File pluginHome = new File (Gate.getPluginsHome(), "Ontology");
		try {
//			Gate.getCreoleRegister().registerDirectories(pluginHome.toURI().toURL());
			Plugin ontologyPlugin = new Plugin.Directory(pluginHome.toURI().toURL());
			Gate.getCreoleRegister().registerPlugin(ontologyPlugin);

		} catch (MalformedURLException | GateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		FeatureMap fm = Factory.newFeatureMap ();
		try {
//			fm.put("rdfXmlURL", getClass().getClassLoader().getResource("SkillsAndRecruitmentOntology.owl").toExternalForm());
			fm.put("turtleURL", getClass().getClassLoader().getResource("InformaticsSkills.ttl").toExternalForm());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		Ontology ont = (Ontology)Factory.createResource("gate.creole.ontology.impl.sesame.OWLIMOntology",fm);
		ont.setName("SARO");

		return ont;

	}

	private Gazetteer createGazetteerOntologyBased(Ontology ontforgaz) throws GateException{

		//load the Gazetteer_Ontology_Based

		try {

//			Gate.getCreoleRegister().registerDirectories(new File(Gate.getPluginsHome(), "Gazetteer_Ontology_Based").toURI().toURL());
			Plugin gazPlugin = new Plugin.Maven("uk.ac.gate.plugins", "gazetteer-ontology-based", "8.5");
			Gate.getCreoleRegister().registerPlugin(gazPlugin);

		} catch (GateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		OntoRootApp rootFinder = new OntoRootApp();

		FeatureMap params = Factory.newFeatureMap();
		params.put("ontology", ontforgaz);
		params.put("rootFinderApplication", rootFinder.createResources());

		Gazetteer OntoRootGazetteer = (Gazetteer)Factory
				.createResource("gate.clone.ql.OntoRootGaz",params);

		return OntoRootGazetteer;


	}

	public static class SortedAnnotationList extends Vector {
		public SortedAnnotationList() {
			super();
		} // SortedAnnotationList

		public boolean addSortedExclusive(Annotation annot) {
			Annotation currAnot = null;
			// overlapping check
			for (int i = 0; i < size(); ++i) {
				currAnot = (Annotation) get(i);
				if (annot.overlaps(currAnot)) {
					return false;
				} // if
			} // for
			long annotStart = annot.getStartNode().getOffset().longValue();
			long currStart;
			// insert
			for (int i = 0; i < size(); ++i) {
				currAnot = (Annotation) get(i);
				currStart = currAnot.getStartNode().getOffset().longValue();
				if (annotStart < currStart) {
					insertElementAt(annot, i);
					/*
					 * Out.prln("Insert start: "+annotStart+" at position: "+i+
					 * " size="+size()); Out.prln("Current start: "+currStart);
					 */
					return true;
				} // if
			} // for
			int size = size();
			insertElementAt(annot, size);
			// Out.prln("Insert start: "+annotStart+" at size position: "+size);
			return true;
		} // addSorted
	} // SortedAnnotationList

}