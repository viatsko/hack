package freemarker.entity;

public class PathName {
    private int depth;

    private String name;

    private String fullPath;

    public PathName(int depth, String name, String fullPath) {
        this.depth = depth;
        this.name = name;
        this.fullPath = fullPath;
    }

    public int getDepth() {
        return depth;
    }

    public String getName() {
        return name;
    }

    public String getFullPath() {
        return fullPath;
    }

    @Override
    public String toString() {
        return "PathName{" +
                "depth=" + depth +
                ", name='" + name + '\'' +
                ", fullPath='" + fullPath + '\'' +
                '}';
    }
}
