public class isThisBST {
    boolean checkBST(Node root) {
        return isBSTNode(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    boolean isBSTNode(Node root, int min, int max){
        boolean isBstNode = false;
        if(root == null){
            return true;
        }
        if(root.data < min || root.data > max){
            return false;
        }
        return (isBSTNode(root.left, min, root.data-1) && isBSTNode(root.right, root.data+1, max));
    }

}
