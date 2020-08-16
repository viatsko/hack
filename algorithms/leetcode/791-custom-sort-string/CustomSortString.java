class Solution {
    public String customSortString(String S, String T) {
        int[] pos = new int[26];

        Arrays.fill(pos, -1);

        for (int i = 0; i < S.length(); i++) {
            pos[S.charAt(i) - 'a'] = i;
        }
        
        int N = T.length();
        Character[] C = new Character[N];
        
        for (int i = 0; i < N; i++) {
            C[i] = T.charAt(i);
        }
        
        Arrays.sort(C, new Comparator<Character>() {
            @Override
            public int compare(Character a, Character b) {
                return pos[a - 'a'] - pos[b - 'a'];
            }
        });
        
        StringBuilder sb = new StringBuilder();
        for (Character c : C) {
            sb.append(c);
        }
        return sb.toString();
    }
}
