import java.util.*;

class topViewNode {
    nodeHuffman left;
    nodeHuffman right;
    int data;

    topViewNode(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class treeTopView {

    /*

    class Node
        int data;
        Node left;
        Node right;
    */
    static class Pair{
        public nodeHuffman node;
        public int dist;

        public Pair(nodeHuffman node, int dist){
            this.node = node;
            this.dist = dist;
        }
    }

    public static void topView(nodeHuffman root) {
        if(root == null)
            return;
        Map<Integer, Integer> mp = new TreeMap<>();
        LinkedList<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(root, 0));
        while(!q.isEmpty()){
            Pair pair = q.poll();
            nodeHuffman node = pair.node;
            int dist = pair.dist;
            if(!mp.containsKey(dist)){
                mp.put(dist, (int) node.data);
            }
            if(node.left != null){
                q.add(new Pair(node.left, dist-1));
            }
            if(node.right != null){
                q.add(new Pair(node.right, dist+1));
            }
        }
        for(Map.Entry<Integer, Integer> ent : mp.entrySet()){
            System.out.print(ent.getValue()+ " ");
        }
    }

    public static nodeHuffman insert(nodeHuffman root, int data) {
        if(root == null) {
            return new nodeHuffman(data);
        } else {
            nodeHuffman cur;
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
        nodeHuffman root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        topView(root);
    }
}
