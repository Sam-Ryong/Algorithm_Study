def solution(citations):
    answer = 0
    n = len(citations)
    low = 0
    high = max(citations)
    mid = (low + high + 1) // 2
    while low < high:
        h = mid
        count = 0
        for c in citations:
            if c >= h:
                count += 1
        if count >= h:
            low = mid
        else:
            high = mid - 1
        mid = (low + high + 1) // 2
    return mid