138. Copy List with Random Pointer

Solution 1: hashmap + 2 iteration
第一遍deep copy每个node并存hashmap，第二遍根据hashmap来deep copy random指针（注意条件：cur.random != null）

public RandomListNode copyRandomList(RandomListNode head) {
    RandomListNode dummy = new RandomListNode(0), cur = dummy;
    Map<RandomListNode, RandomListNode> map = new HashMap<>();
    while (head != null) { 
        RandomListNode newNode = new RandomListNode(head.label);
        map.put(head, newNode);
        newNode.random = head.random;
        cur.next = newNode;
        cur = cur.next;
        head = head.next;
    }
    cur = dummy.next;
    while (cur != null) {
        if (cur.random != null)
            cur.random = map.get(cur.random);
        cur = cur.next;
    }
    return dummy.next;
}


Solution 2: hashmap + 1 iteration

public RandomListNode copyRandomList(RandomListNode head) {
    RandomListNode dummy = new RandomListNode(0), cur = dummy;
    Map<RandomListNode, RandomListNode> map = new HashMap<>();
    while (head != null) {
        RandomListNode newNode = null;
        if (map.containsKey(head))
            newNode = map.get(head);
        else {
            newNode = new RandomListNode(head.label);
            map.put(head, newNode);
        }
        if (head.random != null) // ATTENTION
            if (map.containsKey(head.random))
                newNode.random = map.get(head.random);
            else {
                newNode.random = new RandomListNode(head.random.label);
                map.put(head.random, newNode.random);
            }
        cur.next = newNode;
        cur = cur.next;
        head = head.next;
    }
    return dummy.next;
}


Solution 3: copy -> random -> split 
Space： O(1)

public RandomListNode copyRandomList(RandomListNode head) {
    if (head == null) return null;
    RandomListNode cur = head;
    while (cur != null) {
        RandomListNode newNode = new RandomListNode(cur.label);
        newNode.next = cur.next;
        cur.next = newNode;
        cur = cur.next.next;
    }
    cur = head;
    while (cur != null) {
        if (cur.random != null)
            cur.next.random = cur.random.next;
        cur = cur.next.next;
    }
    cur = head;
    RandomListNode newHead = head.next;
    while (cur != null) {
        RandomListNode newNode = cur.next;
        cur.next = newNode.next;
        cur = cur.next;
        if (cur != null)    newNode.next = cur.next;
    }
    return newHead;
}
