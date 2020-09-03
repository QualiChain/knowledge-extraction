
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonIgnoreProperties(ignoreUnknown=true)

public class SkillsConcept {
	private String className;
	@JsonProperty("classId") String classId;
	private String uri;
	private String title;
	private PreferredLabel preferredLabel;
	private Description description;
	@JsonProperty("_links") LinksSkillsConcept _links;
	private String _embedded;
	
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
    
	public Description getDescription() {
        return description;
    }

    public void setDescription(Description description) {
        this.description = description;
    }
    
	public LinksSkillsConcept getLinks() {
        return _links;
    }

    public void setLinks(LinksSkillsConcept _links) {
        this._links = _links;
    }
    
	public String getEmbedded() {
        return _embedded;
    }

    public void setEmbedded(String _embedded) {
        this._embedded = _embedded;
    }

}
