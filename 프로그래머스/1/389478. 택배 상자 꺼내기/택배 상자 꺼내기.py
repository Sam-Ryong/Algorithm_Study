N = 0
W = 0
Find = 0

    

def solution(n, w, find):
    global N, W, Find
    N = n
    W = w
    Find = find
    
    boxs = [[0 for i in range(w)] for i in range(n//w + 1)]
    
    x, y = 0, 0
    X, Y = 0, 0
    direction = 1
    for i in range(1,n+1):
        boxs[y][x] = i
        if (i == find):
            X = x
            Y = y
        x += direction
        if (x == -1 or x == w):
            x -= direction
            y += 1
            direction = direction * (-1)
    answer = 0
    for i in range(Y, n//w + 1):
        if (boxs[i][X] > 0):
            answer += 1

    return answer