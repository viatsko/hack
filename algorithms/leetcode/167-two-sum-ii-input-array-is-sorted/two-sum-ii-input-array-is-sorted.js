
const twoSum = (numbers, target) => {
    const mp = {};

    for (let i = 0; i < numbers.length; i++) {
        if (mp.hasOwnProperty(target - numbers[i])) {
            return [mp[target - numbers[i]], i + 1];
        }

        mp[numbers[i]] = i + 1;
    }

    return [-1, -1];
}
