W,H,f,c,x1,y1,x2,y2 = map(int, input().split())

paper = []

# 세로 접기
temp = []
newW = max(f,W-f)
folded = min(f,W-f)
unfolded = newW - folded

# 가로 접기
newH = int(H / (c + 1))

result = 0

if (x1 < folded):
    if (x2 <= folded):
        result = result + ((x2 - x1) * 2)
    else:
        result = result + (folded - x1) * 2 + (x2 - folded)
else:
    result = result + (x2 - x1)

result = result * (y2-y1) * (c+1)


print(W*H - result)