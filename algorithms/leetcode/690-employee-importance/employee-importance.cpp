class Solution {
private:
    int sum(unordered_map<int, Employee*> &m, int id) {
        int result = m[id]->importance;

        for (auto employee: m[id]->subordinates) {
            result += sum(m, employee);
        }

        return result;
    }

public:
    int getImportance(vector<Employee*> employees, int id) {
        unordered_map<int, Employee*> m;

        for (auto employee: employees) {
            m[employee->id] = employee;
        }

        return sum(m, id);
    }
};
