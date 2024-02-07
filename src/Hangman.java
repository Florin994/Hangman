import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.List;

public class Hangman {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner fileSc = new Scanner(new File("C:/Users/bogda/Desktop/EnglishWordsFile.txt"));
        Scanner userSc = new Scanner(System.in);
        Random random = new Random();
        Counter counter = new Counter(5);

        List<String> chosenDifficulty = new ArrayList<>();
        CreateDifficultyLists difficultyLists = getDifficultyLists(fileSc);
        chosenDifficulty = getDifficulty(userSc, chosenDifficulty, difficultyLists);
        String word = chosenDifficulty.get(random.nextInt(chosenDifficulty.size()));
        List<Character> playerGuess = new ArrayList<>();
        counter.printGame();

        letsPlay(counter, word, playerGuess, userSc);
    }

    private static void letsPlay(Counter counter, String word, List<Character> playerGuess, Scanner userSc) {
        while (counter.getMaxLives() > 0 && !wordState(word, playerGuess)) {
            getLetterGuess(userSc, playerGuess, counter, word);
            if (wordState(word, playerGuess)) {
                break;
            }
            if (counter.getMaxLives() <= 0 || getWordGuess(userSc, playerGuess, counter, word)) {
                break;
            }
            counter.printGame();
        }
        if (counter.getMaxLives() <= 0) {
            counter.printGame();
            System.out.println("You Lose!");
            System.out.println("The word was: " + word);
        } else {
            counter.printGame();
            System.out.println(word);
            System.out.println("You Win!");
        }
    }

    private static List<String> getDifficulty(Scanner userSc, List<String> chosenDifficulty, CreateDifficultyLists difficultyLists) {
        System.out.println("Chose difficulty (e ->easy; m-> medium; h -> hard)");
        String difficulty = userSc.nextLine();
        switch (difficulty) {
            case "e":
                chosenDifficulty = difficultyLists.easyWords();
                break;
            case "m":
                chosenDifficulty = difficultyLists.mediumWords();
                break;
            case "h":
                chosenDifficulty = difficultyLists.hardWords();
                break;
            default:
                System.out.println("Invalid input!");
        }
        return chosenDifficulty;
    }

    private static CreateDifficultyLists getDifficultyLists(Scanner fileSc) {
        List<String> easyWords = new ArrayList<>();
        List<String> mediumWords = new ArrayList<>();
        List<String> hardWords = new ArrayList<>();
        while (fileSc.hasNext()) {
            String currentWord = fileSc.nextLine();
            if (currentWord.length() > 1 && currentWord.length() <= 4) {
                easyWords.add(currentWord);
            } else if (currentWord.length() <= 6) {
                mediumWords.add(currentWord);
            } else {
                hardWords.add(currentWord);
            }
        }
        return new CreateDifficultyLists(easyWords, mediumWords, hardWords);
    }

    private record CreateDifficultyLists(List<String> easyWords, List<String> mediumWords, List<String> hardWords) {
    }

    public static boolean getWordGuess(Scanner userSc, List<Character> playerGuess, Counter counter, String word) {
        counter.printGame();
        wordState(word, playerGuess);
        System.out.println("Enter your guess for the word:");
        String wordGuess = userSc.nextLine();
        boolean wordFound = wordGuess.equalsIgnoreCase(word);
        if (!wordFound) {
            counter.decreaseLives();
            System.out.println("Nope! try again.");
        }
        return wordFound;
    }

    private static void getLetterGuess(Scanner userSc, List<Character> playerGuess, Counter counter, String word) {
        System.out.println("Enter a letter:");
        String guess = userSc.nextLine();
        char guessedLetter = guess.charAt(0);
        boolean letterFound = false;
        for (int i = 0; i < word.length(); i++) {
            if (guessedLetter == word.charAt(i)) {
                letterFound = true;
                break;
            }
        }
        if (!letterFound && !playerGuess.contains(guessedLetter)) {
            counter.decreaseLives();
        }
        if (!playerGuess.contains(guessedLetter)) {
            playerGuess.add(guessedLetter);
        }
    }

    private static boolean wordState(String word, List<Character> playerGuess) {
        boolean allGuessed = true;
        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            if (playerGuess.contains(currentChar)) {
                System.out.print(currentChar);
            } else {
                System.out.print('*');
                allGuessed = false;
            }
        }
        System.out.println();
        return allGuessed;
    }
}