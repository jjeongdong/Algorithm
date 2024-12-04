import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        ArrayList<Brick> bricks = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            bricks.add(new Brick(s, h, w, i + 1));
        }

        // 밑면 넓이를 기준으로 내림차순 정렬
        Collections.sort(bricks);

        int[] dp_h = new int[N];
        int[] predecessor = new int[N];

        // 초기값 설정
        dp_h[0] = bricks.get(0).h;
        Arrays.fill(predecessor, -1);

        // DP 배열 계산
        for (int i = 1; i < N; i++) {
            dp_h[i] = bricks.get(i).h; // 현재 벽돌만 쌓는 경우로 초기화
            for (int j = 0; j < i; j++) {
                if (bricks.get(i).w < bricks.get(j).w) { // 무게 조건 만족
                    if (dp_h[i] < dp_h[j] + bricks.get(i).h) {
                        dp_h[i] = dp_h[j] + bricks.get(i).h;
                        predecessor[i] = j; // 이전 벽돌 추적
                    }
                }
            }
        }

        // 최대 높이와 해당 인덱스 찾기
        int maxHeight = 0;
        int maxIndex = 0;
        for (int i = 0; i < N; i++) {
            if (dp_h[i] > maxHeight) {
                maxHeight = dp_h[i];
                maxIndex = i;
            }
        }

        // 결과 추적 (탑 구성 벽돌 번호)
        List<Integer> result = new ArrayList<>();
        while (maxIndex != -1) {
            result.add(bricks.get(maxIndex).index);
            maxIndex = predecessor[maxIndex];
        }

        // 출력
        sb.append(result.size()).append("\n");

        for (int index : result) {
            sb.append(index).append("\n");
        }
        System.out.print(sb);
    }
}

class Brick implements Comparable<Brick> {
    int s;
    int h;
    int w;
    int index;

    public Brick(int s, int h, int w, int index) {
        this.s = s;
        this.h = h;
        this.w = w;
        this.index = index;
    }

    @Override
    public int compareTo(Brick o) {
        return o.s - this.s; // 밑면 넓이 기준 내림차순 정렬
    }
}
