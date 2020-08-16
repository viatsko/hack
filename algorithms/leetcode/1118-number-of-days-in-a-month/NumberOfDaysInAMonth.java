class Solution {
    public int numberOfDays(int Y, int M) {
        switch (M) {
            case 1:
                return 31;
            case 2:
                if (Y % 100 == 0) {
                    if (Y % 400 == 0) {
                        return 29;
                    }
                    return 28;
                } else {
                    if (Y % 4 == 0) {
                        return 29;
                    } else {
                        return 28;
                    }
                }
            case 3:
                return 31;
            case 4:
                return 30;
            case 5:
                return 31;
            case 6:
                return 30;
            case 7:
                return 31;
            case 8:
                return 31;
            case 9:
                return 30;
            case 10:
                return 31;
            case 11:
                return 30;
            case 12:
                return 31;
            default:
                return 0;
        }
    }
}
