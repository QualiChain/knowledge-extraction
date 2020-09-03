import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonIgnoreProperties(ignoreUnknown=true)

public class LinksOccupationLevel6 {
	@JsonProperty("self") Self self;
	private IsInScheme[] isInScheme;
	private RegulatedProfessionNote regulatedProfessionNote;
	private BroaderOccupation[] broaderOccupation;
	private Skill[] hasEssentialSkill;
	private Skill[] hasOptionalSkill;
		
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
    
    public RegulatedProfessionNote getRegulatedProfessionNote() {
        return regulatedProfessionNote;
    }

    public void setRegulatedProfessionNote(RegulatedProfessionNote regulatedProfessionNote) {
        this.regulatedProfessionNote = regulatedProfessionNote;
    }
    
    public BroaderOccupation[] getBroaderOccupation() {
        return broaderOccupation;
    }

    public void setBroaderOccupation(BroaderOccupation[] broaderOccupation) {
        this.broaderOccupation = broaderOccupation;
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
