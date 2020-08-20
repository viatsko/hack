const intersection = (nums1, nums2) => {
    const h1 = new Set(nums1);
    const h2 = new Set(nums2);

    return [...new Set([...h1].filter(num => h2.has(num)))];
};
