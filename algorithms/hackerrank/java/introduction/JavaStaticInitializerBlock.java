import java.util.Scanner;

public class JavaStaticInitializerBlock {
    private static Scanner in = new Scanner(System.in);
    private static boolean flag = true;
    private static int B = in.nextInt();
    private static int H = in.nextInt();

    static {
        try {
            if (B <= 0 && H <= 0) {
                flag = false;
                throw new Exception("Breadth and height must be positive");
            }
        } catch (Exception e) {
            System.out.println(e.getClass() + " " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        if (flag) {
            int area = B * H;

            System.out.println(area);
        }
    }
}
