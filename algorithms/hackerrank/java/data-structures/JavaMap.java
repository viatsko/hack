import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class JavaMap {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        in.nextLine();

        for (int i = 0; i < n; i++) {
            String name = in.nextLine();

            int phone = in.nextInt();

            map.put(name, phone);

            in.nextLine();
        }

        while (in.hasNext()) {
            String name = in.nextLine();

            Integer phone = map.get(name);

            if (phone != null) {
                System.out.println(name + "=" + phone);
            } else {
                System.out.println("Not found");
            }
        }
    }
}
