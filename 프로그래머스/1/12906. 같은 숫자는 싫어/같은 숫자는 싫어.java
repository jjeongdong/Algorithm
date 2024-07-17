
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int[] solution(int[] arr) {
        if (arr.length == 0) {
            return new int[0];
        }

        List<Integer> result = new ArrayList<>();
        result.add(arr[0]); // 첫 번째 원소를 결과 리스트에 추가합니다.

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1]) { // 현재 원소가 이전 원소와 다르면 추가합니다.
                result.add(arr[i]);
            }
        }

        // ArrayList를 배열로 변환하여 반환합니다.
        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // 테스트 케이스
        int[] arr1 = {1, 1, 3, 3, 0, 1, 1};
        int[] result1 = sol.solution(arr1);
        for (int i : result1) {
            System.out.print(i + " ");
        }
        System.out.println();

        int[] arr2 = {4, 4, 4, 3, 3};
        int[] result2 = sol.solution(arr2);
        for (int i : result2) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
