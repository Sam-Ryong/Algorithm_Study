def parseTime(s):
    mm,ss = s.split(":")
    return int(mm) * 60 + int(ss)

def calcFee(time, fees):
    기본시간 = fees[0]
    기본요금 = fees[1]
    단위시간 = fees[2]
    단위요금 = fees[3]
    if (time <= 기본시간):
        return 기본요금
    else:
        요금 = 기본요금
        추가시간 = (time - 기본시간) // 단위시간
        if ((time - 기본시간) % 단위시간 != 0):
            추가시간 += 1
        요금 += 추가시간 * 단위요금
        return 요금
    
def solution(fees, records):
    answer = []
    
    
    parking = dict()
    r = dict()
    
    for re in records:
        time, num, t = re.split(" ")
        if (t == "IN"):
            parking[num] = parseTime(time)
        else:
            if (r.get(num) == None):
                r[num] = parseTime(time) - parking[num]
            else:
                r[num] += parseTime(time) - parking[num]
            parking[num] = -1

    for ta in parking:
        if parking[ta] != -1:
            if (r.get(ta) == None):
                r[ta] = 23*60 + 59 - parking[ta]
            else:
                r[ta] += 23*60 + 59 - parking[ta]
    result = []
    for s in r:
        result.append([s,calcFee(r[s],fees)])
    result.sort()
    for i in result:
        answer.append(i[1])
    return answer