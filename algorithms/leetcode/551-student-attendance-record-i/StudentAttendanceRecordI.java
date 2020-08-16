public class StudentAttendanceRecordI {
    public boolean checkRecord(String s) {
        int absent = 0;

        int n = s.length();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            switch (ch) {
                case 'A':
                    if (absent++ > 0) {
                        return false;
                    }
                    break;
                case 'P':
                    break;
                case 'L':
                    int count = 1;
                    while (i < n - 1 && s.charAt(i) == s.charAt(i + 1)) {
                        count++;
                    }

                    if (count > 2) {
                        return false;
                    }
                    break;
            }
        }

        return true;
    }
}
