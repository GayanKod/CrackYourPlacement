# 232. Implement Queue using Stacks

[Go to the problem on Leetcode](https://leetcode.com/problems/implement-queue-using-stacks/)

## Intuition

A queue is a data structure where elements are added to the back and removed from the front, like standing in line. On the other hand, a stack is like a pile of books where you can only add or remove the top one. The challenge here is to use two stacks to make a queue. This might seem tricky because stacks naturally work in the opposite order of queues, but by using two stacks, we can reverse the order twice, achieving the desired queue behavior.

## Approach

To implement a queue using two stacks:

- **Stacks**: We'll have two stacks, `input` for adding new elements and `output` for removing elements.
- **Push Operation**: When we add an element, we simply push it onto the `input` stack.
- **Pop Operation**: To remove the front element, we'll move all elements from `input` to `output` if `output` is empty, reversing their order. Then, we pop the top of the `output` stack.
- **Peek Operation**: To get the front element, we do the same as in the pop operation, but instead of removing it, we just look at the top of the `output` stack.
- **Empty Check**: The queue is empty if both stacks are empty.

By using this approach, we mimic the behavior of a queue using two stacks.

## Complexity

### Time complexity :
- **Push Operation**: O(1) - Adding an element to the `input` stack is a constant-time operation.
- **Pop Operation**: Average O(1) - In the worst case, we might need to move all elements from `input` to `output`, but each element is moved at most once, so the average time per operation is still constant.
- **Peek Operation**: Average O(1) - Similar to the pop operation, each element is peeked at most once after being moved.
- **Empty Operation**: O(1) - Checking if both stacks are empty is a constant-time operation.

### Space complexity:
- **O(n)** - The space complexity is linear in terms of the number of elements in the queue because all elements are stored in either `input` or `output` stack.

## Code

```java
class MyQueue {

    private final Stack<Integer> input;
    private final Stack<Integer> output;

    public MyQueue() {
        input = new Stack<>();
        output = new Stack<>();
    }
    
    public void push(int x) {
        input.push(x);
    }
    
    public int pop() {
        peek(); // Ensure output stack has the current elements in queue order
        return output.pop();
    }
    
    public int peek() {
        if (output.empty()) {
            while (!input.empty()) {
                output.push(input.pop());
            }
        }   
        return output.peek();  
    }

    public boolean empty() {
        return output.empty() && input.empty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
