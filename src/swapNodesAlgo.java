import java.util.*;

public class swapNodesAlgo {
    static nodeSwapNodesAlgo root = new nodeSwapNodesAlgo(1);

    public static void main(String ... arg)
    {
        Scanner sc = new Scanner(System.in);
        int n,t,k;
        n = sc.nextInt();
        int[][] tree = new int[n][2];
        for(int i=0;i<n;i++)
        {
            tree[i][0] = sc.nextInt();
            tree[i][1] = sc.nextInt();
        }
        root = ConstuctTree(tree);
        t = sc.nextInt();
        while(t-->0)
        {
            k = sc.nextInt();
            levelWise(root,k);
            InOrderRec(root);
            System.out.println();
        }
    }

    public static void levelWise(nodeSwapNodesAlgo root, int k)
    {
        Stack<nodeSwapNodesAlgo> currentlevel = new Stack<>();
        Stack<nodeSwapNodesAlgo> nextlevel = new Stack<>();
        int level=1;
        nodeSwapNodesAlgo temp;
        currentlevel.push(root);
        while(!currentlevel.empty())
        {
            temp = currentlevel.peek();
            currentlevel.pop();
            if(temp.left!=null)
                nextlevel.push(temp.left);
            if(temp.right!=null)
                nextlevel.push(temp.right);
            if(level%k == 0)
            {
                nodeSwapNodesAlgo n = temp.left;
                temp.left = temp.right;
                temp.right = n;
            }
            if(currentlevel.empty())
            {
                Stack<nodeSwapNodesAlgo> t = currentlevel;
                currentlevel = nextlevel;
                nextlevel = t;
                level++;
            }
        }
    }

    public static void InOrderRec(nodeSwapNodesAlgo root)
    {
        if(root == null)
            return;
        InOrderRec(root.left);
        sout(root.data);
        InOrderRec(root.right);
    }

    public static nodeSwapNodesAlgo ConstuctTree(int[][] tree)
    {
        nodeSwapNodesAlgo root = new nodeSwapNodesAlgo(1);
        Queue<nodeSwapNodesAlgo> q = new LinkedList<>();
        q.add(root);
        for (int[] ints : tree) {
            nodeSwapNodesAlgo left, right;
            if (ints[0] != -1)
                left = new nodeSwapNodesAlgo(ints[0]);
            else
                left = null;
            if (ints[1] != -1)
                right = new nodeSwapNodesAlgo(ints[1]);
            else
                right = null;

            nodeSwapNodesAlgo temp = q.remove();
            temp.left = left;
            temp.right = right;

            if (left != null)
                q.add(left);
            if (right != null)
                q.add(right);
        }
        return root;
    }


    public static void sout(int info)
    {
        System.out.printf("%d ",info);
    }
}

class nodeSwapNodesAlgo {
    int data;
    nodeSwapNodesAlgo left,right;
    nodeSwapNodesAlgo(int item)
    {
        data = item;
        left = null;
        right = null;
    }
}
