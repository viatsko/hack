#include <climits>
#include <vector>

int deleteByIndex(std::vector<int> number, std::size_t index) {
    number.erase(number.begin() + index);

    int result = 0;
    for (int const& digit : number) {
        result *= 10;
        result += digit;
    }

    return result;
}

int deleteDigit(int n) {
    int max = INT_MIN;

    std::vector<int> number;

    while (n > 0) {
        number.push_back(n % 10);
        n /= 10;
    }

    std::reverse(number.begin(), number.end());

    for (std::vector<int>::size_type i = 0; i < number.size(); i++) {
        int num = deleteByIndex(number, i);

        if (num > max) {
            max = num;
        }
    }

    return max;
}
