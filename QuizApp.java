import java.util.Scanner;

public class QuizApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int score = 0;

        // Define questions, options, and answers
        String[] questions = {
                "1) Which keyword is used to declare a constant in Java?",
                "2) Which of the following is not a primitive data type in Java?",
                "3) What is the output of System.out.println(10/3)?",
                "4) Which of the following is the correct way to declare and initialize an array of integers with a size of 5?",
                "5) What does JVM stand for?"
        };
        String[][] options = {
                {"A. static", "B. final", "C. const", "D. immutable"},
                {"A. int", "B. boolean", "C. String", "D. char"},
                {"A. 3.33", "B. 3", "C. 3.0", "D. Error"},
                {"A. int[] arr = new int[5]", "B. int arr[] = {1,2,3,4,5}", "C. int arr[5]", "D. int arr ={5}"},
                {"A. Java Virtual Machine", "B. Java verified Module", "C. Java visualizer Manager", "D.Java Variable Memory"}
        };
        char[] answers = {'B', 'C', 'B', 'A', 'A'}; // Correct answers, now with 5 elements

        long timeLimitPerQuestionMillis = 10000; // 10 seconds per question

        System.out.println("Welcome to the Java Console Quiz!");
        System.out.println("You have " + (timeLimitPerQuestionMillis / 1000) + " seconds to answer each question.");
        System.out.println("Let's begin!\n");

        for (int i = 0; i < questions.length; i++) {
            System.out.println("Question " + (i + 1) + ": " + questions[i]);
            for (String option : options[i]) {
                System.out.println(option);
            }
            System.out.print("Your answer (A, B, C, or D): ");

            long startTime = System.nanoTime(); // Start timer
            String userInput = scanner.nextLine().toUpperCase();
            long endTime = System.nanoTime(); // End timer

            long timeTakenMillis = (endTime - startTime) / 1_000_000; // Convert nanoseconds to milliseconds

            if (timeTakenMillis > timeLimitPerQuestionMillis) {
                System.out.println("Time's up! You took too long to answer.");
            } else {
                if (userInput.length() == 1 && userInput.charAt(0) == answers[i]) {
                    System.out.println("Correct!");
                    score++;
                } else {
                    System.out.println("Wrong. The correct answer was " + answers[i] + ".");
                }
            }
            System.out.println("Time taken: " + (timeTakenMillis / 1000.0) + " seconds.\n");
        }

        System.out.println("Quiz finished!");
        System.out.println("Your final score: " + score + " out of " + questions.length);

        scanner.close();
    }
}