package services.annotation;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.*;
import java.net.URL;

import javax.xml.stream.XMLStreamException;
import javax.xml.transform.Source;

import gate.clone.ql.OntoRootGaz;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.PropertyConfigurator;

import gate.Annotation;
import gate.AnnotationSet;
import gate.Controller;
import gate.Corpus;
import gate.CorpusController;
import gate.Document;
import gate.Factory;
import gate.FeatureMap;
import gate.Gate;
import gate.Node;
import gate.creole.ANNIEConstants;
import gate.creole.ExecutionException;
import gate.creole.ResourceInstantiationException;
import gate.creole.SerialAnalyserController;
import gate.creole.gazetteer.Gazetteer;
import gate.creole.ontology.Ontology;
import gate.util.GateException;
import gate.util.InvalidOffsetException;
import gate.util.compilers.eclipse.jdt.internal.compiler.lookup.Binding;

public class Main {
		//initialize variable for corpus
		private static Corpus corpus;
		private Ontology ontology;
		private Gazetteer gaz;
		private CorpusController skillann;
		private String inputASname, outputASname;
		
		
		
		public List<String> Pipeline (List<Map.Entry<String,String>> files) throws Exception {
			//PropertyConfigurator.configure("log4j.properties");
			
			//step 1: initialize the GATE library
			//Gate.init();
			
			//show the main window
			//MainFrame.getInstance().setVisible(true);
			
			//create corpus consists of job posting files
			createCorpus(files);
			
			//create corpus from description part only in JSON file
			//createCorpusForDescOnly(files);
			
			//create corpus from XML file
			//createCorpusFromXML(files);
			
			//load the ontology
			ontology = loadOntology();
			
			//create Gazetteer Ontology Based 
			gaz = createGazetteerOntologyBased(ontology);
			
			
			SkillAnnotationApp skillannotator = new SkillAnnotationApp();
			  
			skillann = skillannotator.createResources(gaz);
			skillann.setCorpus(corpus);
			skillann.execute();

			//Calculate the number of the skills - we take the absolute number
			displayDocumentFeatures(corpus);
			
			//saveToXML(corpus);
            return saveToList(corpus);
			
			
			
			/*Factory.deleteResource(ontology);
			Factory.deleteResource(corpus);
			Factory.deleteResource(gaz);
			Factory.deleteResource(skillann);
			*/
		}

    private List<String> saveToList(Corpus corp) throws GateException {
        Iterator documentIterator = corp.iterator();
        List<String> items = new ArrayList<String>();
        while(documentIterator.hasNext()) {
            Document currDoc = (Document) documentIterator.next();
            items.add(currDoc.toXml());
        }
        return items;
    }

		private void saveToXML(Corpus corp) throws GateException, XMLStreamException, IOException{
			
			Iterator documentIterator = corp.iterator();
			
			while(documentIterator.hasNext()) {
				Document currDoc = (Document)documentIterator.next();
				File outputFile = new File ("annotation to xml/" + currDoc.getName() + ".xml");
				/*Set<String> annotTypesRequired = new HashSet<String>();
		          annotTypesRequired.add("Skill");
		          annotTypesRequired.add("datePosted");
		          annotTypesRequired.add("jobRole");
		          annotTypesRequired.add("jobTitle");
		          annotTypesRequired.add("Organization");
				  FileUtils.write(outputFile,currDoc.toXml(currDoc.getAnnotations().get(annotTypesRequired), true));
				*/
				//currDoc.getAnnotations().
                currDoc.getNamedAnnotationSets().forEach((k,v)->System.out.println("Item : " + k + " Count : " + v));
				FileUtils.write(outputFile,currDoc.toXml());		
			}
			
		}
		
		
		
