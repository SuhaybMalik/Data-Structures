public class QuestionNode {

    private String statement;
    private QuestionNode yesNode;
    private QuestionNode noNode;

    public QuestionNode(String statement) {

        this.statement = statement;
        yesNode = null;
        noNode = null;

    }

    public String getStatement() {
        return statement;
    }

    public void setStatement(String statement) {
        this.statement = statement;
    }

    public QuestionNode getYesNode() {
        return yesNode;
    }

    public void setYesNode(QuestionNode yesNode) {
        this.yesNode = yesNode;
    }

    public QuestionNode getNoNode() {
        return noNode;
    }

    public void setNoNode(QuestionNode noNode) {
        this.noNode = noNode;
    }
}
