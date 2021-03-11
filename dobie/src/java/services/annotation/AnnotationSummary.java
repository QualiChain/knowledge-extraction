package services.annotation;

import java.io.*;
import java.lang.reflect.AnnotatedArrayType;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.net.URL;


import gate.Annotation;
import gate.AnnotationSet;
import gate.Corpus;
import gate.CorpusController;
import gate.Document;
import gate.Factory;
import gate.FeatureMap;
import gate.Gate;
import gate.Node;
import gate.creole.*;
import gate.creole.gazetteer.Gazetteer;
import gate.creole.ontology.Ontology;
import gate.gui.MainFrame;
import gate.util.GateException;
import gate.util.Out;
import org.apache.commons.io.IOUtils;
import org.apache.jena.query.*;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.riot.RDFDataMgr;
import org.apache.jena.riot.RDFFormat;
import org.apache.jena.update.UpdateAction;
import org.apache.jena.vocabulary.RDF;
import org.apache.jena.vocabulary.RDFS;

import javax.swing.*;
import services.annotation.GateResources.SortedAnnotationList;

public class AnnotationSummary {
		//initialize variable for corpus
		private static Corpus corpus;
		private static final String ttlFolder = "ttlFiles";
		private Ontology ontology;
		private Gazetteer gaz;
		private ConditionalSerialAnalyserController skillann;

		private String inputASname, outputASname;



		public List<String> Pipeline (String gateHome, ArrayList<File> files, String type) throws Exception {

            loadResources(gateHome);
			
			//create corpus consists of job posting files
			createCorpus(files, type);
			
			//create corpus from description part only in JSON file
			//createCorpusForDescOnly(files);
			
			//create corpus from XML file
//			createCorpusFromXML(files);
			
			//load the ontology
			ontology = loadOntology();
			
			//create Gazetteer Ontology Based 
			gaz = createGazetteerOntologyBased(ontology);
			
			
			SkillAnnotationApp skillannotator = new SkillAnnotationApp();
			  
			skillann = skillannotator.createResources(gaz);
			skillann.setCorpus(corpus);
			skillann.execute();

			//Calculate the number of the skills - we take the absolute number
			return displayDocumentFeatures(corpus, type, "" , "", "" , "" );
			
			//saveToXML(corpus);
//            return saveToList(corpus);
		/*Factory.deleteResource(ontology);
			Factory.deleteResource(corpus);
			Factory.deleteResource(gaz);
			Factory.deleteResource(skillann);
			*/
		}

	public List<String> generateAnnotation (URL u, String type) throws Exception {
        GateResources gr = GateResources.getInstance();
        gr.buildCorpusWithDoc(u, type);
        gr.execute();
        Corpus corpus = gr.getCorpus();
		return displayDocumentFeatures(corpus, type, "", "", "", "" );
//		return saveToList(corpus);
	}

	public List<String> generateJobWatchAnnotation (URL u, String type, String title, String location, String company,  String datePosted) throws Exception {
		GateResources gr = GateResources.getInstance();
		gr.buildCorpusWithDoc(u, type);
		gr.execute();
		Corpus corpus = gr.getCorpus();
		return displayDocumentFeatures(corpus, type, title, location, company,  datePosted);
//		return saveToList(corpus);
	}

	private ResultSet sparqlQueryExample () throws FileNotFoundException {
		Model model =  ModelFactory.createDefaultModel();
		model.read( new FileInputStream(("mergedTTLs.ttl")),null,"TTL");

		String queryString = "" +
				"prefix saro: <" + "http://w3id.org/saro/" + ">\n" +
				"prefix qc: <" + "http://w3id.org/qualichain/" + ">\n" +
				"prefix rdf: <" + RDF.getURI() + ">\n" +
				"SELECT  ?entity ?type   \n" +
				"WHERE {   \n" +
				"?entity rdf:type ?type.  \n" +
				"{?entity saro:relatedTo saro:java. }  \n" +
				"UNION  \n" +
				"{?entity qc:refersToExperience saro:java. }  \n" +
				"}";

		System.out.println(queryString);

		Query query= QueryFactory.create(queryString);
		QueryExecution qexec = QueryExecutionFactory.create(query, model);
		ResultSet rs = qexec.execSelect();


		for ( ; rs.hasNext() ; ) {
			QuerySolution soln = rs.nextSolution();
			String entity = soln.get("entity").asResource().getURI();
			String entityType = soln.get("type").toString();
			System.out.println(entity + "     " + entityType);
		}
		return rs;
	}

