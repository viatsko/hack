import java.util.ArrayList;
import java.util.List;

public class NextClosestTime {
    private void backtrack(List<Integer> result, char[] digits, char[] tmp, int length) {
        if (length == 4) {
            String hour = new String(new char[]{
                    tmp[0],
                    tmp[1]
            });

            String minute = new String(new char[]{
                    tmp[2],
                    tmp[3]
            });

            Integer hourN = Integer.parseInt(hour, 10);

            if (hourN >= 24) {
                return;
            }

            Integer minuteN = Integer.parseInt(minute, 10);

            if (minuteN >= 60) {
                return;
            }

            result.add(hourN * 100 + minuteN);

            return;
        }

        for (int i = 0; i < 4; i++) {
            tmp[length] = digits[i];

            backtrack(result, digits, tmp, length + 1);
        }
    }

    public String nextClosestTime(String time) {
        char[] digits = new char[] {
                time.charAt(0),
                time.charAt(1),
                time.charAt(3),
                time.charAt(4)
        };

        char[] tmp = new char[4];

        List<Integer> result = new ArrayList<>();

        backtrack(result, digits, tmp, 0);

        int timeN = Integer.parseInt(new String(digits), 10);

        int min = 2400;
        int minTime = timeN;

        for (Integer current : result) {
            // 2000
            // 2220

            if (current > timeN) {
                int diff = Math.abs(current - timeN);

                if (diff < min) {
                    minTime = current;
                    min = diff;
                }
            } else if (current < timeN) {
                int diff = (2400 - timeN) + current;

                if (diff < min) {
                    minTime = current;
                    min = diff;
                }
            }
        }

        return String.format("%02d", minTime / 100) + ":" + String.format("%02d", minTime % 100);
    }
}
