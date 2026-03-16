from collections import deque

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def bfs(graph,x, y):
    queue = deque()
    queue.append((x, y))
    graph[y][x] = 0

    while queue:
        x, y = queue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if nx < 0 or nx >= m or ny < 0 or ny >= n:
                continue

            if graph[ny][nx] == 0:
                continue

            if graph[ny][nx] == 1:
                graph[ny][nx] = 0
                queue.append((nx, ny))

t = int(input())
for _ in range(t):
    m, n, k = map(int, input().split())
    graph=[[0]*m for _ in range(n)]
    for i in range(k):
        x, y = map(int, input().split())
        graph[y][x] = 1

    count = 0

    for i in range(n):
        for j in range(m):
            if graph[i][j] == 1:
                bfs(graph, j, i)
                count += 1
    print(count)