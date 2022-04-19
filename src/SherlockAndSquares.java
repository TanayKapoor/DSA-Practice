import java.util.Scanner;

public class SherlockAndSquares {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int square_count;
        int test_cases = in.nextInt();
        int from;
        int to;
        for (int i = 0; i < test_cases; i++) {
            from = in.nextInt();
            to = in.nextInt();
            int a = (int) Math.ceil(Math.sqrt(from));
            int b = (int) Math.floor(Math.sqrt(to));
            square_count = b - a + 1;
            System.out.println(square_count);
        }

        in.close();
    }
}
