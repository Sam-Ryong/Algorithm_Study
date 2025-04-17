def solution(points, routes):
    answer = 0
    

    field = [[[] for i in range(101)] for j in range(101)]
    robots = []
    
    for route in routes:
        start = route[0]
        dest = route[-1]
        robot = {
            "start" : points[start-1][:], 
            "end" : points[route[1]-1][:], 
            "pos" : points[start-1][:],
            "dest" : points[dest-1][:],
            "visit" : route[2:]
        }
        
        robots.append(robot)


    while len(robots) > 0:

        arrive = []
        collision = []
        for i in range(len(robots)):
            robot = robots[i]
            pos = robot["pos"]
            start = robot["start"]
            end = robot["end"]
            dest = robot["dest"]
            visit = robot["visit"]
            
            if (len(field[pos[0]][pos[1]]) == 1):
                collision.append(pos[:])
            field[pos[0]][pos[1]].append(robot)
            
            if (pos[0] == end[0] and pos[1] == end[1] and len(visit) == 0):
                arrive.append(i)
                           
            else:
                if (pos[0] == end[0] and pos[1] == end[1]): 
                    
                    end[0] = points[visit[0]-1][0]
                    end[1] = points[visit[0]-1][1]
                    del visit[0]
                                   
                dr = 0
                dc = 0
                if (end[0] > pos[0]):
                    dr = 1
                elif (end[0] < pos[0]):
                    dr = -1
                if (end[1] > pos[1]):
                    dc = 1
                elif (end[1] < pos[1]):
                    dc = -1
                if (pos[0] == end[0]):
                    pos[1] += dc
                else:
                    pos[0] += dr
                
                
        answer += len(collision)
        
        for robot in robots:
            field[robot["pos"][0]][robot["pos"][1]] = []
        
        for i in range(len(arrive)-1, -1, -1):
            arr = arrive[i]
            del robots[arr]
        
        
            
    return answer