import itertools

def solution(N, number):
    
    DP = [-1 for i in range(int(str(N)*8) + 1)]
    DP[N] = 1
    n = N
    for i in range(2,9):
        DP[int(str(n)*i)] = i
    mem = []
    mem.append([])
    mem.append([N])
    for i in range(2, 9):
        temp = [int(str(n)*i)]
        for j in range(1, i):
            for a in mem[j]:
                for b in mem[i-j]:
                    temp.append(a+b)
                    temp.append(a-b)
                    temp.append(a*b)
                    temp.append(a//b)
                    temp.append(b-a)
                    temp.append(a//b)
        for j in range(len(temp)-1,0, -1):
            if (temp[j] <= 0 or temp[j] > int(str(N)*8)):
                del temp[j]
            else:
                if (DP[temp[j]] == -1):
                    DP[temp[j]] = i
                else:
                    del temp[j]
        mem.append(temp)
                    
        
    
    return DP[number]