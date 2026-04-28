def solution(num_str):
    answer = 0
    a = list(num_str)
    a = map(int,a)
    answer = sum(a)
    return answer