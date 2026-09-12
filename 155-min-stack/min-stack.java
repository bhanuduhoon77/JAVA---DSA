class Node {
    int val;
    int min;

    public Node(int v, int m) {
        this.val = v;
        this.min = m;
    }
}

class MinStack {

    Stack<Node> stack;

    public MinStack() {
        stack = new Stack<Node>();
    }

    public void push(int value) {

        // If stack is empty
        if (stack.isEmpty()) {
            stack.push(new Node(value, value));
            return;
        }

        // Get top node
        Node nodeTop = stack.peek();

        // Get minimum stored at top
        int minTop = nodeTop.min;

        // If current value becomes new minimum
        if (value < minTop) {
            stack.push(new Node(value, value));
        } 
        else {
            stack.push(new Node(value, minTop));
        }
    }

    public void pop() {
        if (stack.isEmpty()) {
            return;
        }

        stack.pop();
    }

    public int top() {
        if (stack.isEmpty()) {
            return -1;
        }

        Node nodeTop = stack.peek();

        return nodeTop.val;
    }

    public int getMin() {
        if (stack.isEmpty()) {
            return -1;
        }

        Node nodeTop = stack.peek();

        return nodeTop.min;
    }
}