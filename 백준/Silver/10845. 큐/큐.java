import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String value = "";

        List<Integer> list = new ArrayList<>();

        list.add(2);
        list.add(100);
        list.remove(0);

        int N = scanner.nextInt();
        StringBuilder answer = new StringBuilder();

        List<String> queue = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            String[] str = scanner.nextLine().split(" ");
            String command = str[0];

            if (str.length == 2) {
                value = str[1];
            }

            if (command.equals("push")) {
                queue.add(value);
            } else if (command.equals("pop")) {

                if (queue.isEmpty()) {
                    answer.append(-1).append("\n");
                } else {
                    answer.append(queue.get(0)).append("\n");
                    queue.remove(0);
                }

            } else if (command.equals("empty")) {
                if (queue.isEmpty()) {
                    answer.append(1).append("\n");
                } else {
                    answer.append(0).append("\n");
                }

            } else if (command.equals("size")) {
                answer.append(queue.size()).append("\n");

            } else if (command.equals("front")) {

                if (queue.isEmpty()) {
                    answer.append(-1).append("\n");
                } else {
                    answer.append(queue.get(0)).append("\n");
                }
            } else if (command.equals("back")) {

                if (queue.isEmpty()) {
                    answer.append(-1).append("\n");
                } else {
                    answer.append(queue.get(queue.size() - 1)).append("\n");
                }
            }
        }

        System.out.println(answer);
    }
}
