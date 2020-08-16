function truncate(str, max) {
    if (typeof str !== 'string' || str.length === 0) {
        return str;
    }

    return str.length > max ? `${str.substr(str, max)}…` : str;
}
