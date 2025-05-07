def solution(cap, n, deliveries, pickups):
    answer = 0
    distance = 0
    dp = -1
    pp = -1
    
    for i in range(n-1,-1,-1):
        if (deliveries[i] > 0):
            dp = i
            break
    for i in range(n-1,-1,-1):
        if (pickups[i] > 0):
            pp = i
            break
    
    answer += max([dp+1,pp+1,0]) * 2
    
    while (dp > -1 or pp > -1):
        truck = cap
        
        while dp > -1:
            
            if (truck - deliveries[dp] >= 0):
                truck = truck - deliveries[dp]
                deliveries[dp] = 0
                dp -= 1
            else:
                deliveries[dp] -= truck
                truck = 0
                break
        truck = cap
        while pp > -1:      
            if (truck - pickups[pp] >= 0):
                truck = truck - pickups[pp]
                pickups[pp] = 0
                pp -= 1
            else:
                pickups[pp] -= truck
                truck = 0
                break

        answer += max([dp+1,pp+1,0]) * 2
        
            
        
    return answer