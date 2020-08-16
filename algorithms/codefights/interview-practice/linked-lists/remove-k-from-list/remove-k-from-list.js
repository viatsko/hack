function removeKFromList(l, k) {
    while (l && l.value === k) {
        l = l.next;
    }

    return l;
}
