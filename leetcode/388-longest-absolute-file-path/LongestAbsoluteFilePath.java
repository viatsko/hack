import java.util.ArrayList;
import java.util.List;

public class LongestAbsoluteFilePath {
    public int lengthLongestPath(String input) {
        List<String> path = new ArrayList<>();

        String[] lines = input.split("\n");

        int max = 0;

        for (String line : lines) {
            int index = 0;

            while (line.charAt(index) == '\t') {
                index++;
            }

            if (line.contains(".")) {
                StringBuilder stringBuilder = new StringBuilder();

                for (int i = 0; i < index; i++) {
                    stringBuilder.append(path.get(i)).append("/");
                }

                stringBuilder.append(line.substring(index));

                max = Math.max(max, stringBuilder.length());
            } else {
                if (path.size() < index + 1) {
                    path.add(line.substring(index));
                } else {
                    path.set(index, line.substring(index));
                }
            }
        }

        return max;
    }
}
