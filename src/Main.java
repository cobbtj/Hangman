import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

import static java.lang.String.valueOf;

public class Main {
    public Main() {
    }

    public static void main(String[] args) throws IOException {
        hangman();
    }

    public static void hangman() throws IOException {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> guesses = new ArrayList(20);
        String word = (Words.getWord());
        int count = word.length();
        int guessesLeft = word.length();
        String[] mysteryWord = new String[word.length()];
        String[] guessedWord = new String[word.length()];
        for(int i = 0; i<word.length(); i++){
            guessedWord[i] = "_";
        }
        word.split("(?!^)");
        for(int i = 0; i< word.length(); i++) {
            mysteryWord[i] = valueOf( word.charAt(i) );
        }
        System.out.println("Welcome to HANGMAN presented by Tyler and Debi!");
        while(count >0 && guessesLeft > 0) {
            System.out.println("\n");
            for(int i = 0; i<word.length(); i++){
                System.out.print(guessedWord[i] + " ");
            }
            System.out.println( "\nPlease guess a letter: " );
            String guess = sc.nextLine();
            guess = valueOf(guess.charAt(0));
            guess= guess.toLowerCase();
            guesses.add( guess );
            for (int i = 0; i < mysteryWord.length; i++) {
                if (guess.equals( mysteryWord[i] )) {
                    guessedWord[i] = guess;
                    count -= 1;

                }

            }
            for(int i = 0; i<word.length(); i++){
                System.out.print(guessedWord[i] + " ");
            }
            System.out.println("\n");
            System.out.print("Guessed: ");
            for (int i = 0; i < guesses.size(); ++i) {
                System.out.print( guesses.get( i ) + ", ");
            }
        }

    }
}