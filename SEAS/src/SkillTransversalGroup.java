import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonIgnoreProperties(ignoreUnknown=true)

public class SkillTransversalGroup {
	@JsonProperty("total") Integer total;
	@JsonProperty("_embedded") EmbeddedResultsTransversal _embedded;
		
	public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
    
    public EmbeddedResultsTransversal getEmbedded() {
        return _embedded;
    }

    public void setEmbedded(EmbeddedResultsTransversal _embedded) {
        this._embedded = _embedded;
    }

}
