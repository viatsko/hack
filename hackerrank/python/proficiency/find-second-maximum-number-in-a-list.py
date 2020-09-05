if __name__ == '__main__':
    n = int(input())
    arr = map(int, input().split())
    scores = set(arr)
    scores.remove(max(scores))
    print(max(scores))
