import java.util.List;

/**
 * Created by XingyangChen on 10/15/16.
 */
public class IndexTree {
    class TreeNode{
        int val;
        int parent;
        boolean visited;
        boolean valid;
    }
    public void deleteSubTree(int index, List<TreeNode> input){
        input.get(index).visited = true;
        input.get(index).valid = true;
        for(int i = 0; i < input.size(); i++){
            if(input.get(i).visited) continue;
            if(needDelete(index, input)){
                label(index,input);
            }
        }

    }
    public boolean needDelete(int index, List<TreeNode> input){
        int cur = index;
        while(cur != -1 && !input.get(cur).visited){
            input.get(cur).visited = true;
            cur = input.get(cur).parent;
        }
        if(cur == -1) return false;
        return !input.get(cur).valid;
    }

    public void label(int index, List<TreeNode> input){
        int cur = index;
        while(cur != -1 && input.get(cur).valid){
            input.get(cur).valid = false;
            cur = input.get(index).parent;
        }
    }


}
