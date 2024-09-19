N = int(input())
tests = []
for i in range(N):
    num = int(input())
    tests.append(num)

arr = [[1,0],[0,1]]

for i in range(40):
    now = [arr[len(arr) - 1][0] + arr[len(arr) - 2][0], arr[len(arr) - 1][1] + arr[len(arr) - 2][1]]
    arr.append(now)

for test in tests:
    print(arr[test][0],arr[test][1])