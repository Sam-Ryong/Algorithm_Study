

    
def solution(answers):
    answer = []
    a = [1,2,3,4,5]
    b = [2,1,2,3,2,4,2,5]
    c = [3,3,1,1,2,2,4,4,5,5]
    A = 0
    B = 0
    C = 0
    
    for i in range(len(answers)):
        if (a[i%5] == answers[i]):
            A += 1
        if (b[i%8] == answers[i]):
            B += 1
        if (c[i%10] == answers[i]):
            C += 1
        
    cut = max(A,B,C)
    result = [A,B,C]
    for i in range(3):
        if (result[i] == cut):
            answer.append(i+1)
            
    return answer