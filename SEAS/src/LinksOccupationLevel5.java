import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonIgnoreProperties(ignoreUnknown=true)

public class LinksOccupationLevel5 {
	@JsonProperty("self") Self self;
	private IsTopConceptInScheme[] isTopConceptInScheme;
	private IsInScheme[] isInScheme;
	private RegulatedProfessionNote regulatedProfessionNote;
	private BroaderIscoGroup[] broaderIscoGroup;
	private NarrowerOccupation[] narrowerOccupation;
	private Skill[] hasEssentialSkill;
	private Skill[] hasOptionalSkill;
		
    public Self getSelf() {
        return self;
    }

    public void setSelf(Self self) {
        this.self = self;
    }
    
    public IsTopConceptInScheme[] getIsTopConceptInScheme() {
        return isTopConceptInScheme;
    }

    public void setIsTopConceptInScheme(IsTopConceptInScheme[] isTopConceptInScheme) {
        this.isTopConceptInScheme = isTopConceptInScheme;
    }
	
    public IsInScheme[] getIsInScheme() {
        return isInScheme;
    }

    public void setIsInScheme(IsInScheme[] isInScheme) {
        this.isInScheme = isInScheme;
    }
    
    public RegulatedProfessionNote getRegulatedProfessionNote() {
        return regulatedProfessionNote;
    }

    public void setRegulatedProfessionNote(RegulatedProfessionNote regulatedProfessionNote) {
        this.regulatedProfessionNote = regulatedProfessionNote;
    }
    
    public BroaderIscoGroup[] getBroaderIscoGroup() {
        return broaderIscoGroup;
    }

    public void setBroaderIscoGroup(BroaderIscoGroup[] broaderIscoGroup) {
        this.broaderIscoGroup = broaderIscoGroup;
    }
   
    public NarrowerOccupation[] getNarrowerOccupation() {
        return narrowerOccupation;
    }

    public void setNarrowerOccupation(NarrowerOccupation[] narrowerOccupation) {
        this.narrowerOccupation = narrowerOccupation;
    }
    
    public Skill[] getHasEssentialSkill() {
        return hasEssentialSkill;
    }

    public void setHasEssentialSkill(Skill[] hasEssentialSkill) {
        this.hasEssentialSkill = hasEssentialSkill;
    }
    
    public Skill[] getHasOptionalSkill() {
        return hasOptionalSkill;
    }

    public void setHasOptionalSkill(Skill[] hasOptionalSkill) {
        this.hasOptionalSkill = hasOptionalSkill;
    }
    
}
