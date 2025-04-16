def solution(n, results):
    answer = 0
    match = [[0 for i in range(n+1)] for i in range(n+1)]
    
    for [i,j] in results:
        match[i][j] = 1
        match[j][i] = -1

    
    for i in range(1,n+1):        
        for j in range(1,n+1):            
            if (match[i][j] == 0):
                for k in range(1,n+1):
                    if (match[i][k] * match[k][j] == 1):
                        match[i][j] = match[i][k]
                        match[j][i] = match[i][k] * -1
    for i in range(1,n+1):
        count = 0
        for j in range(1,n+1):
            if (i != j and match[i][j] != 0):
                count += 1
        if (count == n - 1):
            answer += 1
    
    
    return answer