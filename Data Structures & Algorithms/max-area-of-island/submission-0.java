class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j] == 1){
                    int[] area = {1};
                    grid[i][j] = 2;
                    findArea(grid, i, j, area);
                    max = Math.max(max, area[0]);
                }
            }
        }

        return max;
    }

    private void findArea(int[][] grid, int i, int j, int[] area){
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for(int[] dir:dirs){
            int x = i + dir[0];
            int y = j + dir[1];
            if(x>=0 && x< grid.length && y>=0 && y<grid[x].length && grid[x][y] == 1){
                area[0]++;
                grid[x][y] = 2;
                findArea(grid, x, y, area);
            }
        }
    }
}
