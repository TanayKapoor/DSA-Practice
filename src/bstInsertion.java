import java.util.*;

//class Node {
//    Node left;
//    Node right;
//    int data;
//
//    Node(int data) {
//        this.data = data;
//        left = null;
//        right = null;
//    }
//}

class bstInsertion {

    public static void preOrder( nodeHuffman root ) {

        if( root == null)
            return;

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);

    }

 /* Node is defined as :
 class Node 
    int data;
    Node left;
    Node right;
    
    */

    public static nodeHuffman insert(nodeHuffman root, int value)
    {
        if(root == null) {
            root = new nodeHuffman(value);
        } else if(value < root.data){
            root.left = insert(root.left,value);
        } else if(value > root.data) {
            root.right = insert(root.right,value);
        }

        return root;

    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        nodeHuffman root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        preOrder(root);
    }
}