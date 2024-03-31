class Solution {
    public int solution(String t, String p) {
       int answer = 0;

        int size = p.length();

        for (int i = 0; i <= t.length() - size; i++) {
            if (Long.parseLong(p) >= Long.parseLong(t.substring(i, size + i))) {
                answer++;
            }
        }

        
        return answer;
    }
}