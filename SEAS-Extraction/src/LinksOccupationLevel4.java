import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonIgnoreProperties(ignoreUnknown=true)

public class LinksOccupationLevel4 {
	@JsonProperty("self") Self self;
	private IsInScheme[] isInScheme;
	private BroaderConcept[] broaderConcept;
	private NarrowerOccupation[] narrowerOccupation;
	
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
    
    public NarrowerOccupation[] getNarrowerOccupation() {
        return narrowerOccupation;
    }

    public void setNarrowerOccupation(NarrowerOccupation[] narrowerOccupation) {
        this.narrowerOccupation = narrowerOccupation;
    }

}
