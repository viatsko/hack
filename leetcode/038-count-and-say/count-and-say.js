const countAndSay = n => {
    let num = '1';

    for (let i = 0; i < (n - 1); i++) {
        let result = '';

        for (let j = 0; j < num.length; j++) {
            const ch = num[j];
            let count = 1;

            while(num[j + 1] === ch) {
                j++;
                count++;
            }

            result += (count + ch);
        }

        num = result;
    }

    return num;
};
