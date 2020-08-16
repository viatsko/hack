class Solution {
  boolean[] visited;
  List<List<Integer>> rooms;

  private void dfs(int index) {
    if (visited[index]) {
      return;
    }

    visited[index] = true;

    for (int key : rooms.get(index)) {
      dfs(key);
    }
  }

  public boolean canVisitAllRooms(List<List<Integer>> rooms) {
    int N = rooms.size();

    this.visited = new boolean[N];
    this.rooms = rooms;

    dfs(0);

    for (boolean room : visited) {
      if (!room) {
        return false;
      }
    }

    return true;
  }
}
