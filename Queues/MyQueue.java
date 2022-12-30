package Queues;

public class MyQueue {
    int[] queue;
    int frontIndex;
    int backIndex;
    int count;

    public MyQueue(int size){
        this.count = 0;
        queue = new int[size];
        frontIndex = 0;
        backIndex = 0;
    }


    public void enqueue(int x){
        if(isFull()) throw new IllegalStateException();
        queue[backIndex] = x;
        backIndex = (backIndex+1) % queue.length;
        count++;
    }

    public int dequeue(){
        if(isEmpty()) throw new IllegalStateException();
        int temp = queue[frontIndex];
        queue[frontIndex] = 0;
        frontIndex = (frontIndex+1)% queue.length;
        count--;
        return temp;
    }
    
    public int peek(){
        if(isEmpty()) throw new IllegalStateException();
        return queue[frontIndex];
    }

    public boolean isEmpty(){
        if(count==0) return true;
        return false;
    }
    public boolean isFull(){
        if(count == queue.length) return true;
        else return false;
    }

    public String toString(){
        String ans = "";
        for(int i=0; i<queue.length; i++){
            ans += queue[i]+ " ";
        }
        return ans;
    }


    public static void main(String[] args) {
        MyQueue queue1 = new MyQueue(5);
        //queue does not expand: uses circular array

        queue1.enqueue(1);
        queue1.enqueue(2);
        queue1.enqueue(3);
        queue1.dequeue();
        queue1.dequeue();
        queue1.enqueue(1);
        queue1.enqueue(2);
        queue1.enqueue(3);
        queue1.enqueue(1);
        queue1.dequeue();
        queue1.dequeue();
        queue1.dequeue();
        


        System.out.println(queue1);
    }
}
