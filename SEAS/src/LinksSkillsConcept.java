import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonIgnoreProperties(ignoreUnknown=true)

public class LinksSkillsConcept {
	@JsonProperty("self") Self self;
	private IsTopConceptInScheme[] isTopConceptInScheme;
	private IsInScheme[] isInScheme;
	private Skill[] hasSkillType;
	private BroaderConcept[] hasReuseLevel;
	private Skill[] hasEssentialSkill;
	private Skill[] hasOptionalSkill;	
	private IsInScheme[] isEssentialForOccupation;
	private IsInScheme[] isOptionalForOccupation;
	private Skill[] isEssentialForSkill;
	private Skill[] isOptionalForSkill;
			
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
    
    public Skill[] getHasSkillType() {
        return hasSkillType;
    }

    public void setHasSkillType(Skill[] hasSkillType) {
        this.hasSkillType = hasSkillType;
    }
    
    public BroaderConcept[] getHasReuseLevel() {
    	return hasReuseLevel;
    }
    
    public void setHasReuseLevel(BroaderConcept[] hasReuseLevel) {
    	this.hasReuseLevel = hasReuseLevel;
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
    
    public IsInScheme[] getIsEssentialForOccupation() {
        return isEssentialForOccupation;
    }

    public void setIsEssentialForOccupation(IsInScheme[] isEssentialForOccupation) {
        this.isEssentialForOccupation = isEssentialForOccupation;
    }
    
    public IsInScheme[] getIsOptionalForOccupation() {
        return isOptionalForOccupation;
    }

    public void setIsOptionalForOccupation(IsInScheme[] isOptionalForOccupation) {
        this.isOptionalForOccupation = isOptionalForOccupation;
    }
    
    public Skill[] getIsEssentialForSkill() {
        return isEssentialForSkill;
    }

    public void setIsEssentialForSkill(Skill[] isEssentialForSkill) {
        this.isEssentialForSkill = isEssentialForSkill;
    }
    
    public Skill[] getIsOptionalForSkill() {
        return isOptionalForSkill;
    }

    public void setIsOptionalForSkill(Skill[] isOptionalForSkill) {
        this.isOptionalForSkill = isOptionalForSkill;
    }
    

}
