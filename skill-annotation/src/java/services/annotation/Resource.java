package services.annotation;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

/**
 * Root resource (exposed at "resource" path)
 */
@Path("dobie")
public class Resource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     * @throws MalformedURLException 
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() throws MalformedURLException {
        return "Ready to annotate the text!";
    }
    
    @Path("getname")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getName(@QueryParam("firstname") String firstName, @QueryParam("lastname") String lastName){
    	return "{name:" + firstName+ " " + lastName + "}";
    }
    

    

    
    @POST
	@Path("/fileUpload/{type}")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
//    @Produces(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public Response uploadFileJSON(
		@PathParam("type") String type,
		@FormDataParam("file") InputStream uploadedInputStream,
		@FormDataParam("file") FormDataContentDisposition fileDetail) throws Exception {

    	File file = new File("Files");
    	
    	if(!file.exists()){
    		if(file.mkdir()){
    			System.out.println(file.toString() + " has been created!");
    		}else{
    			System.out.println("Failed to create directory \"Files/\"");
    		}
    	}
    		
    	String filename = fileDetail.getFileName();
		String uploadedFileLocation = file.toString() + "/" + validateFilename(filename);		
		
		writeToFile(uploadedInputStream, uploadedFileLocation);
		

    	URL fileUrl = new File(uploadedFileLocation).toURI().toURL();
    	System.out.println("starting to annotate the file");
    	try{
			AnnotationSummary annotationSummary = new AnnotationSummary();
			List<String> TTLs = annotationSummary.generateAnnotation(fileUrl, type);
			System.out.println("Annotation finished!");
			return Response.ok().entity(new GenericEntity<String>(TTLs.get(0)){})
					.header("Access-Control-Allow-Origin", "*")
					.header("Access-Control-Allow-Methods", "*")
					.build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.ok().entity("Error running the pipeline").build();

		}

	}



    
/*    @POST
	@Path("/urlUploadJSON")  
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public Response uploadUrlJSON(
    		String eula
    		) throws Exception {


    	Document doc = Jsoup.connect(eula).get();
		
    	String text = doc.body().text();
    	String title = doc.title();
    	System.out.print("Title: "+title);

    	File file = new File("Files");
    	
    	if(!file.exists()){
    		if(file.mkdir()){
    			System.out.println(file.toString() + " has been created!");
    		}else{
    			System.out.println("Failed to create directory \"Files/\"");
    		}
    	}
    	
    	String filename = title + ".txt";    	
		String uploadedFileLocation = file.toString() + "/" + validateFilename(filename);

		InputStream inputStream = IOUtils.toInputStream(text, "windows-1252");
		writeToFile(inputStream, uploadedFileLocation);
		
    	ThreadDao tDao = new ThreadDao();
    	URL fileUrl = new File(uploadedFileLocation).toURI().toURL();
    	
    	Summary summary = tDao.getSummaryForDoc(fileUrl);
		summary.setSubject(title);		
		
		return Response.ok().entity(new GenericEntity<Summary>(summary){})
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "*")
				.build();
	}*/
    
	// save uploaded file to new location
	private void writeToFile(InputStream uploadedInputStream,
		String uploadedFileLocation) {

		try {
			OutputStream out = new FileOutputStream(new File(
					uploadedFileLocation));
			int read = 0;
			byte[] bytes = new byte[1024];

			out = new FileOutputStream(new File(uploadedFileLocation));
			while ((read = uploadedInputStream.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}
			out.flush();
			out.close();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
	
	private String validateFilename(String filename){
		
		String regx = "\\/:*?\"<>|";
		char[] ca = regx.toCharArray();
		for(char c : ca){
			filename = filename.replace(""+c,"");
		}
		
		return filename;
	}
    
    @Path("getRDFdataset/{path}/{type}")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
//    @Produces(MediaType.APPLICATION_XML)
    public Response doGetAsJSON(@PathParam("path") String path, @PathParam("type") String type) {
		try {
			AnnotationSummary annotationSummary = new AnnotationSummary();
			List<String> TTLs = annotationSummary.generateAnnotation(getClass().getResource("/docs/testset/test/"+path), type);
			return Response.ok().entity(new GenericEntity<String>(TTLs.get(0)){})
					.header("Access-Control-Allow-Origin", "*")
					.header("Access-Control-Allow-Methods", "*")
					.build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.ok().entity("No file was found").build();

		}
    }

}
