import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int[] stageCount = new int[N + 2]; // stageCount[i] = 스테이지 i에 머무른 사람 수

        for (int stage : stages) {
            stageCount[stage]++;
        }

        int totalPlayers = stages.length;
        ArrayList<Failure> failureList = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            int stuck = stageCount[i];
            double failureRate = totalPlayers == 0 ? 0 : (double) stuck / totalPlayers;
            failureList.add(new Failure(i, failureRate));
            totalPlayers -= stuck;
        }

        Collections.sort(failureList);

        for (int i = 0; i < N; i++) {
            answer[i] = failureList.get(i).idx;
        }

        return answer;
    }

    static class Failure implements Comparable<Failure> {
        int idx;
        double rate;

        public Failure(int idx, double rate) {
            this.idx = idx;
            this.rate = rate;
        }

        @Override
        public int compareTo(Failure o) {
            if (Double.compare(o.rate, this.rate) != 0) {
                return Double.compare(o.rate, this.rate); // 실패율 내림차순
            }
            return Integer.compare(this.idx, o.idx); // 같으면 번호 오름차순
        }
    }
}
