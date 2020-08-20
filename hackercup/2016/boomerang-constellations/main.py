T = int(raw_input().strip())

for t in xrange(T):
    N = int(raw_input().strip())

    stars = []

    solutions = {}

    matches = 0

    for n in xrange(N):
        x, y = map(int, raw_input().strip().split())
        stars.append((x, y))

    #stars = sorted(stars, key=lambda x: (x[0], x[1]))

    for i in xrange(len(stars)):
        p1 = stars[i]

        for j in xrange(i + 1, len(stars)):
            p2 = stars[j]

            s1 = (p2[0] - p1[0]) ** 2 + (p2[1] - p1[1]) ** 2

            if s1 not in solutions:
                solutions[s1] = []

            solutions[s1].append((p1, p2))

    for coords in solutions.itervalues():
        if len(coords) > 1:
            cd = {}

            for coord in coords:
                if coord[0] not in cd:
                    cd[coord[0]] = [coord]
                else:
                    cd[coord[0]].append(coord)

                if coord[1] not in cd:
                    cd[coord[1]] = [coord]
                else:
                    cd[coord[1]].append(coord)

            for i in xrange(len(coords)):
                if coords[i][0] in cd:
                    matches += len(cd[coords[i][0]]) - 1
                if coords[i][1] in cd:
                    matches += len(cd[coords[i][1]]) - 1

    print 'Case #' + str(t + 1) + ': ' + str(matches // 2)
