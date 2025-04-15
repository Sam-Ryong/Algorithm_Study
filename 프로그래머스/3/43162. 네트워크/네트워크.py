def bfs(start, computers, network):
    temp = []
    now = []
    now.append(start)
    changed = False
    while len(now) > 0:
        for num in now:
            for i in range(len(computers[num])):
                if (computers[num][i] == 1):
                    computers[num][i] = network
                    computers[i][num] = network
                    changed = True
                    temp.append(i)
        now = []
        now = temp[:]
        temp = []
    return changed

def solution(n, computers):
    answer = 0
    network_num = 2
    for i in range(n):
        if (bfs(i,computers,network_num)):
            network_num += 1
    
    return network_num - 2