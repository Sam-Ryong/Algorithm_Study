N = int(input())

steps = [0]

dp = [0 for i in range(N+1)]

for i in range(N):
    steps.append(int(input()))

dp[1] = steps[1]
if (N >= 2):
    dp[2] = steps[1] + steps[2]

if (N >= 3):
    for i in range(3,N+1):

        dp[i] = max(dp[i-2] + steps[i], dp[i-3] + steps[i-1] + steps[i])

print(dp[-1])