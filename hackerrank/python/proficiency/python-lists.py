if __name__ == '__main__':
    N = int(input())
    arr = []
    for i in range(N):
        line = input().split()
        command = line[0]
        if len(line) > 1:
            x = int(line[1])
        if len(line) > 2:
            y = int(line[2])
        if command == 'insert':
            arr.insert(x, y)
        elif command == 'print':
            print(arr)
        elif command == 'remove':
            arr.remove(x)
        elif command == 'append':
            arr.append(x)
        elif command == 'sort':
            arr.sort()
        elif command == 'pop':
            arr.pop()
        elif command == 'reverse':
            arr.reverse()
