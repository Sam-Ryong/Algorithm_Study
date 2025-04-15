def bfs(n, edge):
    now = [1]
    visit = [0 for i in range(n+1)]
    temp = []
    visit[1] = 1
    while True:
        for start in now:
            for i in edge[start]:
                if (visit[i] == 0):
                    temp.append(i)
                    visit[i] = 1
        if (len(temp) == 0):
            break
        now = temp[:]
        temp = []
        
    return len(now)
        

def solution(n, vertex):
    answer = 0
    
    edge = dict()
    for i in range(1,n+1):
        edge[i] = []
        
    for [a,b] in vertex:
        edge[a].append(b)
        edge[b].append(a)
    
    return bfs(n,edge)