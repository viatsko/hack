import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathFromToInMatrix {
    private static class Direction {
        int row;
        int col;

        Direction(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    private static class Point {
        int row;
        int col;
        int total = 0;

        Point(int row, int col) {
            this.row = row;
            this.col = col;
        }

        Point(int row, int col, int total) {
            this.row = row;
            this.col = col;
            this.total = total;
        }
    }

    private static Direction[] directions = new Direction[] {
            new Direction(-1, 0),
            new Direction(1, 0),
            new Direction(0, -1),
            new Direction(0, 1),
    };

    private static boolean isValid(int[][] grid, int row, int col) {
        return  row >= 0 &&
                row < grid.length &&
                col >= 0 &&
                col < grid[0].length;
    }

    private static int bfs(int[][] grid, Point from, Point to) {
        if (grid.length == 0 || grid[0].length == 0) {
            return -1;
        }

        boolean[][] visited = new boolean[grid.length][grid[0].length];

        Queue<Point> queue = new LinkedList<>();

        queue.add(from);

        while (!queue.isEmpty()) {
            Point current = queue.poll();

            if (current.row == to.row && current.col == to.col) {
                return current.total;
            }

            for (Direction direction : directions) {
                int row = current.row + direction.row;
                int col = current.col + direction.col;

                if (isValid(grid, row, col) && !visited[row][col]) {
                    visited[row][col] = true;
                    queue.add(new Point(row, col, current.total + 1));
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                new int[] {1, 0, 1, 1, 1, 1, 1, 1, 1, 0},
                new int[] {0, 0, 1, 1, 0, 0, 0, 0, 1, 0},
                new int[] {0, 0, 1, 1, 0, 0, 0, 0, 1, 0},
                new int[] {0, 0, 1, 1, 0, 0, 0, 0, 1, 0},
                new int[] {0, 0, 1, 1, 0, 0, 0, 0, 1, 0},
                new int[] {0, 0, 1, 1, 1, 0, 0, 0, 1, 0},
                new int[] {0, 0, 1, 1, 1, 1, 0, 0, 1, 0},
                new int[] {0, 0, 1, 1, 0, 1, 1, 1, 1, 0},
                new int[] {0, 0, 1, 1, 0, 0, 0, 0, 1, 0},
                new int[] {0, 0, 1, 1, 1, 1, 1, 1, 1, 0},
        };

        Point from = new Point(0, 2);
        Point to = new Point(9, 9);

        System.out.println(bfs(grid, from, to));
    }
}
