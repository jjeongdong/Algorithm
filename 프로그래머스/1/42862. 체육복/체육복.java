class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
         int[] student = new int[n];

        for (int i = 0; i < n; i++) {
            student[i] = 1;
        }

        for (int tmp : lost) {
            student[tmp - 1]--;
        }

        for (int tmp : reserve) {
            student[tmp - 1]++;
        }


        for (int i = 0; i < student.length; i++) {
            if (student[i] == 2) {
                if ((i - 1) >= 0 && student[i - 1] == 0) {
                    student[i - 1]++;
                    student[i]--;
                } else if ((i + 1) < n && student[i + 1] == 0) {
                    student[i + 1]++;
                    student[i]--;
                }
            }
        }

        for (int tmp:
             student) {

            if (tmp >= 1) answer++;
        }
        
        return answer;
    }
}