N = int(input())
M = int(input())
result = 0
class Node:

    def __init__(self):
        self.status = False
        self.next = []

computers = [Node() for i in range(N)]
for i in range(M):
    a, b = map(int,input().split(" "))
    computers[a-1].next.append(computers[b-1])
    computers[b-1].next.append(computers[a-1])

def infect(node):

    global result
    if node.status:
        return
    node.status = True
    result = result + 1

    for next in node.next:
        infect(next)

infect(computers[0])

print(result-1)