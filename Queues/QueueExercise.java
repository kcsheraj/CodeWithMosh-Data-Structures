package Queues;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class QueueExercise {
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

    public static Queue<Integer> reverseFirstKElements(Queue<Integer> queue, int k){
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<k;i++){//put first k elements into a stack
            stack.add(queue.remove());
        }
        while(!stack.isEmpty()){//enqueue contents of stack at back of queue
            queue.add(stack.pop());
        }

        for(int i=0; i< queue.size()-k; i++){//add the front of queue to back up to len-k
            queue.add(queue.poll());
        }

        return queue;
    }


    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(10);
        queue.add(20);
        queue.add(30);
        reverse(queue);

        Queue<Integer> queue2 = new ArrayDeque<>();
        queue2.add(10);
        queue2.add(20);
        queue2.add(30);
        queue2.add(40);
        queue2.add(50);
 
        queue2 = reverseFirstKElements(queue2,3);
        
        System.out.println();
    }
}
