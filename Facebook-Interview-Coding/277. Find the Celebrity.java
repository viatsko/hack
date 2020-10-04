277. Find the Celebrity

public int findCelebrity(int n) {
    int candidate = 0;
    for (int i = 1; i < n; i++) 
        if (knows(candidate, i))    candidate = i;
    for (int i = 0; i < n; i++) {
        if (i < candidate && (!knows(i, candidate) || knows(candidate, i)))  return -1;
        if (i > candidate && !knows(i, candidate))  return -1;
    }
    return candidate;
}

// The first loop is to find the candidate as the author explains. In detail, suppose the candidate after the first for loop is person k, 
// it means 0 to k-1 cannot be the celebrity, because they know a previous or current candidate. Also, 
// since k knows no one between k+1 and n-1, k+1 to n-1 can not be the celebrity either. Therefore, 
// k is the only possible celebrity, if there exists one.


