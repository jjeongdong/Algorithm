import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int sum = 0;
        int tmp = N;
        int num1 = 0, num2 = 0;

        for (int i = 1; i <= N / 2 + 1; i++) {
            tmp -= i;

            if (tmp == 0) {
                sum = i + 1;
                break;
            } else if (tmp <= i) {
                sum = i + 2;
                break;
            }
        }

        if (tmp == 0) {
            if (sum % 2 == 1) {
                num2 = 1;
                num1 = sum - num2;


            } else {
                num1 = 1;
                num2 = sum - num1;

            }
        } else {
            for (int i = 0; i < tmp; i++) {
                if (sum % 2 == 1) {
                    num1++;
                    num2 = sum - num1;

                } else {
                    num2++;
                    num1 = sum - num2;
                }
            }
        }

        if (N == 1) {
            System.out.println("1/1");
        } else {
            System.out.println(num1 + "/" + num2);
        }
    }
}
