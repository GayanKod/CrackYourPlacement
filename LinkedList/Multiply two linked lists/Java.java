class Solution {
    public long multiplyTwoLists(Node first, Node second) {
        // Modulo value to avoid overflow
        long MOD = 1000000007;
        
        long firstNum = 0;
        long secondNum = 0;
        
        // Traverse the first linked list
        while (first != null) {
            firstNum = (firstNum * 10 + first.data) % MOD;
            first = first.next;
        }
        
        // Traverse the second linked list
        while (second != null) {
            secondNum = (secondNum * 10 + second.data) % MOD;
            second = second.next;
        }
        
        // Multiply the two numbers and take modulo
        return (firstNum * secondNum) % MOD;
    }
}