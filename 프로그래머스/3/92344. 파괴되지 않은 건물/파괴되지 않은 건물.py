def solution(board, skill):
    count = 0
    matrix = [[0 for i in range(len(board[0]) + 1)]for i in range(len(board)+1)]
    
    for s in skill:
        t = s[0]
        r1 = s[1]
        c1 = s[2]
        r2 = s[3]
        c2 = s[4]
        d = s[5]
        if (t == 1):
            matrix[r1][c1] += -1 * d
            matrix[r2+1][c2+1] += -1 * d
            matrix[r1][c2+1] += d
            matrix[r2+1][c1] += d
        elif (t == 2): 
            matrix[r1][c1] += d
            matrix[r2+1][c2+1] += d
            matrix[r1][c2+1] += -1 * d
            matrix[r2+1][c1] += -1 * d
            
    for i in range(1,len(matrix)):
        for j in range(len(matrix[0])):
            matrix[i][j] += matrix[i-1][j]
    

    for i in range(len(matrix)):
        for j in range(1,len(matrix[0])):
            matrix[i][j] += matrix[i][j-1]
            
    for i in range(len(board)):
        for j in range(len(board[0])):
            board[i][j] += matrix[i][j]
            if (board[i][j] > 0):
                count+=1
            
    
    
    return count