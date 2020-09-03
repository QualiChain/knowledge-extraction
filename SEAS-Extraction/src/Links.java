import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonIgnoreProperties(ignoreUnknown=true)
public class Links {
	@JsonProperty("self") Self self;
	private IsInScheme[] isInScheme;
	private BroaderConcept[] broaderConcept;
	private NarrowerConcept[] narrowerConcept;
	
    public Self getSelf() {
        return self;
    }

    public void setSelf(Self self) {
        this.self = self;
    }
	
    public IsInScheme[] getIsInScheme() {
        return isInScheme;
    }

    public void setIsInScheme(IsInScheme[] isInScheme) {
        this.isInScheme = isInScheme;
    }

    public BroaderConcept[] getBroaderConcept() {
        return broaderConcept;
    }

    public void setBroaderConcept(BroaderConcept[] broaderConcept) {
        this.broaderConcept = broaderConcept;
    }
    
    public NarrowerConcept[] getNarrowerConcept() {
        return narrowerConcept;
    }

    public void setNarrowerConcept(NarrowerConcept[] narrowerConcept) {
        this.narrowerConcept = narrowerConcept;
    }
    
}
