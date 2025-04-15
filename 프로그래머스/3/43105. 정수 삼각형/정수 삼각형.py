def solution(triangle):
    answer = 0
    DP = []
    for i in range(len(triangle)):
        DP.append([])
        for j in range(len(triangle[len(triangle) - i - 1])):
            DP[i].append(0)
    DP[0] = triangle[-1]
    for i in range(1,len(DP)):
        for j in range(len(DP[i])):
            DP[i][j] = max(DP[i-1][j], DP[i-1][j+1])  + triangle[len(DP) - i - 1][j]
                
    return DP[-1][-1]