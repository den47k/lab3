package lab3;
import java.util.Scanner;
/*
Виконав Герасимчук Даниіл ІО-33 (Додаткова інформація в README.md)
*/

public class Main {

    public static void main(String[] args) {
    	System.out.println("Variant definotion: ");
        System.out.println("C3: " + 3306 % 3);
        System.out.println("C17" + 3306 % 17);

        Scanner textScanner = new Scanner(System.in);
        System.out.println("Enter the text: ");
        StringBuilder text = new StringBuilder(textScanner.nextLine());
        System.out.println("Enter character: ");
        char letter = textScanner.next().charAt(0);
        textScanner.close();

        String[] words = text.toString().split("\\s+");
        StringBuilder[] wordBuilders = new StringBuilder[words.length];

        for (int i = 0; i < words.length; i++) {
            wordBuilders[i] = new StringBuilder(words[i]);
        }

        sortByLetterCount(wordBuilders, letter);
        StringBuilder res = new StringBuilder();

        for (StringBuilder wordBuilder : wordBuilders) {
            res.append(wordBuilder).append(" ");
        }

        System.out.println("Result: " + res.toString());
    }

    public static int countLetterOccurrences(StringBuilder word, char letter) {
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == letter) {
                count++;
            }
        }
        return count;
    }

    public static void sortByLetterCount(StringBuilder[] words, char letter) {
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = i + 1; j < words.length; j++) {
                int count1 = countLetterOccurrences(words[i], letter);
                int count2 = countLetterOccurrences(words[j], letter);
                if (count1 > count2) {
                    StringBuilder temp = words[i];
                    words[i] = words[j];
                    words[j] = temp;
                }
            }
        }
    }
}
