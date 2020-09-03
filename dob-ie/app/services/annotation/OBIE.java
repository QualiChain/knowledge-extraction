package services.annotation;

import java.io.File;
import java.util.ArrayList;
import gate.Corpus;
import gate.creole.gazetteer.Gazetteer;
import gate.creole.ontology.Ontology;

public interface OBIE {

	public void pipeline(ArrayList<File> files);
	public void saveToXML(Corpus corp);
	public Gazetteer createGazetteerOntologyBased(Ontology ontforgaz);
	public void createCorpus(ArrayList<File> files);
	public void loadOntology();
	public void displayDocumentFeatures(Corpus corp);
	
}


