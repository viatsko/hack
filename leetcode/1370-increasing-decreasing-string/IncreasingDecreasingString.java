class Solution {
  public String sortString(String s) {
    char[] ch = s.toCharArray();
    Arrays.sort(ch);

    List<Character> list = new String(ch).chars().mapToObj(c -> (char)c).collect(Collectors.toList());

    StringBuilder sb = new StringBuilder();
    char prev;
    while(list.size() > 0) {
      sb.append(list.get(0));
      prev = list.get(0);
      list.remove(0);

      while(list.size() > 0) {
        boolean found = false;

        for (int i = 0; i < list.size(); i++) {
          if (list.get(i) > prev) {
            sb.append(list.get(i));
            prev = list.get(i);
            list.remove(i);
            found = true;
            break;
          }
        }

        if (!found) {
          break;
        }
      }

      if (list.size() > 0) {
        sb.append(list.get(list.size() - 1));
        prev = list.get(list.size() - 1);
        list.remove(list.size() - 1);
      }

      while(list.size() > 0) {
        boolean found = false;

        for (int i = 0; i < list.size(); i++) {
          if (list.get(list.size() - i - 1) < prev) {
            sb.append(list.get(list.size() - i - 1));
            prev = list.get(list.size() - i - 1);
            list.remove(list.size() - i - 1);
            found = true;
            break;
          }
        }

        if (!found) {
          break;
        }
      }
    }

    return sb.toString();
  }
}
