import java.util.Scanner;

public class HangmanGame {
    // This program is a game where user needs to guess a word

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to the Hangman Game!");
        System.out.println("2 PLAYER GAME\nEnter the word to be used for this game (second player, doesn't looks!)\nWORD:");
        String phrase = input.nextLine(); // takes input of the phrase
        phrase = phrase.trim(); // removes the spaces in the beginning and the end
        phrase = phrase.replaceAll(" ", "  ");
        phrase = phrase.toUpperCase();
        String phrase1 = phrase.replaceAll("[A-Z]", "_ ");
        /*
         * Displays the phrase in underscores with single space between letters
         * And double space for 1 space in the original phrase
         */
        // prints in new line
        System.out.print("\n");
        System.out.print("\n");
        System.out.print("\n");
        System.out.print("\n");
        System.out.print("\n");
        System.out.print("\n");
        System.out.print("\n");
        System.out.print("\n");
        System.out.print("\n");
        System.out.print("\n");
        System.out.print("\n");
        System.out.print("\n");
        System.out.print("\n");
        System.out.println("Okay so, let's play! Here is the board:");

        int attempts = 0;
        int incorrect = 0;
        String guess;
        char letter;
        boolean guessescontainsguess;
        String guesses = "";
        boolean phrasecontainsguess;

        /*
         * attempts = counts number of attempts incorrect = counts number of
         * incorrect attempts guess = stores the guessed letter input letter =
         * pulls out the first letter from guess for use guesses = stores all
         * the already guessed letters guessescontainsguess= boolean for guess
         * in already guessed letters phrasecontainsguess= boolean for guess in
         * phrase
         */

        while (incorrect < 5 && phrase1.contains("_")) {
            // while loop begins

            System.out.println(phrase1);
            System.out.print("\n");
            System.out.println("You have "+incorrect+" incorrect guesses so far.");

            if (incorrect == 1) {
                // for picture 1
                System.out.println("         ____________");
                System.out.println("        |      |     |");
                System.out.println("        |      O     |");
                System.out.println("        |            |");
                System.out.println("        |            |");
                System.out.println("       	|            |");
                System.out.println("         ____________");
                System.out.print("\n");
            } else if (incorrect == 2) {
                // for picture 2
                System.out.println("         ____________");
                System.out.println("        |      |     |");
                System.out.println("        |      O     |");
                System.out.println("        |      |     |");
                System.out.println("        |            |");
                System.out.println("       	|            |");
                System.out.println("         ____________");
                System.out.print("\n");
            } else if (incorrect == 3) {
                // for picture 3
                System.out.println("         ____________");
                System.out.println("        |      |     |");
                System.out.println("        |      O     |");
                System.out.println("        |    /-|-    |");
                System.out.println("        |            |");
                System.out.println("       	|            |");
                System.out.println("         ____________");
                System.out.print("\n");
            } else if (incorrect == 4) {
                // for picture 4
                System.out.println("         ____________");
                System.out.println("        |      |     |");
                System.out.println("        |      O     |");
                System.out.println("        |    /-|-\\   |");
                System.out.println("        |      |     |");
                System.out.println("       	|            |");
                System.out.println("         ____________");
                System.out.print("\n");
            }

            System.out.print("Guess a letter:");
            guess = input.nextLine(); // takes guess input
            guess = guess.toUpperCase(); // converts to uppercase for comparison
            letter = guess.charAt(0); // gets the first letter as guessed letter
            guessescontainsguess = (guesses.indexOf(letter)) != -1;
            guesses += letter; // stores every letter guessed in guesses
            letter = Character.toUpperCase(letter); // converts to uppercase for comparison
            if (guessescontainsguess == true) { // if statement begins
                System.out.println("You ALREADY guessed  "+letter );
                if (incorrect > 0) { // inner if begins
                } // inner if ends
            } // if statement begins

            phrasecontainsguess = (phrase.indexOf(letter)) != -1;
            if (phrasecontainsguess == true) { // if statement begins
                System.out.println(letter + " is in the word.");
                System.out.print("\n");
                for (int position = 0; position < phrase.length(); position++) { // for begins
                    if (phrase.charAt(position) == letter && phrase1.charAt(position) != letter) {
                        // inner if begins
                        phrase1 = phrase1.replaceAll("_ ", "_");
                        String phrase2;
                        phrase2 = phrase1.substring(0, position) + letter + phrase1.substring(position + 1);
                        phrase2 = phrase2.replaceAll("_", "_ ");
                        phrase1 = phrase2;
                    } // inner if ends
                } // for ends
            } else { // if statement ends, else if begins
                System.out.print("\n");
                System.out.println(letter + " is not in the word."); // prints
                System.out.print("\n");
                incorrect++; // incorrect = incorrect + 1, after every incorrect answer
            }
            attempts++; // attempts = attempts + 1, after every attempt

        } // while loop ends

        if (incorrect == 5) {
            // for picture 5
            System.out.println("         ____________");
            System.out.println("        |      |     |");
            System.out.println("        |      0     |");
            System.out.println("        |    /-|-\\   |");
            System.out.println("        |      |     |");
            System.out.println("       	|     / \\    |");
            System.out.println("         ------------");
            System.out.print("\n");
            System.out.println("Sorry, you've reached your maximum number of incorrect guesses. \n GAME OVER!");
            System.out.println("ThankYou for playing this game\n -by Shreya Prasad");
        }
        else {

            System.out.println("The word is:"); // when solved
            System.out.println(phrase1);
            System.out.println("CONGRATULATIONS, you solved it!");
            System.out.println("ThankYou for playing this game\n -by Shreya Prasad");
        }

        input.close(); // Scanner closed
    }

}