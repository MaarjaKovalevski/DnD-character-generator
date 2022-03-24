/**
 * This class generates a backstory if it is needed.
 * The backstory is generated randomly from different lists in separate files
 *      (this includes parents/guardians, other relatives/pets and occupation).
 * We read the files and create the lists using the method readFile() from the class readFiles.
 * When generating a backstory, the gender is needed to use the correct pronouns
 *      when adding the backstory to the needed traits list.
 */

import java.util.Objects;

public class createBackstory {

    private String gender;
    private String parents;
    private String relatives1;
    private String relatives2;
    private String occupation;


    public createBackstory(String gender) throws Exception {

        this.gender = gender;

        String[] parents = readFiles.readFile("Parents.txt");
        int random = (int) (Math.random() * parents.length);
        this.parents = parents[random];

        String[] relatives = readFiles.readFile("Relatives.txt");
        int random1 = (int) (Math.random() * relatives.length);
        int random2 = (int) (Math.random() * relatives.length);
        this.relatives1 = relatives[random1];
        this.relatives2 = relatives[random2];

        String[] occupation = readFiles.readFile("Occupation.txt");
        random = (int) (Math.random() * occupation.length);
        this.occupation = occupation[random];
    }

    @Override
    public String toString() {
        // According to the gender the correct pronouns are chosen:
        String pronouns1;
        String pronouns2;
        String pronouns3;
        String pronouns4;

        if (Objects.equals(gender, "f")) {
            pronouns1 = "She was";
            pronouns2 = "she";
            pronouns3 = "her";
            pronouns4 = "She earns her";
        } else if (Objects.equals(gender, "m")) {
            pronouns1 = "He was";
            pronouns2 = "he";
            pronouns3 = "his";
            pronouns4 = "He earns his";
        } else {
            pronouns1 = "They were";
            pronouns2 = "they";
            pronouns3 = "their";
            pronouns4 = "They earn their";
        }

        // If both of the relatives are the same name, we correct
        // the phrasing of the toString() to have better readability:
        if (relatives1.equals(relatives2))
            return pronouns1 + " raised by " + parents +
                    " and " + pronouns2 + " lived with " + pronouns3 + " two " + relatives1 +
                    "s. " + pronouns4 + " living as a " + occupation+".";
        else {
            return pronouns1 + " raised by " + parents +
                    " and " + pronouns2 + " lived with " + pronouns3 + " " + relatives1 +
                    " and " + pronouns3 + " " + relatives2 + ". " + pronouns4 + " living as a " + occupation + ".";
        }
    }
}
