class Solution {
    public boolean exist(char[][] board, String word) {        
        int wordI = 0;
        for(int i =0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if(board[i][j] == word.charAt(wordI)){
                    if(dfs(board, word, wordI, i, j, new HashSet<Pair<Integer, Integer>>()))
                    {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private boolean dfs(final char[][] board, final String word, int wordI, int i, int j, final Set<Pair<Integer, Integer>> visited){
        if(wordI == word.length()){
            return true;
        }

        if(i<0 || j< 0 || i == board.length || j == board[i].length){
            return false;
        }

        if(visited.contains(new Pair(i, j))){
            return false;
        }
  
        if(word.charAt(wordI) != board[i][j]){
            return false;
        }

        visited.add(new Pair<>(i, j));
        System.out.println(word.charAt(wordI));    
        wordI++;
        boolean result = dfs(board, word, wordI, i, j+1, visited) || dfs(board, word, wordI, i, j-1, visited) || dfs(board, word, wordI, i+1, j, visited) || dfs(board, word, wordI, i-1, j, visited);
        visited.remove(new Pair<>(i,j));
        return result;
    }
}