    public void loadResources(String gateFolder) throws GateException, IOException, URISyntaxException, InvocationTargetException,InterruptedException {
        String gateHome = "";
        if(!gateFolder.equals("")){
            gateHome = gateFolder;

        }else{
            gateHome = "gate";
        }
        Gate.setGateHome(new File(gateHome));
		Properties props = System.getProperties();

		props.setProperty("M2_SETTINGS_XML", String.valueOf(new File(gateHome,"settings.xml")));
//		props.setProperty("vmparams", String.valueOf(new File(gateHome,"gate.l4j.ini")));

		Gate.setUserConfigFile(new File(gateHome,"gate.xml"));
        File pluginsHome = new File(gateHome,"plugins");
        Gate.setPluginsHome(pluginsHome);
        Gate.init();
        SwingUtilities.invokeAndWait(new Runnable() {
        public void run() {
                MainFrame.getInstance().setVisible(true);
                }
        });
/*
        gr = GateResources.getInstance();
        gr.initializePipeLines();

        // load the Ontology
        FeatureMap fm = Factory.newFeatureMap ();
        try {
            fm.put("turtleURL", getClass().getClassLoader().getResource("acc.ttl").toExternalForm());

        } catch (Exception e) {
            e.printStackTrace();
        }
        pwcAcc = (Ontology)Factory.createResource("gate.creole.ontology.impl.sesame.OWLIMOntology",fm);
        pwcAcc.setName("PwC_Acc");
*/


    }
	private void produceRDF(Document currDoc, String type,  String title, String location, String company, String datePosted) throws Exception {
		System.out.println("Type of Document: " + type);

		String filename = currDoc.getName();
		AnnotationSet outputAnnSet = (outputASname == null || outputASname.length() == 0)
				? currDoc.getAnnotations()
				: currDoc.getAnnotations(outputASname);

		String skills = "";
		String skillFrequency = "";
		AnnotationSet skillTopics = outputAnnSet.get("SkillTopic");
		for (Iterator itr = skillTopics.iterator(); itr.hasNext();){
			Annotation skillTopic = (Annotation)itr.next();
			String mentionText = currDoc.getContent().getContent(skillTopic.getStartNode().getOffset(),skillTopic.getEndNode().getOffset()).toString();
			FeatureMap features = skillTopic.getFeatures();
//			features.get("frequencyOfMention");
			skills = skills.concat("saro:" + features.get("string") + " , ");
			skillFrequency = skillFrequency.concat("saro:" + features.get("string") + "	saro:frequencyOfMention	\"" +
							features.get("frequencyOfMention")) + "\"^^xsd:integer ;\n" +
							"	rdfs:label	\"" + features.get("label") + "\" ;\n" +
							"	a	saro:" + features.get("kind") + " .\n";
		}

		AnnotationSet skillProducts = outputAnnSet.get("SkillProduct");
		for ( Annotation skillProduct: skillProducts) {
			FeatureMap features = skillProduct.getFeatures();
			skills = skills.concat("saro:" + features.get("string") + " , ");
			skillFrequency = skillFrequency.concat("saro:" + features.get("string") + "	saro:frequencyOfMention	\"" +
					features.get("frequencyOfMention")) + "\"^^xsd:integer ;\n" +
					"	rdfs:label	\"" + features.get("label") + "\" ;\n" +
					"	a	saro:" + features.get("kind") + " .\n";

		}

		AnnotationSet skillTools = outputAnnSet.get("SkillTool");
		for ( Annotation skillTool : skillTools) {
			FeatureMap features = skillTool.getFeatures();
			skills = skills.concat("saro:" + features.get("string") + " , ");
			skillFrequency = skillFrequency.concat("saro:" + features.get("string") + "	saro:frequencyOfMention	\"" +
					features.get("frequencyOfMention")) + "\"^^xsd:integer ;\n" +
					"	rdfs:label	\"" + features.get("label") + "\" ;\n" +
					"	a	saro:" + features.get("kind") + " .\n";
		}
		System.out.println("Name of Gate Document: " + filename);

		String docName = filename.replaceAll("\\.","_");
		docName = docName.replaceAll(" " , "_");
		System.out.println("Name of Gate Document modifies: " + docName);

		String insertStatement = "";
        String exp = "";
        String expInsert = "";
        String lecturerInsert = "";

        if(type.equals(Consts.JOB_POST_TYPE) || type.equals(Consts.CV_TYPE)) {

            String experienceProperty = "";
            if(type.equals(Consts.JOB_POST_TYPE)){
                experienceProperty = "   qc:minExperienceDuration   ";
            }else{
                experienceProperty =  "   qc:experienceDuration   ";
            }

            AnnotationSet experiences = outputAnnSet.get("Experience");
            for ( Annotation experience: experiences) {
                FeatureMap features = experience.getFeatures();
				Annotation expDuration = (Annotation)features.get("durationPeriod");
				AnnotationSet expDurationText = (AnnotationSet)features.get("durationText");
				String expDurationStr = expDuration.getFeatures().get("string").toString();
				if (expDuration.getFeatures().get("kind").toString().equals("word")){
					expDurationStr = convertNumberStrToInt(expDurationStr);
				}
				String expDurationTextStr = currDoc.getContent().getContent(expDurationText.firstNode().getOffset(),expDurationText.lastNode().getOffset()).toString();
				expDurationTextStr = expDurationTextStr.replaceAll("\\r", "");
				expDurationTextStr = expDurationTextStr.replaceAll("\\n", "");

				if (features.get("kind").toString().equals("bundledExperience")){
					AnnotationSet allExperiences = (AnnotationSet)features.get("allExperiences");
					ArrayList<String> saroExps = convertAnnSetToStr(allExperiences);
					for(String saroExp: saroExps){
						exp = exp.concat("saro:" + saroExp + " , ");
						String sql = "saro:" + saroExp + experienceProperty + "\"P".concat(expDurationStr).concat("Y\"") + " ;\n" +
								"                   qc:experienceDurationText   \"" + expDurationTextStr + "\"" + " .\n";
						expInsert = expInsert.concat(sql);

					}
				}else {
					exp = exp.concat("saro:" + features.get("string") + " , ");
					String sql = "saro:" + features.get("string") + experienceProperty + "\"P".concat(expDurationStr).concat("Y\"") + " ;\n" +
							"                   qc:experienceDurationText   \"" + expDurationTextStr + "\"" + " .\n";
					expInsert = expInsert.concat(sql);

				}

            }

        }


		if(type.equals(Consts.JOB_POST_TYPE)) {

            AnnotationSet qualifications = outputAnnSet.get("Qualification");
            String quali = "";
            String qualiInsert = "";
            for ( Annotation qualification: qualifications) {
                FeatureMap features = qualification.getFeatures();
                quali = quali.concat("saro:" + features.get("string") + " , ");
                Annotation degreeAnn = (Annotation)features.get("certificateDegree");
                String str = currDoc.getContent().getContent(degreeAnn.getStartNode().getOffset(),degreeAnn.getEndNode().getOffset()).toString();
                String sql = "saro:" + features.get("string") + "   so:educationLevel   " + "\"".concat(str).concat("\"") + " .\n";
                qualiInsert = qualiInsert.concat(sql);

            }
            String organisation = "";
            String organisationSql = "";
            if (company.length() > 0) {
				company = company.replaceAll("-" , " ");
				if (company.contains("(")) {
					company = company.substring(0,company.indexOf("("));
				}
            	if (!company.contains(" ")) {
					organisation = company.toLowerCase();
				} else {
            		String[] splittedCompanyName = company.toLowerCase().trim().split(" ");
					organisation = splittedCompanyName[0];
            		for (int i = 1; i < splittedCompanyName.length; i++) {
            			organisation += splittedCompanyName[i].substring(0,1).toUpperCase() + splittedCompanyName[i].substring(1).toLowerCase();
					}

				}
				organisationSql = ":" + organisation + "	a	so:Organisation , saro:Recruiter .";
			}
			String jobLocation = "";
			String jobLocationSql = "";
			if (location.length() > 0) {
				location = location.replaceAll("-" , " ");
				if (location.contains("(")) {
					location = location.substring(0,location.indexOf("("));
				}
				if (location.contains(" ")) {
					String[] splittedLocationName = location.toLowerCase().trim().split(" ");
					for (int i = 0; i < splittedLocationName.length; i++) {
						jobLocation += splittedLocationName[i].substring(0,1).toUpperCase() + splittedLocationName[i].substring(1) + "_";
					}
					jobLocation = jobLocation.substring(0,jobLocation.length()-1);
				} else {
					jobLocation = location;
				}
				jobLocationSql = ":" + jobLocation + "	a	so:Place .";
			}





                    insertStatement = ":" + docName + "	a 	saro:JobPosting; \n" +
					" 					saro:describes	:" + docName + "_JobRole" + " .\n" +
					":" + docName + "_JobRole" + "	a	saro:JobRoleOrType ; \n" +
					"					rdfs:label \"" + (title.equals("") ? "unknown" : title.trim()) + "\"@en ;\n" +
                    (company.equals("") ? "" : ("					so:hiringOrganisation	:" + organisation + "	;\n")) +
                    (location.equals("") ? "" : ("					so:jobLocation	:" + jobLocation + "	;\n")) +
                    //(link.equals("") ? "" : ("					so:URL	\"" + link.trim() + "\"	;\n")) +
                    (datePosted.equals("") ? "" : ("				so:datePosted	\"" + datePosted + "\"^^xsd:date	;\n")) +
                    (skills.equals("") ? "" : ("					saro:requiresSkill	" + skills.substring(0,skills.lastIndexOf(",")) + "	;\n")) +
                    (exp.equals("") ? "" : ("					saro:requiresExperience	" + exp.substring(0,exp.lastIndexOf(",")) + "	;\n")) +
                    (quali.equals("") ? "" : ("					saro:requiresQualificaton	" + quali.substring(0,quali.lastIndexOf(",")) + "	;\n"));

            insertStatement = insertStatement.substring(0, insertStatement.lastIndexOf(";")).concat(".\n");

            insertStatement = insertStatement.concat(expInsert + qualiInsert + organisationSql  + jobLocationSql + skillFrequency);

		}else if(type.equals(Consts.COURSE_TYPE)) {
            AnnotationSet courseTitlesAnn = outputAnnSet.get("CourseTitle");
            String courseTitles = "";
            for ( Annotation courseTitle: courseTitlesAnn) {
                FeatureMap features = courseTitle.getFeatures();
                courseTitles = courseTitles.concat("\"" + features.get("string").toString().trim() + "\" , ");
            }

            AnnotationSet lecturersAnn = outputAnnSet.get("Lecturer");
            if (lecturersAnn.size() > 0){
                Annotation lecturers = lecturersAnn.iterator().next();
                String lecturersStr = lecturers.getFeatures().get("string").toString();
                String[] allLecturers = lecturersStr.split(",");
                for (String lecturer : allLecturers){
                    String sql = ":" + lecturer.replaceAll(" ", "") + "  a saro:EducatororTrainer; \n" +
									"			a	qc:Person; \n" +
									"			foaf:name	\"" + lecturer.trim() + "\"@en ; \n" +
                                    "           saro:develops    :" + docName + ". \n";
                    lecturerInsert = lecturerInsert.concat(sql);
                }
           }

			insertStatement = ":" + docName + "	a 	saro:TrainingResource; \n" +
                    (courseTitles.equals("")? "" : (" 					rdfs:label	" + courseTitles.substring(0,courseTitles.lastIndexOf(","))  + " ;\n")) +
                    (skills.equals("")? "" :(" 					saro:relatedTo	" + skills.substring(0,skills.lastIndexOf(","))  + " ;\n"));


            insertStatement = insertStatement.substring(0, insertStatement.lastIndexOf(";")).concat(".\n");
            insertStatement = insertStatement.concat(lecturerInsert + skillFrequency);

        }else if(type.equals(Consts.CV_TYPE)){
			String firstName = "";
			String lastName = "";
			String gender = "";
			String personQueryInsert = "";
			AnnotationSet persons = outputAnnSet.get("Person");
			if (persons.size() > 0) {
				SortedAnnotationList sortedAnnots = new SortedAnnotationList();
				for(Annotation an: persons){
					sortedAnnots.addSortedExclusive(an);
				}
				Annotation firstIdentified = (Annotation) sortedAnnots.iterator().next();
				FeatureMap features = firstIdentified.getFeatures();
				firstName = features.get("firstName").toString();
				lastName = features.get("surname").toString();
				gender = features.get("gender").toString();
				personQueryInsert = ":" + firstName + lastName + "	a	qc:Person; \n" +
									"			qc:hasResume	:" + docName + "; \n" +
									"			foaf:name	\"" + firstName + " " + lastName + "\"@en; \n" +
									"			foaf:firstName	\"" + firstName  + "\"@en; \n" +
									"			foaf:lastName	\"" + lastName  + "\"@en; \n" +
						(gender.equals("")? "" : (" 	foaf:gender	\"" + gender + "\"@en ;\n"));
				personQueryInsert = personQueryInsert.substring(0, personQueryInsert.lastIndexOf(";")).concat(".\n");
			}

			insertStatement = ":" + docName + "	a 	cv:CV; \n" +
                    (personQueryInsert.equals("") ? "" : ("			cv:aboutPerson	:" + firstName + lastName + ";\n")) +
                    (exp.equals("") ? "" : ("					qc:refersToExperience	" + exp.substring(0,exp.lastIndexOf(",")) + "	;\n")) +
                    (skills.equals("")? "" : (" 					qc:refersToAccomplishment	" + skills.substring(0,skills.lastIndexOf(","))  + " ;\n"));

            insertStatement = insertStatement.substring(0, insertStatement.lastIndexOf(";")).concat(".\n");
            insertStatement = insertStatement.concat(expInsert).concat(personQueryInsert).concat(skillFrequency);


        }else{
			throw new Exception("File Type not recognized");
		}
        String finalInsert = "prefix saro: <" + "http://w3id.org/saro/" + ">\n" +
                "prefix xsd: <" + "http://www.w3.org/2001/XMLSchema#" + ">\n" +
                "prefix foaf: <" + "http://xmlns.com/foaf/0.1/" + ">\n" +
                "prefix qc: <" + "http://w3id.org/qualichain/" + ">\n" +
                "prefix cv: <" + "http://rdfs.org/resume-rdf/cv.rdfs#" + ">\n" +
                "prefix so: <" + "http://schema.org/" + ">\n" +
                "prefix : <" + "https://qualichain-project.eu/" + ">\n" +
                "prefix rdfs: <"+ RDFS.getURI()+">\n" +
                "INSERT DATA { \n" + insertStatement + " \n" +
                " }";
		System.out.println(finalInsert);
//		Dataset dataset = RDFDataMgr.loadDataset(getClass().getClassLoader().getResource("defaultModel.ttl").getPath(), Lang.TURTLE) ;
		Model model = aSimpleModel();
		UpdateAction.parseExecute( finalInsert, model );
		File directory = new File(ttlFolder);
		boolean dirCreated = directory.mkdir();
		File file = new File(directory,filename+".ttl");
		OutputStream currentFileAnnotations = new FileOutputStream(file);
		RDFDataMgr.write(currentFileAnnotations, model, RDFFormat.TURTLE_PRETTY) ;
		currentFileAnnotations.close();
	}

