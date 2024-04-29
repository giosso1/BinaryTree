import javax.swing.*;

public class Tree {
    private Node root;

    //constructs tree with one node (Computer)
    public Tree() {
        root = new Node("Computer");
    }

    //asks questions from the root of the tree
    public void askQuestions() {
        root = askQuestions(root);
    }

    //asks questions from a specific node
    //iterates through nodes until guess is made OR computer runs out of questions
    private Node askQuestions(Node current) {
        //if the current node is an answer
        if (isAnswerNode(current)) {
            //if computer is correct
            if (yesTo("Is your object " + current.data +"?")) {
                JOptionPane.showMessageDialog(null, "I got it correct");
            }
            //if the computer was incorrect
            //gets new information from user to update tree
            else{
                String input = JOptionPane.showInputDialog(null, "What is your object? ");
                Node answer = new Node(input);
                input = JOptionPane.showInputDialog(null, "Please give a yes/no question to distinguish your object");
                String question = input;
                if (yesTo("What is the answer")) {
                    current = new Node(question, answer, current);
                } else {
                    current = new Node(question, current, answer);
                }
            }
        }//end answer node
        //if the current node is a question node
        else {
            //ask the current question
            if (yesTo(current.data)) {
                current.yesNode = askQuestions(current.yesNode);
            }
            else {
                current.noNode = askQuestions(current.noNode);
            }
        }//end question node

        return current;
    }//end askQuestions (with node input)

    //asks yes/no question with given string
    //returns true for yes, false for no
    public boolean yesTo(String prompt) {
        String[] opt = {"Yes", "No"};
        int response = JOptionPane.showOptionDialog(null, prompt, null, JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opt, opt[0]);
        return response==0;
    }

    // private method that determines whether a specific node is an answer (leaf) node
    private boolean isAnswerNode(Node node) {
        return (node.yesNode == null || node.noNode == null);
    }
}