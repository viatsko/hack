
const optimalDivision = nums => {
    if (nums.length <= 2) {
        return nums.join('/');
    } else {
        return nums.shift() + '/(' + nums.join('/') + ')';
    }
}
