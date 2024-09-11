test = []

while True:
    nums = list(map(int,input().split()))
    if nums == [0,0,0]:
        break

    long = max(nums)*max(nums)
    nums.remove(max(nums))

    pita = 0
    for num in nums:
        pita = pita + num * num

    if long == pita:
        test.append("right")
    else:
        test.append("wrong")

for t in test:
    print(t)