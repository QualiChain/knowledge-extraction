package services.annotation;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.io.IOUtils;


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
import org.json.JSONArray;
import org.json.JSONObject;


/**
 * Root resource (exposed at "resource" path)
 */
@Path("")
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
	public Response uploadFile(
		@PathParam("type") String type,
		@FormDataParam("file") InputStream uploadedInputStream,
		@FormDataParam("file") FormDataContentDisposition fileDetail) throws Exception {


//    	String filename = fileDetail.getFileName();
//		writeToFile(uploadedInputStream, uploadedFileLocation);
		AnnotationSummary annotationSummary = new AnnotationSummary();
		List<String> TTLs = new ArrayList<String>();
		try {
			if (type.equals(Consts.JOB_WATCH_TYPE)) {
				String JSON_DATA = IOUtils.toString(uploadedInputStream);
				final JSONObject obj = new JSONObject(JSON_DATA);
				if (obj.getJSONArray("jobPost") != null){
					JSONArray jobWatch = obj.getJSONArray("jobPost");
					if (jobWatch.length() > 0){
						JSONObject job = jobWatch.getJSONObject(0);
						job.getString("location");

						String jobSnippet = job.getString("description");
						InputStream jobSnippetStream = new ByteArrayInputStream(jobSnippet.getBytes(StandardCharsets.UTF_8));
						URL fileUrl = stream2file(jobSnippetStream).toURI().toURL();
						TTLs = annotationSummary.generateJobWatchAnnotation(fileUrl, Consts.JOB_POST_TYPE, job.getString("title"), job.getString("location"), job.getString("company"));
					}
				}
			} else {
				URL fileUrl = stream2file(uploadedInputStream).toURI().toURL();
				TTLs = annotationSummary.generateAnnotation(fileUrl, type);
			}
			System.out.println("starting to annotate the file");
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



    @POST
	@Path("/jsonUpload/{type}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response uploadFileJSON(
			@PathParam("type") String type,
			@FormDataParam("file") InputStream uploadedInputStream,
			@FormDataParam("file") FormDataContentDisposition fileDetail) throws Exception {

//    public Response uploadJSON(	@PathParam("type") String type,  Data data) throws Exception {
		return Response.ok().entity(new GenericEntity<String>("DONE"){})
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "*")
				.build();
	}

	private File stream2file (InputStream in) throws IOException {
		String PREFIX = "stream2file";
		String SUFFIX = ".tmp";
		final File tempFile = File.createTempFile(PREFIX, SUFFIX);
		tempFile.deleteOnExit();
		try (FileOutputStream out = new FileOutputStream(tempFile)) {
			IOUtils.copy(in, out);
		}
		return tempFile;
	}
	// save uploaded file to new location
	private void writeToFile(InputStream uploadedInputStream,
		String uploadedFileLocation) {

		try {
			OutputStream out;
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

class Data {
	private double id;
	private String text;

	@JsonCreator
	public Data(@JsonProperty("id") double latitude,
				@JsonProperty("text") String time) {
		this.id = latitude;
		this.text = text;
	}

	public String getText() {
		return text;
	}

}
