def solution(sizes):
    answer = 0
    short = []
    long = []
    for size in sizes:
        short.append(min(size))
        long.append(max(size))
    
    return max(long) * max(short)