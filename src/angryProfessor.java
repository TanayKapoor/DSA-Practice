import java.util.Scanner;

public class angryProfessor {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        for (int i = 0; i < T; i++) {
            int numOfStudents = 0;
            int N = scan.nextInt();
            int K = scan.nextInt();
            for (int j = 0; j < N; j++) {
                int a = scan.nextInt();
                if (a <= 0) numOfStudents++;
            }
            if (numOfStudents < K) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
