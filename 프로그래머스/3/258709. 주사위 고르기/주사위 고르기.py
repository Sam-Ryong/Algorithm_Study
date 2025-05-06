import itertools

def solution(dice):
    answer = []
    cases = itertools.combinations(range(1,len(dice)+1),len(dice) // 2)
    best_prob = 0
    best_set = []
    for case in cases:
        memory = [0]
        temp = []
        for num in case:
            for n in dice[num-1]:
                for k in memory:
                    temp.append(k+n)
            memory = temp[:]
            temp = []
            
        memory2 = [0]
        temp2 = []
        case2 = []
        for i in range(1,len(dice)+1):
            if (i not in case):
                case2.append(i)
        for num in case2:
            for n in dice[num-1]:
                for k in memory2:
                    temp2.append(k+n)
            memory2 = temp2[:]
            temp2 = []
        win = 0
        me = dict()
        you = dict()
        for i in range(len(memory)):
            if (me.get(memory[i]) == None):
                me[memory[i]] = 1
            else:
                me[memory[i]] += 1
        for i in range(len(memory)):
            if (you.get(memory2[i]) == None):
                you[memory2[i]] = 1
            else:
                you[memory2[i]] += 1
                
        for a in me:
            for b in you:
                if (a > b):
                    win += me[a] * you[b]

        if (win > best_prob):
            best_set = case[:]
            best_prob = win
            
            
    return best_set