def solution(n, lost, reserve):
    # 교집합 제거: 여벌 가져왔지만 도난당한 사람
    lost_set = set(lost) - set(reserve)
    reserve_set = set(reserve) - set(lost)

    # 학생 상태 초기화 (1 = 체육복 있음)
    status = [1] * n

    # 도난당한 학생 체육복 차감
    for l in lost_set:
        status[l - 1] -= 1
    # 여벌 체육복 더하기
    for r in reserve_set:
        status[r - 1] += 1

    # 체육복 빌려주기
    for i in range(n):
        if status[i] == 0:
            if i > 0 and status[i - 1] == 2:
                status[i] = 1
                status[i - 1] = 1
            elif i < n - 1 and status[i + 1] == 2:
                status[i] = 1
                status[i + 1] = 1

    # 체육수업 들을 수 있는 학생 수 반환
    return sum(s > 0 for s in status)