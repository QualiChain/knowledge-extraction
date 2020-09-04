import com.fasterxml.jackson.annotation.JsonProperty;

public class DescEN {
	private String literal;
	@JsonProperty("mimetype") String mimetype;
	
	public String getLiteral() {
        return literal;
    }

    public void setLiteral(String literal) {
        this.literal = literal;
    }
    
	public String getMimeType() {
        return mimetype;
    }

    public void setMimeType(String mimetype) {
        this.mimetype = mimetype;
    }

}
