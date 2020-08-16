import java.util.Scanner;

public class BasicsOfInputOutput {
    public static void main(String args[] ) throws Exception {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        System.out.println(n * 2);

        in.nextLine();

        System.out.println(in.nextLine());
    }
}
