package BinaryTrees;
public class MyBinaryTree {
    private Node rootNode;


    public void insert(int value){
        if(rootNode==null){//if tree was empty
            rootNode = new Node(value);
        }
        else{
            Node temp = rootNode;
            
            while(true){
                if(value>temp.value){//go to right
                    if(temp.rightChild==null){//if no right child insert
                        temp.rightChild = new Node(value);
                        return;
                    }
                    else{
                        temp = temp.rightChild;
                    }
                }
                else{//go to left
                    if(temp.leftChild==null){//if no left child insert
                        temp.leftChild = new Node(value);
                        return;
                    }
                    else{
                        temp = temp.leftChild;
                    }

                }
            }

        }
    }

    public boolean find(int value){
        Node temp = rootNode;
            while(temp != null){
                if(value>temp.value){
                    temp = temp.rightChild;
                }
                else if(value<temp.value){
                    temp = temp.leftChild;
                }
                else{
                    return true;
                }
            }

            return false;
    }

    public void traversePreOrder(){
        traversePreOrder(rootNode);
    }
    private void traversePreOrder(Node root){
        //root, left, right
        if(root==null) return;
        System.out.println(root.value);
        traversePreOrder(root.leftChild);
        traversePreOrder(root.rightChild);
    }

    public void traverseInOrder(){
        traverseInOrder(rootNode);
    }
    private void traverseInOrder(Node root){
                // left, root, right
                if(root==null) return;
                traverseInOrder(root.leftChild);
                System.out.println(root.value);
                traverseInOrder(root.rightChild);
    }

    public void traversePostOrder(){
        traversePostOrder(rootNode);
    }
    private void traversePostOrder(Node root){
                // left, right, root
                if(root==null) return;
                traversePostOrder(root.leftChild);
                traversePostOrder(root.rightChild);
                System.out.println(root.value);
    }
    
    //height is the steps from root node to furthest leaf
    public int height(){
        return height(rootNode);
    }
    private int height(Node root){//individual leaf counts as height of 0
        if(root==null) return -1;
        if(root.leftChild == null && root.rightChild == null){//if leaf
            return 0;
        }
        return 1+Math.max(height(root.leftChild), height(root.rightChild));
    }

    public int minOfNonOrderedBinaryTree(){
        return minOfNonOrderedBinaryTree(rootNode);
    }
    private int minOfNonOrderedBinaryTree(Node root){
        if(root.leftChild==null && root.rightChild==null) return root.value;

        int lr = Math.min(minOfNonOrderedBinaryTree(root.leftChild),
                        minOfNonOrderedBinaryTree(root.rightChild));
        return Math.min(root.value, lr);
    }
 
    public boolean equals(MyBinaryTree otherTree){
        if(otherTree==null) return false;
        return traversePostOrder(rootNode,otherTree.rootNode);
    }
    private boolean traversePostOrder(Node root, Node otherRoot){
        // left, root, right
        if(root==null && otherRoot == null) return true;
        if(root==null || otherRoot == null) return false;
        if(root.value != otherRoot.value) return false;

        if(root!=null && otherRoot!=null){
        return traversePostOrder(root.leftChild,otherRoot.leftChild) && traversePostOrder(root.rightChild,otherRoot.rightChild);
        }

        return false;
    }
    private class Node{
        private int value;
        private Node leftChild;
        private Node rightChild;
        public Node(int value){
            this.value = value;
        }
    }

    public static void main(String[] args) {
        MyBinaryTree tree = new MyBinaryTree();
        tree.insert(7);
        tree.insert(4);



        System.out.println(tree.find(6));
        tree.traversePreOrder();
        System.out.println();
        tree.traverseInOrder();
        System.out.println();
        tree.traversePostOrder();
        System.out.println();

        System.out.println(tree.height());

        //System.out.println(tree.minOfNonOrderedBinaryTree());

        MyBinaryTree tree2 = new MyBinaryTree();
        tree2.insert(7);


        System.out.println(tree.equals(tree2));

    }
    
}
