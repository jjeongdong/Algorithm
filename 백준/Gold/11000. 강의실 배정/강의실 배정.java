

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        int N = Integer.parseInt(br.readLine());
        ArrayList<Lecture> lectureArrayList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            lectureArrayList.add(new Lecture(start, end));
        }

        // 시작 시간 기준 정렬
        Collections.sort(lectureArrayList);
        priorityQueue.add(lectureArrayList.get(0).endTime); // 첫 강의는 무조건 하나 필요

        for (int i = 1; i < N; i++) {
            Lecture lecture = lectureArrayList.get(i);
            if (priorityQueue.peek() <= lecture.startTime) {
                priorityQueue.poll(); // 강의실 재사용
            }
            priorityQueue.add(lecture.endTime); // 새 강의 등록
        }

        System.out.println(priorityQueue.size()); // 필요한 강의실 수
    }

    static class Lecture implements Comparable<Lecture> {
        int startTime;
        int endTime;

        public Lecture(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        @Override
        public int compareTo(Lecture o) {
            return this.startTime - o.startTime;
        }
    }
}