	private ArrayList<String> convertAnnSetToStr (AnnotationSet annSet) {
			ArrayList<String> temp = new ArrayList<String>();
			for(Annotation ann: annSet) {
				FeatureMap features = ann.getFeatures();
				if (features.get("URI") != null) {
					String uri = features.get("URI").toString();
					int hashtagpos = uri.lastIndexOf("/");
					if(!temp.contains(uri.substring(hashtagpos + 1))) {
						temp.add(uri.substring(hashtagpos + 1));
					}
				}
			}
			return temp;
	}
	private Model aSimpleModel() {
		Model m = ModelFactory.createDefaultModel();
		m.setNsPrefix("so", "http://schema.org/");
		m.setNsPrefix("cv", "http://rdfs.org/resume-rdf/cv.rdfs#");
		m.setNsPrefix("rdfs", "http://www.w3.org/2000/01/rdf-schema#");
		m.setNsPrefix("foaf", "http://xmlns.com/foaf/0.1/");
		m.setNsPrefix("xsd", "http://www.w3.org/2001/XMLSchema#");
		m.setNsPrefix("xml", "http://www.w3.org/XML/1998/namespace");
		m.setNsPrefix("rdf", "http://www.w3.org/1999/02/22-rdf-syntax-ns#");
		m.setNsPrefix("owl", "http://www.w3.org/2002/07/owl#");
		m.setNsPrefix("dbo", "http://dbpedia.org/ontology/");
		m.setNsPrefix("esco", "http://data.europa.eu/esco/model#");
		m.setNsPrefix("qc", "http://w3id.org/qualichain/");
		m.setNsPrefix("saro", "http://w3id.org/saro/");
		m.setNsPrefix("", "https://qualichain-project.eu/");
		return m;
	}


