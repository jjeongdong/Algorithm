import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    public static int MAX = Integer.MIN_VALUE;    // 최댓값
    public static int MIN = Integer.MAX_VALUE;    // 최솟값
    public static int[] operator = new int[4];    // 연산자 개수
    public static int[] number;                    // 숫자
    public static int N;                        // 숫자 개수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        number = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            number[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }

        DFS(number[0], 1);

        System.out.println(MAX);
        System.out.println(MIN);
    }

    private static void DFS(int num, int index) {
        if (index == N) {
            MAX = Math.max(MAX, num);
            MIN = Math.min(MIN, num);
        }

        for (int i = 0; i < 4; i++) {
            if (operator[i] > 0) {

                operator[i]--;
                switch (i) {
                    case 0:
                        DFS(num + number[index], index + 1);
                        break;
                    case 1:
                        DFS(num - number[index], index + 1);
                        break;
                    case 2:
                        DFS(num * number[index], index + 1);
                        break;
                    case 3:
                        DFS(num / number[index], index + 1);
                        break;
                }

                operator[i]++;
            }
        }
    }
}
