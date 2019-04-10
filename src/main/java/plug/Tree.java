package plug;

import java.util.ArrayList;
import java.util.List;

public class Tree {
    public String text ="";
    public List<Tree> nodes = new ArrayList<Tree>();


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<Tree> getNodes() {
        return nodes;
    }

    public void setNodes(List<Tree> nodes) {
        this.nodes = nodes;
    }
    public void addNodes(Tree tree){
        this.nodes.add(tree);
    }

    public Tree(String text) {
        this.text = text;
    }

    public Tree() {
    }

    @Override
    public String toString() {
        return "Tree{" +
                "text='" + text + '\'' +
                ", nodes=" + nodes +
                '}';
    }
}
