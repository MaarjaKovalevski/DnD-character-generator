/**
 * The purpose of this class is to remember the gender of the character.
 */

public class generateGender {

    private String gender;


    public generateGender() {
        this.gender = "o";
    }

    // We use the get method to get the gender when needed:
    public String getGender() {
        return gender;
    }

    // What gender the user wishes the character to be:
    public void setGender(String gender) {
        this.gender = gender;
    }
}
