import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int count = 0; // 경우의 수를 세기 위한 변수
        int sum = 0; // 연속된 자연수의 합
        int start = 1; // 시작 포인터

        // start부터 N까지 연속된 합을 구하면서 경우의 수를 세기
        for (int end = 1; end <= N; end++) {
            sum += end;

            // 합이 N보다 크면, start를 증가시켜서 합을 줄임
            while (sum > N) {
                sum -= start;
                start++;
            }

            // 합이 N과 같으면 경우의 수 증가
            if (sum == N) {
                count++;
            }
        }

        System.out.println(count);
    }
}
