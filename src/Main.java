import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;

void main() throws FileNotFoundException {

    ArrayList<String> kanji = new ArrayList<>();
    ArrayList<String> furigana = new ArrayList<>();
    ArrayList<String> english = new ArrayList<>();
    ArrayList<String> romaji = new ArrayList<>();

    File kanjiFile = new File("n1Words.txt");
    File furiganaFile = new File("n1Furigana.txt");
    File englishFile = new File("n1Answers.txt");
    File romajiFile = new File("n1Romaji.txt");

    Scanner kanjiInput = new Scanner(kanjiFile);
    Scanner furiganaInput = new Scanner(furiganaFile);
    Scanner englishInput = new Scanner(englishFile);
    Scanner romajiInput = new Scanner(romajiFile);

    while (kanjiInput.hasNextLine()) {

        String line = kanjiInput.nextLine();
        String[] words = line.split(",");

        String linef = furiganaInput.nextLine();
        String[] furiganaWords = linef.split(",");

        String linee = englishInput.nextLine();
        String[] englishWords = linee.split(",");

        String liner = romajiInput.nextLine();
        String[] romajiWords = liner.split(",");

        for (int i = 0; i < words.length; i++) {
            kanji.add(words[i].trim().replace("\"", ""));
            furigana.add(furiganaWords[i].trim().replace("\"", ""));
            english.add(englishWords[i].trim().replace("\"", ""));
            romaji.add(romajiWords[i].trim().replace("\"", ""));
        }
    }

    Scanner input = new Scanner(System.in);
    Random random = new Random();

    while (!kanji.isEmpty()) {

        int randomIndex = random.nextInt(kanji.size());

        System.out.println();
        System.out.println(kanji.get(randomIndex));
        System.out.println(furigana.get(randomIndex));

        System.out.print("Do you know this word? (y/n): ");
        String answer = input.nextLine();

        System.out.println();
        System.out.println("Meaning: " + english.get(randomIndex));
        System.out.println("Romaji: " + romaji.get(randomIndex));

        if (answer.equalsIgnoreCase("y")) {

            kanji.remove(randomIndex);
            furigana.remove(randomIndex);
            english.remove(randomIndex);
            romaji.remove(randomIndex);

        } else if (answer.equalsIgnoreCase("n")) {


        } else {

            System.out.println("Please enter y or n.");
        }
    }

    System.out.println();
    System.out.println("You know all the words!");
}