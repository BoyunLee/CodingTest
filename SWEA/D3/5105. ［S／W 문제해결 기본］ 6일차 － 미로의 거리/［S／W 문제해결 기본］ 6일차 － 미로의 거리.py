from collections import deque

dr = [0, 1, 0, -1]
dc = [1, 0, -1, 0]

T = int(input())

for t in range(1, T + 1):
    N = int(input())
    miro = [[0] * N for _ in range(N)]
    sr, sc = -1, -1
    answer = 0

    for i in range(N):
        line = input().strip()
        for j in range(N):
            miro[i][j] = int(line[j])
            if miro[i][j] == 2:
                sr, sc = i, j

    visited = [[False] * N for _ in range(N)]
    queue = deque()
    visited[sr][sc] = True
    queue.append((sr, sc, 0))  # r, c, dist

    while queue:
        r, c, dist = queue.popleft()

        if miro[r][c] == 3:
            answer = dist - 1
            break

        for d in range(4):
            nr = r + dr[d]
            nc = c + dc[d]

            if 0 <= nr < N and 0 <= nc < N:
                if not visited[nr][nc] and miro[nr][nc] != 1:
                    visited[nr][nc] = True
                    queue.append((nr, nc, dist + 1))

    print(f"#{t} {answer}")
