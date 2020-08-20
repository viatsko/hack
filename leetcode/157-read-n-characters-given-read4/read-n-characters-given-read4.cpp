// Forward declaration of the read4 API.
int read4(char *buf);

class Solution {
public:
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    int read(char *buf, int n) {
      int len = 0;

      while (true) {
        int current_len = read4(buf + len);

        len += current_len;

        if (current_len < 4 || current_len >= n) {
          break;
        }
      }

      return len > n ? n : len;
    }
};
