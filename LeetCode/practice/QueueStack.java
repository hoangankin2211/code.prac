import java.util.*;
public class QueueStack {
        
}

class MyQueue {

    final Stack<Integer> stack1;
    final Stack<Integer> stack2;

    public MyQueue() {
        stack1 = new Stack();
        stack2 = new Stack();
    }
    
    public void push(int x) {
        stack2.clear();
        stack2.push(x);
        stack1.forEach(stack2::push);
        
        stack1.clear();
        stack2.forEach(stack1::push);
    }
    
    public int pop() {
        stack1.pop();
        return stack2.pop();
    }
    
    public int peek() {
        return stack2.peek();
    }
    
    public boolean empty() {
        return stack2.isEmpty();
    }
}
