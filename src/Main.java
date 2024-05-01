public class Main {

    public static void main(String[] args) {

        QuestionTree questionTree = new QuestionTree(new QuestionNode("computer"));

        do {
            questionTree.askQuestions();
        }

        while(questionTree.yesTo("Do you want to play again?"));

    }

}
