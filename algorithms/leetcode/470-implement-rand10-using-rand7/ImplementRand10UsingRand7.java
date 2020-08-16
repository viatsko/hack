/**
 * The rand7() API is already defined in the parent class SolBase.
 * public int rand7();
 * @return a random integer in the range 1 to 7
 */
class Solution extends SolBase {
    public int rand10() {
        int result;
        
        do {
            result = 7 * (rand7() - 1) + (rand7() - 1);
        } while (result >= 40);
        
        return result % 10 + 1;
    }
}
