import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	// 위 아래 왼 오
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());

			char[][] map = new char[H][W];
			int robinR = 0;
			int robinC = 0;
			int robinD = 0;
			for (int i = 0; i < H; i++) {
				String line = br.readLine();
				for (int j = 0; j < W; j++) {
					map[i][j] = line.charAt(j);
					if (map[i][j] == '^') {
						robinR = i;
						robinC = j;
						robinD = 0;
					} else if (map[i][j] == 'v') {
						robinR = i;
						robinC = j;
						robinD = 1;
					} else if (map[i][j] == '<') {
						robinR = i;
						robinC = j;
						robinD = 2;
					} else if (map[i][j] == '>') {
						robinR = i;
						robinC = j;
						robinD = 3;
					}
				}
			}

			int N = Integer.parseInt(br.readLine());
			String Nline = br.readLine();
			int nr = 0;
			int nc = 0;
			for (int i = 0; i < N; i++) {
				char C = Nline.charAt(i);
				switch (C) {
				case 'U':
					robinD = 0;
					nr = robinR + dr[robinD];
					nc = robinC + dc[robinD];

					if (nr >= 0 && nr < H && nc >= 0 && nc < W) {
						if (map[nr][nc] == '.') {
							map[robinR][robinC] = '.';
							robinR = nr;
							robinC = nc;
							map[nr][nc] = '^';
						} else {
							map[robinR][robinC] = '^';
						}
					} else {
						map[robinR][robinC] = '^';
					}
					break;

				case 'D':
					robinD = 1;
					nr = robinR + dr[robinD];
					nc = robinC + dc[robinD];

					if (nr >= 0 && nr < H && nc >= 0 && nc < W) {
						if (map[nr][nc] == '.') {
							map[robinR][robinC] = '.';
							robinR = nr;
							robinC = nc;
							map[nr][nc] = 'v';
						} else {
							map[robinR][robinC] = 'v';
						}
					} else {
						map[robinR][robinC] = 'v';
					}
					break;

				case 'L':
					robinD = 2;
					nr = robinR + dr[robinD];
					nc = robinC + dc[robinD];

					if (nr >= 0 && nr < H && nc >= 0 && nc < W) {
						if (map[nr][nc] == '.') {
							map[robinR][robinC] = '.';
							robinR = nr;
							robinC = nc;
							map[nr][nc] = '<';
						} else {
							map[robinR][robinC] = '<';
						}
					} else {
						map[robinR][robinC] = '<';
					}
					break;

				case 'R':
					robinD = 3;
					nr = robinR + dr[robinD];
					nc = robinC + dc[robinD];

					if (nr >= 0 && nr < H && nc >= 0 && nc < W) {
						if (map[nr][nc] == '.') {
							map[robinR][robinC] = '.';
							robinR = nr;
							robinC = nc;
							map[nr][nc] = '>';
						} else {
							map[robinR][robinC] = '>';
						}
					} else {
						map[robinR][robinC] = '>';
					}
					break;

				case 'S':
					int r = robinR;
					int c = robinC;

					while (true) {
						nr = r + dr[robinD];
						nc = c + dc[robinD];

						if (nr >= 0 && nr < H && nc >= 0 && nc < W) {
							if (map[nr][nc] == '#') {
								break;
							} else if (map[nr][nc] == '*') {
								map[nr][nc] = '.';
								break;
							} else {
								r = nr;
								c = nc;
							}
						} else {
							break;
						}
					}
					break;

				default:
					break;
				}
			}

			System.out.print("#" + t + " ");
			for (int i = 0; i < H; i++) {
				StringBuilder sb = new StringBuilder();
				for (int j = 0; j < W; j++) {
					sb.append(map[i][j]);
				}
				System.out.println(sb);
			}
		}
	}
}
