import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int L = 0;
        int N = Integer.parseInt(br.readLine());
        int apple_count = Integer.parseInt(br.readLine());
        int[][] board = new int[N + 1][N + 1];

        // 사과 위치, 지리 정보 입력
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                board[i][j] = 0;
            }
        }

        for (int i = 0; i < apple_count; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            board[x][y] = 1;
        }

        // 뱀 방향 정보 입력
        int snake_direction_info_count = Integer.parseInt(br.readLine());
        String[][] snake_direction_info = new String[snake_direction_info_count][2];
        for (int i = 0; i < snake_direction_info_count; i++) {
            st = new StringTokenizer(br.readLine());
            snake_direction_info[i][0] = st.nextToken();
            snake_direction_info[i][1] = st.nextToken();
        }

        int snake_direction = 1;
        Deque<Point> deque = new ArrayDeque<>();
        deque.add(new Point(1, 1));
        board[1][1] = 2;

        while (!deque.isEmpty()) {
            L++;
            Point now = deque.peekFirst();
            int x = now.x;
            int y = now.y;

            if (snake_direction == 0) {
                x = x - 1;
            } else if (snake_direction == 1) {
                y = y + 1;
            } else if (snake_direction == 2) {
                x = x + 1;
            } else if (snake_direction == 3) {
                y = y - 1;
            }


            if (x <= 0 || x > N || y <= 0 || y > N || board[x][y] == 2) {
                break;
            }


            if (board[x][y] == 1) {
                board[x][y] = 2;
                deque.addFirst(new Point(x, y));
            } else if (board[x][y] == 0) {
                board[x][y] = 2;
                deque.addFirst(new Point(x, y));
                Point point = deque.pollLast();
                board[point.x][point.y] = 0;
            }

            for (int i = 0; i < snake_direction_info.length; i++) {
                if (L == Integer.parseInt(snake_direction_info[i][0])) {
                    if ("D".equals(snake_direction_info[i][1])) {
                        snake_direction = (snake_direction + 1) % 4;
                    } else {
                        snake_direction = (snake_direction + 3) % 4;
                    }
                    break; // 조건을 만족하면 즉시 종료
                }
            }
        }

        System.out.println(L);
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
