class Node{
    Node next;
    Node prev;
    int val;
    int minSoFar = Integer.MAX_VALUE;
    Node(int value){
        this.val = value;
    }
}
class MinStack {
    Node top;
    int min = Integer.MAX_VALUE;

    public MinStack() {
        top = new Node(0);
    }
    
    public void push(int value) {
        top.next = new Node(value);
        top.next.prev = top;
        top = top.next;
        top.minSoFar = Math.min(top.prev.minSoFar, value);
    }
    
    public void pop() {
        top = top.prev;
    }
    
    public int top() {
        return top.val;
    }
    
    public int getMin() {

        return top.minSoFar;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */