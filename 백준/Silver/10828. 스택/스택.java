import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        scanner.nextLine(); // consume the newline character

        int[] arr = new int[10000];
        int lt = -1;
        int tmp = 0;

        StringBuilder output = new StringBuilder();

        for (int i = 0; i < N; i++) {
            String[] str = scanner.nextLine().split(" ");
            String command = str[0];

            if (str.length == 2) {
                tmp = Integer.parseInt(str[1]);
            }

            if ("push".equals(command)) {
                arr[++lt] = tmp;
            } else if ("top".equals(command)) {
                if (lt == -1) {
                    output.append("-1\n");
                } else {
                    output.append(arr[lt]).append("\n");
                }
            } else if ("size".equals(command)) {
                output.append(lt + 1).append("\n");
            } else if ("pop".equals(command)) {
                if (lt == -1) {
                    output.append("-1\n");
                } else {
                    output.append(arr[lt]).append("\n");
                    lt--;
                }
            } else if ("empty".equals(command)) {
                if (lt == -1) {
                    output.append("1\n");
                } else {
                    output.append("0\n");
                }
            }
        }

        System.out.print(output.toString());
    }
}
