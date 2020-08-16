const isIsomorphic = (s, t) => {
    if (s.length !== t.length) {
        return false;
    }

    const st = new Map();
    const ts = new Map();

    for (let i = 0; i < s.length; i++) {
        if (!st.has(s[i]) && !ts.has(t[i])) {
            st.set(s[i], t[i]);
            ts.set(t[i], s[i]);
        } else {
            if (st.get(s[i]) !== t[i] || ts.get(t[i]) !== s[i]) {
                return false;
            }
        }
    }

    return true;
};
