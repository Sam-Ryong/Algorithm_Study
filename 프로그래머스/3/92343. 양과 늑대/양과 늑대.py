def solution(info, edges):
    answer = 0
    child = [[]for i in range(len(info))]
    
    for edge in edges:
        child[edge[0]].append(edge[1])
    
    now = [[0]]
    max_sheep = 0
    while True:
        temp = []
        for seq in now:
            wolf = 0
            sheep = 0
            for a in seq:
                if info[a] == 0:
                    sheep += 1
                else:
                    wolf += 1
            for a in seq:
                for c in child[a]:
                    if (not (c in seq) and (wolf + info[c] != sheep)):
                        temp.append(seq[:]+[c])
                        # if (sheep > max_sheep):
                        #     max_sheep = sheep
                
        if (len(temp) == 0):
            break
        now = temp[:]
        
    for i in now:
        total = 0
        for j in i:
            if info[j] == 0:
                total += 1
        if (max_sheep < total):
            max_sheep = total
                
    
    return max_sheep