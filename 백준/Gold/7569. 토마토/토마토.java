import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int[][][] tomato = new int[h][n][m];

        Queue<Tomato> queue = new LinkedList<>();
        int[] rowArr = {-1, 0, 1, 0, 0, 0}; // z 방향
        int[] colArr = {0, 1, 0, -1, 0, 0}; // x 방향
        int[] heightArr = {0, 0, 0, 0, 1, -1}; // y 방향

        // 토마토 상태 입력 및 초기화
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < m; k++) {
                    tomato[i][j][k] = Integer.parseInt(st.nextToken());
                    if (tomato[i][j][k] == 1) {
                        queue.add(new Tomato(i, j, k)); // 익은 토마토를 큐에 추가
                    }
                }
            }
        }

        int days = bfs(m, n, h, tomato, queue, rowArr, colArr, heightArr);

        if (isFinish(m, n, h, tomato)) {
            System.out.println(days);
        } else {
            System.out.println(-1);
        }
    }

    static int bfs(int m, int n, int h, int[][][] tomato, Queue<Tomato> queue,
                   int[] rowArr, int[] colArr, int[] heightArr) {
        int days = -1;

        while (!queue.isEmpty()) {
            int len = queue.size();

            for (int i = 0; i < len; i++) {
                Tomato tmp = queue.poll();

                int tz = tmp.z;
                int ty = tmp.y;
                int tx = tmp.x;

                for (int j = 0; j < 6; j++) {
                    int nz = tz + heightArr[j];
                    int ny = ty + rowArr[j];
                    int nx = tx + colArr[j];

                    if (nx >= 0 && nx < m && ny >= 0 && ny < n && nz >= 0 && nz < h) {
                        if (tomato[nz][ny][nx] == 0) {
                            tomato[nz][ny][nx] = 1;
                            queue.add(new Tomato(nz, ny, nx));
                        }
                    }
                }
            }

            days++;
        }

        return days;
    }

    static boolean isFinish(int m, int n, int h, int[][][] tomato) {
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (tomato[i][j][k] == 0) return false; // 익지 않은 토마토 발견
                }
            }
        }
        return true;
    }
}

class Tomato {
    int x, y, z;

    public Tomato(int z, int y, int x) {
        this.z = z; // 높이
        this.y = y; // 행
        this.x = x; // 열
    }
}
