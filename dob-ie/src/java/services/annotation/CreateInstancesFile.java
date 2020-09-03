package services.annotation;

import java.io.*;


import org.apache.jena.ontology.OntModelSpec;
import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Resource;


import org.apache.jena.vocabulary.RDF;

import gate.creole.ontology.Ontology;


public class CreateInstancesFile {
    private static GateResources gr;
    private static Ontology pwcAcc;
    private static Model saroModel = ModelFactory.createOntologyModel(OntModelSpec.OWL_DL_MEM);


    public CreateInstancesFile() throws FileNotFoundException {
        String typeCamelCase = "";
        saroModel.read(new FileInputStream(getClass().getClassLoader().getResource("SkillsAndRecruitmentOntology.owl").getFile()), null);


        String[] allInstances = getAllInstances();
        String str = "";
        for(int i = 0; i < allInstances.length; i++){
            String strWithSpace = allInstances[i];
            Resource saroType = findSaroType(strWithSpace);
            if(saroType != null) {
                String[] spacesplitted = strWithSpace.split(" ");
                String camelCase = spacesplitted[0].toLowerCase();
                for(int j = 1; j < spacesplitted.length; j++){
                    camelCase += spacesplitted[j].substring(0,1).toUpperCase() +  spacesplitted[j].substring(1).toLowerCase();
                }


                String saroTypeStr = saroType.toString();
                String type = saroTypeStr.substring(saroTypeStr.lastIndexOf("#") + 1);
                if(type.equals("tool")){
                    typeCamelCase = "Tool";
                }else if(type.equals("product")){
                    typeCamelCase = "Product";
                }else if(type.equals("topic")){
                    typeCamelCase = "Topic";
                }else if(type.equals("transversalskill")){
                    typeCamelCase = "TransversalSkill";
                }
                str =  "saro:" + camelCase + " a saro:" + typeCamelCase + " ;\n" +
                        "\t rdfs:label \"" + strWithSpace + "\" .";
//                System.out.println(str);
//                System.out.println();
            }else{
                System.out.println(strWithSpace);
            }
        }
//        Dataset instances = RDFDataMgr.loadDataset(getClass().getClassLoader().getResource("skillNames.ttl").getFile()) ;
//
//
//        OutputStream informaticsSkills = new FileOutputStream(new File("InformaticsSkills.ttl"));
//
//        RDFDataMgr.write(informaticsSkills, dataset.getDefaultModel(), RDFFormat.TURTLE_PRETTY) ;


    }

    public Resource findSaroType (String strWithSpace){
        String[] spaceSplitted = strWithSpace.split(" ");
        strWithSpace = strWithSpace.replaceAll(" ", "");
        strWithSpace = strWithSpace.replaceAll("-", "");


        Resource retrievedInstance = saroModel.getResource("http://www.semanticweb.org/elisasibarani/ontologies/2016/0/untitled-ontology-51#"+strWithSpace);
        Resource retrievedType = retrievedInstance.getPropertyResourceValue(RDF.type);
        return retrievedType;
    }

    public String[] getAllInstances() throws FileNotFoundException {

        Model model = ModelFactory.createDefaultModel();
        model.read(new FileInputStream(getClass().getClassLoader().getResource("skillNames.ttl").getFile()), null, "TTL");

        String queryString = "" +
                "prefix ns3: <" + "http://www.edsa-project.eu/edsa#" + ">\n" +
                "SELECT  ?uri  ?str\n" +
                "WHERE {  \n" +
                "?uri ns3:lexicalValue ?str. \n" +
                "}";


        System.out.println(queryString);

        Query query = QueryFactory.create(queryString);
        QueryExecution qexec = QueryExecutionFactory.create(query, model);
        ResultSet rs = qexec.execSelect();

        String[] allInstances = new String[733];
//        ArrayList<HashMap<String, String>> allInstances = new ArrayList<HashMap<String, String>>();
        int counter = 0;
        for (; rs.hasNext(); ) {
            QuerySolution soln = rs.nextSolution();
//            HashMap<String, String> instance = new HashMap<String, String>();
            String str = soln.get("str").toString();
//            instance.put("str", str);
            String corruptedURI = soln.get("uri").asResource().getURI();
//            instance.put("corruptedURI", corruptedURI);
//            allInstances.add(instance);
            allInstances[counter] = str;
            counter++;
        }
        return allInstances;
    }

    public static void main(String[] args) throws FileNotFoundException {

        CreateInstancesFile createInstancesFile = new CreateInstancesFile();
    }


}
