import java.util.Scanner;

public class CatsAndAMouse {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        for(int i = 0; i < n; i++){
            // Cat A
            int x = in.nextInt();

            // Cat B
            int y = in.nextInt();

            // Mouse C
            int z = in.nextInt();

            int xz = Math.abs(x - z);
            int yz = Math.abs(y - z);

            if (xz == yz) {
                System.out.println("Mouse C");
            } else if (xz < yz) {
                System.out.println("Cat A");
            } else {
                System.out.println("Cat B");
            }
        }
    }
}
