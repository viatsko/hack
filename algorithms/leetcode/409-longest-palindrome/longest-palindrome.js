const longestPalindrome = s => {
    const st = new Set();

    let len = 0;

    for (const c of s) {
        if (st.has(c)) {
            len += 2;
            st.delete(c);
        } else {
            st.add(c);
        }
    }

    if (st.size > 0) {
        len++;
    }

    return len;
};
