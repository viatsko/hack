class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] courseNumberOfPrerequisites = new int[numCourses];
        
        for (int[] prerequisite: prerequisites) {
            courseNumberOfPrerequisites[prerequisite[0]]++;
        }
        
        Queue<Integer> q = new LinkedList<>();
        
        for (int i = 0; i < numCourses; i++) {
            if (courseNumberOfPrerequisites[i] == 0) {
                q.offer(i);
            }
        }
        
        int coursesAttended = q.size();
        
        while (!q.isEmpty()) {
            int current = q.poll();
            
            for (int[] prerequisite: prerequisites) {
                if (prerequisite[1] == current) {
                    courseNumberOfPrerequisites[prerequisite[0]]--;
                    if (courseNumberOfPrerequisites[prerequisite[0]] == 0) {
                        q.offer(prerequisite[0]);
                        coursesAttended++;
                    }
                }
            }
        }
        
        return coursesAttended == numCourses;
    }
}
