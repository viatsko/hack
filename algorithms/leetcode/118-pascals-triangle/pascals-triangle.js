const generate = numRows => {
    let result = [];

    let row = [];

    for (let i = 0; i < numRows; i++) {
        row.splice(0, 0, 1);

        for (let j = 1; j < row.length - 1; j++) {
            row[j] = row[j] + row[j + 1];
        }

        result.push(row.slice(0));
    }

    return result;
};
