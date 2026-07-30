class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j] == '1'){
                    count++;
                    grid[i][j] = '2';
                    visit(grid, i, j);
                }
            }
        }

        return count;
    }

    private void visit(char[][] grid, int i, int j){
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for(int[] dir:dirs){
            int x = i + dir[0];
            int y = j + dir[1];
            if(x>=0 && x < grid.length && y >= 0 && y < grid[x].length && grid[x][y] == '1'){
                grid[x][y] = '2';
                visit(grid, x, y);
            }
        }
    }
}
