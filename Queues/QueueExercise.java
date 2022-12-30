package Queues;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class QueueExercise {
    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(10);
        queue.add(20);
        queue.add(30);

        reverse(queue);
        

    }
    public static void reverse(Queue<Integer> queue){//reverses queue
        //only allowed to use:add,remove,isEmpty methods
        Stack<Integer> stack = new Stack<>();

        while(!queue.isEmpty()){
            stack.push(queue.remove());
        }
        
        while(!stack.isEmpty()){
            queue.add(stack.pop());
        }

        
    }
}
