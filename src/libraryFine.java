import java.util.Scanner;

import static java.lang.System.out;

public class libraryFine {

    public static void main(String x[]) {
        libraryFine o = new libraryFine();
        o.run();
    }

    void run() {
        try (final Scanner in = new Scanner(System.in, "ascii")) {

            final int fine;

            final int a_day = in.nextInt();
            final int amon = in.nextInt();
            final int ayr = in.nextInt();

            final int e_day = in.nextInt();
            final int emon = in.nextInt();
            final int eyr = in.nextInt();

            if (ayr < eyr) {
                fine = 0;
            } else if (ayr > eyr) {
                fine = 10_000;
            } else if (amon < emon) {
                fine = 0;
            } else if (amon > emon) {
                fine = 500 * (amon - emon);
            } else if (a_day > e_day) {
                fine = 15 * (a_day - e_day);
            } else {
                fine = 0;
            }
            out.println(fine);
        }
    }
}
