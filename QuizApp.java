import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Question {
    private String prompt;
    private List<String> options;
    private int correctOption;

    public Question(String prompt, List<String> options, int correctOption) {
        this.prompt = prompt;
        this.options = options;
        this.correctOption = correctOption;
    }

    public String getPrompt() {
        return prompt;
    }

    public List<String> getOptions() {
        return options;
    }

    public int getCorrectOption() {
        return correctOption;
    }
}

class Quiz {
    private List<Question> questions;
    private int score;

    public Quiz(List<Question> questions) {
        this.questions = questions;
        this.score = 0;
    }

    public void startQuiz() {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < questions.size(); i++) {
            Question currentQuestion = questions.get(i);
            System.out.println("Question " + (i + 1) + ": " + currentQuestion.getPrompt());

            List<String> options = currentQuestion.getOptions();
            for (int j = 0; j < options.size(); j++) {
                System.out.println((j + 1) + ". " + options.get(j));
            }

            System.out.print("Your answer: ");
            int userAnswer = scanner.nextInt();

            if (userAnswer == currentQuestion.getCorrectOption()) {
                System.out.println("Correct!\n");
                score++;
            } else {
                System.out.println("Incorrect. The correct answer is: " + currentQuestion.getCorrectOption() + "\n");
            }
        }

        System.out.println("Quiz completed! Your score: " + score + " out of " + questions.size());
    }
}

public class QuizApp {
    public static void main(String[] args) {
        // Create sample questions
        List<Question> questions = new ArrayList<>();
        questions.add(new Question("What is the capital of France?", List.of("Berlin", "Paris", "Madrid", "Rome"), 2));
        questions.add(new Question("Which programming language is Java?", List.of("C++", "Python", "Java", "Ruby"), 3));
        questions.add(new Question("Is the Earth flat?", List.of("True", "False"), 2));

        // Create a quiz with the questions
        Quiz quiz = new Quiz(questions);

        // Start the quiz
        quiz.startQuiz();
    }
}
