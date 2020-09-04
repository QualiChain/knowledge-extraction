import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonIgnoreProperties(ignoreUnknown=true)

public class Description {
	private DescEN en;

	public DescEN getEN() {
        return en;
    }

    public void setEN(DescEN en) {
        this.en = en;
    }
}
