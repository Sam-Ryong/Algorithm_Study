N, K = map(int,input().split())

W = []
V = []
DP = [[0 for i in range(K + 1)]for i in range(N + 1)]

for i in range(N):
    w, v = map(int,input().split())
    W.append(w)
    V.append(v)

for i in range(1, N + 1):
    for j in range(1, K + 1):
        weight = W[i-1]
        value = V[i-1]
        if weight <= j:
            DP[i][j] = max(DP[i-1][j-weight] + value, DP[i-1][j])
        else:
             DP[i][j] = DP[i-1][j]

print(DP[N][K])