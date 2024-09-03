class Solution {
    public int[] countBits(int n) {
        
        int[] arr = new int[n+1];

        for (int i=0; i<=n; i++){
            if (i%2 == 0){
                arr[i] = arr[i/2];
            }else{
                arr[i] = arr[i/2] + 1;
            }
        }

        return arr;
    }

}