class Solution {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (dfs(board, word, row, col, 0)) {
                    return true;
                }
            }
        }

        return false;
    }
    
    private boolean dfs(char[][] board, String word, int row, int col, int start) {
        if (start == word.length()) {
            return true;
        }

        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] != word.charAt(start)) {
            return false;
        }

        char tmp = board[row][col];
        board[row][col] = '#';
        boolean res = dfs(board, word, row + 1, col, start + 1) ||
                      dfs(board, word, row - 1, col, start + 1) ||
                      dfs(board, word, row, col + 1, start + 1) ||
                      dfs(board, word, row, col - 1, start + 1);

        board[row][col] = tmp;
        return res;
    }
}

// If N is the total number of cells and L is the length of the word
// Time complexity - O(N * 3^L)
// Space complexity - O(L)
