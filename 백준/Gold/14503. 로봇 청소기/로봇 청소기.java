import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] board = new int[N][M];
        int answer = 0;

        st = new StringTokenizer(br.readLine());
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        int direction = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (!queue.isEmpty()) {
            Point now = queue.poll();
            boolean flag = false;
            boolean isEnd = false;
            int x = now.x;
            int y = now.y;

            // 현재 칸이 아직 청소되지 않은 경우, 현재 칸을 청소한다.
            if (board[x][y] == 0) {
                board[x][y] = 2;
            }

            // 현재 4칸 중 청소가 되지 않은 빈칸이 있는지 없는지 확인
            for (int i = 0; i < 4; i++) {
                if (board[x + dx[i]][y + dy[i]] == 0) {
                    flag = true;
                    break;
                }
            }

            if (flag) {
                for (int i = 0; i < 4; i++) {
                    direction = (direction + 3) % 4;

                    if (direction == 0) {
                        if (board[x - 1][y] == 0) {
                            board[x - 1][y] = 2;
                            queue.add(new Point(x - 1, y));
                            break;
                        }
                    } else if (direction == 1) {
                        if (board[x][y + 1] == 0) {
                            board[x][y + 1] = 2;
                            queue.add(new Point(x, y + 1));
                            break;
                        }
                    } else if (direction == 2) {
                        if (board[x + 1][y] == 0) {
                            board[x + 1][y] = 2;
                            queue.add(new Point(x + 1, y));
                            break;
                        }
                    } else if (direction == 3) {
                        if (board[x][y - 1] == 0) {
                            board[x][y - 1] = 2;
                            queue.add(new Point(x, y - 1));
                            break;
                        }
                    }
                }
            } else {
                if (direction == 0) {
                    if (!(board[x + 1][y] == 1)) {
                        queue.add(new Point(x + 1, y));
                    } else if (board[x + 1][y] == 1) {
                        isEnd = true;
                    }
                } else if (direction == 1) {
                    if (!(board[x][y - 1] == 1)) {
                        queue.add(new Point(x, y - 1));
                    } else if (board[x][y - 1] == 1) {
                        isEnd = true;
                    }
                } else if (direction == 2) {
                    if (!(board[x - 1][y] == 1)) {
                        queue.add(new Point(x - 1, y));
                    } else if (board[x - 1][y] == 1) {
                        isEnd = true;
                    }
                } else if (direction == 3) {
                    if (!(board[x][y + 1] == 1)) {
                        queue.add(new Point(x, y + 1));
                    } else if (board[x][y + 1] == 1) {
                        isEnd = true;
                    }
                }
            }

            if (isEnd) break;
        }

        for (int i = 1; i < N; i++) {
            for (int j = 1; j < M; j++) {
                if (board[i][j] == 2) {
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }
}

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
