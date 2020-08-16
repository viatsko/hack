import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FindDuplicateFileInSystem {
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> duplicates = new HashMap<>();

        for (String path : paths) {
            String[] tokens = path.split(" ");

            for (int i = 1; i < tokens.length; i++) {
                int openingBrace = tokens[i].indexOf('(');
                int closingBrace = tokens[i].lastIndexOf(')');

                String file = tokens[i].substring(0, openingBrace);
                String content = tokens[i].substring(openingBrace + 1, closingBrace);

                List<String> list = duplicates.get(content);

                if (list == null) {
                    list = new ArrayList<>();
                }

                duplicates.put(content, list);

                list.add(tokens[0] + '/' + file);
            }
        }

        return duplicates.values().stream().filter(x -> x.size() > 1).collect(Collectors.toList());
    }
}
