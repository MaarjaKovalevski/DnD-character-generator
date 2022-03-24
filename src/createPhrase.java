/**
 * This class generates a catchphrase if it is needed.
 * The catchphrase is generated randomly from a list of catchphrases in a separate file.
 * We read the file and create the list using the method readPhrase() from the class readFiles.
 * When generating a phrase, the gender is needed to use the correct pronouns
 *      when adding the phrase to the needed traits list.
 */

import java.util.Objects;

public class createPhrase {
    private String gender;
    private String phrase;

    public createPhrase(String gender) throws Exception {
        this.gender = gender;
        String[] phrases = readFiles.readPhrase();
        int random = (int) (Math.random() * phrases.length);
        this.phrase = phrases[random];
    }

    @Override
    public String toString() {
        // According to the gender, the correct pronouns are chosen:
        String pronouns;
        if (Objects.equals(gender, "f")) {
            pronouns = "Her";
        } else if (Objects.equals(gender, "m")) {
            pronouns = "His";
        } else {
            pronouns = "Their";
        }

        return pronouns+" favourite saying is: " + phrase;
    }
}
