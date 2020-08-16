/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
*/
class Solution {
    private Node clone(Map<Node, Node> originalsToClonesMap, Node originalNode) {
        if (originalNode == null) {
            return null;
        }
        
        if (originalsToClonesMap.containsKey(originalNode)) {
            return originalsToClonesMap.get(originalNode);
        }
        
        List<Node> neighbors = new LinkedList<>();
        
        Node clonedNode = new Node(originalNode.val, neighbors);
        
        originalsToClonesMap.put(originalNode, clonedNode);
        
        for (Node neighbor : originalNode.neighbors) {
            clonedNode.neighbors.add(clone(originalsToClonesMap, neighbor));
        }
        
        return clonedNode;
    }
    
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        
        Map<Node, Node> originalsToClonesMap = new HashMap<>();
        
        return clone(originalsToClonesMap, node);
    }
}
