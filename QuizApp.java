import java.util.*;

class Question {
    String questionText;
    List<String> options;
    int correctOptionIndex;

    public Question(String questionText, List<String> options, int correctOptionIndex) {
        this.questionText = questionText;
        this.options = options;
        this.correctOptionIndex = correctOptionIndex;
    }

    public boolean iscorrect(int answerIndex) {
        return answerIndex == correctOptionIndex;
    }
}


public class QuizApp {
    public static void main(String args[]) {

        Scanner scanner = new Scanner(System.in);

        List<Question> question = new ArrayList<>();


        question.add(new Question(
            "Which language is used for Android app development?",
            Arrays.asList("Python","Java","C#","PHP"),
            1
        ));

        question.add(new Question(
            "Which keyword is used to inherit a class in Java?",
            Arrays.asList("this","extends","implements","super"),
            1
        ));

        question.add(new Question(
            "Which method is the entry point of a Java program?",
            Arrays.asList("main()","start()","run()","execute()"),
            0
        ));

         question.add(new Question(
            "Which keyword is used to create an object in Java?",
            Arrays.asList("new","create","make","construct"),
            0
        ));

        question.add(new Question(
            "Which keyword is used to prevent inheritance in Java?",
            Arrays.asList("static","super","private","final"),
            3
        ));



        int score=0;

        for(int i=0; i<question.size(); i++) {
            Question q =question.get(i);
            System.out.println("\nQ" +(i+1) + ": "+q.questionText);

            for(int j=0; j<q.options.size(); j++) {
                System.out.println((j+1) +". " +q.options.get(j));
            }

            System.out.print("Enter your choice(1-"+q.options.size() + "): ");
            int userChoice = scanner.nextInt() - 1;


            if(q.iscorrect(userChoice)) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Wrong! Correct answer: "+q.options.get(q.correctOptionIndex));
            }
        }

        System.out.println("\n=====Quiz Finished=====");
        System.out.println("Your Score: "+score + "/" +question.size());
        scanner.close();
    }
}