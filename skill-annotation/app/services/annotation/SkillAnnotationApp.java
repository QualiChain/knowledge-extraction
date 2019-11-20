package services.annotation;

import gate.Gate;
import gate.util.GateException;
import gate.Factory;
import gate.FeatureMap;
import gate.creole.ANNIEConstants;
import gate.creole.SerialAnalyserController;
import gate.CorpusController;
import gate.creole.gazetteer.FlexibleGazetteer;
import gate.creole.gazetteer.Gazetteer;

import java.util.ArrayList;
import java.io.File;
import java.net.MalformedURLException;

import org.apache.log4j.PropertyConfigurator;

public class SkillAnnotationApp {

	/* The Corpus Pipeline application
	 * This creates a "corpus pipeline"
	 * application that can be used to annotate sets of documents
	 * based on ontology gazetteer in the annotation/extraction system.
	 */

	public CorpusController createResources (Gazetteer ontrootgaz) throws GateException, MalformedURLException {
		
		try {
		
			//need Tools plugin for the Morphological Analyser and Flexible Gazetteer
			Gate.getCreoleRegister().registerDirectories(
				new File(Gate.getPluginsHome(), "Tools").toURL());
		
			//Load ANNIE for the Document Reset PR, RegEx Sentence Splitter, Tokeniser and POS Tagger
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
				"gate.creole.annotdelete.AnnotationDeletePR",
				"gate.creole.splitter.RegexSentenceSplitter",
				"gate.creole.tokeniser.DefaultTokeniser",
				"gate.creole.POSTagger",
//				Transducer
		        "gate.creole.morph.Morph"};
				
		CorpusController skillannotator = (CorpusController)Factory
		            .createResource("gate.creole.SerialAnalyserController");

		for(int pr = 0; pr < processingResources.length; pr++) {
		      System.out.print("\t* Loading " + processingResources[pr] + " ... ");
		     
		     ((SerialAnalyserController)skillannotator).add((gate.LanguageAnalyser)Factory
		              .createResource(processingResources[pr]));
		      
		      System.out.println("done");
		    }
		
		
		
		FeatureMap params = Factory.newFeatureMap();
		ArrayList<String> inputFeature = new ArrayList<String>();
		inputFeature.add("Token.root");
		params.put("gazetteerInst", ontrootgaz);
		params.put("inputFeatureNames",inputFeature);
		
		
		System.out.print("\t* Loading gate.creole.gazetteer.FlexibleGazetteer" + " ... ");
		((SerialAnalyserController)skillannotator).add((FlexibleGazetteer)Factory.createResource("gate.creole.gazetteer.FlexibleGazetteer",
				params));
		System.out.println("done");
			    
		
		
		FeatureMap params1 = Factory.newFeatureMap();
		params1.put("inputASName", "Original markups");
		//only for evaluation to keep the default set in the list of annotation set
		//params1.put("copyAnnotations", "false"); 
		
		System.out.print("\t* Loading gate.creole.annotransfer.AnnotationSetTransfer" + " ... ");
		((SerialAnalyserController)skillannotator).add((gate.LanguageAnalyser)Factory.createResource("gate.creole.annotransfer.AnnotationSetTransfer",
				params1));
		System.out.println("done");
		
		// featuremaps for .jape files, specifying location of .jape files
		FeatureMap startJapeFeature = Factory.newFeatureMap();
		//startJapeFeature.put("inputASName","Default");
		
		startJapeFeature.put("grammarURL", new File("src/grammar/main_xml.jape").toURI().toURL());
		//--------------------------------------------------------------------
		//for evaluation purpose
		//startJapeFeature.put("grammarURL", new File("src/grammar/main.jape").toURI().toURL());
		//--------------------------------------------------------------------
		
		// load JAPE language resources with specified features 
		 System.out.print("\t* Loading gate.creole.Transducer ... ");
	     
		 ((SerialAnalyserController)skillannotator).add((gate.LanguageAnalyser)Factory
	              .createResource("gate.creole.Transducer",startJapeFeature));
	      System.out.println("done");
	      
	      
	    skillannotator.setName("Skills annotator");  
		return skillannotator;
		
		
	}
}
