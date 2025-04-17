def spread(i,j,land,offset):
    
    count = 0
    now = [[i,j]]
    temp = []
    while len(now) > 0:
        for [x,y] in now:
            if (x >= 0 and x < len(land)) and (y >= 0 and y < len(land[0])):
                if (land[x][y] == 1):
                    land[x][y] = offset
                    count += 1
                    temp.append([x-1,y])
                    temp.append([x+1,y])
                    temp.append([x,y-1])
                    temp.append([x,y+1])
        now = []
        now = temp[:]
        temp = []
    
    return count
    
            
            

def solution(land):
    answer = 0
    offsets = dict()
    offset = -1

    for i in range(len(land)):
        for j in range(len(land[0])):
            if (land[i][j] == 1):
                offsets[offset] = spread(i,j,land,offset)
                offset -= 1
    for j in range(len(land[0])):
        contains = set()
        for i in range(len(land)):
            if (land[i][j] != 0):
                contains.add(land[i][j])
        maximum = 0
        for offset in contains:
            maximum += offsets[offset]
        if (maximum > answer):
            answer = maximum

    return answer