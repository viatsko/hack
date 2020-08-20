import java.util.Scanner;

public class DesignerPDFViewer {
    private static final int LETTERS_COUNT = 26;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int[] heights = new int[LETTERS_COUNT];

        for (int i = 0; i < LETTERS_COUNT; i++) {
            heights[i] = in.nextInt();
        }

        String string = in.next();

        int n = string.length();

        int max = 0;

        for (int i = 0; i < n; i++) {
            max = Math.max(max, heights[string.charAt(i) - 'a']);
        }

        System.out.println(max * n);
    }
}
