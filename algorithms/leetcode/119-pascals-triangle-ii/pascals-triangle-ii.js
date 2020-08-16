const getRow = rowIndex => {
    const row = [1];

    for (let i = 0; i < rowIndex; i++) {
        row.push(row[i] * (rowIndex-i) / (i + 1));
    }

    return row;
};
