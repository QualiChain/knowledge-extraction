import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonIgnoreProperties(ignoreUnknown=true)

public class EmbeddedResultsTransversal {
	@JsonProperty("results") ResultsTransversal[] results;
	
	public ResultsTransversal[] getResultsTransversal() {
        return results;
    }

    public void setResultsTransversal(ResultsTransversal[] results) {
        this.results = results;
    }   

}
