def howManyTime(diffs, times, limit, level):
    result = 0
    prevSolve = 0
    for i in range(len(diffs)):
        diff = diffs[i]
        time = times[i]
        if (level >= diff):
            result += time
            prevSolve = time
        else:          
            result += (prevSolve + time) * (diff - level) 
            result += time
            prevSolve = time
            
    return result
# 0 1 2 3 4 5 6 7 8 9 10
# 1 2 2 3 3 3 3 4 5 6 7
        

def solution(diffs, times, limit):
    answer = 0
    low = 1
    high = 100001
    while low < high:
        mid = (low + high) // 2
        result = howManyTime(diffs,times,limit,mid)
        if (result <= limit):
            high = mid
        else:
            low = mid + 1
    answer = (low + high) // 2
    
    return answer