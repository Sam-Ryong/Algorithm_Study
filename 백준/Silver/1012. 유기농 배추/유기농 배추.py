import sys

sys.setrecursionlimit(10000)

T = int(input())

tests = []

def spread(t,x,y,c):
    global tests
    farm = tests[t]
    
    if x < 0 or x > len(farm) - 1:
        return
    
    if y < 0 or y > len(farm[0]) - 1:
        return

    if farm[x][y] == 1:
        farm[x][y] = c
        spread(t,x-1,y,c)
        spread(t,x+1,y,c)
        spread(t,x,y-1,c)
        spread(t,x,y+1,c)


for ind in range(T):
    M, N ,K = map(int,input().split(" "))
    farm = [[0 for i in range(M)] for i in range(N)]
    for i in range(K):
        x,y = map(int,input().split(" "))
        farm[y][x] = 1
    tests.append(farm)

for t in range(T):
    farm = tests[t]
    count = 0
    for i in range(len(farm)):
        for j in range(len(farm[i])):
            if farm[i][j] == 1:
                count = count - 1
                spread(t,i,j,count)
    print(count * -1)