	private String convertNumberStrToInt (String digitStr) throws Exception {
	    digitStr = digitStr.toLowerCase();
		switch (digitStr) {
			case "one":
				return "1";
			case "two":
				return "2";
			case "three":
				return "3";
			case "four":
				return "4";
			case "five":
				return "5";
			case "six":
				return "6";
			default:
				throw new Exception("Error in Experience Duration!");
		}
    }
    private List<String> saveToList(Corpus corp) throws GateException, IOException {
        Iterator documentIterator = corp.iterator();
        List<String> items = new ArrayList<String>();
        while(documentIterator.hasNext()) {
            Document currDoc = (Document) documentIterator.next();
            items.add(currDoc.toXml());
        }
        return items;
    }



	private Gazetteer createGazetteerOntologyBased(Ontology ontforgaz) throws GateException{
			
			//load the Gazetteer_Ontology_Based
			try {
//				File pluginHome = new File(Gate.getPluginsHome(), "Gazetteer_Ontology_Based");
//				Plugin gazPlugin = new Plugin.Directory(pluginHome.toURI().toURL());
				Plugin gazPlugin = new Plugin.Maven("uk.ac.gate.plugins", "gazetteer-ontology-based", "8.5");
				Gate.getCreoleRegister().registerPlugin(gazPlugin);
//				Gate.getCreoleRegister().registerDirectories(new File(Gate.getPluginsHome(), "Gazetteer_Ontology_Based").toURI().toURL());


			} catch (GateException  e ) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


			OntoRootApp rootFinder = new OntoRootApp();
			
			FeatureMap params = Factory.newFeatureMap();
			params.put("ontology", ontforgaz);
			params.put("rootFinderApplication", rootFinder.createResources());
//			params.put("caseSensitive", false);


			return (Gazetteer) Factory.createResource("gate.clone.ql.OntoRootGaz",params);
			
			
		}
		
	
		
