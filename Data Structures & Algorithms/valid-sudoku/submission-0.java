class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> cols = new HashMap<>();
        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<Integer, Set<Character>> grids = new HashMap<>();

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if(board[i][j] == '.'){
                    continue;
                }
                Set<Character> col = cols.getOrDefault(j, new HashSet<>());
                Set<Character> row = rows.getOrDefault(i, new HashSet<>());
                Set<Character> grid = grids.getOrDefault(getGrid(i, j), new HashSet<>());
                if(row.contains(board[i][j]) || col.contains(board[i][j]) || grid.contains(board[i][j])){
                    return false;
                }

                row.add(board[i][j]);
                col.add(board[i][j]);
                grid.add(board[i][j]);
                rows.put(i, row);
                cols.put(j, col);
                grids.put(getGrid(i, j), grid);
            }
        }

        return true;
    }

    private int getGrid(int i, int j){
        if(i<3){
            if(j<3){
                return 0;
            }else if(j<6){
                return 1;
            }else if(j<9){
                return 2;
            }
        }else if(i<6){
            if(j<3){
                return 3;
            }else if(j<6){
                return 4;
            }else if(j<9){
                return 5;
            }
        }else if(i<9){
            if(j<3){
                return 6;
            }else if(j<6){
                return 7;
            }else if(j<9){
                return 8;
            }
        }

        throw new RuntimeException();
    }
}
