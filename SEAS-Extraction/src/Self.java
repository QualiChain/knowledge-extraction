import com.fasterxml.jackson.annotation.JsonProperty;

public class Self {
	@JsonProperty("href") String href;
	@JsonProperty("uri") String uri;
	@JsonProperty("title") String title;
	
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
