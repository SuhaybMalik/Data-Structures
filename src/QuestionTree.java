import java.io.PrintStream;
import java.util.Scanner;

public class QuestionTree {

    QuestionNode root;
    Scanner console = new Scanner(System.in);

    public QuestionTree(QuestionNode root) {
        this.root = root;
    }

    private void insertNode(String question, String answer, QuestionNode previousQuestion, boolean previousAnswer, boolean newAnswer) {

        if (root == null) {

            root = new QuestionNode(question);

        }

        else if(previousQuestion == null) {

            if(newAnswer) {

                QuestionNode leaf = root;
                root = new QuestionNode(question);
                root.setYesNode(new QuestionNode(answer));
                root.setNoNode(leaf);

            }

            else {

                QuestionNode leaf = root;
                root = new QuestionNode(question);
                root.setNoNode(new QuestionNode(answer));
                root.setYesNode(leaf);

            }

        }

        else {

            if (previousAnswer) {

                QuestionNode leaf = previousQuestion.getYesNode();
                previousQuestion.setYesNode(new QuestionNode(question));

                if(newAnswer) {

                    previousQuestion.getYesNode().setYesNode(new QuestionNode(answer));
                    previousQuestion.getYesNode().setNoNode(leaf);

                }

                else {

                    previousQuestion.getYesNode().setNoNode(new QuestionNode(answer));
                    previousQuestion.getYesNode().setYesNode(leaf);

                }

            }

            else {

                QuestionNode leaf = previousQuestion.getNoNode();
                previousQuestion.setNoNode(new QuestionNode(question));

                if(newAnswer) {

                    previousQuestion.getNoNode().setYesNode(new QuestionNode(answer));
                    previousQuestion.getNoNode().setNoNode(leaf);

                }

                else {

                    previousQuestion.getNoNode().setNoNode(new QuestionNode(answer));
                    previousQuestion.getNoNode().setYesNode(leaf);

                }

            }

        }

    }

    public boolean yesTo(String prompt) {

        System.out.print(prompt + " (y/n)? ");

        String response = console.nextLine().trim().toLowerCase();

        while (!response.equals("y") && !response.equals("n")) {

            System.out.println("Please answer y or n.");

            System.out.print(prompt + " (y/n)? ");

            response = console.nextLine().trim().toLowerCase();

        }

        return response.equals("y");

    }

    public void askQuestions() {

        QuestionNode currentNode = root;
        QuestionNode previousQuestion = null;
        boolean previousAnswer = true;
        System.out.println("Please think of an object for me to guess.");

        while(currentNode.getNoNode() != null && currentNode.getYesNode() != null) {

            previousQuestion = currentNode;
            boolean branch = yesTo(currentNode.getStatement());

            if(branch) {
                currentNode = currentNode.getYesNode();
            }

            else {
                currentNode = currentNode.getNoNode();
            }

        }

        boolean finalAnswer = yesTo("Would your object happen to be " + currentNode.getStatement());

        if(previousQuestion != null) {

            if(currentNode == previousQuestion.getYesNode()) {
                previousAnswer = true;
            }

            else {
                previousAnswer = false;
            }

        }

        if(finalAnswer) {
            System.out.println("Great! I got it right!");
        }

        else {

            System.out.println("What is the name of your object?");
            String answer = console.nextLine();
            System.out.println("Please give me a yes or no question that distinguishes between your object and mine: ");
            String newQuestion = console.nextLine();
            boolean newAnswer = yesTo("And what is the answer for your object?");
            insertNode(newQuestion, answer, previousQuestion, previousAnswer, newAnswer);

        }

    }

    private void preOrderTraversalWrite(PrintStream output, QuestionNode root) {

        if(root == null) {
            return;
        }

        if(root.getYesNode() == null && root.getNoNode() == null) {
            output.print("A:\n" + root.getStatement() + "\n");
        }

        else {
            output.print("Q:\n" + root.getStatement() + "\n");
        }

        preOrderTraversalWrite(output, root.getYesNode());
        preOrderTraversalWrite(output, root.getNoNode());

    }

    public void write(PrintStream output) {
        preOrderTraversalWrite(output, root);
    }

}
