import javax.swing.*;

public class Game {
    public static void main(String[] args){
        //initialize tree
        Tree questions = new Tree();

        do {
            //ask questions
            JOptionPane.showMessageDialog(null, "Please think of an object for me to guess.");
            questions.askQuestions();
        } while (questions.yesTo("Do you want to go again?"));//repeat while user wants to play again
    }//end Main
}//end Game