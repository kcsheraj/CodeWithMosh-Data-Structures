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

        setHeight(node);

        return balance(node); 
    }

    private AVLNode balance(AVLNode node){
        if(isLeftHeavy(node)){
         if(balanceFactor(node.leftChild)<0){
            node.leftChild = rotateLeft(node.leftChild);
         }
          return rotateRight(node);
        }
        else if (isRightHeavy(node)){
            if(balanceFactor(node.rightChild)>0){//if needed right left rotation
                node.rightChild = rotateRight(node.rightChild);
            }
           return rotateLeft(node.leftChild);//always left rotate if right heavy
        }

        return node;//if root was balanced
    }

    private AVLNode rotateLeft(AVLNode node){
        AVLNode newRoot = node.rightChild;
        node.rightChild = newRoot.leftChild;
        newRoot.leftChild = node;
        //reset height of the two nodes
        setHeight(node);
        setHeight(newRoot);

        return newRoot;
    }
    private AVLNode rotateRight(AVLNode node){
        AVLNode newRoot = node.leftChild;
        node.leftChild = newRoot.rightChild;
        newRoot.rightChild = node;
        //reset height of the two nodes
        setHeight(node);
        setHeight(newRoot);

        return newRoot;
    }
    private void setHeight(AVLNode node){
        node.height = Math.max(height(node.leftChild), height(node.rightChild))+1;
    }

    private boolean isLeftHeavy(AVLNode node){
        return balanceFactor(node) > 1;
    }
    private boolean isRightHeavy(AVLNode node){
        return balanceFactor(node) < -1;
    }

    private int balanceFactor(AVLNode node){
        return (node==null)? 0: height(node.leftChild) - height(node.rightChild);
    }

    private int height(AVLNode node){
        if (node==null)
            return -1;
        return node.height;
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
        private int height;
        public AVLNode(int value){
            this.value = value;
        }
    }
     
    public static void main(String[] args) {
        MyAVLTree tree1 = new MyAVLTree();

        tree1.insert(10);
        tree1.insert(3);
        tree1.insert(5);

        System.out.println();
        
    }
}
