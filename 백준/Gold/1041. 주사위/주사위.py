## N-2 * N-2 개의 최소값
## N-2 * 4 개의 2개의 면 최소값
## 4개의 3개의 면 최소값
## N-1 *4 개의 2개의 면 최소값
## N-2 * N-1 * 4개의 최소값

N = int(input())
S = input().split(" ")

for i in range(6):
    S[i] = int(S[i])

## 1개만 보이는 주사위
one = min(S) * ((N-2) * (N-2) + (N-2)* (N-1) * 4)

## 2개만 보이는 주사위
## 2개로 만들수 있는 최소값 먼저 찾기
twomin = sum(S)
for i in range(6):
    for j in range(i+1,6):
        if(i + j != 5):
            if(twomin > S[i]+S[j]):
                twomin = S[i]+S[j]
two = twomin * ((N-2)*4 + (N-1)*4)

## 3개만 보이는 주사위
## 3개로 만들수 있는 최소값 찾기
threemin = sum(S)
for i in range(6):
    for j in range(i+1,6):
        for k in range(j+1,6):
            if (i+j != 5 and i+k !=5 and j+k != 5):
                if(threemin > S[i]+S[j]+S[k]):
                    threemin = S[i]+S[j]+S[k]
three = threemin * 4

if (N == 1):
    print(sum(S)-max(S))
else:
    print(one+two+three)