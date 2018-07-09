import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

import static java.lang.String.valueOf;

public class Hangman {

    public static void main(String[] args) throws IOException {
        hangman();
    }

    public static void hangman() throws IOException {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> guesses = new ArrayList(20);
        String word = (Words.getWord());
        int count = word.length();
        int guessesLeft = 6;
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

        RUN:
        while(count >0 && guessesLeft > 0) {
            Boolean correct = false;
            System.out.println("\n");
            for(int i = 0; i<word.length(); i++){
                System.out.print(guessedWord[i] + " ");
            }
            System.out.println( "\nPlease guess a letter: " );
            String guess = sc.nextLine();
            for(int i = 0; i<guesses.size(); i++){
                if(guess.equals(guesses.get(i))){
                    System.out.println("Sorry, you already guessed that letter.");
                    continue RUN;

                }
            }
            guess = valueOf(guess.charAt(0));
            guess= guess.toLowerCase();
            guesses.add( guess );
            for (int i = 0; i < mysteryWord.length; i++) {
                if (guess.equals( mysteryWord[i] )) {
                    guessedWord[i] = guess;
                    count -= 1;
                    correct = true;

                }

            }
            if(!correct){
                guessesLeft -=1;
            }
            for(int i = 0; i<word.length(); i++){
                System.out.print(guessedWord[i] + " ");
            }
            System.out.println("\n");
            System.out.print("Guessed: ");
            for (int i = 0; i < guesses.size(); ++i) {
                System.out.print( guesses.get( i ) + ", ");
            }
            System.out.println("You have " + guessesLeft + " guesses left.");
            if(count == 0){
                System.out.println("You have guessed the word! Would you like to play again? 1 for yes, 2 for no");
                int choice = sc.nextInt();
                if(choice ==1){
                    hangman();
                }
                else{
                    System.exit(0);
                }
            }
            if(guessesLeft == 0){
                System.out.println("You have run out of guesses! The word was: " + word +   ". Would you like to play again? 1 for yes, 2 for no");

                int choice = sc.nextInt();
                if(choice ==1){
                    hangman();
                }
                else{
                    System.exit(0);
                }
            }
        }

    }
}