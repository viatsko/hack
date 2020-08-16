
const reverseVowels = s => {
    const arr = s.split('');

    const isVowel = c => {
        return ['a', 'e', 'i', 'o', 'u'].indexOf(c.toLowerCase()) !== -1;
    }

    let e = arr.length;

    for (let i = 0; i < arr.length; i++) {
        if (isVowel(arr[i])) {
            while (e > i && e-- >= 0) {
                if (isVowel(arr[e])) {
                    const tmp = arr[e];
                    arr[e] = arr[i];
                    arr[i] = tmp;
                    break;
                }
            }
        }
    }

    return arr.join('');
}
