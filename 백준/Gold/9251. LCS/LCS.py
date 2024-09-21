first = input()
second = input()

DP = [[0 for i in range(len(first) + 1)] for i in range(len(second) + 1)]

for i in range(1,len(DP)):
    for j in range(1,len(DP[i])):
        if second[i-1] == first[j-1]:
            DP[i][j] = DP[i-1][j-1] + 1
        else:
            DP[i][j] = max(DP[i-1][j],DP[i][j-1])

# for line in DP:
#     for num in line:
#         print(num , end = " ")
#     print()

print(DP[-1][-1])
