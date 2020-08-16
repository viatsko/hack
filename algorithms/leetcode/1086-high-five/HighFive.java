class Solution {
    class StudentScoresData {
        public int scores = 0;
        public int total = 0;
        public boolean done = false;
    }
    
    public int[][] highFive(int[][] items) {
        Arrays.sort(items, new Comparator<int[]>(){
            public int compare(int[] a, int[] b) {
                // by score desc
                if (a[0] == b[0]) {
                    return b[1] - a[1];
                }
                
                // by id asc
                return a[0] - b[0];
            }
        });
        
        Map<Integer, StudentScoresData> studentToScoresData = new HashMap<>();
        
        for (int[] studentWithScore : items) {
            StudentScoresData data = studentToScoresData.get(studentWithScore[0]);
            
            if (data == null) {
                data = new StudentScoresData();
                studentToScoresData.put(studentWithScore[0], data);
            }
            
            if (data.done) {
                continue;
            }
            
            data.scores++;
            data.total += studentWithScore[1];
            
            if (data.scores == 5) {
                data.done = true;
            }
        }
        
        int[][] result = new int[studentToScoresData.size()][2];
        
        Iterator it = studentToScoresData.entrySet().iterator();
        int i = 0;
        while(it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            result[i][0] = (Integer) entry.getKey();
            StudentScoresData val = (StudentScoresData) entry.getValue();
            result[i][1] = val.total / 5;
            i++;
        }
        
        return result;
    }
}