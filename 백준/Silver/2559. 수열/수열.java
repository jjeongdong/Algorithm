import java.awt.*;
import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[][] board;
    static Queue<Point> queue = new LinkedList<>();
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        for (int i = 0; i < K; i++) {
            sum += arr[i];
        }

        int max = sum;

        for (int i = K, j= 0; i < N; i++, j++) {
            sum += arr[i] - arr[j];
            max = Math.max(max, sum);
        }

        System.out.println(max);
    }
}
