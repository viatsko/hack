public class DesignCompressedStringIterator {
    static class StringIterator {
        String string;
        char currentChar = ' ';
        int currentIndex = 0;
        int maxLen = 0;
        int count = 0;

        private void checkAndMove() {
            if (count > 0) {
                return;
            }

            if (currentIndex < maxLen) {
                currentChar = string.charAt(currentIndex++);

                StringBuilder numberSB = new StringBuilder();

                char nch = string.charAt(currentIndex);

                while (currentIndex < maxLen && nch >= '0' && nch <= '9') {
                    numberSB.append(nch);

                    currentIndex++;

                    if (currentIndex < maxLen) {
                        nch = string.charAt(currentIndex);
                    }
                }

                count = Integer.parseInt(numberSB.toString());
            } else {
                currentChar = ' ';
            }
        }

        public StringIterator(String compressedString) {
            this.string = compressedString;
            this.maxLen = this.string.length();
        }

        public char next() {
            checkAndMove();

            count--;

            return currentChar;
        }

        public boolean hasNext() {
            checkAndMove();

            return count > 0;
        }
    }

    public static void main(String[] args) {
        StringIterator stringIterator = new StringIterator("L1e2t1C1o1d1e1");

        System.out.println(stringIterator.next());
        System.out.println(stringIterator.next());
        System.out.println(stringIterator.next());
        System.out.println(stringIterator.next());
        System.out.println(stringIterator.next());
        System.out.println(stringIterator.next());

        System.out.println(stringIterator.hasNext());
        System.out.println(stringIterator.next());
        System.out.println(stringIterator.hasNext());
    }
}
