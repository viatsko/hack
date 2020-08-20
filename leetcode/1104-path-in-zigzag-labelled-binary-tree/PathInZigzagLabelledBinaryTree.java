class Solution {
    private int calculateHeight(int n) {
        int height = 1;
        while ((n >>= 1) > 0) height++;
        return height;
    }
    
    public List<Integer> pathInZigZagTree(int label) {
        LinkedList<Integer> result = new LinkedList<>();
        
        int height = calculateHeight(label); // for 14 it's 4
        
        for (; label >= 1; label /= 2, height--) {
            result.addFirst(label);
            // 1. 16 - 1 - 14 + 8 = 9
            //    next step 9 / 2 = 4
            // 2. 8 - 1 - 4 + 4 = 7
            //    next step 7 / 2 = 3
            // 3. etc
            label = (1 << height) - 1 - label + (1 << (height - 1));
        }

        return result;
    }
}
