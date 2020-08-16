#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
#include <cstring>

int main() {
    std::string input;

    std::cin >> input;

    int32_t hour = std::stoi(input.substr(0, 2));

    if (input[8] == 'P' && hour != 12) {
        hour += 12;
    } else if (input[8] == 'A' && hour == 12) {
        hour = 0;
    }

    char * result = new char[input.size() + 1];
    strcpy(result, input.c_str());

    const char * number = std::to_string(hour).c_str();

    if (hour >= 10) {
        result[0] = number[0];
        result[1] = number[1];
    } else {
        result[0] = '0';
        result[1] = number[0];
    }

    result[8] = '\0';

    std::cout << std::string(result) << std::endl;

    delete[] result;

    return 0;
}
