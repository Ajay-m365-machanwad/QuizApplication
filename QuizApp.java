import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class QuizApp {

    // Inner class to represent a Question
    static class Question {
        String prompt;
        String optionA;
        String optionB;
        String optionC;
        String optionD;
        String answer;

        public Question(String p, String a, String b, String c, String d, String ans) {
            this.prompt = p;
            this.optionA = a;
            this.optionB = b;
            this.optionC = c;
            this.optionD = d;
            this.answer = ans;
        }
    }

    public static void main(String[] args) {
        // 1. Load questions from file into a List
        ArrayList<Question> allQuestions = loadQuestions("questions.txt");

        if (allQuestions.isEmpty()) {
            System.out.println("No questions found! Make sure 'questions.txt' exists.");
            return;
        }

        // 2. Randomize the questions
        Collections.shuffle(allQuestions);

        // 3. Select how many questions you want to ask (e.g., 10)
        int questionsToAsk = Math.min(10, allQuestions.size());

        // 4. Create a smaller list for the actual test
        ArrayList<Question> quizSet = new ArrayList<>();
        for (int i = 0; i < questionsToAsk; i++) {
            quizSet.add(allQuestions.get(i));
        }

        // 5. Start the test
        takeTest(quizSet);
    }

    public static ArrayList<Question> loadQuestions(String filename) {
        ArrayList<Question> list = new ArrayList<>();
        try {
            File myFile = new File(filename);
            Scanner fileScanner = new Scanner(myFile);

            while (fileScanner.hasNextLine()) {
                String qText = fileScanner.nextLine();
                String opA = fileScanner.nextLine();
                String opB = fileScanner.nextLine();
                String opC = fileScanner.nextLine();
                String opD = fileScanner.nextLine();
                String ans = fileScanner.nextLine();

                list.add(new Question(qText, opA, opB, opC, opD, ans));
            }
            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found.");
        }
        return list;
    }

    // --- MODIFIED METHOD: Calculates Score and Percentage ---
    public static void takeTest(ArrayList<Question> questions) {
        int score = 0;
        int totalQuestions = questions.size();
        Scanner keyboard = new Scanner(System.in);

        System.out.println("--- Starting Random Java Quiz ---");

        for (int i = 0; i < totalQuestions; i++) {
            Question q = questions.get(i);
            
            System.out.println("Q" + (i + 1) + ": " + q.prompt);
            System.out.println("(a) " + q.optionA);
            System.out.println("(b) " + q.optionB);
            System.out.println("(c) " + q.optionC);
            System.out.println("(d) " + q.optionD);
            
            System.out.print("Your answer: ");
            String answer = keyboard.nextLine();

            if (answer.equalsIgnoreCase(q.answer)) {
                score++;
                System.out.println("Correct!");
            } else {
                System.out.println("Wrong. The answer was: " + q.answer);
            }
            System.out.println("---------------------------");
        }

        // --- NEW: Calculation Logic ---
        double percentage = ((double) score / totalQuestions) * 100;

        // Display Final Report
        System.out.println("\n********************************");
        System.out.println("        QUIZ RESULT");
        System.out.println("********************************");
        System.out.println("Total Questions : " + totalQuestions);
        System.out.println("Correct Answers : " + score);
        System.out.println("Wrong Answers   : " + (totalQuestions - score));
        System.out.println("Percentage      : " + String.format("%.2f", percentage) + "%");
        System.out.println("********************************");

        // Performance Feedback
        if (percentage >= 80) {
            System.out.println("Performance: Excellent! Keep it up.");
        } else if (percentage >= 50) {
            System.out.println("Performance: Good, but room for improvement.");
        } else {
            System.out.println("Performance: You need more practice.");
        }
    }
}