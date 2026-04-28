class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int l=0;
        int r=matrix.length-1;
        while(r>l){
            int m = l + (r-l+1)/2;
            if(matrix[m][0] == target){
                return true;
            } else if(target > matrix[m][0]){
                l = m;
            }else {
                r = m-1;
            }
        }

        int k = l;
        l = 0;
        r = matrix[k].length-1;
        while(r>l){
            int m = l + (r-l+1)/2;
            if(matrix[k][m] == target){
                return true;
            }else if(target > matrix[k][m]){
                l = m;
            }else{
                r=m-1;
            }
        }

        return matrix[k][l] == target;
    }
}
