package Test.inheritance;

public class Engineer extends Employee{
    private String skillset;
    //왜?
    public Engineer(String name) {
        super(name);
    }

    public String getSkillSet() {
        return skillset;
    }
    public void setSkillSet(String skillset) {
        this.skillset = skillset;
    }
}
