import itertools


def solution(numbers):
    answer = ''
    # [priority, priority2, value]
    
    for i in range(len(numbers)):
        priority = int((str(numbers[i]) * 4)[:4])
        numbers[i] = [priority, str(numbers[i])]
    numbers.sort()
    # "1111111101011010001000"
    # "1111111101011010010000"

    for i in range(len(numbers)-1,-1,-1):
        if (answer == "0" and numbers[i][0] == 0):
            answer = "0"
        else:
            answer += numbers[i][1]
    return answer