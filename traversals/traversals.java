import java.util.LinkedList;

public class traversals {
    // We create a class that defines a tree's node
    public static class TreeNode{
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int x){
            value = x;
            left = null;
            right = null;
        }
    }

    // We have another class to do the traversal and create the tree
    public static class Tree{
        public static void preOrderTraversal(TreeNode nodee){
            // return statements are executed for each recursive call
            // when we return out of the traversal we move onto next line
            // e.g line 26 hits null node, exit once out and then we move to line 28
            // in it's recursive level. Once this hits null we move onto next 
            // recursive call if any
            if( nodee == null ){ // no nodes
                return;
            }
            System.out.print(nodee.value + "->");
            preOrderTraversal(nodee.left);
            preOrderTraversal(nodee.right);
        }

        public static void inOrderTraversal(TreeNode nodee){
            if( nodee == null ){ // no nodes
                return;
            }
            inOrderTraversal(nodee.left);
            System.out.print(nodee.value+"->");
            inOrderTraversal(nodee.right);
        }

        public static void postOrderTraversal(TreeNode nodee){
            if( nodee == null ){ // no nodes
                return;
            }
            postOrderTraversal(nodee.left);
            postOrderTraversal(nodee.right);
            System.out.print(nodee.value + "->");
        }

        public static TreeNode createTree(){
            // Instead of doing below, we can use an arraylist ( see below-below )
            // TreeNode one = new TreeNode(1);
            // TreeNode two = new TreeNode(2);
            // TreeNode three = new TreeNode(3);
            // TreeNode four = new TreeNode(4);
            // TreeNode five = new TreeNode(5);
            // TreeNode six = new TreeNode(6);
        
            // Create our tree by first putting all the nodes in the air (no connections between them)
            LinkedList<TreeNode> arrTree = new LinkedList<TreeNode>();
            for (int i=1; i<7; i++){
                arrTree.add(new TreeNode(i));
            }
    
            // Next connect the edges between the nodes to define build our tree
            // arrTree:      1,2,3,4,5,6
            // arrTreeIndex: 0,1,2,3,4,5

            // WRONG !!!!!!!!!!!!!!!!!!!!! 
            //  BELOW IS WRONG AS YOU ARE CREATING NEW TREENODE INSTANCES INSTEAD OF USING EXISTING
            //  ONES WIHTIN THE ARRAYLIST THAT YOU ALREADY CREATED
            // arrTree.get(0).left = new TreeNode(2);
            // arrTree.get(0).right = new TreeNode(2);
            // arrTree.get(1).left = new TreeNode(4); 
            // arrTree.get(1).right = new TreeNode(5);
            // arrTree.get(2).left = new TreeNode(6);

            // CORRECT :))))))))))) // Connect nodes within the list to each other to form a tree
            arrTree.get(0).left = arrTree.get(1);  // Connecting 1->2
            arrTree.get(0).right = arrTree.get(2); // Connecting 1->3

            arrTree.get(1).left = arrTree.get(3);  // Connecting 2->4
            arrTree.get(1).right = arrTree.get(4); // Connecting 2->5

            arrTree.get(2).left = arrTree.get(5);  // Connecting 3->6

            // Tree Structure
                    //      1
                    //    /   \
                    //   2     3
                    //  / \    /
                    // 4   5   6

            return arrTree.get(0); // returns of type node
        }

    }

    public static void main(String[] args){
        TreeNode root = Tree.createTree(); //because createTree returns the root
        System.out.println("PreOrder");
        Tree.preOrderTraversal(root);
        System.out.println();
        System.out.println("InOrder");
        Tree.inOrderTraversal(root);
        System.out.println();
        System.out.println("PostOrder");
        Tree.postOrderTraversal(root);
    }
}
