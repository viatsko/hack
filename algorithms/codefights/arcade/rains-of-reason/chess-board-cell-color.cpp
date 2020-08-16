#include <string>

bool isCellOdd(std::string cell) {
    if (cell[0] % 2 == cell[1] % 2) {
        return true;
    } else {
        return false;
    }
}

bool chessBoardCellColor(std::string cell1, std::string cell2) {
    return isCellOdd(cell1) == isCellOdd(cell2);
}
