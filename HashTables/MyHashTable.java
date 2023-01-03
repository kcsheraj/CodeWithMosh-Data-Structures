package HashTables;

import java.util.LinkedList;

public class MyHashTable {
    LinkedList<HashEntry>[] hashTable;
    int size;
    public MyHashTable(int size){
        hashTable = new LinkedList[size];
        this.size = size;
    }
    public void put(int k, String v){
        int index = hash(k);//get position to insert in hashTable
        if(hashTable[index]==null){
            hashTable[index] = new LinkedList<HashEntry>();
        }
        LinkedList<HashEntry> list  = hashTable[index];//get list
        for(HashEntry x: list){//check for duplicate keys
            if(x.key==k){
                x.key = k;//update key value if duplicate
                return;
            }
        }
        list.add(new HashEntry(k, v));//else add entry to list
    }
    public String get(int k){
        int index = hash(k);
        if(hashTable[index]==null) return "not found";
        LinkedList<HashEntry> list = hashTable[index];
        for(HashEntry x: list){
            if(x.key==k){
                return x.value;
            }
        }
        
        return "not found";
    }
    public String remove(int k){
        int index = hash(k);
        if(hashTable[index]==null) return "not found";
        LinkedList<HashEntry> list = hashTable[index];
        for(HashEntry x: list){
            if(x.key==k){
                list.remove(x);
                return ""+k;
            }
        }
        return "not found";
    }
    private int hash(int k){
        return k%size;
    }

    class HashEntry{
        int key;
        String value;
        public HashEntry(int k,String v){
            key = k;
            value = v;
        }
    }
    public static void main(String[] args) {
        //use chaining for collisions
        MyHashTable x = new MyHashTable(5);
        x.put(10, "Messi");

        System.out.println(x.get(1));
        System.out.println(x.remove(10));



    }
}
