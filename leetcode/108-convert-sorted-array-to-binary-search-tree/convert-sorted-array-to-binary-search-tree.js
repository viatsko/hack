const sortedArrayToBST = nums => {
    const toBST = (left, right) => {
        if (left > right) {
            return null;
        }

        const mid = (left + right) >> 1;

        const node = new TreeNode(nums[mid]);

        node.left = toBST(left, mid - 1);
        node.right = toBST(mid + 1, right);

        return node;
    };

    return toBST(0, nums.length - 1);
};
