X = int(raw_input())
Y = int(raw_input())
Z = int(raw_input())
N = int(raw_input())

cuboid = []

results = [cuboid.append([x, y, z]) for x in range(X+1) for y in range(Y+1) for z in range(Z+1) if x + y + z != N]

print cuboid
