/**
 * This class generates a name if it is needed.
 * The name is generated randomly from a list of names in a separate file.
 * We read the file and create the list using the method readFile() from the class readFiles.
 * When generating a name, the gender is needed to choose the proper file
 *      which contains the proper names (female, male or neutral).
 */

public class generateName {

    private String firstname;
    private String lastname;


    public generateName(String gender) throws Exception {

        // First we generate the first name according to the gender of the character:

        // If the character is female:
        if (gender.equals("f")) {
            String[] names = readFiles.readFile("FemaleNames.txt");
            int random = (int) (Math.random() * names.length);
            this.firstname = names[random];

        // If the character is male:
        } else if (gender.equals("m")) {
            String[] names = readFiles.readFile("MaleNames.txt");
            int random = (int) (Math.random() * names.length);
            this.firstname = names[random];

        // If the character is any other gender:
        } else {
            String[] names = readFiles.readFile("NeutralNames.txt");
            int random = (int) (Math.random() * names.length);
            this.firstname = names[random];
        }

        // We also generate the last name:
        String[] lastnames = readFiles.readFile("LastNames.txt");
        int random = (int)(Math.random()*lastnames.length);
        this.lastname = lastnames[random];
    }

    @Override
    public String toString() {
        return "The name of this person is " + firstname + " " + lastname + ".";
    }
}
