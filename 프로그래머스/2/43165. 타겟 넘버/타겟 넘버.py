answer = 0

def dfs(numbers, now,result, target):
    global answer
    
    if (now == len(numbers) - 1):
        if(result == target):
            answer += 1
        return
    
    dfs(numbers, now + 1, result + numbers[now], target)
    dfs(numbers, now + 1, result - numbers[now], target)
        
def solution(numbers, target):
    global answer
    dfs(numbers,-1,0, target)
    
    return answer