import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}


public class Main {

    static int[][] ch;

    static int[] dx = new int[]{1, 2, 2, 1, -1, -2, -2, -1};
    static int[] dy = new int[]{2, 1, -1, -2, -2, -1, 1, 2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int R = Integer.parseInt(br.readLine());
            ch = new int[R + 1][R + 1];

            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st1.nextToken());
            int y1 = Integer.parseInt(st1.nextToken());

            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int x2 = Integer.parseInt(st2.nextToken());
            int y2 = Integer.parseInt(st2.nextToken());
            Main T = new Main();
            answer.add(T.BFS(R, x1, y1, x2, y2));
        }

        for (Integer integer : answer) {
            System.out.println(integer);
        }
    }

    int BFS(int R, int x1, int y1, int x2, int y2) {

        if (x1 == x2 && y1 == y2) {
            return 0;
        }

        Queue<Point> Q = new LinkedList<>();
        Q.offer(new Point(x1, y1));
        ch[x1][y1] = 1;

        int L = 0;

        while (!Q.isEmpty()) {
            int len = Q.size();

            for (int i = 0; i < len; i++) {
                Point point = Q.poll();
                for (int j = 0; j < 8; j++) {
                    int nx = point.x + dx[j];
                    int ny = point.y + dy[j];

                    if (nx == x2 && ny == y2) {
                        return L + 1;
                    }

                    if ((nx >= 0 && nx < R) && (ny >= 0 && ny < R) && ch[nx][ny] == 0) {
                        ch[nx][ny] = 1;
                        Q.add(new Point(nx, ny));
                    }
                }
            }
            L++;
        }

        return L;
    }
}
