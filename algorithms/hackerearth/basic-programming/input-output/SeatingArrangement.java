import java.util.Scanner;

public class SeatingArrangement {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();

        for (int i = 0; i < t; i++) {
            int n = in.nextInt();

            int mod12 = n % 12;

            String type = "";

            switch(mod12) {
                case 0:
                    n -= 11;
                    type = "WS";
                    break;
                case 1:
                    n += 11;
                    type = "WS";
                    break;
                case 6:
                    n++;
                    type = "WS";
                    break;
                case 7:
                    n--;
                    type = "WS";
                    break;
                case 2:
                    n += 9;
                    type = "MS";
                    break;
                case 5:
                    n += 3;
                    type = "MS";
                    break;
                case 8:
                    n -= 3;
                    type = "MS";
                    break;
                case 11:
                    n -= 9;
                    type = "MS";
                    break;
                case 3:
                    n += 7;
                    type = "AS";
                    break;
                case 4:
                    n += 5;
                    type = "AS";
                    break;
                case 9:
                    n -= 5;
                    type = "AS";
                    break;
                case 10:
                    n -= 7;
                    type = "AS";
            }

            System.out.println(n + " " + type);
        }
    }
}
