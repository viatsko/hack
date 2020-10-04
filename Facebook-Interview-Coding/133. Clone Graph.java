133. Clone Graph
// https://leetcode.com/problems/clone-graph/

Deep Copy

public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
	Map<Integer, UndirectedGraphNode> map = new HashMap<>();
	return dfsClone(node, map);
}
public UndirectedGraphNode dfsClone(UndirectedGraphNode node, Map<Integer, UndirectedGraphNode> map) {
	if (node == null)	return null;
	if (map.containsKey(node.label))	return map.get(node.label);
	UndirectedGraphNode cloneNode = new UndirectedGraphNode(node.label);
	map.put(cloneNode.label, cloneNode);
	for (UndirectedGraphNode n : node.neighbors) 
		cloneNode.neighbors.add(dfsClone(n, map));
	return cloneNode;
}

如果图不连通，定义hashset，set<node> 每deep copy完一个，就remove

