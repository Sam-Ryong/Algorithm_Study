import heapq

def solution(progresses, speeds):
    answer = []
    deploy = []
    heapq.heapify(deploy)
    seq = 0
    while seq < len(speeds):
        count = 0
        for i in range(len(speeds)):
            if (progresses[i] > 0):
                progresses[i] += speeds[i]
            if (progresses[i] >= 100):
                progresses[i] = -1
                heapq.heappush(deploy, i)

        while (len(deploy) > 0 and deploy[0] == seq):
            seq += 1
            count += 1
            heapq.heappop(deploy)
        if (count > 0):
            answer.append(count)
                
                
    return answer