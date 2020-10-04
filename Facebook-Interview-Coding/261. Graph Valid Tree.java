261. Graph Valid Tree
// https://leetcode.com/problems/graph-valid-tree/

Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.
Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false.


Test:
//1. corner case: n == 1 && edges.length == 0. eg. n = 1, [], it's true
//2. edges.length != n - 1 --> a valid n-node tree should have n - 1 edges
//3. initialize roots[i] = -1
//4. find method --> cycle exists ? return false : union them


Solution 1: Union - Find (no need to create disjoint set)
Time: O(V*E), find: O(V)

public boolean validTree(int n, int[][] edges) {
    // if (edges.length == 0 && n == 1)  return true;
    if (edges.length != n - 1)  return false;
    int[] vertices = new int[n];
    Arrays.fill(vertices, -1); // use -1, clean code
    for (int[] e : edges) {
        int i = find(vertices, e[0]);
        int j = find(vertices, e[1]);
        if (i == j)     return false;  // cycle detected, false
        vertices[j] = i; // connect edge
    }
    return true;
}
private int find(int[] nums, int i) {
    if (nums[i] == -1)  return i;  // here also use -1
    return find(nums, nums[i]);
}



Solution 2: DFS in graph 
[YouTube: Cycle Dection in Undirected Graph] // https://www.youtube.com/watch?v=n_t0a_8H8VY

public boolean validTree(int n, int[][] edges) {
    List<List<Integer>> adjList = new ArrayList<>();
    //if (edges.length == 0 && n == 1)  return true;
    if (edges.length != n - 1)  return false;
    for (int i = 0; i < n; i++)
        adjList.add(i, new LinkedList<>());
    for (int[] edge : edges) {
        adjList.get(edge[0]).add(edge[1]);
        adjList.get(edge[1]).add(edge[0]);
    }
    boolean[] visited = new boolean[n];
    if (hasCycle(adjList, visited, 0, -1))  return false; // here use 0 as graph source
    for (int i = 0; i < n; i++) // but 0 may not be in 'adjList', so should check if all vertices are visited,  e.x.[[1,2],[2,3],[1,3]]
        if (!visited[i])    return false;
    return true;
}
public boolean hasCycle(List<List<Integer>> adjList, boolean[] visited, int i, int pre) {
    visited[i] = true;
    for (int v : adjList.get(i)) 
        if (v != pre && visited[v] || !visited[v] && hasCycle(adjList, visited, v, i)) return true;
    return false;
}






