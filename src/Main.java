import java.io.File;
import java.io.PrintStream;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        QuestionTree questionTree = new QuestionTree(new QuestionNode("computer"));

        if(questionTree.yesTo("Reload Saved Game?")) {

            try {

                Scanner sc = new Scanner(new File("Save.txt"));
                questionTree.read(sc);

            }

            catch(Exception e) {
                System.out.println("Exception");
            }

        }

        do {
            questionTree.askQuestions();
        }

        while(questionTree.yesTo("Do you want to play again?"));

        if(questionTree.yesTo("Save Tree?")) {

            try {

                PrintStream output = new PrintStream(new File("Save.txt"));
                questionTree.write(output);

            }

            catch(Exception e) {
                System.out.println("Exception");
            }

        }

    }

}
