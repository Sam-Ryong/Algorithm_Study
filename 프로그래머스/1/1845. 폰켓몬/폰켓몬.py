def solution(nums):
    answer = 0
    pokemon = set(nums)
    
    return min(len(nums) / 2, len(pokemon))