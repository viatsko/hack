
const reconstructQueue = people => {
    people.sort((a, b) => {
        return b[0] - a[0] || a[1] - b[1];
    });
    
    const result = [];
    
    for (const person of people) {
        result.splice(person[1], 0, person);
    }
    
    return result;
}
