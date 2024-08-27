class Solution{
    public:
    long long findMinDiff(vector<long long> a, long long n, long long m){
        sort(a.begin(),a.end());
        
        long long int minimum = INT_MAX;
        int i = 0;
        int j = m-1;
        while (j<n){
            long long int diff = a[j] - a[i];
            minimum = min(minimum, diff);
            i++;
            j++;
        }
        
        return minimum;
    
    }   
}