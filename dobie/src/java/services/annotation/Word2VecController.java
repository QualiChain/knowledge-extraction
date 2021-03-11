package services.annotation;

import org.deeplearning4j.models.word2vec.Word2Vec;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;
import org.nd4j.linalg.ops.transforms.Transforms;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

public class Word2VecController {
	private Word2VecResources word2VecResources;
	private Word2Vec googleWordVec;

	public Word2VecController() throws IOException, URISyntaxException {
		word2VecResources = Word2VecResources.getInstance();
		googleWordVec = word2VecResources.getGoogleWordVec();
	}

	public double wordSimilarity (String word1, String word2){
		return googleWordVec.similarity(word1 , word2);
	}

	public INDArray composeVectorsBySummation(String multiWords) throws IOException{

		multiWords = multiWords.trim();
		String[] multi = multiWords.split("\\s+");

		// compute word vector #1
		INDArray wm;
		if( multi.length == 1 ){
			wm = googleWordVec.getWordVectorMatrix(multi[0]);
		}else if( multi.length == 2 ){
			wm = convertArraytoINDArray(composeVectorsBySummation(googleWordVec.getWordVectorMatrix(multi[0]), googleWordVec.getWordVectorMatrix(multi[1])));
		}else{
			wm = convertArraytoINDArray(composeVectorsBySummation(googleWordVec.getWordVectorMatrix(multi[0]), googleWordVec.getWordVectorMatrix(multi[1])));
			for(int i = 2; i < multi.length; i++){
				wm = convertArraytoINDArray(composeVectorsBySummation(wm, googleWordVec.getWordVectorMatrix(multi[i])));
			}
		}
		return wm;
	}

	public double compositionalSemanticSimilarity(String multiWords1, String multiWords2) throws IOException{

		multiWords1 = multiWords1.trim();
		multiWords2 = multiWords2.trim();
		String[] multi1 = multiWords1.split("\\s+");
		String[] multi2 = multiWords2.split("\\s+");

		// compute word vector #1
		INDArray wm1;
		if( multi1.length == 1 ){
			wm1 = googleWordVec.getWordVectorMatrix(multi1[0]);
		}else if( multi1.length == 2 ){
			wm1 = convertArraytoINDArray(composeVectorsBySummation(googleWordVec.getWordVectorMatrix(multi1[0]), googleWordVec.getWordVectorMatrix(multi1[1])));
		}else{
			wm1 = convertArraytoINDArray(composeVectorsBySummation(googleWordVec.getWordVectorMatrix(multi1[0]), googleWordVec.getWordVectorMatrix(multi1[1])));
			for(int i = 2; i < multi1.length; i++){
				wm1 = convertArraytoINDArray(composeVectorsBySummation(wm1, googleWordVec.getWordVectorMatrix(multi1[i])));
			}
		}

		// compute word vector 21
		INDArray wm2;
		if( multi2.length == 1 ){
			wm2 = googleWordVec.getWordVectorMatrix(multi2[0]);
		}else if( multi2.length == 2 ){
			wm2 = convertArraytoINDArray(composeVectorsBySummation(googleWordVec.getWordVectorMatrix(multi2[0]), googleWordVec.getWordVectorMatrix(multi2[1])));
		}else{
			wm2 = convertArraytoINDArray(composeVectorsBySummation(googleWordVec.getWordVectorMatrix(multi2[0]), googleWordVec.getWordVectorMatrix(multi2[1])));
			for(int i = 2; i < multi2.length; i++){
				wm2 = convertArraytoINDArray(composeVectorsBySummation(wm2, googleWordVec.getWordVectorMatrix(multi2[i])));
			}
		}

		// compute similarity between the two word vectors
		return Transforms.cosineSim(wm1,wm2);

	}

	public  INDArray convertArraytoINDArray(double[] d) {
		return Nd4j.create(d);

	}


	public  double[] composeVectorsBySummation( INDArray wm1, INDArray wm2){

		double[] wv1  = wm1.dup().data().asDouble();
		double[] wv2  = wm2.dup().data().asDouble();

		int size = Math.min(wv1.length, wv2.length);
		double[] composedVector = new double[size];

		//INDArray inferredVectorA = vec.getWordVectorMatrix(word1);
		//INDArray inferredVectorB = vec.getWordVectorMatrix(word2);

		//Transforms.cosineSim(inferredVectorA, inferredVectorB);

		for (int i = 0; i < size; i++) {
			composedVector[i] = wv1[i] + wv2[i];
		}

		return composedVector;
	}

	public  double[] getAverageVector( double[] vector, int num){

		double[] averageVector = new double[vector.length];

		//INDArray inferredVectorA = vec.getWordVectorMatrix(word1);
		//INDArray inferredVectorB = vec.getWordVectorMatrix(word2);

		//Transforms.cosineSim(inferredVectorA, inferredVectorB);

		for (int i = 0; i < vector.length; i++) {
			averageVector[i] = (double)(vector[i]/num);
		}

		return averageVector;
	}



}
