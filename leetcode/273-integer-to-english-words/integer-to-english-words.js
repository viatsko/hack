const numberToWords = num => {
    if (num === 0) {
        return "Zero";
    }

    let negative = false;
    const result = [];

    if (num < 0) {
        num = -num;
        negative = true;
    }

    const l20 = ["", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"];
    const x10 = ["", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"];
    const t = ["", "Thousand", "Million", "Billion"];

    let ti = 0;
    while (num > 0) {
        const group = num % 1000;

        if (group) {
            result.push(t[ti]);
        }

        const smallGroup = group % 100;

        if (smallGroup) {
            if (smallGroup < 20) {
                result.push(l20[smallGroup]);
            } else {
                result.push(x10[smallGroup / 10 | 0] + (smallGroup % 10 !== 0 ? ` ${l20[smallGroup % 10]}` : ''));
            }
        }

        const hundred = group / 100 | 0;

        if (hundred) {
            result.push(`${l20[hundred]} Hundred`);
        }

        num = num / 1000 | 0;

        ti++;
    }

    if (negative) {
        result.push("Negative");
    }

    return result.reverse().join(' ').trim();
};
