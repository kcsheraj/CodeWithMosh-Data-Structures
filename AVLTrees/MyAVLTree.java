package AVLTrees;
public class MyAVLTree {
    private AVLNode rootNode;

     //insert recursively
     public void insert(int value){
        rootNode = insert(rootNode,value);
     }

     private AVLNode insert(AVLNode node, int value){
        if(node == null){
            return new AVLNode(value);
        }
        if(value<node.value){
            node.leftChild = insert(node.leftChild, value);
        }
        else{
            node.rightChild = insert(node.rightChild, value);
        }
        return node;

    }

    private boolean isLeaf(AVLNode node){
        if(node.leftChild==null && node.rightChild==null){
            return true;
        }
        return false;
    }
    
    private class AVLNode{
        private int value;
        private AVLNode leftChild;
        private AVLNode rightChild;
        public AVLNode(int value){
            this.value = value;
        }
    }
     
    public static void main(String[] args) {
        MyAVLTree tree1 = new MyAVLTree();

        tree1.insert(7);
        tree1.insert(8);
        tree1.insert(4);
        tree1.insert(5);
        tree1.insert(23);
        tree1.insert(21);
        System.out.println();
        
    }
}
