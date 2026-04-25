package practiceset.tree;

import java.util.ArrayList;

public class TernaryTreeNode {
    public Integer value;
    public ArrayList<TernaryTreeNode> children;

    public TernaryTreeNode(Integer value) {
        this.value = value;
        this.children = new ArrayList(3);
    }
}
