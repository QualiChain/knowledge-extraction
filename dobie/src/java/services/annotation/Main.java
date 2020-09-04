package services.annotation;
import org.apache.jena.sys.JenaSystem;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.media.multipart.MultiPartFeature;

import gate.util.*;
import java.io.IOException;
import java.net.URI;


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
        GateResources.getInstance(gateHome);

        System.out.println("Server started: http://localhost:5000/ ");

        System.out.println("Hit enter to stop it...");


        System.in.read();
        server.shutdown();

    }
}

