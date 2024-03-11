import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = scanner.nextInt();
        scanner.nextLine(); // 정수 뒤에 나오는 Enter 키 처리

        for (int i = 0; i < size; i++) {
            String[] str = scanner.nextLine().split(" ");

            for (String s : str) {
                StringBuilder sb = new StringBuilder(s);
                System.out.print(sb.reverse() + " ");
            }

            System.out.println();

        }
    }
}