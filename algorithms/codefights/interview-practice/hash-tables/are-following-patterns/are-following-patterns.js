const areFollowingPatterns = (s, p) => {
    const u = {};
    const us = {};
    for (const i in s) {
        if (!u[p[i]] && !us[s[i]]) {
            u[p[i]] = s[i];
            us[s[i]] = p[i];
        } else if (u[p[i]] !== s[i] || us[s[i]] !== p[i]) {
            return false;
        }
    }

    return true;
};
