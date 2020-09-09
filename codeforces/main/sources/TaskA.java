package sources;

import java.io.PrintWriter;
import java.util.*;

public class TaskA {
  class Node {
    public List<Node> children;

    Node() {
      children = new ArrayList<>();
    }
  }

  public void solve(int testNumber, Scanner in, PrintWriter out) {
    int n = in.nextInt();

    int[] employees = new int[n];

    Map<Integer, Node> employeeToNode = new HashMap<>();
    Node root = new Node();

    for (int i = 0; i < n; i++) {
      employees[i] = in.nextInt();

      if (!employeeToNode.containsKey(i + 1)) {
        employeeToNode.put(i + 1, new Node());
      }

      if (employees[i] == -1) {
        root.children.add(employeeToNode.get(i + 1));
      } else if (!employeeToNode.containsKey(employees[i])) {
        Node employee = new Node();
        employee.children.add(employeeToNode.get(i + 1));
        employeeToNode.put(employees[i], employee);
      }
    }

    out.println(maxHeight(root));
  }

  private int maxHeight(Node root) {
    int maxChildHeight = 0;

    for (Node child : root.children) {
      maxChildHeight = Math.max(maxChildHeight, maxHeight(child));
    }

    return maxChildHeight + 1;
  }
}
