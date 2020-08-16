package freemarker.entity;

import java.util.HashMap;
import java.util.Map;

public class PathNameTreeNode {
    private PathName value;

    private Map<String, PathNameTreeNode> children = new HashMap<>();


    // for root node
    public PathNameTreeNode() {

    }

    public PathNameTreeNode(PathName value) {
        this.value = value;
    }
    public Map<String, PathNameTreeNode> getChildren() {
        return children;
    }

    public PathName getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "PathNameTreeNode{" +
                "value=" + value +
                ", children=" + children +
                '}';
    }
}
