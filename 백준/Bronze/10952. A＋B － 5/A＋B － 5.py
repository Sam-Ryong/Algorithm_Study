result = []

while (True):
    a = input()
    A = int(a[0])
    B = int(a[2])
    if (A == 0 & B == 0):
        break;
    result.append(A+B)

for elem in result:
    print(elem)