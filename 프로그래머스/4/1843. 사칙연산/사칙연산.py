import math

def solution(arr):
    answer = -1
    
    DP = [[0 for i in range(len(arr) // 2 + 1)] for i in range(len(arr) // 2 + 1)]
    DP2 = [[0 for i in range(len(arr) // 2 + 1)] for i in range(len(arr) // 2 + 1)]
    
    for i in range(len(arr) // 2 + 1):
        arr[i*2] = int(arr[i*2])
        DP[i][i] = arr[i*2]
        DP2[i][i] = arr[i*2]

    for i in range(1, len(arr) // 2 + 1):
        for j in range(len(arr) // 2 + 1 - i):
            memory = -math.inf
            memory2 = math.inf
            for k in range(i):
                num1 = DP[j][j+k]
                num2 = DP[j+k+1][j+i]
                num3 = DP2[j][j+k]
                num4 = DP2[j+k+1][j+i]
                op = arr[j+k+j+k+1]
                result = 0
                if (op == "-"):
                    memory = max(memory,num1 - num2, num1 - num4, num3 - num2, num3 - num4)
                    memory2 = min(memory2,num1 - num2, num1 - num4, num3 - num2, num3 - num4)
                elif (op == "+"):
                    memory = max(memory,num1 + num2, num1 + num4, num3 + num2, num3 + num4)
                    memory2 = min(memory2,num1 + num2, num1 + num4, num3 + num2, num3 + num4)
            DP[j][j + i] = memory
            DP2[j][j + i] = memory2
    
    # for i in range(len(DP)):
    #     for j in range(len(DP)):
    #         print(DP[i][j], end = " ")
    #     print()
    # print()
    # for i in range(len(DP)):
    #     for j in range(len(DP)):
    #         print(DP2[i][j], end = " ")
    #     print()
    return max(DP[0][-1], DP2[0][-1])