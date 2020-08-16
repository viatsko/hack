const cloneGraph = graph => {
    if (!graph) {
        return null;
    }

    const map = new Map();

    const f = node => {
        if (map.has(node.label)) {
            return map.get(node.label);
        }

        const cloned = new UndirectedGraphNode(node.label);

        map.set(node.label, cloned);

        for (const neighbor of node.neighbors) {
            cloned.neighbors.push(f(neighbor));
        }

        return cloned;
    };

    let root = f(graph);

    return root;
};
