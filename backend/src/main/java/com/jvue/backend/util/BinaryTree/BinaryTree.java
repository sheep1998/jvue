package com.jvue.backend.util.BinaryTree;

public class BinaryTree implements Tree {
    private Node root;

    public Node getRoot(){
        return root;
    }

    @Override
    public Node find(int key) {
        Node current = root;
        while(current != null){
            if(current.getData()>key){
                current = current.getLeftChild();
            }
            else if(current.getData()<key){
                current = current.getRightChild();
            }
            else{
                return current;
            }
        }
        return null;
    }

    @Override
    public boolean insert(int key) {
        Node newNode = new Node(key);
        if(root == null){
            root = newNode;
            return true;
        }
        else{
            Node current = root;
            Node parentNode = null;
            while(current!=null){
                parentNode = current;
                if(current.getData()>key){
                    current = current.getLeftChild();
                    if(current==null){
                        parentNode.setLeftChild(newNode);
                        return true;
                    }
                }
                else{
                    current = current.getRightChild();
                    if(current==null){
                        parentNode.setRightChild(newNode);
                        return true;
                    }
                }
            }
            return false;
        }
    }

    public Node getSuccessor(Node delNode){
        Node successorParent = delNode;
        Node successor = delNode;
        Node current = delNode.getRightChild();
        while(current!=null){
            successorParent = successor;
            successor = current;
            current = current.getLeftChild();
        }
        if(successor!=delNode.getRightChild()){
            successorParent.setLeftChild(successor.getRightChild());
            successor.setRightChild(delNode.getRightChild());
        }
        return successor;
    }

    @Override
    public boolean delete(int key) {
        Node current = root;
        Node parent = root;
        boolean isLeftChild = false;
        while(current.getData()!=key){
            parent = current;
            if(current == null){
                return  false;
            }
            if(current.getData()>key){
                isLeftChild = true;
                current = current.getLeftChild();
            }
            else{
                isLeftChild = false;
                current = current.getRightChild();
            }
        }
        if(current.getLeftChild()==null&&current.getRightChild()==null){
            if(current==root){
                root = null;
            }
            else if(isLeftChild){
                parent.setLeftChild(null);
            }
            else {
                parent.setRightChild(null);
            }
            return true;
        }
        else if(current.getLeftChild()==null&&current.getRightChild()!=null){
            if(current==root){
                root=current.getRightChild();
            }
            else if(isLeftChild){
                parent.setLeftChild(current.getRightChild());
            }
            else{
                parent.setRightChild(current.getRightChild());
            }
            return true;
        }
        else if(current.getLeftChild()!=null&&current.getRightChild()==null){
            if(current==root){
                root=current.getLeftChild();
            }
            else if(isLeftChild){
                parent.setLeftChild(current.getLeftChild());
            }
            else{
                parent.setRightChild(current.getLeftChild());
            }
            return true;
        }
        else{
            Node successor = getSuccessor(current);
            if(current == root){
                root = successor;
            }
            else if(isLeftChild){
                parent.setLeftChild(successor);
            }
            else{
                parent.setRightChild(successor);
            }
            successor.setLeftChild(current.getLeftChild());
            return true;
        }
    }

    @Override
    public Node findMax() {
        Node current = root;
        Node maxNode = current;
        while(current!=null){
            maxNode = current;
            current = current.getRightChild();
        }
        return maxNode;
    }

    @Override
    public Node findMin() {
        Node current = root;
        Node minNode = current;
        while(current!=null){
            minNode = current;
            current = current.getLeftChild();
        }
        return minNode;
    }

    @Override
    public void infixOrder(Node current) {
        if(current!=null){
            infixOrder(current.getLeftChild());
            System.out.println(current.getData()+" ");
            infixOrder(current.getRightChild());
        }
    }

    @Override
    public void preOrder(Node current) {
        if(current!=null){
            System.out.println(current.getData()+" ");
            preOrder(current.getLeftChild());
            preOrder(current.getRightChild());
        }
    }

    @Override
    public void postOrder(Node current) {
        if(current!=null){
            postOrder(current.getLeftChild());
            postOrder(current.getRightChild());
            System.out.println(current.getData()+" ");
        }
    }
}
