import java.util.LinkedList;
import java.util.Scanner;

class treeLevelOrderTraversal {

    /*

    class Node
        int data;
        Node left;
        Node right;
    */
    public static void levelOrder(nodeHuffman root) {
        LinkedList<nodeHuffman> nodes = new LinkedList<>();

        nodes.add(root);

        while (!nodes.isEmpty()) {
            if (nodes.peek().left != null)
                nodes.add(nodes.peek().left);

            if (nodes.peek().right != null)
                nodes.add(nodes.peek().right);

            System.out.print(nodes.poll().data + " ");
        }
    }

    public static nodeHuffman insert(nodeHuffman root, int data) {
        if (root == null) {
            return new nodeHuffman(data);
        } else {
            nodeHuffman cur;
            if (data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        nodeHuffman root = null;
        while (t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        levelOrder(root);
    }
}
