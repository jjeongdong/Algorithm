import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        int sum = 0;
        boolean bool = false;

        for (int i = 0; i < 5000; i++) {
            for (int j = 0; j < 5000; j++) {
                sum = 3 * i + 5 * j;
                if (N == sum) {
                    list.add(i + j);
                    bool = true;
                    break;
                } else if (N < sum) {
                    break;
                }
            }

            if (bool) {
                break;
            }
        }

        if (list.isEmpty()) {
            System.out.println(-1);
        } else {
            System.out.println(list.get(0));
        }

    }
}
