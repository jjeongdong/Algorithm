import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int count = 1; // 경우의 수를 세기 위한 변수
        int sum = 1; // 연속된 자연수의 합
        int start = 1; // 시작 포인터
        int end = 1;

        while (end != N) {
            if (sum == N) {
                count++;
                end++;
                sum = sum + end;
            } else if (sum > N) {
                sum = sum - start;
                start++;
            } else {
                end++;
                sum = sum + end;
            }
        }

        System.out.println(count);
    }
}
