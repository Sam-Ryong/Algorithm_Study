DP = []

def printDP():
    for i in range(len(DP)):
        for elem in DP[i]:
            print(elem, end = " ")
        print()

def solution(info, n, m):
    global DP
    DP = [[0 for i in range(m+1)] for i in range(len(info)+1)]
    for i in range(1, len(info)+1):
        DP[i][0] = DP[i-1][0] + info[i-1][0]
    for i in range(1,len(info)+1):
        for j in range(1,m+1):
            DP[i][j] = DP[i-1][j] + info[i-1][0]
            if (info[i-1][1] < j):
                DP[i][j] = min(DP[i][j], DP[i-1][j-info[i-1][1]])
    
    printDP()
    
    if DP[len(info)][m] >= n:
        return -1
    
    return DP[len(info)][m]
    
    
            