		private void createCorpus(ArrayList<File> files, String type) throws GateException {
		    corpus = Factory.newCorpus("Job Advertisement");

		    int c = 0;
		    for(File file : files) {
		      System.out.print("\t " + (c++) + ") " + file);
		      try {
		          //corpus.add(Factory.newDocument(new File(file).toURL()));
		    	  //corpus.add(Factory.newDocument((file).toURL()));
                  //Document d = Factory.newDocument(file.getValue());
                  //d.setName(file.getKey());

                  FeatureMap params = Factory.newFeatureMap();
                  URL u = file.toURI().toURL();
                  params.put("sourceUrl", u);
                  params.put("preserveOriginalContent", true);
                  params.put("collectRepositioningInfo", true );

                  Document d = (Document) Factory.createResource("gate.corpora.DocumentImpl", params);
                  d.setName(file.getName());
				  switch (type) {
					  case "jobPost":
						  d.getFeatures().put("docType", "jobPost");
						  break;
					  case "courseDescription":
						  d.getFeatures().put("docType", "courseDescription");
						  break;
					  case "cv":
						  d.getFeatures().put("docType", "cv");
						  break;
					  default:
						  throw new Exception("File Type not recognized");
				  }
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

			File pluginHome = new File (Gate.getPluginsHome(), "Ontology");
			//Load the plugin from that directory
			try {
                Plugin ontologyPlugin = new Plugin.Directory(pluginHome.toURI().toURL());
                Gate.getCreoleRegister().registerPlugin(ontologyPlugin);
//                        Gate.getCreoleRegister().registerDirectories(pluginHome.toURI().toURL());
				
			}  catch (GateException | MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			FeatureMap fm = Factory.newFeatureMap ();
			try {
				fm.put("turtleURL", getClass().getClassLoader().getResource("InformaticsSkills.ttl").toExternalForm());

//				fm.put("rdfXmlURL", getClass().getClassLoader().getResource("SkillsAndRecruitmentOntology.owl").toExternalForm());

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


			Ontology ont = (Ontology)Factory.createResource("gate.creole.ontology.impl.sesame.OWLIMOntology",fm);		
			ont.setName("SARO");
					
			return ont;
			
		}		
		
		
			
		private List<String> displayDocumentFeatures(Corpus corp, String type, String title, String location, String company,  String datePosted) throws Exception {
			Iterator documentIterator = corp.iterator();
			List<String> ttlFiles = new ArrayList<String>();
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
			  		              "You need to run the JAPE Transducer!");
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
				removeDuplicateAnn( "SkillProductTemp" , currDoc,outputAnnSet, inputAnnSet);
				removeDuplicateAnn( "SkillToolTemp" , currDoc,outputAnnSet, inputAnnSet);
				removeDuplicateAnn( "SkillTopicTemp" , currDoc,outputAnnSet, inputAnnSet);
				removeDuplicateAnn( "CertificateDegreeTemp" , currDoc,outputAnnSet, inputAnnSet);
				removeDuplicateAnn( "ExperienceTemp" , currDoc,outputAnnSet, inputAnnSet);
				removeDuplicateAnn( "QualificationTemp" , currDoc,outputAnnSet, inputAnnSet);
				removeDuplicateAnn( "CourseTitleTemp" , currDoc,outputAnnSet, inputAnnSet);
				removeDuplicateAnn( "LecturerTemp" , currDoc,outputAnnSet, inputAnnSet);
				//call method to delete unimportant annotation types
			    deleteUnimportantAnn(currDoc,inputAnnSet);
			    
			  //delete the original markups annotation set using the Document Reset PR and
			  //migrate all the annotations type from default annotation set to a named annotation set  
				try {

//                    File pluginHome = new File(Gate.getPluginsHome(), "ANNIE");
//                    Plugin anniePlugin = new Plugin.Directory(pluginHome.toURI().toURL());
					Plugin anniePlugin = new Plugin.Maven("uk.ac.gate.plugins", "annie", "8.5");
                    Gate.getCreoleRegister().registerPlugin(anniePlugin);
                } catch (GateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				SerialAnalyserController skillannotator = (SerialAnalyserController) Factory.createResource("gate.creole.SerialAnalyserController");
				
				FeatureMap params1 = Factory.newFeatureMap();
				params1.put("outputASName",currDoc.getName());
				//important to use the parameter below to keep the default annotation set has all the annotation types for the evaluation related task
				//params1.put("copyAnnotations","true"); 

				produceRDF(currDoc, type, title, location, company, datePosted);
				System.out.println("TTL file saved");
				File ttl = new File(ttlFolder,currDoc.getName()+".ttl");
				String RDFdata = IOUtils.toString(new FileInputStream(ttl), StandardCharsets.UTF_8);
				ttlFiles.add(RDFdata);
/*
				System.out.print("\t* Loading gate.creole.annotransfer.AnnotationSetTransfer" + " ... ");
				(skillannotator).add((gate.LanguageAnalyser)Factory.createResource("gate.creole.annotransfer.AnnotationSetTransfer",
						params1));
				System.out.println("done");
				
				FeatureMap params2 = Factory.newFeatureMap();
				params2.put("setsToRemove","Original markups");
				params2.put("keepOriginalMarkupsAS", "false");
				
				System.out.print("\t* Loading gate.creole.annotdelete.AnnotationDeletePR ... ");
				(skillannotator).add((gate.LanguageAnalyser)Factory
			              .createResource("gate.creole.annotdelete.AnnotationDeletePR",params2));
				System.out.println("done");
				Corpus corpus1 = Factory.newCorpus("");
				corpus1.add(currDoc);
				skillannotator.setCorpus(corpus1);
				skillannotator.execute();
*/
			}
			return ttlFiles;
		 }	  
		  
		private void deleteUnimportantAnn(gate.Document Doc, AnnotationSet inputAS) throws ExecutionException {
			
			//get the default annotation set
		    AnnotationSet DefASes = Doc.getAnnotations();

			//obtain unimportant types
			AnnotationSet topicSetDesc = DefASes.get("description");
			AnnotationSet topicSetSource = DefASes.get("source");
			AnnotationSet topicSetURL = DefASes.get("url");
//			AnnotationSet topicSetLoc = DefASes.get("Location");
			AnnotationSet topicSetSkill = DefASes.get("requiresSkill");
			AnnotationSet topicSetDesc2 = DefASes.get("Description");
			AnnotationSet topicSetRDF = DefASes.get("RDF");
			AnnotationSet topicSetType = DefASes.get("type");
			
			//delete all annotation with 'ns1:datePosted' annotation
			inputAS.removeAll(topicSetDesc);
			inputAS.removeAll(topicSetSource);
			inputAS.removeAll(topicSetURL);
//			inputAS.removeAll(topicSetLoc);
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
		

	private void removeDuplicateAnn(String annsetName, gate.Document Doc, AnnotationSet outputAS, AnnotationSet inputAS) throws ExecutionException {

		//get the default annotation set
		AnnotationSet DefASes = Doc.getAnnotations();

		//create a list to store the temporary skill
		ArrayList<String> tempList = new ArrayList<String>();


		//obtain annotations of type 'SkillToolTemp'
		AnnotationSet annotationSet = DefASes.get(annsetName);

		int a = 0;
		boolean flag = false;
		//iterate over each annotation
		//obtain the string, create the array to store each different skill
		for (Annotation annot : annotationSet){
			String str = (String) annot.getFeatures().get("string");
			if (tempList.isEmpty()){
				tempList.add(str);

			}else {
				while(a < tempList.size()){
					if (str.equalsIgnoreCase(tempList.get(a))){
						flag = true;
					}
					a++;
				}
				if (!flag){
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
		String kind = "";
		String label = "";
		Annotation durationPeriod = null;
		AnnotationSet durationText = null;
		AnnotationSet allExperiences = null;
		Annotation certificateDegree = null;
		for (int i = 0; i < tempList.size(); i++){
			for (Annotation annot : annotationSet){

				String str = (String) annot.getFeatures().get("string");
				if (str.equalsIgnoreCase(tempList.get(i))) {
					count ++;
					flag = true;
					kind = annot.getFeatures().get("kind").toString();
					label = annot.getFeatures().get("label").toString();
					if(annsetName.equals("ExperienceTemp")) {
						durationPeriod = (Annotation)annot.getFeatures().get("durationPeriod");
						durationText = (AnnotationSet)annot.getFeatures().get("durationText");
						allExperiences = (AnnotationSet)annot.getFeatures().get("allExperiences");
					}
					if(annsetName.equals("QualificationTemp")) {
						certificateDegree = (Annotation)annot.getFeatures().get("certificateDegree");
					}
					startnode = annot.getStartNode();
					endnode = annot.getEndNode();
				}
			}
			if (flag){
				//System.out.println(tempList.get(i) + "with frequency of Mention: " + count);
				FeatureMap features1 = Factory.newFeatureMap();
				features1.put("frequencyOfMention",count);
				features1.put("string", tempList.get(i));
				features1.put("kind", kind);
				features1.put("label", label);
				if(annsetName.equals("ExperienceTemp")){
                    features1.put("durationPeriod", durationPeriod);
                    features1.put("durationText", durationText);
                    features1.put("allExperiences", allExperiences);
                }
                if(annsetName.equals("QualificationTemp")){
                    features1.put("certificateDegree", certificateDegree);
                }
				outputAS.add(startnode, endnode, annsetName.substring(0 , annsetName.length()-4), features1);
			}
			count = 0;
			flag = false;
			startnode = null;
			endnode = null;

		}
		inputAS.removeAll(annotationSet);
	}

		  public static void main(String[] args) {
			 			 
			  ArrayList<File> files = new ArrayList<File>();
			  String filesDir = "";
			  String gateHome = "";
			  if(args.length > 0 ){
				  gateHome = args[0];
				  filesDir = args[1];

			  }else{
				  gateHome = "gate";
				  filesDir = "input data";

			  }
//			  if(currDoc.getName().toLowerCase().contains("job post") || currDoc.getName().toLowerCase().contains("cv")) {
			  String type = "cv";
			  try
			  {

//				  File dir = new File("c:/DIC/Fraunhofer/EDSA/TOBIE/OBIE/smalldataset");
				  File dir = new File(filesDir);
				  File[] directoryListing = dir.listFiles();
				  if (directoryListing != null) {
				    for (File child : directoryListing) {
				         files.add(child);
						 System.out.println("\n== OBTAINING DOCUMENTS ==");
					}

				    AnnotationSummary m = new AnnotationSummary();
				    List<String> TTLs = m.Pipeline(gateHome, files, type);
                      for(Iterator itr = TTLs.iterator(); itr.hasNext();) {
//                          System.out.println(itr.next());
                      }

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
