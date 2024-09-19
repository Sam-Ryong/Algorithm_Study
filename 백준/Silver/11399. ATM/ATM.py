N = int(input())
temp = list(map(int,input().split()))
temp.sort()
result = 0

for i in range(N):
    result = result + (temp[i] * (N - i))

print(result)