function ucFirst(str) {
    if (typeof str !== 'string' || str.length === 0) {
        return str;
    }

    return str[0].toUpperCase() + str.substr(1);
}
