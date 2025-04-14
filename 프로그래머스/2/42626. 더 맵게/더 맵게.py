import heapq

def mix(a, b):
    return a + b * 2

def solution(scoville, K):
    answer = 0
    heapq.heapify(scoville)
    while (True):
        if (scoville[0] >= K):
            break
        if (len(scoville) == 1):
            answer = -1
            break
        a = heapq.heappop(scoville)
        b = heapq.heappop(scoville)
        heapq.heappush(scoville, mix(a,b))
        answer += 1
        
    return answer