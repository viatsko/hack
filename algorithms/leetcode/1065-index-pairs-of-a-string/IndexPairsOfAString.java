class Solution {
    public int[][] indexPairs(String text, String[] words) {
        List<int[]> pairs = new LinkedList<>();
        for (int i = 0; i < words.length; i++) {
            int index = 0;
            
            while (true) {
                index = text.indexOf(words[i], index);
                
                if (index == - 1)
                    break;
                
                pairs.add(new int[]{ index, index + words[i].length() - 1 });
                index++;
            }
        }
        
        Collections.sort(pairs, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0]) {
                    return a[1] - b[1];
                }
                return a[0] - b[0];
            }
        });
        
        return pairs.toArray(new int[pairs.size()][2]);
    }
}