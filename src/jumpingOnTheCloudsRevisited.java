import java.util.*;

public class jumpingOnTheCloudsRevisited {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] c = new int[n];
        for(int c_i=0; c_i < n; c_i++){
            c[c_i] = in.nextInt();
        }
        int curr = 0;
        int Energy = 100;
        while(curr < n ){
            Energy--;
            if(c[curr]==1)
                Energy-=2;
            curr += k;
        }
        System.out.println(Energy);
    }

}
