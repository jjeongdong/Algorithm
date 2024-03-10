import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            int N = scanner.nextInt();

            if (N == 0) {
                break;
            }

            int answer = 0;

            int[] arr = new int[2 * N + 1];
            arr[0] = 1;
            arr[1] = 1;

            for (int i = 2; i <= 2 * N; i++) {
                if (arr[i] == 0) {
                    if (i > N && i <= 2 * N) {
                        answer++;
                    }
                }
 
                for (int j = i; j <= 2 * N; j += i) {  
                    arr[j] = 1;
                }
            }

            System.out.println(answer);
        }
    }
}
