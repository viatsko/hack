int knapsackLight(int value1, int weight1, int value2, int weight2, int maxW) {
    if (weight1 + weight2 <= maxW) {
        return value1 + value2;
    } else if ((value1 >= value2 || weight2 > maxW) && weight1 <= maxW) {
        return value1;
    } else if (value2 > value1 && weight2 <= maxW) {
        return value2;
    } else {
        return 0;
    }
}
