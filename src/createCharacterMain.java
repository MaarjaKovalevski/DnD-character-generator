/**
 * This is a character generator program created by Veronika Kukk and Maarja Kovalevski.
 * This project was created for a class.
 * You have the option to generate the following traits:
 *      Name
 *      Looks
 *      Characteristics
 *      Backstory
 *      Catchphrase
 * After answering the questions on which traits you would like created,
 *      the program will give you the needed traits.
 *      After that you have a chance to create a new character or stop the program.
 */

import java.util.ArrayList;
import java.util.Scanner;

public class createCharacterMain {
    public static void main(String[] args) throws Exception {

        // Before we go into character creation the program asks
        // if you would even like to create a character:

        Scanner characterNeeded = new Scanner(System.in);
        System.out.println("Would you like to create a character? (y/n)");
        String character = characterNeeded.nextLine();
        while (character.equals("y")) {
            String characterName;
            String characterGender = null;
            ArrayList<String> neededTraits = new ArrayList<>();
            generateGender generateGender = new generateGender();


            // Do we need to generate a name?
            Scanner nameNeeded = new Scanner(System.in);
            System.out.println("Do you need a name? (y/n)");
            String name = nameNeeded.nextLine();

            // If we do need to generate a name:
            if (name.equals("y")) {
                // We ask for the wished gender of the character:
                Scanner nameGender = new Scanner(System.in);
                System.out.println("Insert wished gender: (f/m/o - other)");
                characterGender = nameGender.nextLine();
                // Set the gender with the setGender() of the class generateGender:
                generateGender.setGender(characterGender);
                // Generate a name for the character:
                generateName generateName = new generateName(generateGender.getGender());
                // Add the name to a list from which we get all traits that needed to be generated:
                neededTraits.add(String.valueOf(generateName));

            // If we don't need to generate a name:
            } else if (name.equals("n")) {
                // We ask for the existing name and the gender of the character:
                Scanner existingName = new Scanner(System.in);
                System.out.println("Insert the name of your character: ");
                characterName = existingName.nextLine();
                Scanner existingGender = new Scanner(System.in);
                System.out.println("Insert the gender of your character: (f/m/o - other)");
                characterGender = existingGender.nextLine();
                // Set the gender:
                generateGender.setGender(characterGender);
                // Add the name to the needed traits list:
                neededTraits.add("The name of this person is " + characterName + ".");
            }


            // Do we need to generate looks?
            Scanner looksNeeded = new Scanner(System.in);
            System.out.println("Do you need looks? (y/n)");
            String generateLooks = looksNeeded.nextLine();

            // If we need to generate looks:
            if (generateLooks.equals("y")) {
                // Generate looks and add to the needed traits list:
                createLooks looks = new createLooks(generateGender.getGender());
                neededTraits.add(String.valueOf(looks));
            }


            // Do we need to generate characteristics?
            Scanner characteristicsNeeded = new Scanner(System.in);
            System.out.println("Do you need characteristics? (y/n)");
            String generateCharacteristics = characteristicsNeeded.nextLine();

            // If we need to generate characteristics:
            if (generateCharacteristics.equals("y")) {
                Scanner goodOrBadCharacter = new Scanner(System.in);
                // We ask if the character will be good or bad:
                System.out.println("Would you like a good or a bad character? (press \"1\" for good and \"2\" for bad");
                int goodOrBad = Integer.parseInt(goodOrBadCharacter.nextLine());
                // Generate the characteristics and add them to the needed traits list:
                createCharacteristics characteristics = new createCharacteristics(generateGender.getGender(), goodOrBad);
                neededTraits.add(String.valueOf(characteristics));
            }


            // Do we need to generate a backstory?
            Scanner backstoryNeeded = new Scanner(System.in);
            System.out.println("Would you like a backstory? (y/n)");
            String generateBackstory = backstoryNeeded.nextLine();

            // If we need to generate a backstory:
            if (generateBackstory.equals("y")) {
                // Generate the backstory and add it to the needed traits list:
                createBackstory backstory = new createBackstory(generateGender.getGender());
                neededTraits.add(String.valueOf(backstory));
            }

            // Do we need to generate a catchphrase?
            Scanner phraseNeeded = new Scanner(System.in);
            System.out.println("Would you like a catchphrase for your character? (y/n)");
            String generatePhrase = phraseNeeded.nextLine();

            // If we need to generate a catchphrase:
            if (generatePhrase.equals("y")) {
                // Generate a catchphrase and add it to the needed traits list:
                createPhrase phrase = new createPhrase(generateGender.getGender());
                neededTraits.add(String.valueOf(phrase));
            }

            // Print all the needed traits:
            System.out.println("Alright, here you go!");
            for (int i = 0; i < neededTraits.size(); i++) {
                System.out.println(neededTraits.get(i));
            }
            // We add an extra line for easier readability:
            System.out.println();

            // Ask whether another character is needed:
            Scanner newCharacterNeeded = new Scanner(System.in);
            System.out.println("Would you like to create another character? (y/n)");
            character = newCharacterNeeded.nextLine();
            // If yes, we move back to the beginning of the while loop 🠕🠕🠕
        }
        // If no, the program says goodbye and closes:
        System.out.println("Alright, goodbye!");
    }
}