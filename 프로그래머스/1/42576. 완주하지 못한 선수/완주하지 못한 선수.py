def solution(participant, completion):
    answer = ''
    all = dict()
    for name in set(participant):
        all[name] = 0
    for i in range(len(participant)):
        all[participant[i]] += 1

    for name in completion:
        all[name] -= 1
    for name in participant:
        if (all[name] != 0):
            answer = name
            break
    return answer