		private Gazetteer createGazetteerOntologyBased(Ontology ontforgaz) throws GateException{
			
			//load the Gazetteer_Ontology_Based
			
			try {
				
				Gate.getCreoleRegister().registerDirectories(
			    		 new File(Gate.getPluginsHome(), "Gazetteer_Ontology_Based").toURI().toURL());
							
				
			} catch (GateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace(); 
			} 
			
			OntoRootApp rootFinder = new OntoRootApp();
			
			FeatureMap params = Factory.newFeatureMap();
			params.put("ontology", ontforgaz);
			params.put("rootFinderApplication", rootFinder.createResources());
			
			OntoRootGaz OntoRootGazetteer = (OntoRootGaz)Factory
		            .createResource("gate.clone.ql.OntoRootGaz",params);
			
			return OntoRootGazetteer;
			
			
		}
		
	
		
		private void createCorpus(List<Map.Entry<String,String>> files) throws GateException {
		    corpus = Factory.newCorpus("Job Advertisement");
		    int c = 0;
		    for(Map.Entry<String,String> file : files) {
		      System.out.print("\t " + (c++) + ") " + file);
		      try {
		        //corpus.add(Factory.newDocument(new File(file).toURL()));
		    	//corpus.add(Factory.newDocument((file).toURL()));
                Document d = Factory.newDocument(file.getValue());
                d.setName(file.getKey());
                corpus.add(d);
		    	//corpus.add(Factory.newDocument(file));
		    	System.out.println(" -- success");
		      }
		      catch(gate.creole.ResourceInstantiationException e) {
		        System.out.println(" -- failed (" + e.getMessage() + ")");
		      }
		      catch(Exception e) {
		        System.out.println(" -- " + e.getMessage());
		      }
		    }
		  }

		
		
