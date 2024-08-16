class Solution {
    public void setZeroes(int[][] matrix) {
        //Marker Technique
        //Let's take first row and column as a marker
        boolean x = false;
        boolean y = false;

        //Check first row has 0s
        for (int i=0; i<matrix[0].length; i++){
            if (matrix[0][i] == 0){
                x = true;
            }
        }

        //Check first column has 0s
        for (int i=0; i<matrix.length; i++){
            if (matrix[i][0] == 0){
                y = true;
            }
        }

        //markers
        for (int i=1; i<matrix.length; i++){
            for (int j=1; j<matrix[i].length; j++){
                if (matrix[i][j] == 0){
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        //According markers, make relevant rows and columns zeroes
        //columns
        for (int i=1; i<matrix[0].length; i++){
            if (matrix[0][i] == 0){
                for(int j=1; j<matrix.length; j++){
                    matrix[j][i] = 0;
                }
            }
        }

        // rows
        for (int i=1; i<matrix.length; i++){
            if (matrix[i][0] == 0){
                for(int j=1; j<matrix[i].length; j++){
                    matrix[i][j] = 0;
                }
            }
        }

        //According to x and y fill 1st row and 1st columns
        if (x){
            for (int i=0; i<matrix[0].length; i++){
                matrix[0][i] = 0;
            }
        }

        if (y){
            for (int i=0; i<matrix.length; i++){
                matrix[i][0] = 0;
            }
        }
        
    }
}
