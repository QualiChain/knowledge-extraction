package services.annotation;

import gate.Gate;
import gate.util.GateException;
import gate.Factory; 
import gate.creole.ANNIEConstants;
import gate.creole.SerialAnalyserController;
import gate.CorpusController;
import java.io.File;
import java.net.MalformedURLException;

import org.apache.log4j.PropertyConfigurator;


public class OntoRootApp {
	
	/* The Corpus Pipeline application
	 * This creates a "corpus pipeline"
	 * application that will be referred from rootFinder Application 
	 * in the OntoRoot Gazetteer.
	 */

	
	
	public CorpusController createResources () throws GateException {
		

		try {
		
			//need Tools plugin for the Morphological Analyser 
			Gate.getCreoleRegister().registerDirectories(
				new File(Gate.getPluginsHome(), "Tools").toURL());
		
			//Load ANNIE for the Tokeniser and POS Tagger
			Gate.getCreoleRegister().registerDirectories(
	    	    new File(Gate.getPluginsHome(), ANNIEConstants.PLUGIN_DIR).toURL()
	    	    );
			
		
			
		} catch (GateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); 
		} 
		
		String[] processingResources = {		    	
			    	"gate.creole.tokeniser.DefaultTokeniser",
			    	"gate.creole.POSTagger",
			        "gate.creole.morph.Morph"};
		
		CorpusController rootfinder = (CorpusController)Factory
		            .createResource("gate.creole.SerialAnalyserController");
		 
		for(int pr = 0; pr < processingResources.length; pr++) {
			      System.out.print("\t* Loading " + processingResources[pr] + " ... ");
			      ((SerialAnalyserController)rootfinder).add((gate.LanguageAnalyser)Factory
			              .createResource(processingResources[pr]));
			      System.out.println("done");
			    }
		rootfinder.setName("Root finder");
		return rootfinder;
	}
	
	

}
