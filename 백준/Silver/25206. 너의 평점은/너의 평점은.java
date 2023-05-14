import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int cnt = 20;
        double totalGrade = 0;
        double totalCount = 0;

        for (int i = 0; i < 20; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            String name = st.nextToken();
            double count = Double.parseDouble(st.nextToken());
            totalCount += count;
            String strGrade = st.nextToken();
            double grade = 0;

            if (Objects.equals(strGrade, "A+")) {
                grade = 4.5;
                totalGrade += count * grade;
            } else if (Objects.equals(strGrade, "A0")) {
                grade = 4.0;
                totalGrade += count * grade;
            } else if (Objects.equals(strGrade, "B+")) {
                grade = 3.5;
                totalGrade += count * grade;
            } else if (Objects.equals(strGrade, "B0")) {
                grade = 3.0;
                totalGrade += count * grade;
            } else if (Objects.equals(strGrade, "C+")) {
                grade = 2.5;
                totalGrade += count * grade;
            } else if (Objects.equals(strGrade, "C0")) {
                grade = 2.0;
                totalGrade += count * grade;
            } else if (Objects.equals(strGrade, "D+")) {
                grade = 1.5;
                totalGrade += count * grade;
            } else if (Objects.equals(strGrade, "D0")) {
                grade = 1.0;
                totalGrade += count * grade;
            } else if (Objects.equals(strGrade, "F")) {
                grade = 0.0;
                totalGrade += count * grade;
            } else {
                totalCount -= count;
            }

        }

        System.out.printf("%.6f", totalGrade/totalCount);


    }
}