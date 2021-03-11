package services.annotation;
import org.apache.jena.sys.JenaSystem;
import org.deeplearning4j.models.embeddings.loader.WordVectorSerializer;
import org.deeplearning4j.models.word2vec.Word2Vec;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.media.multipart.MultiPartFeature;

import gate.util.*;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
//import org.datavec.api.util.ClassPathResource;




/**
 * Main class.
 *
 */
public class Main {
    // Base URI the Grizzly HTTP server will listen on
    public static final String BASE_URI = "http://0.0.0.0:5000/";
//    public static final String BASE_URI = "http://129.26.77.77:5000/";



	
    /**
     * Starts Grizzly HTTP server exposing JAX-RS resources defined in this application.
     * @return Grizzly HTTP server.
     */
    public static HttpServer startServer() {
        // create a resource config that scans for JAX-RS resources and providers
        final ResourceConfig rc = new ResourceConfig().packages("services.annotation");
        rc.register(MultiPartFeature.class);
        rc.register(new CorsFilter());


        // create and start a new instance of grizzly http server
        // exposing the Jersey application at BASE_URI
        return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI),rc);
    }

	
    public Main(){

		}
    /**
     * Main method.
     * @param args
     * @throws IOException
     * @throws GateException 
     */
   
    public static void main(String[] args) throws IOException, GateException , Exception{
        final HttpServer server = startServer();
        JenaSystem.init();
        org.apache.jena.query.ARQ.init();
        String gateHome = "";
        if(args.length > 0 ){
        	gateHome = args[0];

        }else{
        	gateHome = "gate";
        }
        System.out.println("Loading Gate libraries ...");
        GateResources.getInstance(gateHome);
        System.out.println("Loading Google Model ...");
        //File gModel = new ClassPathResource("GoogleNews-vectors-negative300.bin.gz").getFile();
        File gModel = new File("GoogleNews-vectors-negative300.bin.gz");
        Word2Vec googleVector  = WordVectorSerializer.readWord2VecModel(gModel);
        System.out.println("Loading Google Model Finished");
        System.out.println("Initializig word2vec instance ...");
        Word2VecResources.getInstance(googleVector);
        System.out.println("finished");
        System.out.println("Server started: http://localhost:5000/ ");
        System.out.println("Hit enter to stop it...");
        System.in.read();
        server.shutdown();

    }
}

