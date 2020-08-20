import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class JavaDateAndTime {
    private static String[] weekDays = new String[]{"", "SUNDAY", "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY"};

    private static String getDay(String day, String month, String year) {
        Calendar calendar = new GregorianCalendar(
                Integer.parseInt(year),
                Integer.parseInt(month) - 1,
                Integer.parseInt(day)
        );

        return weekDays[calendar.get(Calendar.DAY_OF_WEEK)];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String month = in.next();
        String day = in.next();
        String year = in.next();

        System.out.println(getDay(day, month, year));
    }
}
