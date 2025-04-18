import math
import heapq

def solution(n, costs):
    answer = 0
    
    edge = [[0 for i in range(n)] for i in range(n)]
    
    for cost in costs:
        edge[cost[0]][cost[1]] = cost[2]
        edge[cost[1]][cost[0]] = cost[2]
    
    Q = []
    now = 0
    union = [i for i in range(n)]
    cost = 0
    for i in range(n - 1):        
        for j in range(n):
            if edge[now][j] != 0:
                if (union[j] != 0):
                    heapq.heappush(Q, [edge[now][j], now, j])
        select = []
        while len(Q) > 0:    
            select = heapq.heappop(Q)         
            if (union[select[2]] != 0):
                break    
        cost += select[0]
        now = select[2]
        union[now] = 0
        
    return cost