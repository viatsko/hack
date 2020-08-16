function camelize(str) {
    return str.split('-').map(function(str, index) {
        return index === 0 ? str : `${str[0].toUpperCase()}${str.substr(1)}`;
    }).join('');
}
