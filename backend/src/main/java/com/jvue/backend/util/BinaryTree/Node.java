package com.jvue.backend.util.BinaryTree;

import lombok.Data;

@Data
public class Node {
    private int data;
    private Node leftChild;
    private Node rightChild;
    private boolean isDelete;

    public Node(int data){
        this.data = data;
    }

    public void display(){
        System.out.println(data);
    }
}
