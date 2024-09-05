# 225. Implement Stack using Queues

[Go to the problem on Leetcode](https://leetcode.com/problems/implement-stack-using-queues/submissions/1379749613/)

## Intuition
The task is to create a stack using two queues. A stack is a data structure that follows the **Last In, First Out (LIFO)** principle, where the last element you add is the first one to be removed. In contrast, a queue follows the **First In, First Out (FIFO)** principle. To simulate a stack using queues, we need to cleverly manipulate the elements in the queue to ensure that we can access the most recently added element first.

## Approach
We are using two queues (`q1` and `q2`) to simulate the behavior of a stack. Here's how each operation works:

1. **Push operation (`push`)**: We always add the new element (`x`) to `q1`. If `q2` already has elements, we move all of them to `q1`. This ensures that the newly added element is at the front of the queue (which is similar to the top of the stack).

2. **Pop operation (`pop`)**: To remove the top element (the most recent element added), we first move all elements from `q1` to `q2` one by one, until only one element is left in `q1`. This last element in `q1` is the top of the stack, so we remove and return it. We then move all the elements back from `q2` to `q1`.

3. **Top operation (`top`)**: The top operation is similar to `pop`. We move all elements from `q1` to `q2` except the last one, which represents the top of the stack. We retrieve this last element, but instead of removing it, we return it and add it back to `q1` to maintain the structure.

4. **Empty operation (`empty`)**: We simply check if both `q1` and `q2` are empty. If they are, the stack is empty.

## Complexity
The main idea of this approach is to always move elements between two queues in such a way that the last inserted element is easily accessible, just like the top of a stack. This ensures the operations mimic the behavior of a stack, even though we're using queues underneath.

### Time complexity:
- **Push**: O(n), because we may have to move all elements from `q2` to `q1` to maintain the correct order.
- **Pop**: O(n), since we have to transfer elements from `q1` to `q2` to access the top element.
- **Top**: O(n), similar to `pop`, as we need to access the top element by moving elements between the two queues.
- **Empty**: O(1), as we only check if both queues are empty.

### Space complexity:
- O(n), where `n` is the number of elements in the stack. We are using two queues, each potentially holding up to `n` elements.

## Code

```java
class MyStack {

    private final Queue<Integer> q1;
    private final Queue<Integer> q2;

    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }
    
    public void push(int x) {
        if (!q2.isEmpty()){
            while(!q2.isEmpty()){
                q1.add(q2.remove());
            }
        }
        q1.add(x);
    }
    
    public int pop() {
        while (!q1.isEmpty()){
            q2.add(q1.remove());
        }
        while (q2.size() > 1){
            q1.add(q2.remove());
        }
        return q2.remove();
    }
    
    public int top() {
        while (!q1.isEmpty()){
            q2.add(q1.remove());
        }
        while (q2.size() > 1){
            q1.add(q2.remove());
        }
        int t = q2.peek();
        q1.add(q2.remove());
        return t;  
    }
    
    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
    }
}