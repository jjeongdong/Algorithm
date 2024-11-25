import java.io.*;
import java.util.StringTokenizer;

public class Main {
    private static final StringBuilder sb = new StringBuilder();
    private static final boolean[] set = new boolean[21];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double totalScore = 0;
        int count = 0;
        for (int i = 0; i < 20; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String courseName = st.nextToken();
            double num = Double.parseDouble(st.nextToken());
            String grade = String.valueOf(st.nextToken());


            if (grade.equals("A+")) {
                totalScore += 4.5 * num;
                count += num;
            } else if (grade.equals("A0")) {
                totalScore += 4.0 * num;
                count += num;
            } else if (grade.equals("B+")) {
                totalScore += 3.5 * num;
                count += num;
            } else if (grade.equals("B0")) {
                totalScore += 3.0 * num;
                count += num;
            } else if (grade.equals("C+")) {
                totalScore += 2.5 * num;
                count += num;
            } else if (grade.equals("C0")) {
                totalScore += 2.0 * num;
                count += num;
            } else if (grade.equals("D+")) {
                totalScore += 1.5 * num;
                count += num;
            } else if (grade.equals("D0")) {
                totalScore += num;
                count += num;
            } else if (grade.equals("F")) {
                totalScore += 0;
                count += num;
            }

        }

        System.out.println(totalScore/count);
    }
}
