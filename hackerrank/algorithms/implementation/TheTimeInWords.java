import java.util.Scanner;

public class TheTimeInWords {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] hours = new String[] {
                "one",
                "two",
                "three",
                "four",
                "five",
                "six",
                "seven",
                "eight",
                "nine",
                "ten",
                "eleven",
                "twelve"
        };

        String[] minutes = new String[] {
                "one",
                "two",
                "three",
                "four",
                "five",
                "six",
                "seven",
                "eight",
                "nine",
                "ten",
                "eleven",
                "twelve",
                "thirteen",
                "fourteen",
                "quarter",
                "sixteen",
                "seventeen",
                "eighteen",
                "nineteen",
                "twenty",
                "twenty one",
                "twenty two",
                "twenty three",
                "twenty four",
                "twenty five",
                "twenty six",
                "twenty seven",
                "twenty eight",
                "twenty nine",
                "half"
        };

        int h = in.nextInt();
        int m = in.nextInt();

        if (m == 0) {
            System.out.println(hours[h - 1] + " o'clock");
        } else if (m <= 30) {
            System.out.println(minutes[m - 1] + (m % 15 != 0 ? (m == 1 ? " minute" : " minutes") : "") + " past " + hours[h - 1]);
        } else { // m > 30
            System.out.println(minutes[60 - m - 1] + (m % 15 != 0 ? (m == 59 ? " minute" : " minutes") : "") + " to " + hours[h != 12 ? h : 0]);
        }

        in.close();
    }
}
