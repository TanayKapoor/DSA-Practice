import java.util.Scanner;

class Node {
    Node left;
    Node right;
    int data;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class lowestCommonAncestor {

    /*
    class Node
        int data;
        Node left;
        Node right;
    */


    /*
    class Node
        int data;
        Node left;
        Node right;
    */
    static nodeSwapNodesAlgo lca(nodeSwapNodesAlgo root, int v1, int v2)
    {
        //Decide if you have to call rekursively
        //Samller than both
        if(root.data < v1 && root.data < v2){
            return lca(root.right,v1,v2);
        }
        //Bigger than both
        if(root.data > v1 && root.data > v2){
            return lca(root.left,v1,v2);
        }

        //Else solution already found
        return root;
    }


    public static nodeSwapNodesAlgo insert(nodeSwapNodesAlgo root, int data) {
        if(root == null) {
            return new nodeSwapNodesAlgo(data);
        } else {
            nodeSwapNodesAlgo cur;
            if(data <= root.data) {
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
        nodeSwapNodesAlgo root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        int v1 = scan.nextInt();
        int v2 = scan.nextInt();
        scan.close();
        if (root != null) {
            nodeSwapNodesAlgo ans = lca(root, v1, v2);
            System.out.println(ans.data);
        } else {
            throw new AssertionError();
        }
    }
}
