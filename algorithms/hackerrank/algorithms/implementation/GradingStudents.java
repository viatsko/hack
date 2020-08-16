import java.util.Scanner;

public class GradingStudents {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        for (int i = 0; i < n; i++) {
            int tmp = in.nextInt();

            if (tmp < 38) {
                System.out.println(tmp);
            } else {
                int closest = (int) Math.ceil((double) tmp / 5.0) * 5;

                if (Math.abs(closest - tmp) < 3) {
                    System.out.println(closest);
                } else {
                    System.out.println(tmp);
                }
            }
        }
    }
}
