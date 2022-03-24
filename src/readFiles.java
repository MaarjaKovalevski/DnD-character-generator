/**
 * The purpose of this class is to hold all the methods we need for reading files
 *      and creating lists from those files.
 * Since some files need different approaches, there are different methods.
 */

import java.util.ArrayList;

public class readFiles {

    // This is the default method, where the separator is ",":
    static String[] readFile(String filename) throws Exception{
        java.io.File file = new java.io.File(filename);
        String[] contents = new String[1];
        try(java.util.Scanner sc = new java.util.Scanner(file,"UTF-8")){
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                contents = line.split(",");
                for (int i = 0; i < contents.length; i++) {
                    contents[i] = contents[i].trim();
                }
            }
        }
        return contents;
    }

    // The file Phrases.txt has ";" separating different phrases:
    static String[] readPhrase() throws Exception{
        java.io.File file = new java.io.File("Phrases.txt");
        String[] contents = new String[1];
        try(java.util.Scanner sc = new java.util.Scanner(file,"UTF-8")){
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                contents = line.split(";");
                for (int i = 0; i < contents.length; i++) {
                    contents[i] = contents[i].trim();
                }
            }
        }
        return contents;
    }

    // The file Skincolor.txt has the race in the first spot
    // and the possible skin colors of that race after that on the same line.
    // This method creates a list of skincolors according to the race (chooses the proper line):
    static String[] readSkincolor(int n) throws Exception{
        java.io.File file = new java.io.File("Skincolor.txt");
        String[] contents = new String[1];
        int loendur = 0;
        try(java.util.Scanner sc = new java.util.Scanner(file,"UTF-8")){
            while(sc.hasNextLine()){
                if(loendur == n){
                    String line = sc.nextLine();
                    contents = line.split(",");
                    for (int i = 0; i < contents.length; i++) {
                        contents[i] = contents[i].trim();
                    }
                }
                if(loendur > n)
                    break;
                loendur++;
            }
        }
        return contents;
    }

    // The file Skincolor.txt has the race in the first spot
    // and the possible skin colors of that race after that on the same line.
    // This method creates a list of races:
    static String[] readRace() throws Exception{
        java.io.File file = new java.io.File("Skincolor.txt");
        String[] contents = new String[1];
        ArrayList<String> racesList = new ArrayList<>();
        try(java.util.Scanner sc = new java.util.Scanner(file,"UTF-8")){
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                contents = line.split(",");
                contents[0] = contents[0].trim();
                racesList.add(contents[0]);
            }
        }
        String[] races = new String[racesList.size()];
        for (int i = 0; i < racesList.size(); i++) {
            races[i] = racesList.get(i);
        }
        return races;
    }
}
