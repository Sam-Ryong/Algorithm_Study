def solution(players, m, k):
    servers = []
    scale_count = 0
    for i in range(24):
        delete = []
        if ((players[i] // m) > len(servers)):
            for i in range(players[i] // m - len(servers)):
                servers.append(k)
                scale_count += 1
        for i in range(len(servers)):
            servers[i] -= 1
            if (servers[i] == 0):
                delete.insert(0,i)
        for num in delete:
            del servers[num]
            
    return scale_count