package com.jvue.backend.util.BinaryTree;

public interface Tree {
    public Node find(int key);
    public boolean insert(int key);
    public boolean delete(int key);
    public Node findMax();
    public Node findMin();
    public void infixOrder(Node current);
    public void preOrder(Node current);
    public void postOrder(Node current);
}
