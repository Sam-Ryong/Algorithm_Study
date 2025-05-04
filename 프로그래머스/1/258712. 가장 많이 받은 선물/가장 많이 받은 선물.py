def solution(friends, gifts):
    answer = 0
    d = dict()
    history = [[0 for i in range(len(friends))] for i in range(len(friends))]
    expect = [0 for i in range(len(friends))]
    for i in range(len(friends)):
        d[friends[i]] = i
    for s in gifts:
        a, b = s.split(" ")
        history[d[a]][d[b]] += 1
    for i in range(len(friends)-1):
        for j in range(i+1, len(friends)):
            if (history[i][j] > history[j][i]):
                expect[i] += 1
            elif (history[i][j] < history[j][i]):
                expect[j] += 1
            else:
                numI = sum(history[i])
                numJ = sum(history[j])
                for k in range(len(friends)):
                    numI -= history[k][i]
                    numJ -= history[k][j]
                if numI < numJ:
                    expect[j] += 1
                elif numJ < numI:
                    expect[i] += 1
                
    return max(expect)