package practiceset.tree;

/*
   For your reference:
   class TreeNode {
       Integer value;
       ArrayList<TreeNode> children;

       TreeNode(Integer value) {
           this.value = value;
           this.children = new ArrayList(3);
       }
   }
   */

public class MaximumHeightTernaryTree {

    public static void main(String[] args) {
        //Input: root = [1,null,2,3,null,4,null,5]
        //Output: 4

        TernaryTreeNode root = new TernaryTreeNode(1);
        root.children.add(new TernaryTreeNode(2));
        root.children.add(new TernaryTreeNode(3));
        root.children.getFirst().children.add(new TernaryTreeNode(4));
        root.children.getFirst().children.getFirst().children.add(new TernaryTreeNode(5));

        System.out.println(find_height(root));
    }


    static Integer find_height(TernaryTreeNode root) {
        // Write your code here.
        int result = calculateHeight(root);
        return result;
    }

    // T(n) = O(n)
    static Integer calculateHeight(TernaryTreeNode root){
        if(root == null)
            return 0;

        int maxHeight = -1;

        for(TernaryTreeNode node: root.children){
            maxHeight = Math.max(maxHeight,calculateHeight(node));

        }

        /*for(int i=0;i<root.children.size();i++){
            maxHeight = Math.max(maxHeight,calculateHeight(root.children.get(i)));
        }*/

        return maxHeight + 1;
    }
}
