import heapq
import math

def solution(jobs):
    
    N = len(jobs)
    answer = []
    wait = []
    process = {"isProcessing": False, "start":0, "end":0}
    time = 0
    heapq.heapify(jobs)
    
    while True:
        while (len(jobs) > 0 and jobs[0][0] == time):
            job = heapq.heappop(jobs)
            heapq.heappush(wait, [job[1], job[0]])
        
        if process["isProcessing"] and process["end"] == time:
            answer.append(process["end"] - process["start"])
            process = {"isProcessing": False, "start":0, "end":0}
        
        if len(answer) == N:
            break
            
        if not process["isProcessing"]:       
            if (len(wait) > 0):
                p = heapq.heappop(wait)
                process = {"isProcessing": True, "start":p[1], "end": time + p[0]}
        time += 1
    
    return sum(answer) // len(answer)
            