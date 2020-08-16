
// could be a pair of indexOf + Math.max.apply,
// but for-loop allows us to avoid double walking array like in case of those two functions
const findMaxInArray = arr => {
    let max = Number.MIN_VALUE;
    let maxIdx = -1;

    for (let i = 0; i < arr.length; i++) {
        if (arr[i] > max) {
            max = arr[i];
            maxIdx = i;
        }
    }

    return maxIdx;
};

const constructMaximumBinaryTree = nums => {    
    const rootIdx = findMaxInArray(nums);
    const rootNode = new TreeNode(nums[rootIdx]);
    
    const leftArr = nums.slice(0, rootIdx);
    if (leftArr.length) {
        rootNode.left = constructMaximumBinaryTree(leftArr);
    }
    
    const rightArr = nums.slice(rootIdx + 1);
    if (rightArr.length) {
        rootNode.right = constructMaximumBinaryTree(rightArr);
    }
    
    return rootNode;
}
