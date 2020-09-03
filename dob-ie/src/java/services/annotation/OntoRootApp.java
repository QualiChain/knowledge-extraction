package services.annotation;

import gate.Gate;
import gate.creole.Plugin;
import gate.util.GateException;
import gate.Factory;
import gate.creole.SerialAnalyserController;
import gate.CorpusController;


public class OntoRootApp {
	
	/* The Corpus Pipeline application
	 * This creates a "corpus pipeline"
	 * application that will be referred from rootFinder Application 
	 * in the OntoRoot Gazetteer.
	 */

	
	
	public CorpusController createResources () throws GateException {


		try {

			Plugin anniePlugin = new Plugin.Maven("uk.ac.gate.plugins", "annie", "8.5");
			Gate.getCreoleRegister().registerPlugin(anniePlugin);


			Plugin toolsPlugin = new Plugin.Maven("uk.ac.gate.plugins", "tools", "8.5");
			Gate.getCreoleRegister().registerPlugin(toolsPlugin);

			
		} catch (GateException e) {
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
