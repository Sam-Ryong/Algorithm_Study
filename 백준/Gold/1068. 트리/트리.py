N = int(input())
S = input().split(" ")
M = int(input())

nodes = []
result = 0

for i in range(N):
    S[i] = int(S[i])

class node:
    def __init__(self,parent, childList):
        self.parent = parent
        self.childList = childList
    def addChild(self,child):
        self.childList.append(child)
    def removeChild(self,child):
        self.childList.remove(child)

for i in range(N):
    temp = node(S[i],[])
    nodes.append(temp)

for i in range(N):
    if (S[i] != -1):
        nodes[S[i]].addChild(i)


def erase(M):
    global nodes
    childList = []
    for child in nodes[M].childList:
        childList.append(child)
    parent = nodes[M].parent
    if (nodes[M].parent == -1):
        for child in childList:
            erase(child)
        return
    nodes[parent].childList.remove(M)
    for child in childList:
        erase(child)
   
def count(root):
    global nodes
    global result
    if (nodes[root].childList == []):
        result = result + 1
        return
    for child in nodes[root].childList:
        count(child)


erase(M)

root = S.index(-1)

if (M == root):
    print(0)
else:
    count(root)
    print(result)