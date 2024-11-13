import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

/*
9 8
CCTGGATTG
2 0 1 1
 */

public class Main {
    static int[] myArr = new int[4];
    static int[] checkArr = new int[4];
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        char[] str = br.readLine().toCharArray();
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 4; i++) {
            checkArr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < P; i++) {
            if (str[i] == 'A') myArr[0]++;
            if (str[i] == 'C') myArr[1]++;
            if (str[i] == 'G') myArr[2]++;
            if (str[i] == 'T') myArr[3]++;
        }

        if (checkingArr()) {
            answer++;
        }

        int i = -1;
        for (int j = P; j < S; j++) {
            i = j - P;

            if (str[i] == 'A') myArr[0]--;
            if (str[i] == 'C') myArr[1]--;
            if (str[i] == 'G') myArr[2]--;
            if (str[i] == 'T') myArr[3]--;

            if (str[j] == 'A') myArr[0]++;
            if (str[j] == 'C') myArr[1]++;
            if (str[j] == 'G') myArr[2]++;
            if (str[j] == 'T') myArr[3]++;

            if (checkingArr()) {
                answer++;
            }
        }


        System.out.println(answer);
    }


    static boolean checkingArr() {
        for (int i = 0; i < 4; i++) {
            if (checkArr[i] > myArr[i]) {
                return false;
            }
        }
        return true;
    }
}
