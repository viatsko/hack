Find K Closest Points

class Point{
     int x;
     int y;
     public Point(int x, int y) {
         this.x = x;
         this.y = y;
     }
}

重点看第二种方法！记住

Solution 1： MAX Heap 
Time: O(nlogk)    Space: O(k)

public Point[] findKClosestPoints(Point[] points, int k, Point target) {
    if (points == null || points.length == 0 || k < 1 || k > points.length)   return points;
    Queue<Point> pq = new PriorityQueue<>(k, new Comparator<Point>(){
        public int compare(Point p1, Point p2) {
            int d1 = (p1.x - target.x) * (p1.x - target.x) + (p1.y - target.y) * (p1.y - target.y);
            int d2 = (p2.x - target.x) * (p2.x - target.x) + (p2.y - target.y) * (p2.y - target.y);
            return d2 - d1;
        }
    });
    for (Point p : points) {
        pq.offer(p);
        if (pq.size() > k)
            pq.poll();
    }
    Point[] res = new Point[k];
    for (int i = k - 1; i >= 0; i--) 
        res[i] = pq.poll();
    return res;
}


Solution 2: QuickSelect
Time: O(n) average, O(n + klogk) time if output is sorted;  O(n^2) worst case
Space: O(1)

public Point[] findKClosestPoints(Point[] points, int k, Point target) {
    if (points.length == 0 || k < 1 || k > points.length)   return points;
    int left = 0, right = points.length - 1;
    while (true) {
        int pos = partition(points, left, right, target);
        if (pos == k - 1)   break; 
        else if (pos > k - 1)   right = pos - 1;
        else    left = pos + 1;
    }
    Point[] res = new Point[k];
    for (int i = 0; i < k; i++)
        res[i] = points[i];
    return res;
}

private int partition(Point[] points, int left, int right, Point target) {
    shuffle(points);
    int idx = left; // important
    Point pivot = points[idx];
    int pDist = getDistance(pivot, target);
    swap(points, idx, right);
    for (int i = left; i < right; i++) {
        int iDist = getDistance(points[i], target);
        if (iDist < pDist)  swap(points, i, idx++);
    }
    swap(points, idx, right);
    return idx;
}

private int getDistance(Point p, Point target) {
    return (p.x - target.x) * (p.x - target.x) + (p.y - target.y) * (p.y - target.y);
}

private static void swap(Point[] points, int left, int right) {
     Point temp = points[left];
     points[left] = points[right];
     points[right] = temp;
}








