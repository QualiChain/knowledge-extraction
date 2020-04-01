package services.annotation;

import gate.*;
import gate.creole.*;
import gate.util.GateException;
import gate.creole.gazetteer.FlexibleGazetteer;
import gate.creole.gazetteer.Gazetteer;

import java.util.ArrayList;

public class SkillAnnotationApp {

	/* The Corpus Pipeline application
	 * This creates a "corpus pipeline"
	 * application that can be used to annotate sets of documents
	 * based on ontology gazetteer in the annotation/extraction system.
	 */
	
	
	
	public ConditionalSerialAnalyserController createResources (Gazetteer ontrootgaz) throws GateException{

		ConditionalSerialAnalyserController skillannotator = (ConditionalSerialAnalyserController)Factory
				.createResource("gate.creole.ConditionalSerialAnalyserController");

		System.out.print("\t* Loading gate.creole.annotdelete.AnnotationDeletePR ... ");
		skillannotator.add((ProcessingResource)Factory.createResource("gate.creole.annotdelete.AnnotationDeletePR"));
		System.out.println("done");
		
		System.out.print("\t* Loading gate.creole.tokeniser.DefaultTokeniser ... ");
		skillannotator.add((ProcessingResource)Factory.createResource("gate.creole.tokeniser.DefaultTokeniser"));
		System.out.println("done");

		//add my defined Gazetteer
		FeatureMap param = Factory.newFeatureMap();
		param.put("listsURL", getClass().getClassLoader().getResource("gazetteer/lists.def").toExternalForm());
		skillannotator.add((ProcessingResource) Factory.createResource("gate.creole.gazetteer.DefaultGazetteer", param));


		String[] processingResources = {
				"gate.creole.splitter.RegexSentenceSplitter",
				"gate.creole.POSTagger",
		        "gate.creole.morph.Morph",
				"gate.creole.ANNIETransducer"};
				
//		CorpusController skillannotator = (CorpusController)Factory.createResource("gate.creole.SerialAnalyserController");



		for(int pr = 0; pr < processingResources.length; pr++) {
		      System.out.print("\t* Loading " + processingResources[pr] + " ... ");
		      skillannotator.add((ProcessingResource)Factory.createResource(processingResources[pr]));
		      System.out.println("done");
		    }


		FeatureMap params = Factory.newFeatureMap();
		ArrayList<String> inputFeature = new ArrayList<String>();
		inputFeature.add("Token.root");
		params.put("gazetteerInst", ontrootgaz);
		params.put("inputFeatureNames",inputFeature);
		
		
		System.out.print("\t* Loading gate.creole.gazetteer.FlexibleGazetteer" + " ... ");
		skillannotator.add((FlexibleGazetteer)Factory.createResource("gate.creole.gazetteer.FlexibleGazetteer",
				params));
		System.out.println("done");
			    
		
		
		FeatureMap params1 = Factory.newFeatureMap();
		params1.put("inputASName", "Original markups");
		//only for evaluation to keep the default set in the list of annotation set
		//params1.put("copyAnnotations", "false"); 
		
		System.out.print("\t* Loading gate.creole.annotransfer.AnnotationSetTransfer" + " ... ");
		skillannotator.add((ProcessingResource)Factory.createResource("gate.creole.annotransfer.AnnotationSetTransfer",
				params1));
		System.out.println("done");




		// featuremaps for .jape files, specifying location of .jape files
		FeatureMap startJapeFeature = Factory.newFeatureMap();
		startJapeFeature.put("grammarURL", getClass().getClassLoader().getResource("JAPE/main_job_post.jape").toExternalForm());
		System.out.print("\t* Loading gate.creole.Transducer ... ");
		ProcessingResource la = (ProcessingResource)Factory.createResource("gate.creole.Transducer",startJapeFeature);
		skillannotator.add(la);
		skillannotator.setRunningStrategy(9, new AnalyserRunningStrategy(
                (LanguageAnalyser) la, RunningStrategy.RUN_CONDITIONAL,
                "docType", "jobPost"));

        // featuremaps for .jape files, specifying location of .jape files
        startJapeFeature = Factory.newFeatureMap();
        startJapeFeature.put("grammarURL", getClass().getClassLoader().getResource("JAPE/main_course_desc.jape").toExternalForm());
        System.out.print("\t* Loading gate.creole.Transducer ... ");
        la = (ProcessingResource)Factory.createResource("gate.creole.Transducer",startJapeFeature);
        skillannotator.add(la);
        skillannotator.setRunningStrategy(10, new AnalyserRunningStrategy(
                (LanguageAnalyser) la, RunningStrategy.RUN_CONDITIONAL,
                "docType", "courseDescription"));

        // featuremaps for .jape files, specifying location of .jape files
        startJapeFeature = Factory.newFeatureMap();
        startJapeFeature.put("grammarURL", getClass().getClassLoader().getResource("JAPE/main_cv.jape").toExternalForm());
        System.out.print("\t* Loading gate.creole.Transducer ... ");
        la = (ProcessingResource)Factory.createResource("gate.creole.Transducer",startJapeFeature);
        skillannotator.add(la);
        skillannotator.setRunningStrategy(11, new AnalyserRunningStrategy(
                (LanguageAnalyser) la, RunningStrategy.RUN_CONDITIONAL,
                "docType", "cv"));

        System.out.println("done");

	    skillannotator.setName("Skills annotator");  
		return skillannotator;
		
		
	}
}
