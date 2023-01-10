package AVLTrees;
public class MyAVLTree {
    private AVLNode rootNode;

     //insert recursively
     public void insert(int value){
        insert(rootNode,value);
     }

     private void insert(AVLNode node, int value){
        if(node==null){
            rootNode = new AVLNode(value);
            return;
        }
        if(value>node.value){
            if(node.rightChild==null){
                node.rightChild = new AVLNode(value);
                return;
            }
            insert(node.rightChild, value);
        }
        else{
            if(node.leftChild==null){
                node.leftChild = new AVLNode(value);
                return;
            }
            insert(node.leftChild, value);
        }

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
