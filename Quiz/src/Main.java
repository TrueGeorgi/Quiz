import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Question> questions = addQuestions();

        List<String> startingMenu = new ArrayList<>();
        startingMenu.add("A. Play");
        startingMenu.add("B. Add a question");
        startingMenu.add("C. Exit the game");

        boolean continueStartingMenu = true;

        System.out.println("Welcome to the Quiz game. How should we call you?");
        String username = scanner.nextLine();
        Player player = new Player(username);
        System.out.println("Ok, " + username + ". Let's start.");

        while (continueStartingMenu) {

            System.out.println("What would you like to do? Choose the letter of the action you would like to take.");

            displayStartingMenu(startingMenu);

            String answer = correctLetterInput(startingMenu.size());
            System.out.println();

            switch (answer) {
                case "A":
                    Random random = new Random();
                    int randomQuestion = random.nextInt(questions.size() + 1);
                    Question currentQuestion = questions.get(randomQuestion);
                    System.out.println(currentQuestion.getQuestion());
                    System.out.println();
                    System.out.println("A: " + currentQuestion.getOptionA());
                    System.out.println("B: " + currentQuestion.getOptionB());
                    System.out.println("C: " + currentQuestion.getOptionC());
                    System.out.println();
                    System.out.print("The correct answer is: ");
                    String playerAnswerString = correctLetterInput(3);
                    char playerAnswer = playerAnswerString.charAt(0);
                    System.out.println();
                    if (playerAnswer == currentQuestion.getCorrectOption()) {
                        System.out.println("You are correct!");
                        player.setRightAnswers();
                    } else {
                        System.out.println("Not correct. The right answer was: "
                                + currentQuestion.getCorrectOption() +
                                ": "
                                + currentQuestion.getCorrectOptionString());
                        player.setWrongAnswers();
                    }
                    System.out.println();
                    break;
                case "B":
                    System.out.print("Write the question here: ");
                    String question = scanner.nextLine();
                    System.out.println();
                    System.out.println("You will be asked to give 3 possible answers. One correct and two incorrect.");
                    System.out.print("Option A: ");
                    String optionA = scanner.nextLine();
                    System.out.print("Option B: ");
                    String optionB = scanner.nextLine();
                    System.out.print("Option C: ");
                    String optionC = scanner.nextLine();
                    System.out.println("Which one is the correct answer? A, B or C?");
                    String correct = correctLetterInput(3);
                    char correctAnswer = correct.charAt(0);
                    System.out.println();

                    Question outsideQuestion = new Question(question, optionA, optionB, optionC, correctAnswer, player.getUsername());
                    questions.add(outsideQuestion);
                    break;
                case "C":
                    continueStartingMenu = false;
                    break;
            }
        }
        System.out.println();
        int totalAnswers = player.getRightAnswers() + player.getWrongAnswers();
        System.out.printf("User %s had played %d times and had:%n-%d correct answers%n-%d wrong answers.%n",
                player.getUsername(),
                totalAnswers,
                player.getRightAnswers(),
                player.getWrongAnswers());
        System.out.println("Thank you for playing! I hope you had fun.");
        System.out.println("For feedback please feel free to contact me via mail at: Georgi.iliev9191@gmail.com");

    }
    public static String correctLetterInput(int length) {
        Scanner scanner = new Scanner(System.in);

        boolean correctLetter = false;

        String input = scanner.nextLine().toUpperCase();

        while (!correctLetter) {
            if (input.length() != 1) {
                System.out.println("Please choose the correct letter");
                input = scanner.nextLine().toUpperCase();
            } else {
                char letter = input.charAt(0);
                if (letter > 64 && letter <= 64 + length) {
                    correctLetter = true;
                } else {
                    System.out.println("Please choose the correct letter");
                    input = scanner.nextLine().toUpperCase();
                }
            }
        }
        return input;
    }
    public static void displayStartingMenu(List<String> startingMenu) {
        for (int i = 0; i < startingMenu.size(); i++) {
            System.out.println(startingMenu.get(i));
        }
    }
    public static List<Question> addQuestions () {

        List<Question> questions = new ArrayList<>();

        Question one = new Question(
                "Which country is the largest by land area?",
                "China",
                "Russia",
                "USA",
                'B'
        );
        questions.add(one);
        Question two = new Question(
                "What is the capital of Brazil?",
                "Brasilia",
                "Rio De Jeneiro",
                "Cairo",
                'A'
        );
        questions.add(two);
        Question three = new Question(
                "Which is the longest river in the world?",
                "Amazon",
                "Volga",
                "Nile",
                'C'
        );
        questions.add(three);
        Question four = new Question(
                "Which continent is the largest in terms of land area?",
                "Africa",
                "Asia",
                "North America",
                'B'
        );
        questions.add(four);
        Question five = new Question(
                "What is the highest mountain in the world?",
                "Mount Kilimanjaro",
                "Mount Everest",
                "Mount McKinley (Denali)",
                'B'
        );
        questions.add(five);
        Question six = new Question(
                """
                        What is the output of the following code in Java?
                        int x = 5;
                        System.out.println(x++ + ++x);""",
                "11",
                "12",
                "13",
                'B'
        );
        questions.add(six);
        Question seven = new Question(
                "Who was the first emperor of the Roman Empire?",
                "Augustus",
                "Julius Caesar",
                "Nero",
                'A'
        );
        questions.add(seven);
        Question eight = new Question(
                "Which event marked the official end of the Western Roman Empire in 476 CE?",
                "Fall of Constantinople",
                "Sack of Rome",
                "The deposition of Romulus Augustus",
                'C'
        );
        questions.add(eight);
        Question nine = new Question(
                "Who is the king of the gods in Greek mythology?",
                "Zeus",
                "Poseidon",
                "Hades",
                'A'
        );
        questions.add(nine);
        Question ten = new Question(
                "Which goddess is associated with love and beauty in Greek mythology?",
                "Athena",
                "Aphrodite",
                "Artemis",
                'B'
        );
        questions.add(ten);

        return questions;
    }
}
