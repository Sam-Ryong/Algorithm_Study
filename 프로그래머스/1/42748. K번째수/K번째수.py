def solution(array, commands):
    answer = []
    for cmd in commands:
        i = cmd[0]
        j = cmd[1]
        k = cmd[2]
        l = array[i-1:j]
        l.sort()
        answer.append(l[k-1])
    return answer