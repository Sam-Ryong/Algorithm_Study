def solution(n, k):
    answer = 0
    
    def convert(n, k):
        result = ""
        a = n % k
        b = n // k
        while b >= 0:
            result = result + str(a)
            n = b
            a = n % k
            b = n // k
            if (n == 0):
                break
    
        return result[::-1] 

    def isPrime(n):
        result = True
        if (n == 1):
            return False
        for i in range(2, int(n ** 0.5) + 1):
            if (n % i == 0):
                result = False
                break
        return result
    
    kNum = convert(n,k)
    a = 0
    b = 0
    x = kNum.split("0")
    for num in x:
        if (num == ""):
            continue
        if (isPrime(int(num))):    
            answer += 1

    return answer