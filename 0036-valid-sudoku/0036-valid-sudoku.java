class Solution {
    public boolean isValidSudoku(char[][] board) {

        boolean[][] row = new boolean[9][9];
        boolean[][] col = new boolean[9][9];
        boolean[][] box = new boolean[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                if (board[i][j] == '.')
                    continue;

                int num = board[i][j] - '1';
                int b = (i / 3) * 3 + (j / 3);

                if (row[i][num] || col[j][num] || box[b][num])
                    return false;

                row[i][num] = true;
                col[j][num] = true;
                box[b][num] = true;
            }
        }

        return true;
    }
}