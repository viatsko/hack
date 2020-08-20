public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        if (strs.size() == 0) {
            return "";
        }
        
        StringBuilder header = new StringBuilder();
        for (String str: strs) {
            header.append(String.valueOf(str.length()));
            header.append(',');
        }

        header.setLength(header.length() - 1);
        return header.toString() + "\n" + String.join("", strs);
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> result = new LinkedList<>();
        
        if (s.length() == 0) {
            return result;
        }
        
        int nl = s.indexOf('\n');
        String header = s.substring(0, nl);
        
        int start = nl + 1;
        for (String len_s : header.split(",")) {
            int len = Integer.parseInt(len_s, 10);
            result.add(s.substring(start, start + len));
            start += len;
        }
        
        return result;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));
