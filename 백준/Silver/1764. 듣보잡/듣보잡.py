N, M = map(int,input().split())

noheard = set()
result = []

for i in range(N):
    name = input()
    noheard.add(name)

for i in range(M):
    name = input()
    if name in noheard:
        result.append(name)

result.sort()
print(len(result))
for name in result:
    print(name)