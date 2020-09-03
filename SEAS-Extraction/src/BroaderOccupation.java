import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonIgnoreProperties(ignoreUnknown=true)

public class BroaderOccupation {
	private String href;
	private String uri;
	private String title;
		
	public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

	public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }
    
	public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
