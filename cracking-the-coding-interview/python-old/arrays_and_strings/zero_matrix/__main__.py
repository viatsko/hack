from random import randint


def zerofy(matrix):
    rows = {}
    columns = {}

    n = len(matrix)
    m = len(matrix[0])

    for i in range(n):
        for j in range(m):
            if matrix[i][j] == 0:
                rows[i] = True
                columns[j] = True

    for row in rows.keys():
        for j in range(m):
            matrix[row][j] = 0

    for column in columns.keys():
        for i in range(n):
            matrix[i][column] = 0


def print_matrix(matrix):
    for line in range(len(matrix)):
        for c in matrix[line]:
            print(c, end=' ')
        print()


def main():
    print('For this task, we are generating random matrix')

    n = randint(1, 10)

    matrix = []

    for i in range(n):
        sm = []

        for j in range(n):
            sm.append(randint(0, 5))

        matrix.append(sm)

    print('Before')
    print_matrix(matrix)

    zerofy(matrix)

    print('After')
    print_matrix(matrix)


if __name__ == '__main__':
    main()
