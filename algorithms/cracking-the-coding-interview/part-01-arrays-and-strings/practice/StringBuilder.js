/** This was only useful in IE6/IE7, just a PoC **/
class StringBuilder {
    constructor() {
        this.index = 0;
        this.list = [];
    }

    append(part) {
        this.list[this.index++] = part;
    }

    toString() {
        return this.list.join('');
    }
}

const sb = new StringBuilder();
sb.append('first');
sb.append('second');
console.log(sb.toString());
