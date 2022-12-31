package Queues;

import java.util.Arrays;

public class MyPriorityQueue {
  private int[] queue = new int[5];
  private int count;

  // O(n)
  public void add(int item) {
    if(count == queue.length) throw new IllegalStateException();

    int i = shiftItemsToInsert(item);
    queue[i] = item;
    count++;
  }

  public boolean isFull(){
    return count == queue.length;
  }

  public int shiftItemsToInsert(int item){
    int i;//index to add
    for(i=count-1; i>=0; i--){
        if(queue[i]>item){//shift
            queue[i+1] = queue[i];
        }
        else{//found
         break;
        }
    }
    return i+1;
  }

  public int remove(){//since piroity: assume you wnat to remove largetst to smallest;
    if(isEmpty()) throw new IllegalStateException();
    return queue[--count];
  }

  public boolean isEmpty(){
    return count == 0;
  }

  public String toString() {
    return Arrays.toString(queue);
  }


  public static void main(String[] args) {
    //created a priotityQueue that uses an array
    //numbers inserted in queue least to greatest.
    //remove method removes from end of queue however(greatest to least)
    MyPriorityQueue queue1 = new MyPriorityQueue();
    
    queue1.add(3);
    queue1.add(2);
    queue1.add(4);
    queue1.add(1);
    queue1.add(5);
    System.out.println(queue1);

  }
}



