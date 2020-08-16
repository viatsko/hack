import java.util.Scanner;

public class SumOfFour {
    public static void main(String[] args) {

        int[] numArray = new int[4]; // Define an array of integers of size 4.
        Scanner s = new Scanner(System.in);
        int i;
        for(i=0; i<4; i++){
            numArray[i] = s.nextInt(); // Get the input
        }

        int sum = 0;
        // Write the logic to add these integers here:
        for (i = 0; i < 4; i++) {
            sum += numArray[i];
        }



        System.out.print(sum); // Print the sum
        s.close();
    }
}
