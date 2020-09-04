import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationConfig;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class Main {
	
	private static final String GET_URL_INDIVIDUAL_SKILL = "http://localhost:8080/resource/skill?uri=http://data.europa.eu/esco/skill/a59708e3-e654-4e37-8b8a-741c3b756eee&language=en";
		
	private static final String GET_URL_TAXONOMY_REUSE_LEVEL = "http://localhost:8080/resource/taxonomy?uri=http://data.europa.eu/esco/concept-scheme/skill-reuse-level&full=true";
	
	private static final String GET_URL_CONCEPT_REUSE_LEVEL = "http://localhost:8080/resource/concept?uri=http://data.europa.eu/esco/concept-scheme/skill-reuse-level&full=true";
	
	private static final String GET_URL_REUSE_LEVEL_CROSS_SECTOR = "http://localhost:8080/resource/concept?uri=http://data.europa.eu/esco/skill-reuse-level/cross-sector&full=true";
	
	private static final String GET_URL_REUSE_LEVEL_TRANSVERSAL = "http://localhost:8080/resource/concept?uri=http://data.europa.eu/esco/skill-reuse-level/transversal&full=true";
	
	private static final String GET_URL_REUSE_LEVEL_SECTOR_SPECIFIC = "http://localhost:8080/resource/concept?uri=http://data.europa.eu/esco/skill-reuse-level/sector-specific&full=true";
	
	private static final String GET_URL_REUSE_LEVEL_OCCUPATION_SPECIFIC = "http://localhost:8080/resource/concept?uri=http://data.europa.eu/esco/skill-reuse-level/occupation-specific&full=true";
	
	private static final String GET_URL_REUSE_LEVEL_WAY_1 = "http://localhost:8080/resource/related?uri=http://data.europa.eu/esco/concept-scheme/skill-reuse-level&relation=hasTopConcept&full=true";
	
	private static final String GET_URL_REUSE_LEVEL_WAY_2 = "http://localhost:8080/resource/related?uri=http://data.europa.eu/esco/skill-reuse-level/sector-specific&relation=broaderConcept&full=true";
	
	private static final String GET_URL_SKILL_ICT_GROUPS = "http://localhost:8080/suggest?type=skill&isInScheme=http://data.europa.eu/esco/concept-scheme/skill-ict-groups&language=en&limit=21&full=true";

	private static final String GET_URL_REUSE_LEVEL_ALL = "http://localhost:8080/suggest?type=concept&isInScheme=http://data.europa.eu/esco/concept-scheme/skill-reuse-level&full=true";

	private static final String GET_URL_INDIVIDUAL_OCCUPATION_LEVEL_4_CONCEPT = "http://localhost:8080/resource/concept?uri=http://data.europa.eu/esco/isco/C2511&language=en&full=true";
	
	private static final String GET_URL_INDIVIDUAL_OCCUPATION_LEVEL_4_OCCUPATION = "http://localhost:8080/resource/occupation?uri=http://data.europa.eu/esco/isco/C2514&language=en&full=true";
	
	private static final String GET_URL_INDIVIDUAL_OCCUPATION_LEVEL_5 = "http://localhost:8080/resource/occupation?uri=http://data.europa.eu/esco/occupation/bd272aee-adc9-4a06-a15c-a73b4b4a46a7&language=en&full=true";
	
	private static final String GET_URL_INDIVIDUAL_OCCUPATION_LEVEL_6 = "http://localhost:8080/resource/occupation?uri=http://data.europa.eu/esco/occupation/57af9090-55b4-4911-b2d0-86db01c00b02&language=en&full=true";
	
	private static final String GET_URL_INDIVIDUAL_OCCUPATION_LEVEL_3 = "http://localhost:8080/resource/occupation?uri=http://data.europa.eu/esco/isco/C251&language=en&full=true";
	
	private static final String GET_URL_INDIVIDUAL_OCCUPATION_LEVEL_2_ICT = "http://localhost:8080/resource/occupation?uri=http://data.europa.eu/esco/isco/C25&language=en&full=true";
	
	private static final String GET_URL_INDIVIDUAL_OCCUPATION_LEVEL_2_TEACHING = "http://localhost:8080/resource/occupation?uri=http://data.europa.eu/esco/isco/C23&language=en&full=true";
	
	private static final String GET_URL_INDIVIDUAL_OCCUPATION_LEVEL_2_SCIENCEENGINEERING = "http://localhost:8080/resource/occupation?uri=http://data.europa.eu/esco/isco/C21&language=en&full=true";
	
	private static final String GET_URL_INDIVIDUAL_OCCUPATION_LEVEL_2_HEALTH = "http://localhost:8080/resource/occupation?uri=http://data.europa.eu/esco/isco/C22&language=en&full=true";
	
	private static final String GET_URL_INDIVIDUAL_OCCUPATION_LEVEL_2_BUSINESSADMINISTRATION = "http://localhost:8080/resource/occupation?uri=http://data.europa.eu/esco/isco/C24&language=en&full=true";
	
	private static final String GET_URL_INDIVIDUAL_OCCUPATION_LEVEL_2_LEGALSOCIALCULTURAL= "http://localhost:8080/resource/occupation?uri=http://data.europa.eu/esco/isco/C26&language=en&full=true";
	
	private static final String GET_URL_SKILL_TRANSVERSAL_GROUPS = "http://localhost:8080/suggest?type=skill&isInScheme=http://data.europa.eu/esco/concept-scheme/skill-transversal-groups&language=en&limit=107&full=true";
	
	private static final String GET_URL_INDIVIDUAL_OCCUPATION_LEVEL_1 = "http://localhost:8080/resource/occupation?uri=http://data.europa.eu/esco/isco/C2&language=en&full=true";
	
	private static final String GET_URL_ALL_SKILL = "http://localhost:8080/suggest?type=skill&language=en&full=true";
	
		
	public static void main(String[] args) throws ParseException, IOException{
		
		//sendGET(GET_URL_SKILL_TRANSVERSAL_GROUPS);
		//System.out.println("GET DONE");
		
		//requestSkillTransversal(GET_URL_SKILL_TRANSVERSAL_GROUPS);
		//System.out.println("GET DONE");
		
		String url = GET_URL_INDIVIDUAL_OCCUPATION_LEVEL_2_LEGALSOCIALCULTURAL;
		String filename = "LegalSocialCulturalSkills.ttl";
		String sectorname = "LEGALSOCIALCULTURAL";
		requestSkillBySector(url,filename,sectorname);
		System.out.println("GET DONE");
		
		//String title = "bring out performers’ artistic potential !,.:;'{}()";
		//System.out.println(title.replaceAll("[\\p{Ps}\\p{Pe}]", "").replaceAll("'", "").replaceAll(",", "").replaceAll("\\+", "plus").replaceAll("!", "").replaceAll(";", "").replaceAll("’", "").replaceAll(" ", ""));
		
	}
	
	public static void requestSkillTransversal(String URL) throws IOException {
		System.out.println("GET START");
		URL obj = new URL(URL);
		 String readLine = null;
		 HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		 con.setRequestMethod("GET");
		 int responseCode = con.getResponseCode();
		 System.out.println("GET Response Code :: " + responseCode);
		 if (responseCode == HttpURLConnection.HTTP_OK) {
			 BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		     StringBuffer response = new StringBuffer();
		        
		     while ((readLine = in.readLine()) != null) {
		        	response.append(readLine);
		     }
		     in.close();
		     ObjectMapper mapper = new ObjectMapper();
		     mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		     SkillTransversalGroup trav = mapper.readValue(response.toString(), SkillTransversalGroup.class);
		     System.out.println("Transversal Skills: " + trav.getTotal());
		     StringBuffer resp = new StringBuffer();
		     String url;
		     String skilltitle;
		     int total = 0;
		     for (ResultsTransversal restrav : trav.getEmbedded().getResultsTransversal()) {
		    	 System.out.println("\t\turi : " + restrav.getURI());
		    	 skilltitle ="";
		    	 url = "";
	        	 url = "http://localhost:8080/resource/skill?uri=" + restrav.getURI() + "&language=en&full=true";
	        	 resp.delete(0, resp.length());
		         resp = sendGET(url);
		         ObjectMapper mapperskill = new ObjectMapper();
		         SkillsConcept skillTrav = mapperskill.readValue(resp.toString(), SkillsConcept.class);
		    	 
		         //print the extracted skills to a file
		         BufferedWriter writer = new BufferedWriter(
			    			 					 new FileWriter("C:/Users/elisa sibarani/eclipse-workspace/GetSkillESCO/TransversalSkills.ttl",true) 
			    			 					 );
		         writer.newLine();
		         writer.newLine();
		         skilltitle = skillTrav.getTitle().replaceAll("[\\p{Ps}\\p{Pe}]", "").replaceAll("â€™", "").replaceAll("\\+", "plus").replaceAll("'", "").replaceAll(",", "").replaceAll("!", "").replaceAll(";", "").replaceAll(" ", "");
		         
		         writer.write("saro:" + skilltitle + " a saro:TransversalSkill ;");
			     writer.newLine();
			     writer.write("\tsaro:isFrom \"ESCO\" ;" );
			     writer.newLine();
			    	 
			     for(Skill stype : skillTrav.getLinks().getHasSkillType()) {
			    	 writer.write("\tsaro:hasSkillType \"" + stype.getTitle() + "\" ;");
			    	 writer.newLine();
			     }
			     for(BroaderConcept sreuse : skillTrav.getLinks().getHasReuseLevel()) {
			    	 writer.write("\tsaro:hasReuseLevel \"" + sreuse.getTitle() + "\" ;");
			    	 writer.newLine();
			     }
			     
			     writer.write("\trdfs:label \"" + skillTrav.getTitle() + "\" .");
			     writer.close();
			 	 total = total + 1;       
		     }
		     System.out.println("Transversal Skills: " + total);
		 }
	}
	
	public static void requestSkillBySector(String URL, String filename, String sectorname) throws IOException {
		System.out.println("GET START");
		URL obj = new URL(URL);
		 String readLine = null;
		 HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		 con.setRequestMethod("GET");
		 int responseCode = con.getResponseCode();
		 System.out.println("GET Response Code :: " + responseCode);
		 if (responseCode == HttpURLConnection.HTTP_OK) {
			 BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		     StringBuffer response = new StringBuffer();
		        
		     while ((readLine = in.readLine()) != null) {
		        	response.append(readLine);
		     }
		     in.close();
		     ObjectMapper mapper2 = new ObjectMapper();
		     mapper2.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		     OccupationLevel2 occ2 = mapper2.readValue(response.toString(), OccupationLevel2.class);
		     System.out.println("Occupation Level 2");
		     //printParsedObject(occ2);
		     
		     HashMap<String,String> skillMap = new HashMap<>();
		     //HashMap<String,BroaderConcept[]> skillReuseLevelMap = new HashMap<>();
		     //HashMap<String,Skill[]> skillTypeMap = new HashMap<>();
		     
		     StringBuffer resp = new StringBuffer();
		     String url;		     
		     for (NarrowerConcept nc2 : occ2.getLinks().getNarrowerConcept()) {
		    	 System.out.println("Occupation Level 3");
		    	 System.out.println("\t\turi : " + nc2.getUri());
		    	 url = "";
		         url = "http://localhost:8080/resource/occupation?uri="+ nc2.getUri() + "&language=en&full=true";
		         System.out.println(url);
		         resp = sendGET(url);
		         ObjectMapper mapper3 = new ObjectMapper();
		         OccupationLevel3 occ3 = mapper3.readValue(resp.toString(), OccupationLevel3.class);
		         
		         System.out.println("className : " + occ3.getClassName());
		         System.out.println();
		         for (NarrowerConcept nc3 : occ3.getLinks().getNarrowerConcept()) {
		        	 System.out.println("Occupation Level 4");
		        	 System.out.println("\t\ttitle : " + nc3.getTitle());
			         //System.out.println("\t\tcode : " + nc3.getCode());
			         System.out.println();
			         
			         //System.out.println("\t\t\turi : " + nc3.getUri());
			         url = "";
			         url = "http://localhost:8080/resource/occupation?uri="+ nc3.getUri() + "&language=en&full=true";
			         //System.out.println(url);
			         resp.delete(0, resp.length());
			         resp = sendGET(url);
			         ObjectMapper mapper4 = new ObjectMapper();
			         OccupationLevel4 occ4 = mapper4.readValue(resp.toString(), OccupationLevel4.class);
			         
			         //System.out.println("className : " + occ4.getClassName());
			         System.out.println();
			         
			         if(occ4.getLinks().getNarrowerOccupation()!=null) {
			        	 for (NarrowerOccupation nc4 : occ4.getLinks().getNarrowerOccupation()) {
				        	 System.out.println("Occupation Level 5");
				        	 System.out.println("\t\ttitle : " + nc4.getTitle());
				        	 //System.out.println();
				        	 //System.out.println("\t\t\turi : " + nc4.getHref());
				        	 url = "";
				        	 url = nc4.getHref() + "&full=true";
				        	 //System.out.println(url);
					         resp.delete(0, resp.length());
					         resp = sendGET(url);
					         ObjectMapper mapper5 = new ObjectMapper();
					         OccupationLevel5 occ5 = mapper5.readValue(resp.toString(), OccupationLevel5.class);
					         //System.out.println("className : " + occ5.getClassName());
					         //System.out.println();
					         				         
					         if(occ5.getLinks().getHasEssentialSkill()!=null) {
					        	 for (Skill esskill5 : occ5.getLinks().getHasEssentialSkill()) {
						        	 //System.out.println("Essential Skill from Level-5");
						        	 //System.out.println("\t\t\t\t" + esskill5.getTitle());
						        	 System.out.println();	
						        	 			        	 
						        	 if(!skillMap.containsKey(esskill5.getUri())) {
						        		 skillMap.put(esskill5.getUri(), esskill5.getTitle());
						             }				        	 			        	 
						         }				        	 
					         }			         	 
					        	
					         if(occ5.getLinks().getHasOptionalSkill()!=null) {
					        	 for (Skill optskill5 : occ5.getLinks().getHasOptionalSkill()) {
						        	 //System.out.println("Optional Skill from Level-5");
						        	 //System.out.println("\t\t\t\t" + optskill5.getTitle());
						        	 System.out.println();
						        	 				        	 
						        	 if(!skillMap.containsKey(optskill5.getUri())) {
						        		 skillMap.put(optskill5.getUri(), optskill5.getTitle());
						             }					        	 				        	 
						         }			        	 
					         }				         
					         
					         if(occ5.getLinks().getNarrowerOccupation()!=null) {
					        	 System.out.println("Narrower occupation exists");
					        	 
					        	 for (NarrowerOccupation nc5 : occ5.getLinks().getNarrowerOccupation()) {
					        		 System.out.println("Occupation Level 6");
						        	 System.out.println("\t\t\t\t\ttitle : " + nc5.getTitle());
						        	 //System.out.println();
						        	 //System.out.println("\t\t\turi : " + nc4.getHref());
						        	 url = "";
						        	 url = nc5.getHref() + "&full=true";
						        	 //System.out.println(url);
							         resp.delete(0, resp.length());
							         resp = sendGET(url);
							         ObjectMapper mapper6 = new ObjectMapper();
							         OccupationLevel6 occ6 = mapper6.readValue(resp.toString(), OccupationLevel6.class);
							         //System.out.println("className : " + occ6.getClassName());
							         //System.out.println();
							         
							         if(occ6.getLinks().getHasEssentialSkill()!=null) {
							        	 for (Skill esskill6 : occ6.getLinks().getHasEssentialSkill()) {
								        	 //System.out.println("Essential Skill from Level-6");
								        	 //System.out.println("\t\t\t\t" + esskill6.getTitle());
								        	 System.out.println();				        	
								        	 						        		        	 
								        	 if(!skillMap.containsKey(esskill6.getUri())) {
								        		 skillMap.put(esskill6.getUri(), esskill6.getTitle());
								             }						        	 						        	 
								         }						        	 
							         }
							         
							         if(occ6.getLinks().getHasOptionalSkill()!=null) {
							        	 for (Skill optskill6 : occ6.getLinks().getHasOptionalSkill()) {
								        	 //System.out.println("Optional Skill from Level-6");
								        	 //System.out.println("\t\t\t\t" + optskill6.getTitle());
								        	 System.out.println();
								        	 
								        	 if(!skillMap.containsKey(optskill6.getUri())) {
								        		 skillMap.put(optskill6.getUri(), optskill6.getTitle());
								             }						        	 
								         }						        	 
							         }				        	 
						         }				        	 
					         }else {
					        	 System.out.println("No narrower occupation after level 5");
					         }			        	 
				         }			        	 
			         }else {
			        	 System.out.println("No narrower occupation after level 4");
			         }			         
		         }
		            
		         System.out.println();
		     }
		     
		     //print the extracted skills to a file
		     
		     for(HashMap.Entry<String, String> entry: skillMap.entrySet()) {
		    	 System.out.println(entry.getKey() + " : " + entry.getValue());
		    	 
		    	 BufferedWriter writer = new BufferedWriter(
		    			 					 new FileWriter("C:/Users/elisa sibarani/eclipse-workspace/GetSkillESCO/"+filename,true) 
		    			 					 );
		    	 writer.newLine();
		    	 writer.newLine();
		    	 		    	 
		    	 writer.write("saro:" + entry.getValue().replaceAll("[\\p{Ps}\\p{Pe}]", "").replaceAll("â€™", "").replaceAll("'", "").replaceAll(",", "").replaceAll("\\+", "plus").replaceAll("!", "").replaceAll(";", "").replaceAll(" ", "") + " a saro:Skill ;");
		    	 writer.newLine();
		    	 writer.write("\tsaro:isCoreTo saro:"+sectorname+" ;");
		    	 writer.newLine();
		    	 writer.write("\tsaro:isFrom \"ESCO\" ;" );
		    	 writer.newLine();
		    	 
		    	 url = "";
	        	 url = "http://localhost:8080/resource/skill?uri=" + entry.getKey() + "&language=en&full=true";
	        	 resp.delete(0, resp.length());
		         resp = sendGET(url);
		         ObjectMapper mapperskill = new ObjectMapper();
		         SkillsConcept skillTypeReuse = mapperskill.readValue(resp.toString(), SkillsConcept.class);
		    	 
		    	 for(Skill stype : skillTypeReuse.getLinks().getHasSkillType()) {
		    		 writer.write("\tsaro:hasSkillType \"" + stype.getTitle() + "\" ;");
		    		 writer.newLine();
		    	 }
		    	 for(BroaderConcept sreuse : skillTypeReuse.getLinks().getHasReuseLevel()) {
		    		 writer.write("\tsaro:hasReuseLevel \"" + sreuse.getTitle() + "\" ;");
		    		 writer.newLine();
		    	 }
		    	 
		    	 writer.write("\trdfs:label \"" + entry.getValue() + "\" .");
		    	 writer.close();
		    	 //break;
		    	}
		     
		     System.out.println("The amount of extracted skills:" + skillMap.size());
		     		     
		 } else {
		    	System.out.println("GET NOT WORKED");
		 }
			
	}
	
		
	private static void printParsedObject(OccupationLevel2 occupation) {
        
        System.out.println("className : " + occupation.getClassName());
        System.out.println();
        System.out.println("classId : " + occupation.getClassID());
        System.out.println();
        System.out.println("uri : " + occupation.getURI());
        System.out.println();
        System.out.println("title : " + occupation.getTitle());
        System.out.println();
        PreferredLabel preflab = occupation.getPreferredLabel();
        System.out.println("preferredLabel : ");
        System.out.println("**********");
        System.out.println("\tno : " + preflab.getno());
        System.out.println("\ten : " + preflab.geten());
        System.out.println();
        Description desc = occupation.getDescription();
        System.out.println("description : ");
        System.out.println("**********");
        System.out.println("\ten : ");
        System.out.println("\t\tliteral : " + desc.getEN().getLiteral());
        System.out.println("\t\tmimetype : " + desc.getEN().getMimeType());
        System.out.println();
        Links link = occupation.getLinks();
        System.out.println("_links : ");
        System.out.println("**********");
        System.out.println("\tself : ");
        System.out.println("\t\thref : " + link.getSelf().getHref());
        System.out.println("\t\turi : " + link.getSelf().getUri());
        System.out.println("\t\ttitle : " + link.getSelf().getTitle());
        System.out.println();
        
        
        System.out.println("\tisInScheme : ");
        for (IsInScheme sch : link.getIsInScheme()) {
        	System.out.println("\t\thref : " + sch.getHref());
            System.out.println("\t\turi : " + sch.getUri());
            System.out.println("\t\ttitle : " + sch.getTitle());
            System.out.println();
        }
        System.out.println("\tbroaderConcept : ");
        for (BroaderConcept bc : link.getBroaderConcept()) {
        	System.out.println("\t\thref : " + bc.getHref());
            System.out.println("\t\turi : " + bc.getUri());
            System.out.println("\t\ttitle : " + bc.getTitle());
            System.out.println("\t\tcode : " + bc.getCode());
            System.out.println();
        }
        System.out.println("\tnarrowerConcept : ");
        for (NarrowerConcept nc : link.getNarrowerConcept()) {
        	System.out.println("\t\thref : " + nc.getHref());
            System.out.println("\t\turi : " + nc.getUri());
            System.out.println("\t\ttitle : " + nc.getTitle());
            System.out.println("\t\tcode : " + nc.getCode());
            System.out.println();
        }
        
    }
	
	
	
	public static StringBuffer sendGET(String url) throws IOException {
		System.out.println("GET START");
	    URL obj = new URL(url);
	    String readLine = null;
	    HttpURLConnection con = (HttpURLConnection) obj.openConnection();
	    con.setRequestMethod("GET");
	    int responseCode = con.getResponseCode();
	    System.out.println("GET Response Code :: " + responseCode);
	    StringBuffer response = new StringBuffer();
	    if (responseCode == HttpURLConnection.HTTP_OK) {
	    	BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
	        	        
	        while ((readLine = in.readLine()) != null) {
	        	response.append(readLine);
	        	
	        }
	        in.close();
	        ObjectMapper mapper = new ObjectMapper();
	        
	        Object json = mapper.readValue(response.toString(), Object.class);
	        String indented = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(json);
	        
	        
	        //if you want to store the results in a json file
	        /*
	        BufferedWriter bwr = new BufferedWriter(new FileWriter(new File("skill-Transversal_groups.json")));
	        bwr.write(indented);
	        bwr.flush();
	        bwr.close();
	        System.out.println("Successfully written to JSON file");
	        */
	        
	        //print result to console
	        //System.out.println("JSON String Result " + indented);
	        
	        return response;
	        
	        
	    } else {
	        System.out.println("GET NOT WORKED");
	        response = null;
	       
	    }
		return response;
	}
}
