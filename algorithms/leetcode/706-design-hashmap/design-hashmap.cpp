#include <vector>
using namespace std;

class MyHashMap {
private:
    struct Node {
        int key;
        int value;
        Node* next;
    };

    size_t TABLE_SIZE = 93;
    vector<Node*> t;

    size_t hash(int key) {
        return key % TABLE_SIZE;
    }
public:
    /** Initialize your data structure here. */
    MyHashMap(): t{TABLE_SIZE} {

    }

    /** value will always be non-negative. */
    void put(int key, int value) {
        int hk = hash(key);

        Node * head = t[hk];

        if (head == nullptr) {
            t[hk] = head = new Node;
            head->key = key;
            head->value = value;
            head->next = nullptr;
            return;
        }

        Node* new_node = new Node;
        new_node->key = key;
        new_node->value = value;
        new_node->next = nullptr;

        if (head->key == key) {
            new_node->next = head->next;
            delete head;
            t[hk] = new_node;
            return;
        }

        Node * node;
        for (node = head; node->next != nullptr; node = node->next) {
            if (node->next->key == key) {
                new_node->next = node->next->next;
                node->next = new_node;
                return;
            }
        }

        if (node->key != key) {
            node->next = new_node;
        }
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    int get(int key) {
        int hk = hash(key);

        Node * head = t[hk];

        for (Node * node = head; node; node = node->next) {
            if (node->key == key) {
                return node->value;
            }
        }

        return -1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    void remove(int key) {
        int hk = hash(key);

        Node * head = t[hk];

        if (head == nullptr) {
            return;
        }

        if (head->key == key) {
            delete t[hk];
            t[hk] = head->next;
            return;
        }

        for (Node * node = head; node->next != nullptr; node = node->next) {
            if (node->next->key == key) {
                Node * tmp = node->next;
                node->next = node->next->next;
                delete tmp;
                return;
            }
        }
    }
};

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
