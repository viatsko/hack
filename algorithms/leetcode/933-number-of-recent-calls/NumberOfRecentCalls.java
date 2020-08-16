class RecentCounter {
    Queue<Integer> q = new LinkedList<>();

    public int ping(int t) {
        q.add(t);
        while(q.peek() < t - 3000) {
            q.poll();
        }
        return q.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */
