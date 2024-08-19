N = int(input())

digit = 1
result = []
size = [[1,1,1,1,1,1,1,1,1,1]]
num = -1

def makeTable():
    global digit
    global result
    global size
    total = 0
    nextSize = []
    for i in range(digit ):
        nextSize.append(0)
    for i in range(digit , 10):
        nextSize.append(sum(size[-1][:i]))
    size.append(nextSize)
    digit = digit + 1
    if (digit == 10):
        return
    makeTable()

def find(a,b):
    global size
    global result
    num = 0
    
    if (a < 0):
        return
    for i in range(10):
        b = b - size[a][i]
        if (b < 0):
            b = b + size[a][i]
            num = i
            break
    result.append(num)
    a = a - 1
    find(a,b)

makeTable()

tog = False
for i in range(10):
    for j in range(10):
        N = N - size[i][j]
        if (N < 0):
            N = N + size[i][j]
            where = i
            num = j
            tog = True
            break
    if (tog):
        break

result.append(num)
if (num != -1):
    find(where-1,N)

answer = ""

for num in result:
    answer = answer + str(num)

print(int(answer))