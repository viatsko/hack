const calPoints = ops => {
    let sum = 0;
    const q = [];

    for (const op of ops) {
        switch (op) {
            case 'C':
                q.pop();
                break;
            case 'D':
                q.push(q[q.length - 1] * 2);
                break;
            case '+':
                q.push(q.slice(-2).reduce((prev, next) => prev + next, 0));
                break;
            default:
                q.push(+op);
        }
    }

    return q.reduce((prev, next) => prev + next, 0)
};
