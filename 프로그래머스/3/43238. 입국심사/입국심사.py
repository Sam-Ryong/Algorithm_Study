import sys

def binSearch(low, high, val, times):   
    mid = (low + high) // 2
    while high > low:
        
        count = 0
        for t in times:
            count += mid // t
            
        if (count < val):
            low = mid + 1
        else:
            high = mid
        mid = (low + high) // 2
    return (low + high) // 2


def solution(n, times):
    answer = 0
    times.sort()
    return binSearch(0, sys.maxsize, n, times)