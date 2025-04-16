def parseTime(time):
    mm = time[0]+time[1]
    ss = time[3]+time[4]
    
    return (int(mm), int(ss))

def isOpening(time, opStart, opEnd):
    (mm,ss) = parseTime(time)
    (osm,oss) = parseTime(opStart)
    (oem,oes) = parseTime(opEnd)
    result = False

    pos = mm * 100 + ss
    op_start = osm * 100 + oss
    op_end = oem * 100 + oes
    if (pos >= op_start and pos <= op_end):
        return True
    else:
        return False
    
def next(time, endTime):
    (mm,ss) = parseTime(time)
    (MM,SS) = parseTime(endTime)
    
    if (ss >= 50):
        ss = (ss + 10) % 60
        mm += 1
    else:
        ss = (ss + 10) % 60
    
    if (mm == MM and ss >= SS):
        return endTime
    if (mm > MM):
        return endTime
    
    ss = str(ss)
    mm = str(mm)
    if (len(ss) == 1):
        ss = "0"+ss
    if (len(mm) == 1):
        mm = "0"+mm
    
    return mm + ":" + ss

def prev(time):
    (mm,ss) = parseTime(time)
    if (mm == 0 and ss < 10):
        return "00:00"
    if (ss < 10):
        ss = (ss - 10) % 60
        mm -= 1
    else:
        ss = (ss - 10) % 60
    
    ss = str(ss)
    mm = str(mm)
    if (len(ss) == 1):
        ss = "0"+ss
    if (len(mm) == 1):
        mm = "0"+mm
    return mm + ":" + ss
    

def solution(video_len, pos, op_start, op_end, commands):
    answer = ''
    if (isOpening(pos, op_start, op_end)):
        pos = op_end
    for cmd in commands:
        if (isOpening(pos, op_start, op_end)):
            pos = op_end
        if (cmd == "next"):
            pos = next(pos, video_len)
        elif (cmd == "prev"):
            pos = prev(pos)
    if (isOpening(pos, op_start, op_end)):
        pos = op_end
            
    return pos