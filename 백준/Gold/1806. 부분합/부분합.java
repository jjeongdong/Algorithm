import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N, S;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 슬라이딩 윈도우 알고리즘
        int minLength = Integer.MAX_VALUE; // 최소 길이 저장
        int sum = 0; // 현재 부분합
        int start = 0; // 슬라이딩 윈도우의 시작 인덱스

        for (int end = 0; end < N; end++) {
            sum += arr[end]; // 윈도우에 새 요소 추가

            while (sum >= S) { // 현재 합이 S 이상이면
                minLength = Math.min(minLength, end - start + 1); // 최소 길이 갱신
                sum -= arr[start++]; // 윈도우의 시작 인덱스를 이동
            }
        }

        // 결과 출력
        System.out.println(minLength == Integer.MAX_VALUE ? 0 : minLength);
    }
}
