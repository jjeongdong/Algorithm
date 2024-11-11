import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Time> arrayList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            arrayList.add(new Time(start, end));
        }

        int cnt = 0;
        Collections.sort(arrayList);

        int endTime = 0;
        for (Time ob : arrayList) {
            if (ob.start >= endTime) {
                cnt++;
                endTime = ob.end;
            }
        }

        System.out.println(cnt);
    }
}

class Time implements Comparable<Time> {
    int start;
    int end;

    public Time(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Time o) {
        if (this.end == o.end) return this.start - o.start;
        else return this.end - o.end;
    }
}
