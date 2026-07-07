// Last updated: 7/7/2026, 10:59:40 PM
class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        if (rows == 1) return encodedText;

        int n = encodedText.length();
        int cols = n / rows;

        char[][] grid = new char[rows][cols];

        // Fill matrix row-wise
        int index = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = encodedText.charAt(index++);
            }
        }

        StringBuilder result = new StringBuilder();

        // Traverse diagonally
        for (int j = 0; j < cols; j++) {
            int i = 0, k = j;
            while (i < rows && k < cols) {
                result.append(grid[i][k]);
                i++;
                k++;
            }
        }

        // Remove trailing spaces
        int end = result.length() - 1;
        while (end >= 0 && result.charAt(end) == ' ') {
            end--;
        }

        return result.substring(0, end + 1);
    }
}