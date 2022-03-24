/**
 * This class generates the characters looks if needed.
 * The looks are generated randomly from different lists in separate files
 *      (this includes race; extras and skin-color according to the race; body type and weight;
 *      hair length, color and style; face shape; eye color and shape).
 * We also generate an age randomly.
 * We read the files and create the lists using the methods readFile(), readRace()
 *      and readSkincolor() from the class readFiles.
 * When generating looks, the gender is needed to use the correct pronouns
 *      when adding the looks to the needed traits list.
 */

import java.util.Objects;

public class createLooks {
    private String gender;
    private String race;
    private String extras;
    private String skincolor;
    private String bodytype;
    private String bodyweight;
    private int age;
    private String hairlength;
    private String haircolor;
    private String hairstyle;
    private String faceshape;
    private String eyecolor;
    private String eyeshape;

    public createLooks(String gender) throws Exception{

        this.gender = gender;

        String[] races = readFiles.readRace();
        int random = (int) (Math.random() * races.length);
        this.race = races[random];

        // We add extras if the generated race normally has these extras:
        if (race.equals("tiefling") || race.equals("satyr") || race.equals("centaur") || race.equals("genasi")) {
            this.extras = "horns";
        } else if (race.equals("fairy") || race.equals("aasimar")) {
            this.extras = "wings";
        } else {
            this.extras = "none";
        }

        String[] skincolors = readFiles.readSkincolor(random);
        random = (int) (Math.random() * (skincolors.length-1)+1);
        this.skincolor = skincolors[random];

        String[] bodytypes = readFiles.readFile("BodyType.txt");
        random = (int) (Math.random() * bodytypes.length);
        this.bodytype = bodytypes[random];

        String[] bodyweights = readFiles.readFile("Weight.txt");
        random = (int) (Math.random() * bodyweights.length);
        this.bodyweight = bodyweights[random];

        // Age is generated randomly between 10 and 110
        random = (int) (Math.random()*100+10);
        this.age = random;

        String[] hairstyles = readFiles.readFile("Hairstyle.txt");
        random = (int) (Math.random() * hairstyles.length);
        this.hairstyle = hairstyles[random];

        // If the character is bald, they cannot have a hair color or length:
        if(!Objects.equals(hairstyle, "bald")) {

            String[] hairlengths = readFiles.readFile("Hairlength.txt");
            random = (int) (Math.random() * hairlengths.length);
            this.hairlength = hairlengths[random];

            String[] haircolors = readFiles.readFile("Haircolor.txt");
            random = (int) (Math.random() * haircolors.length);
            this.haircolor = haircolors[random];

        } else {
            this.hairlength = "";
            this.haircolor = "";
        }

        String[] faceshapes = readFiles.readFile("FaceShape.txt");
        random = (int) (Math.random() * faceshapes.length);
        this.faceshape = faceshapes[random];

        String[] eyecolors = readFiles.readFile("Eyecolor.txt");
        random = (int) (Math.random() * eyecolors.length);
        this.eyecolor = eyecolors[random];

        String[] eyeshapes = readFiles.readFile("Eyeshape.txt");
        random = (int) (Math.random() * eyeshapes.length);
        this.eyeshape = eyeshapes[random];

    }

    public String toString(){
        // According to the gender the correct pronouns are chosen:
        String pronouns1;
        String pronouns2;
        String pronouns3;
        String pronouns4;
        String pronouns5;

        if (Objects.equals(gender, "f")) {
            pronouns1 = "She is";
            pronouns2 = "Her";
            pronouns3 = "her";
            pronouns4 = "She has";
            pronouns5 = "she has";
        } else if (Objects.equals(gender, "m")) {
            pronouns1 = "He is";
            pronouns2 = "His";
            pronouns3 = "his";
            pronouns4 = "He has";
            pronouns5 = "he has";
        } else {
            pronouns1 = "They are";
            pronouns2 = "Their";
            pronouns3 = "their";
            pronouns4 = "They have";
            pronouns5 = "they have";
        }

        // We use case switch to generate between special hair lengths,
        // that need a different return statement for easier readability:
        switch (hairlength) {

            case "bald":
                return pronouns1 + " a " + race + ". " +
                        pronouns2 + " skin is coloured " + skincolor + ". \n" +
                        pronouns1 + " " + bodytype + " compared to others from " + pronouns3 + " race and " + bodyweight + ". \n" +
                        pronouns1 + " " + age + " years old. \n" +
                        pronouns1 + " " +  hairlength + ". \n" +
                        pronouns2 + " face is " + faceshape + " shaped and " + pronouns5 + " " + eyeshape + " " + eyecolor + " eyes." + " Extras: " + extras+".";

            case "buzz cut":
                return pronouns1 + " a " + race + ". " +
                        pronouns2 + " skin is coloured " + skincolor + ". \n" +
                        pronouns1 + " " + bodytype + " compared to others from " + pronouns3 + " race and " + bodyweight + ". \n" +
                        pronouns1 + " " + age + " years old. \n" +
                        pronouns4 + " a " + haircolor + " " + hairstyle + " " + hairlength + ". \n" +
                        pronouns2 + " face is " + faceshape + " shaped and " + pronouns5 + " " + eyeshape + " " + eyecolor + " eyes." + " Extras: " + extras+".";

            default:
                return pronouns1 + " a " + race + ". " +
                        pronouns2 + " skin is coloured " + skincolor + ". \n" +
                        pronouns1 + " " + bodytype + " compared to others from " + pronouns3 + " race and " + bodyweight + ". \n" +
                        pronouns1 + " " + age + " years old. \n" +
                        pronouns4 + " " + hairlength + " " + haircolor + " " + hairstyle + " hair. \n" +
                        pronouns2 + " face is " + faceshape + " shaped and " + pronouns5 + " " + eyeshape + " " + eyecolor + " eyes." + " Extras: " + extras+".";
        }
    }
}