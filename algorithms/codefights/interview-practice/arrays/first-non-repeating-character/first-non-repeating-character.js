function firstNotRepeatingCharacter(s) {
    const repeated = {};

    for (const char of s) {
        // in javascript,
        // ~ returns -(N+1) used on empty type,
        // so it's an increment
        repeated[char] = -~repeated[char];
    }

    // leveraging the fact that
    // in modern browsers/vms object is ordered
    for (const char in repeated) {
        if (repeated[char] === 1) {
            return char;
        }
    }

    return "_";
}
