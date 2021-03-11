package services.annotation;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.io.IOUtils;


import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.deeplearning4j.models.word2vec.Word2Vec;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

// assumes the current class is called MyLogger


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

		Logger logger = Logger.getLogger(Resource.class.getName());
		FileHandler fh;
		logger.setLevel(Level.FINE);


		try {

			// This block configure the logger with handler and formatter
			File directory = new File("Log");
			boolean dirCreated = directory.mkdir();
			fh = new FileHandler("Log/UploadFile.log");
			logger.addHandler(fh);
			SimpleFormatter formatter = new SimpleFormatter();
			fh.setFormatter(formatter);

			// the following statement is used to log any messages
			logger.info("Entering uploadFile function ..");

		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}


//    	String filename = fileDetail.getFileName();
//		writeToFile(uploadedInputStream, uploadedFileLocation);
		AnnotationSummary annotationSummary = new AnnotationSummary();
		List<String> TTLs = new ArrayList<String>();
		try {
			logger.info("Checking the file type ..");
			if (type.equals(Consts.JOB_WATCH_TYPE)) {
				System.out.println("Wrong call of method!");
				/*
				String JSON_DATA = IOUtils.toString(uploadedInputStream);
				final JSONObject obj = new JSONObject(JSON_DATA);
				if (obj.getJSONArray("jobPost") != null) {
					JSONArray jobWatch = obj.getJSONArray("jobPost");
					if (jobWatch.length() > 0){
						JSONObject job = jobWatch.getJSONObject(0);
						job.getString("location");

						String jobSnippet = job.getString("description");
						InputStream jobSnippetStream = new ByteArrayInputStream(jobSnippet.getBytes(StandardCharsets.UTF_8));
						URL fileUrl = stream2file(jobSnippetStream).toURI().toURL();
						TTLs = annotationSummary.generateJobWatchAnnotation(fileUrl, Consts.JOB_POST_TYPE, job.getString("title"), job.getString("location"), job.getString("company"));
					}
				}*/
			} else {
				logger.info("creating tmp file ..");
				URL fileUrl = stream2file(uploadedInputStream).toURI().toURL();
				logger.info("starting to annotate the file ..");
				TTLs = annotationSummary.generateAnnotation(fileUrl, type);
				logger.info("Annotation finished!");
			}
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
	@Path("/jsonData/{type}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response jobPostNTUA(@PathParam("type") String type, String metadata) {
		AnnotationSummary annotationSummary = new AnnotationSummary();
		List<String> TTLs = new ArrayList<String>();
		try {
			if (type.equals(Consts.NTUA_JOB_POST)) {
			final JSONObject obj = new JSONObject(metadata);
				if (obj.getJSONArray("tasks") != null) {
					JSONArray jobWatch = obj.getJSONArray("tasks");
					if (jobWatch.length() > 0){
						JSONObject job = jobWatch.getJSONObject(0);
						String jobSnippet = job.has("jobDescription")  ? job.getString("jobDescription") : "";
						String jobTitle = job.has("title") ? job.getString("title") : "";
						String jobLocation = job.has("location") ? job.getString("location"): "";
						String jobCompany = job.has("company") ? job.getString("company"): "";
//						String jobLink = job.has("link") ? job.getString("link"): "";
						String datePosted = job.has("date") ? job.getString("date"): "";
						if (datePosted.length() > 0) {
							datePosted = datePosted.trim();
							datePosted = datePosted.substring(0,10);
						}
						InputStream jobSnippetStream = new ByteArrayInputStream(jobSnippet.getBytes(StandardCharsets.UTF_8));
						URL fileUrl = stream2file(jobSnippetStream).toURI().toURL();
						TTLs = annotationSummary.generateJobWatchAnnotation(fileUrl, Consts.JOB_POST_TYPE, jobTitle, jobLocation.trim() , jobCompany, datePosted);

					}
				}
			}
			System.out.println("starting to annotate the job post description");
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

	@POST
	@Path("/degreeComparison")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response degreeComparison(String metadata) throws IOException, URISyntaxException {
		/*curl -v -H "Content-Type:application/json" -d "{\"tasks\":[{\"label\":\"computer\" , \"label2\":\"informatics\"}]}" "http://localhost:5000/degreeComparison"*/
		Word2VecController word2VecController = new Word2VecController();
		try {
			double similarity = 0;
			final JSONObject obj = new JSONObject(metadata);
			if (obj.getJSONArray("tasks") != null) {
				JSONArray jobWatch = obj.getJSONArray("tasks");
				if (jobWatch.length() > 0) {
					JSONObject job = jobWatch.getJSONObject(0);
					String str1 = job.has("label") ? job.getString("label") : "";
					String str2 = job.has("label2") ? job.getString("label2") : "";
					if (str1.equals(str2)) {
						similarity = 1;
					} else if (!str1.contains(" ") && !str2.contains(" ")) { // if both are a single token
						similarity = word2VecController.wordSimilarity(str1 , str2);
					} else {
						similarity = word2VecController.compositionalSemanticSimilarity(str1 , str2);
					}
				}
			}

			return Response.ok().entity(new GenericEntity<Double>(similarity){})
					.header("Access-Control-Allow-Origin", "*")
					.header("Access-Control-Allow-Methods", "*")
					.build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.ok().entity("Error running the pipeline").build();

		}
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
class Agent {
	private Name name;
	// getters and setters

	public static class Name {
		private String first;
		private String last;
		// getters and setters
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
