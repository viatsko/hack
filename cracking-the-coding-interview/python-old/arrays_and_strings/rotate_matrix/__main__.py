from random import randint


def rotate90(matrix):
    sz = len(matrix)

    rm = [[0 for x in range(sz)] for x in range(sz)]

    for i in range(sz):
        for j in range(sz):
            rm[sz - j - 1][i] = matrix[i][j]

    return rm


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
            sm.append(randint(1, 100))

        matrix.append(sm)

    print('Before')
    print_matrix(matrix)

    print('After')
    print_matrix(rotate90(matrix))


if __name__ == '__main__':
    main()
