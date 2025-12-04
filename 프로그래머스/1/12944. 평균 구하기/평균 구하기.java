class Solution {
    public double solution(int[] arr) {
        int total = 0;
        int size = arr.length;
        for(int num : arr) {
            total += num;
        }
        double answer = (double) total / size;
        return answer;
    }
}