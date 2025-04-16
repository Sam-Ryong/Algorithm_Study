def solution(m, n, puddles):
    answer = 0
    DP = [[-1 for i in range(m+1)] for i in range(n+1)]
    DP[1][1] = 1
    for i in range(m+1):
        DP[0][i] = 0
    for i in range(n+1):
        DP[i][0] = 0
    
    
    for puddle in puddles:
        DP[puddle[1]][puddle[0]] = 0
    
    for i in range(1,n+1):
        for j in range(1,m+1) :   
            if (DP[i][j] == -1):
                DP[i][j] = DP[i-1][j] + DP[i][j-1]
                
    return DP[n][m] % 1000000007