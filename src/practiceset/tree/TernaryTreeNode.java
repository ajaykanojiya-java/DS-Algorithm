package practiceset.tree;

import java.util.ArrayList;

public class TernaryTreeNode {
    Integer value;
    ArrayList<TernaryTreeNode> children;

    TernaryTreeNode(Integer value) {
        this.value = value;
        this.children = new ArrayList(3);
    }
}
