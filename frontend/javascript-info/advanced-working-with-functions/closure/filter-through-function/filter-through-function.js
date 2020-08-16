/* .. your code for inBetween and inArray */
let arr = [1, 2, 3, 4, 5, 6, 7];

function inBetween(a, b) {
    return function(x) {
        return x >= a && x <= b;
    }
}

function inArray(arr) {
    return function(x) {
        return ~arr.indexOf(x);
    }
}

process.stdout.write(arr.filter(inBetween(3, 6)).toString());
process.stdout.write("\n");
process.stdout.write(arr.filter(inArray([1, 2, 10])).toString());
