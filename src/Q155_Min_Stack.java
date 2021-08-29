//import java.util.Deque;
//import java.util.LinkedList;
//
///*
//Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
//
//Implement the MinStack class:
//
//MinStack() initializes the stack object.
//void push(val) pushes the element val onto the stack.
//void pop() removes the element on the top of the stack.
//int top() gets the top element of the stack.
//int getMin() retrieves the minimum element in the stack.
//
//
//Example 1:
//
//Input
//["MinStack","push","push","push","getMin","pop","top","getMin"]
//[[],[-2],[0],[-3],[],[],[],[]]
//
//Output
//[null,null,null,null,-3,null,0,-2]
//
//Explanation
//MinStack minStack = new MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.getMin(); // return -3
//minStack.pop();
//minStack.top();    // return 0
//minStack.getMin(); // return -2
//
//
//Constraints:
//
//-231 <= val <= 231 - 1
//Methods pop, top and getMin operations will always be called on non-empty stacks.
//At most 3 * 104 calls will be made to push, pop, top, and getMin.
// */
//public class Q155_Min_Stack {
//    private Deque<Integer> stack;
//    private Deque<Integer> minStack;
//
//    public MinStack() {
//        stack = new LinkedList<Integer>();
//        minStack = new LinkedList<Integer>();
//
//    }
//
//    public void push(int val) {
//        stack.offerFirst(val);
//        //when value <=current min value in stack, need to push the value to minStack
//        if (minStack.isEmpty() || val <= minStack.peekFirst()) {
//            minStack.offerFirst(val);
//        }
//    }
//
//    public void pop() {
//        if (stack.isEmpty()) {
//            return;
//        }
//        Integer result = stack.pollFirst();
//        //when popped value is the same as top value of minStack, the value need to be popped from minStack as well
//        if (minStack.peekFirst().equals(result)) {
//            minStack.pollFirst();
//        }
//        return;
//    }
//
//
//    public int top() {
//        if (stack.isEmpty()) {
//            return -1;
//        }
//        return stack.peekFirst();
//
//    }
//
//    public int getMin() {
//        if (minStack.isEmpty()) {
//            return -1;
//        }
//        return minStack.peekFirst();
//    }
//}}
//}
