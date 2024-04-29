public class Node {
    public String data;
    public Node yesNode;
    public Node noNode;

    //constructs node with data (question), leaf node
    //parameter String (question)
    public Node(String data) {
        this(data,null, null);
    }

    //constructs node with data (question), yes and no subtrees
    //parameters String (question), Node (left subtree), Node (right subtree)
    public Node(String data, Node yesNode, Node noNode) {
        this.data = data;
        this.yesNode = yesNode;
        this.noNode = noNode;
    }

}//end Node