		private Ontology loadOntology() throws ResourceInstantiationException {
			
			
			/*try{
			Gate.getCreoleRegister().registerDirectories(
		            new File(System.getProperty("user.dir")).toURL());
			} catch (GateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace(); 
			} */
			
			File pluginHome = new File (new File(Gate.getGateHome(),"plugins"), "Ontology");
			//Load the plugin from that directory
			try {
				Gate.getCreoleRegister().registerDirectories(pluginHome.toURI().toURL());
				
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (GateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			FeatureMap fm = Factory.newFeatureMap ();
			try {
				fm.put("rdfXmlURL", new File("SkillsAndRecruitmentOntology.owl").toURI().toURL());
				
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			

			Ontology ont = (Ontology)Factory.createResource("gate.creole.ontology.impl.sesame.OWLIMOntology",fm);		
			ont.setName("SARO");
					
			return ont;
			
		}		
		
		
			
		private void displayDocumentFeatures(Corpus corp) throws ExecutionException, InvalidOffsetException, ResourceInstantiationException {
			Iterator documentIterator = corp.iterator();
			  
			while(documentIterator.hasNext()) {
				
				gate.Document currDoc = (gate.Document)documentIterator.next();
			    //System.out.println("The features of document \""
			           //   + currDoc.getSourceUrl().getFile() + "\" are:");
			    int firstseen = 0;
			    currDoc.getFeatures().clear();
			    
			    AnnotationSet inputAnnSet = (inputASname == null || inputASname.length() == 0)
			            ? currDoc.getAnnotations()
			            : currDoc.getAnnotations(inputASname);

			    AnnotationSet outputAnnSet = (outputASname == null || outputASname.length() == 0)
			            ? currDoc.getAnnotations()
			            : currDoc.getAnnotations(outputASname);
			    
			            
			    // put the number lookup feature for the document        
			    try {
			    		/*currDoc.getFeatures().put(
			  		          "Number of Lookup",
			  		              new Integer(inputAnnSet.get(
			  		                      ANNIEConstants.LOOKUP_ANNOTATION_TYPE).size())
			  		                      .toString());*/
			  	
			    	
			  		                      
			    	
			    	
			    		AnnotationSet allLookup = inputAnnSet.get(ANNIEConstants.LOOKUP_ANNOTATION_TYPE);
			  			System.out.println();
			  			  //Iterator<Annotation> data=allLookup.iterator();	
			  			  
			  			Iterator LookupIterator = inputAnnSet.get(ANNIEConstants.LOOKUP_ANNOTATION_TYPE).iterator();
			  			  
			  			while(LookupIterator.hasNext()){
			  				 Annotation LookupAnnotation = (Annotation)LookupIterator.next();
			  				 
			  				 if(LookupAnnotation.getFeatures().get("type").equals("instance")){
			  					 
			  					 System.out.println(LookupAnnotation.toString());
			  				 }
			  			}
			  		 }catch(NullPointerException e) {
			  		      throw new ExecutionException(
			  		              "You need to run the gazetteer first!");
			  		 }
			    
			    
			    //put the first seen feature for the document
			    Iterator sentenceIterator = inputAnnSet.get(
			            ANNIEConstants.SENTENCE_ANNOTATION_TYPE).iterator(), tokenIterator;
			    
			    
			    while(sentenceIterator.hasNext()) {
			      
			    	Annotation sentenceAnnotation = (Annotation)sentenceIterator.next();
			    	tokenIterator = inputAnnSet.get(ANNIEConstants.TOKEN_ANNOTATION_TYPE,
			              sentenceAnnotation.getStartNode().getOffset(),
			              sentenceAnnotation.getEndNode().getOffset()).iterator();
			   		
			    	int firstseenCount = 0;
			    	String word = "";
			    	
			      while(tokenIterator.hasNext()) {
			        Annotation tokenAnnotation = (Annotation)tokenIterator.next();
			        if(tokenAnnotation.getFeatures().get(
			                ANNIEConstants.TOKEN_KIND_FEATURE_NAME).equals("word"))
			        {
			        word = (String)tokenAnnotation.getFeatures().get(
			                ANNIEConstants.TOKEN_STRING_FEATURE_NAME);
			        		  			        
			        if(word.equalsIgnoreCase("firstSeen")){
			        	System.out.println("sama :" + word);
			        	firstseenCount ++;
			        	
			        	try {
			            outputAnnSet.add(tokenAnnotation.getStartNode().getOffset(),
			                    tokenAnnotation.getEndNode().getOffset(), "firstSeen",
			                    gate.Factory.newFeatureMap());   
			            
			        		}
			        	catch(gate.util.InvalidOffsetException ioe) {
			            throw new ExecutionException(ioe);
			          }
			          
			        }
			        }
			      }
			      			    	  		      
			      firstseen += firstseenCount;
			      }
			    
			    //currDoc.getFeatures().put("FirstSeen",firstseen);
			    
			    //currDoc.getFeatures().put("Filename", currDoc.getName());
			    
			    
				//call method to rename the datePosted annotation		    
			    //renameDatePosted(currDoc,outputAnnSet,inputAnnSet);
			    //call method to rename the jobLocation annotation		    
			    //renameJobLocation(currDoc,outputAnnSet,inputAnnSet);
			    //call method to rename the jobRole annotation		    
			    //renameJobTitle(currDoc,outputAnnSet,inputAnnSet);
			    //call method to rename the hiringOrganization annotation		    
			    //renameHiringOrganization(currDoc,outputAnnSet,inputAnnSet);
				//call method to add frequencyOfMention to SkillProduct annotation
			    addSkillProductAnn(currDoc,outputAnnSet, inputAnnSet);
				//call method to add frequencyOfMention to SkillTool annotation
			    addSkillToolAnn(currDoc,outputAnnSet,inputAnnSet);
			    //call method to add frequencyOfMention to SkillTopic annotation
			    addSkillTopicAnn(currDoc,outputAnnSet,inputAnnSet);
				//call method to delete unimportant annotation types
			    deleteUnimportantAnn(currDoc,outputAnnSet,inputAnnSet);
			    
			  //delete the original markups annotation set using the Document Reset PR and
			  //migrate all the annotations type from default annotation set to a named annotation set  
				try {
					
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
				
				SerialAnalyserController skillannotator = (SerialAnalyserController) Factory.createResource("gate.creole.SerialAnalyserController");
				
				FeatureMap params1 = Factory.newFeatureMap();
				params1.put("outputASName",currDoc.getName());
				//important to use the parameter below to keep the default annotation set has all the annotation types for the evaluation related task
				//params1.put("copyAnnotations","true"); 
				
				System.out.print("\t* Loading gate.creole.annotransfer.AnnotationSetTransfer" + " ... ");
				((SerialAnalyserController)skillannotator).add((gate.LanguageAnalyser)Factory.createResource("gate.creole.annotransfer.AnnotationSetTransfer",
						params1));
				System.out.println("done");
				
				FeatureMap params2 = Factory.newFeatureMap();
				params2.put("setsToRemove","Original markups");
				params2.put("keepOriginalMarkupsAS", "false");
				
				System.out.print("\t* Loading gate.creole.annotdelete.AnnotationDeletePR ... ");
				((SerialAnalyserController)skillannotator).add((gate.LanguageAnalyser)Factory
			              .createResource("gate.creole.annotdelete.AnnotationDeletePR",params2));
				System.out.println("done");
				
				
				Corpus corpus1 = Factory.newCorpus("");
				corpus1.add(currDoc);
				skillannotator.setCorpus(corpus1);
				skillannotator.execute();
	            
				
				
				
			    /*
			    AnnotationSet origMarkupsSet = currDoc.getAnnotations("Original markups");
			    AnnotationSet anchorSetLoc = origMarkupsSet.get("jobLocation");
			    AnnotationSet anchorSetDate = origMarkupsSet.get("firstSeen");
			    AnnotationSet anchorSetOrg = origMarkupsSet.get("hiringOrganization");
			    AnnotationSet anchorSetTit = origMarkupsSet.get("title");
			    
			    
			    currDoc.getFeatures().put("jobLocation", Utils.stringFor(currDoc,anchorSetLoc));
			    currDoc.getFeatures().put("datePosted", Utils.stringFor(currDoc,anchorSetDate));
			    currDoc.getFeatures().put("hiringOrganization", Utils.stringFor(currDoc,anchorSetOrg));
			    currDoc.getFeatures().put("jobRole", Utils.stringFor(currDoc,anchorSetTit));
			    */
			    
			    //print the features which have been stored in the document
			    gate.FeatureMap documentFeatures = currDoc.getFeatures();

			      Iterator featureIterator = documentFeatures.keySet().iterator();
			      while(featureIterator.hasNext()) {
			        String key = (String)featureIterator.next();
			        System.out.println("\t*) " + key + " --> " + documentFeatures.get(key));
			      }
			      System.out.println();
			}
		 }	  
		  
		private void deleteUnimportantAnn(gate.Document Doc, AnnotationSet outputAS, AnnotationSet inputAS) throws ExecutionException {
			
			//get the default annotation set
		    AnnotationSet DefASes = Doc.getAnnotations();

			//obtain unimportant types
			AnnotationSet topicSetDesc = DefASes.get("description");
			AnnotationSet topicSetSource = DefASes.get("source");
			AnnotationSet topicSetURL = DefASes.get("url");
			AnnotationSet topicSetLoc = DefASes.get("Location");
			AnnotationSet topicSetSkill = DefASes.get("requiresSkill");
			AnnotationSet topicSetDesc2 = DefASes.get("Description");
			AnnotationSet topicSetRDF = DefASes.get("RDF");
			AnnotationSet topicSetType = DefASes.get("type");
			
			//delete all annotation with 'ns1:datePosted' annotation
			inputAS.removeAll(topicSetDesc);
			inputAS.removeAll(topicSetSource);
			inputAS.removeAll(topicSetURL);
			inputAS.removeAll(topicSetLoc);
			inputAS.removeAll(topicSetSkill);
			inputAS.removeAll(topicSetDesc2);
			inputAS.removeAll(topicSetRDF);
			inputAS.removeAll(topicSetType);
		}
		
		
		private void renameDatePosted(gate.Document Doc, AnnotationSet outputAS, AnnotationSet inputAS) throws ExecutionException {
			
			//get the default annotation set
		    AnnotationSet DefASes = Doc.getAnnotations();

			//obtain annotations of type 'ns1:datePosted'
			AnnotationSet topicSet = DefASes.get("ns1:datePosted");
			
		
			Node startnode = null;
			Node endnode = null;
			
			for (Annotation topic : topicSet){
					
				startnode = topic.getStartNode();
				endnode = topic.getEndNode();
				FeatureMap features1 = Factory.newFeatureMap();
				features1.put("kind", "datePosted");
				outputAS.add(startnode, endnode, "datePosted", features1);
					
			}
			startnode = null;
			endnode = null;
						
			//delete all annotation with 'ns1:datePosted' annotation
			inputAS.removeAll(topicSet);
		}
		
		private void renameJobLocation(gate.Document Doc, AnnotationSet outputAS, AnnotationSet inputAS) throws ExecutionException {
			
			//get the default annotation set
		    AnnotationSet DefASes = Doc.getAnnotations();

			//obtain annotations of type 'ns1:jobLocation'
			AnnotationSet topicSet = DefASes.get("ns1:jobLocation");
			
		
			Node startnode = null;
			Node endnode = null;
			
			for (Annotation topic : topicSet){
					
				startnode = topic.getStartNode();
				endnode = topic.getEndNode();
				FeatureMap features1 = Factory.newFeatureMap();
				features1.put("kind", "jobLocation");
				outputAS.add(startnode, endnode, "Location", features1);
					
			}
			startnode = null;
			endnode = null;
						
			//delete all annotation with 'ns1:jobLocation' annotation
			inputAS.removeAll(topicSet);
		}
		
		private void renameHiringOrganization(gate.Document Doc, AnnotationSet outputAS, AnnotationSet inputAS) throws ExecutionException {
			
			//get the default annotation set
		    AnnotationSet DefASes = Doc.getAnnotations();

			//obtain annotations of type 'ns1:hiringOrganization'
			AnnotationSet topicSet = DefASes.get("ns1:hiringOrganization");
			
		
			Node startnode = null;
			Node endnode = null;
			
			for (Annotation topic : topicSet){
					
				startnode = topic.getStartNode();
				endnode = topic.getEndNode();
				FeatureMap features1 = Factory.newFeatureMap();
				features1.put("kind", "hiringOrganization");
				outputAS.add(startnode, endnode, "Organization", features1);
					
			}
			startnode = null;
			endnode = null;
						
			//delete all annotation with 'ns1:hiringOrganization' annotation
			inputAS.removeAll(topicSet);
		}
		
		private void renameJobTitle(gate.Document Doc, AnnotationSet outputAS, AnnotationSet inputAS) throws ExecutionException {
			
			//get the default annotation set
		    AnnotationSet DefASes = Doc.getAnnotations();

			//obtain annotations of type 'ns1:jobTitle'
			AnnotationSet topicSet = DefASes.get("ns1:jobTitle");
			
		
			Node startnode = null;
			Node endnode = null;
			
			for (Annotation topic : topicSet){
					
				startnode = topic.getStartNode();
				endnode = topic.getEndNode();
				FeatureMap features1 = Factory.newFeatureMap();
				features1.put("kind", "jobTitle");
				outputAS.add(startnode, endnode, "jobRole", features1);
					
			}
			startnode = null;
			endnode = null;
						
			//delete all annotation with 'ns1:jobTitle' annotation
			inputAS.removeAll(topicSet);
		}
		
		private void addSkillTopicAnn(gate.Document Doc, AnnotationSet outputAS, AnnotationSet inputAS) throws ExecutionException {
			
			//get the default annotation set
		    AnnotationSet DefASes = Doc.getAnnotations();
		    //get each types in the default annotation set
		    Set<String> annotTypes = DefASes.getAllTypes();
			for(String aType : annotTypes) {
				//System.out.println(" " + aType + ": " + DefASes.get(aType).size());
			}
			
					
			//create a list to store the temporary skill
			ArrayList<String> tempList = new ArrayList<String>();
			
			
			//obtain annotations of type 'SkillTopicTemp'
			AnnotationSet topicSet = DefASes.get("SkillTopicTemp");
			
			int a = 0;
			boolean flag = false;
			//iterate over each annotation
			//obtain the string, create the array to store each different skill
			for (Annotation topic : topicSet){
				String str = (String) topic.getFeatures().get("string");
				System.out.println("The skilltopic inside job posting :" + str);
				if (tempList.isEmpty()){
					tempList.add(str);
					
				}
				else if (!(tempList.isEmpty())){
					while(a < tempList.size()){
						if (str.equalsIgnoreCase(tempList.get(a))){
							flag = true;
						}
						a++;
					}
											
					if (flag == false){
						tempList.add(str);
					}
				}
				
				a = 0;
				flag = false;
			}
			
			//count the frequency of mention
			int count = 0;
			Node startnode = null;
			Node endnode = null;
			flag = false;
			for (int i = 0; i < tempList.size(); i++){
				for (Annotation topic : topicSet){
					
					String str = (String) topic.getFeatures().get("string");
					if (str.equalsIgnoreCase(tempList.get(i))){
						count ++;
						flag = true;
						startnode = topic.getStartNode();
						endnode = topic.getEndNode();
					}
					
					
				}
				if (flag == true){
					//System.out.println(tempList.get(i) + "with frequency of Mention: " + count);
					FeatureMap features1 = Factory.newFeatureMap();
					features1.put("frequencyOfMention",count);
					features1.put("string", tempList.get(i));
					features1.put("kind", "topic");
					outputAS.add(startnode, endnode, "SkillTopic", features1);
				}
				
				System.out.println(" Inside the list with size " + tempList.size() + " are " + tempList.get(i) + "with frequency of Mention: " + count);
				count = 0;
				flag = false;
				startnode = null;
				endnode = null;
				
			}
			
			//delete all annotation with 'SkillTopicTemp' annotation
			inputAS.removeAll(topicSet);
		}
		
		private void addSkillProductAnn(gate.Document Doc, AnnotationSet outputAS, AnnotationSet inputAS) throws ExecutionException {
			
			 //get the default annotation set
		    AnnotationSet DefASes = Doc.getAnnotations();
		    //get each types in the default annotation set
		    Set<String> annotTypes = DefASes.getAllTypes();
			for(String aType : annotTypes) {
				//System.out.println(" " + aType + ": " + DefASes.get(aType).size());
			}
			
			
			
			//create a list to store the temporary skill
			ArrayList<String> tempList = new ArrayList<String>();
			
			
			//obtain annotations of type 'SkillProductTemp'
			AnnotationSet prodSet = DefASes.get("SkillProductTemp");
			
			int a = 0;
			boolean flag = false;
			//iterate over each annotation
			//obtain the string, create the array to store each different skill
			for (Annotation product : prodSet){
				String str = (String) product.getFeatures().get("string");
				System.out.println("The skillproduct inside job posting :" + str);
				if (tempList.isEmpty()){
					tempList.add(str);
					
				}
				else if (!(tempList.isEmpty())){
					while(a < tempList.size()){
						if (str.equalsIgnoreCase(tempList.get(a))){
							flag = true;
						}
						a++;
					}
											
					if (flag == false){
						tempList.add(str);
					}
				}
				
				a = 0;
				flag = false;
			}
			
			//count the frequency of mention
			int count = 0;
			Node startnode = null;
			Node endnode = null;
			flag = false;
			for (int i = 0; i < tempList.size(); i++){
				for (Annotation product : prodSet){
					
					String str = (String) product.getFeatures().get("string");
					if (str.equalsIgnoreCase(tempList.get(i))){
						count ++;
						flag = true;
						startnode = product.getStartNode();
						endnode = product.getEndNode();
					}
				}
				if (flag == true){
					//System.out.println(tempList.get(i) + "with frequency of Mention: " + count);
					FeatureMap features1 = Factory.newFeatureMap();
					features1.put("frequencyOfMention",count);
					features1.put("string", tempList.get(i));
					features1.put("kind", "product");
					outputAS.add(startnode, endnode, "SkillProduct", features1);
				}
				System.out.println(" Inside the list with size " + tempList.size() + " are " + tempList.get(i) + "with frequency of Mention: " + count);
				count = 0;
				flag = false;
				startnode = null;
				endnode = null;
				
			}
			
			//delete all annotation with 'SkillProductTemp' annotation
			inputAS.removeAll(prodSet);
		}
		 
		private void addSkillToolAnn(gate.Document Doc, AnnotationSet outputAS, AnnotationSet inputAS) throws ExecutionException {
			
			 //get the default annotation set
		    AnnotationSet DefASes = Doc.getAnnotations();
		    //get each types in the default annotation set
		    Set<String> annotTypes = DefASes.getAllTypes();
			for(String aType : annotTypes) {
				//System.out.println(" " + aType + ": " + DefASes.get(aType).size());
			}
			
			
			
			//create a list to store the temporary skill
			ArrayList<String> tempList = new ArrayList<String>();
			
			
			//obtain annotations of type 'SkillToolTemp'
			AnnotationSet toolSet = DefASes.get("SkillToolTemp");
			
			int a = 0;
			boolean flag = false;
			//iterate over each annotation
			//obtain the string, create the array to store each different skill
			for (Annotation tool : toolSet){
				String str = (String) tool.getFeatures().get("string");
				System.out.println("The skilltool inside job posting :" + str);
				if (tempList.isEmpty()){
					tempList.add(str);
					
				}
				else if (!(tempList.isEmpty())){
					while(a < tempList.size()){
						if (str.equalsIgnoreCase(tempList.get(a))){
							flag = true;
						}
						a++;
					}
											
					if (flag == false){
						tempList.add(str);
					}
				}
				
				a = 0;
				flag = false;
			}
			
			//count the frequency of mention
			int count = 0;
			Node startnode = null;
			Node endnode = null;
			flag = false;
			for (int i = 0; i < tempList.size(); i++){
				for (Annotation tool : toolSet){
					
					String str = (String) tool.getFeatures().get("string");
					if (str.equalsIgnoreCase(tempList.get(i))){
						count ++;
						flag = true;
						startnode = tool.getStartNode();
						endnode = tool.getEndNode();
					}
				}
				if (flag == true){
					//System.out.println(tempList.get(i) + "with frequency of Mention: " + count);
					FeatureMap features1 = Factory.newFeatureMap();
					features1.put("frequencyOfMention",count);
					features1.put("string", tempList.get(i));
					features1.put("kind", "tool");
					outputAS.add(startnode, endnode, "SkillTool", features1);
				}
				System.out.println(" Inside the list with size " + tempList.size() + " are " + tempList.get(i) + "with frequency of Mention: " + count);
				count = 0;
				flag = false;
				startnode = null;
				endnode = null;
				
			}
			
			//delete all annotation with 'SkillProductTemp' annotation
			inputAS.removeAll(toolSet);
		}
		
		  public static void main(String[] args) {
			 			 
			  ArrayList<File> files = new ArrayList<File>();
			  
			  try
			  {		
				  
				  File dir = new File("c:/DIC/Fraunhofer/EDSA/TOBIE/OBIE/smalldataset");
				  File[] directoryListing = dir.listFiles();
				  if (directoryListing != null) {
				    for (File child : directoryListing) {
				         files.add(child);
						 System.out.println("\n== OBTAINING DOCUMENTS ==");
					}
				    
				    Main m = new Main();
				    //m.Pipeline(files);
				    
				  } else{
					  System.out.println("\n Directory has no file in it)");
				  }
				  

				  
				 
				  System.out.println("\nDemo done... :)");
				  
				  
			  }catch(Exception io)		    
			  {
				  System.out.println("Text is not provided");
				  io.printStackTrace();
			  }
			  
			  
			  
		  }


}
