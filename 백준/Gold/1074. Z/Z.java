import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int N, r, c;
    public static int answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        int size = (int) Math.pow(2, N); // 전체 배열 크기
        DFS(0, 0, size); // 탐색 시작
    }

    public static void DFS(int row, int col, int size) {
        if (size == 1) { // 배열 크기가 1x1이면 값 출력
            System.out.println(answer);
            return;
        }

        int half = size / 2; // 현재 영역의 절반 크기

        // 좌표 (r, c)가 현재 1사분면에 있을 경우
        if (r < row + half && c < col + half) {
            DFS(row, col, half);
        }
        // 좌표 (r, c)가 현재 2사분면에 있을 경우
        else if (r < row + half && c >= col + half) {
            answer += half * half; // 이전 사분면 크기만큼 더하기
            DFS(row, col + half, half);
        }
        // 좌표 (r, c)가 현재 3사분면에 있을 경우
        else if (r >= row + half && c < col + half) {
            answer += 2 * half * half; // 이전 두 사분면 크기만큼 더하기
            DFS(row + half, col, half);
        }
        // 좌표 (r, c)가 현재 4사분면에 있을 경우
        else {
            answer += 3 * half * half; // 이전 세 사분면 크기만큼 더하기
            DFS(row + half, col + half, half);
        }
    }
}
