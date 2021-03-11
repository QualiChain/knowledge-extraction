package services.annotation;


import gate.util.Out;
import org.deeplearning4j.models.word2vec.Word2Vec;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Properties;
import java.util.Vector;

/**
 * Class to get all data from the document using GATE modules. 
 *
 */
public class Word2VecResources {

	Word2Vec googleWordVec;
	private static Word2VecResources instance = null;



	protected Word2VecResources(Word2Vec vectors) throws  IOException, URISyntaxException{
		setGoogleWordVec(vectors);
		Out.prln("Word2Vec is initialized");

	}

	private void setGoogleWordVec(Word2Vec vectors) {
		googleWordVec = vectors;
	}

	public Word2Vec getGoogleWordVec(){
		return googleWordVec;
	}



	public static Word2VecResources getInstance(Word2Vec vectors) throws IOException, URISyntaxException{
		if(instance == null){
			instance = new Word2VecResources(vectors);
		}

		return instance;
	}

	public static Word2VecResources getInstance() throws  IOException, URISyntaxException {
		return instance;
	}

}