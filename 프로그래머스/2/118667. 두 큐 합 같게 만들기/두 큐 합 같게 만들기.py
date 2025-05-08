from collections import deque

def solution(queue1, queue2):
    target = (sum(queue1) + sum(queue2))
    count = 0
    queue1 = deque(queue1)
    queue2 = deque(queue2)
    
    if (target % 2 == 1):
        return -1
    sum1 = sum(queue1)
    sum2 = sum(queue2)
    while True:
        
        if (sum1 > target // 2):
            count += 1
            a = queue1.popleft()
            sum1 -= a
            sum2 += a
            queue2.append(a)
        elif (sum1 < target // 2):
            count += 1
            a = queue2.popleft()
            sum1 += a
            sum2 -= a
            queue1.append(a)
        else:
            break
        
        if (count == 1000000):
            count = -1
            break
        
        if (len(queue1) == 0 or len(queue2) == 0):
            count = -1
            break

            
    
    return count