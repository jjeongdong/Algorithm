import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static class Pole implements Comparable<Pole> {
        int start, end;
        Pole(int start, int end) {
            this.start = start;
            this.end = end;
        }
        @Override
        public int compareTo(Pole o) {          // start 오름차순, 같으면 end 오름차순
            return this.start != o.start ?
                   this.start - o.start :
                   this.end   - o.end;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        ArrayList<Pole> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            list.add(new Pole(Integer.parseInt(st.nextToken()),
                              Integer.parseInt(st.nextToken())));
        }

        /* 1) 왼쪽 전봇대(start) 기준 정렬 */
        Collections.sort(list);

        /* 2) 오른쪽 전봇대(end) 배열 추출 */
        int[] end = new int[N];
        for (int i = 0; i < N; i++) end[i] = list.get(i).end;

        /* 3) LIS O(N²) */
        int[] dp  = new int[N];
        int lisLen = 0;
        for (int i = 0; i < N; i++) {
            dp[i] = 1;                         // 자기 자신
            for (int j = 0; j < i; j++) {
                if (end[j] < end[i])           // 증가하는 경우에만 갱신
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            lisLen = Math.max(lisLen, dp[i]);  // 전체 LIS 길이
        }

        /* 4) 제거할 전깃줄 최소 개수 = N - LIS */
        System.out.println(N - lisLen);
    }
}
