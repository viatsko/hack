const isValid = s => {
    const st = [];

    const brackets = {
        '(': ')',
        '[': ']',
        '{': '}'
    };

    for (let i = 0; i < s.length; i++) {
        if (st.length && !brackets[s[i]]) {
            const want = brackets[st.pop()];

            if (want !== s[i]) {
                return false;
            } else {
                continue;
            }
        }

        st.push(s[i]);
    }

    return st.length === 0;
};
