M = int(input())
cout = 0
S = []
count = 0
for i in range(M):
    cmd = list(input().split())
    if (len(cmd) == 2):
        cmd[1] = int(cmd[1])
    if (cmd[0] == "add"):
        if not(cmd[1] in S):
            S.append(cmd[1])

    elif (cmd[0] == "check"):
        count = count + 1
        if cmd[1] in S:
            cout = cout + 1
            cout = cout * 2
        else:
            cout = cout * 2

    elif (cmd[0] == "remove"):
        if cmd[1] in S: 
            S.remove(cmd[1])

    elif (cmd[0] == "toggle"):
        if cmd[1] in S:
            S.remove(cmd[1])
        else:
            S.append(cmd[1])

    elif (cmd[0] == "all"):
        S = [(i+1) for i in range(20)]
     
    elif (cmd[0] == "empty"):
        S = []

leng = len(bin(cout)) - 3
if count > leng:
    for i in range(count - leng):
        print(0)
for letter in bin(cout)[2:len(bin(cout))-1]:
    print(letter)