using namespace std;

#include <iostream>

class HappyNumber {
  public:
    static bool find(int num) {
      int slow = num, fast = num;
      do {
        slow = calculateSquare(slow);
        fast = calculateSquare(calculateSquare(fast));
      } while (slow != fast);
      return slow == 1;
    }
  private:
    static int calculateSquare(int num) {
      int result = 0;
      while (num > 0) {
        int rem = num % 10;
        result += rem * rem;
        num /= 10;
      }
      return result;
    }
};

int main(int argc, char* argv[]) {
  cout << HappyNumber::find(23) << endl;
  cout << HappyNumber::find(12) << endl;
}
