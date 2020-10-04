import java.util.*;

/**
 * Created by XingyangChen on 10/15/16.
 */
public class ModFive {
    Iterator<Integer> it;
    int buffer;

    int next() throws Exception {
        if (!hasNext()) {
            throw new RuntimeException("No more element");
        }
        return buffer;
    }

    boolean hasNext() {
        while (it.hasNext()) {
            int n = it.next();
            if (n % 5 == 0) {
                buffer = 5;
                return true;
            }
        }
        return false;
    }

    void remove() {
        it.remove();
    }


}
