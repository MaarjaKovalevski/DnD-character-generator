/**
 * This class generates the characters characteristics if needed.
 * We ask the user if the character needs to be good or bad and assign 2 of the
 *      wished for characteristics to that character.
 * We also add one neutral characteristic and one character flaw.
 * The characteristics are generated randomly from different lists in separate files.
 * We read the files and create the lists using the method readFile() from the class readFiles.
 * When generating characteristics, the gender is needed to use the correct pronouns
 *      when adding the characteristics to the needed traits list.
 */

import java.util.Objects;

public class createCharacteristics {

    private String gender;
    private String characteristic1;
    private String characteristic2;
    private String characteristic3;
    private String flaw;


    public createCharacteristics(String gender, int goodOrBad) throws Exception {

        this.gender=gender;

        // If the character needs to have "good" characteristics:
        if (goodOrBad == 1) {
            String[] characteristics = readFiles.readFile("GoodCharacteristics.txt");
            int random = (int) (Math.random() * characteristics.length);
            this.characteristic1 = characteristics[random];
            random = (int) (Math.random() * characteristics.length);
            this.characteristic2 = characteristics[random];

        // If the character needs to have "bad" characteristics:
        } else if (goodOrBad == 2) {
            String[] characteristics = readFiles.readFile("BadCharacteristics.txt");
            int random = (int) (Math.random() * characteristics.length);
            this.characteristic1 = characteristics[random];
            random = (int) (Math.random() * characteristics.length);
            this.characteristic2 = characteristics[random];
        }

        String[] neutralCharacteristics = readFiles.readFile("NeutralCharacteristics.txt");
        int random = (int) (Math.random() * neutralCharacteristics.length);
        this.characteristic3 = neutralCharacteristics[random];

        String[] flaws = readFiles.readFile("CharacterFlaws.txt");
        random = (int) (Math.random() * flaws.length);
        this.flaw = flaws[random];
    }

    @Override
    public String toString() {
        // According to the gender the correct pronouns are chosen:
        String pronouns1;
        String pronouns2;

        if (Objects.equals(gender, "f")) {
            pronouns1 = "Her";
            pronouns2 = "she is";
        } else if (Objects.equals(gender, "m")) {
            pronouns1 = "His";
            pronouns2 = "he is";
        } else {
            pronouns1 = "Their";
            pronouns2 = "they are";
        }

        return pronouns1 + " strongest character trait is being " + characteristic1 +
                ", but " + pronouns2 + " also " + characteristic2 + ". \n" +
                "Oftentimes, though, " + pronouns2 +" " + characteristic3 + ". " +
                pronouns1 + " one big flaw: " + flaw + ".";
    }
}