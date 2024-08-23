N = input()
limits = sorted(list(map(int, input().split())), reverse=True)
M = input()
weights = sorted(list(map(int, input().split())), reverse=True)
time = 0

if limits[0] < weights[0]:
    print(-1)

else:
    while (True):
        for i in range(len(limits)):
            for j in range(len(weights)):
                if (limits[i] >= weights[j]):
                    weights.pop(j)
                    break
        time = time + 1 
        if (len(weights) == 0):
            break

    print(time)


