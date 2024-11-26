import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int E = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int startE = 1;
        int startS = 1;
        int startM = 1;

        int answer = 1;

        while (true) {

            int tmpE = startE % 15 == 0 ? 15 : startE % 15;
            int tmpS = startS % 28 == 0 ? 28 : startS % 28;
            int tmpM = startM % 19 == 0 ? 19 : startM % 19;

            if (tmpE == E && tmpS == S && tmpM == M) {
                break;
            }

            startE++;
            startS++;
            startM++;

            answer++;
        }

        System.out.println(answer);
    }
}
