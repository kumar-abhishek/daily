/*
155. Min Stack
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.

*/
//accepted
public class MinStack {
    private Stack<Integer> s1, s2;

    /** initialize your data structure here. */
    public MinStack() {
        s1 = new Stack<Integer>();
        s2 = new Stack<Integer>(); // keeps local mins
    }
    
    public void push(int x) {
        if(!s2.isEmpty()){ 
            int t = s2.peek(); 
            if(t >= x) s2.push(x); // equals was important
        } else {
            s2.push(x);
        }
         s1.push(x);
    }
    
    public void pop() {
        int x = s1.peek();
        s1.pop();
        if(x == s2.peek()) s2.pop();
    }
    
    public int top() {
        return s1.peek();
    }
    
    public int getMin() {
        return s2.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
