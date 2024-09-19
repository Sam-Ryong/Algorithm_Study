N = int(input())
count = 1000000000000
def find(N,now):
    global count
    if (now >= count):
        return
    if (N == 1):
        if now < count:
            count = now
        return
    if (N % 3 == 0):
        find(N // 3, now + 1)
    if (N % 2 == 0):
        find(N // 2, now + 1)
    find(N - 1, now + 1)

find(N,0)

print(count)