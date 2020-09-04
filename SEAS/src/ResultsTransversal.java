import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonIgnoreProperties(ignoreUnknown=true)

public class ResultsTransversal {
	private String className;
	@JsonProperty("classId") String classId;
	private String uri;
	private String title;
	private PreferredLabel preferredLabel;
	
	
	public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
    
	public String getClassID() {
        return classId;
    }

    public void setClassID(String classId) {
        this.classId = classId;
    }
    
	public String getURI() {
        return uri;
    }

    public void setURI(String uri) {
        this.uri = uri;
    }
    
	public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

	public PreferredLabel getPreferredLabel() {
        return preferredLabel;
    }

    public void setPreferredLabel(PreferredLabel preferredLabel) {
        this.preferredLabel = preferredLabel;
    }
    	
}
