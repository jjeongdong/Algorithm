import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        int answer = 0;

        String[] board = new String[row];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < row; i++) {
            board[i] = br.readLine();
        }

        int min = Integer.MAX_VALUE;

        for (int i = 0; i <= row - 8; i++) {
            for (int j = 0; j <= col - 8; j++) {
                int cnt = getSolution(i, j, board);

                if (cnt < min) min = cnt;
            }
        }


        System.out.println(min);
    }

    public static int getSolution(int startRow, int startCol, String[] board) {
        String[] whiteBoard = {"WBWBWBWB", "BWBWBWBW"};
        int cnt = 0;

        for (int i = 0; i < 8; i++) {
            int row = startRow + i;
            for (int j = 0; j < 8; j++) {
                int col = startCol + j;

                if (!String.valueOf(board[row].charAt(col)).equals(String.valueOf(whiteBoard[i % 2].charAt(j)))) {
                    cnt++;
                }

            }
        }

        return Math.min(cnt, 64 - cnt);
    }

}
