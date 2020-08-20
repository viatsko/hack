const nextGreaterElement = (findNums, nums) => {
    const st = [];
    const map = new Map();

    const result = [];

    for (const num of nums) {
        while(st.length && st[st.length - 1] < num) {
            map.set(st.pop(), num);
        }

        st.push(num);
    }

    for (const num of findNums) {
        result.push(map.has(num) ? map.get(num) : -1);
    }

    return result;
};
