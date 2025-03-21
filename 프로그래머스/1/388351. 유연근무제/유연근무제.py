def isLate(arriveTime, deadline):
    Dminiute = deadline % 100 + 10
    Dhour = deadline // 100
    
    if (Dminiute >= 60):
        Dminiute = Dminiute % 60
        Dhour = Dhour + 1
    
    return (Dhour * 100 + Dminiute) < arriveTime

def solution(schedules, timelogs, startday):
    answer = 0

    for i in range(len(schedules)):
        time = schedules[i]
        
        isPass = 1
        for j in range(7):
            if (((startday + j - 1) % 7) >= 5):
                continue
            if (isLate(timelogs[i][j], time)):
                isPass = 0
                break;
                
        answer += isPass
    return answer