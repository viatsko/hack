import java.util.Scanner;

public class JavaStdinAndStdoutI {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while(in.hasNext()) {
            System.out.println(in.nextInt());
        }
    }
}
