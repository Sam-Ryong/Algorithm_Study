max_plus = 0
max_price = 0

def solution(users, emoticons):
    answer = []
    
                
    def dfs(num, discount):
        global max_plus, max_price
        if (num == len(emoticons)):
            total = [0 for i in range(len(users))]
            plus = 0
            price = 0
            for i in range(len(users)):
                for j in range(len(discount)):
                    if (users[i][0] <= discount[j]):
                        total[i] += emoticons[j] * (100 - discount[j]) // 100
            for i in range(len(total)):
                if (total[i] >= users[i][1]):
                    plus += 1
                else:
                    price += total[i]
                
            if (max_plus < plus):
                max_plus = plus
                max_price = price
            elif (max_plus == plus):
                if (max_price < price):
                    max_price = price
            return
        
        for i in [10,20,30,40]:
            discount[num] = i
            dfs(num+1,discount[:])
    
    dfs(0,[0 for i in range(len(emoticons))])
        
                
    return [max_plus,max_price]