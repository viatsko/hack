if __name__ == '__main__':
    scores = set()
    students = []
    for _ in range(int(input())):
        name = input()
        score = float(input())
        students.append((name, score))
        scores.add(score)

    scores.remove(min(scores))
    res = list(filter(lambda student: student[1] == min(scores), students))
    res.sort(key=lambda student: student[0])

    for student in res:
        print(student[0])
