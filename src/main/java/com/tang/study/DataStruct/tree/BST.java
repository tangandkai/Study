package com.tang.study.DataStruct.tree;

public class BST<Key extends Comparable<Key>, Value> {

    private class Node{
        public Key key;
        public Value value;
        public Node left,right;

        public int height;
        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
            left = right = null;
            height =1;
        }

        public Node(Node node){
            this.key = node.key;
            this.value = node.value;
            this.left = node.left;
            this.right = node.right;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value=" + value +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    private Node root;
    private int size;

    public BST() {
        root = null;
        size = 0;
    }


    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    private int getHeight(Node node){
        if (node==null)
            return 0;
        return node.height;
    }

    private int getBalanceFactor(Node node){
        if (node==null)
            return 0;
        return getHeight(node.left)-getHeight(node.right);
    }

    private Node add(Node node,Key key,Value value){
        if (node==null){
            size ++;
            return new Node(key,value);
        }
        if (node.key.compareTo(key)>0)
            node.left = add(node.left,key,value);
        else if (node.key.compareTo(key)<0)
            node.right = add(node.right,key,value);
        else
            node.value = value;
        node.height = Math.max(getHeight(node.left),getHeight(node.right));
        int balanceFactor = getBalanceFactor(node);
        //LL
        if (balanceFactor>1 && getBalanceFactor(node.left)>=0)
            return rightRotate(node);
        //RR
        if (balanceFactor<-1 && getBalanceFactor(node.right)<=0)
            return leftRotate(node);
        //LR
        if (balanceFactor>1 && getBalanceFactor(node.left)<0){
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        //RL
        if (balanceFactor<-1 && getBalanceFactor(node.left)>0){
            node.right = leftRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    //平衡因子大于一使用
    private Node rightRotate(Node y){
        Node x = y.left;
        Node t3 = x.right;
        x.right = y;
        y.left = t3;
        y.height = Math.max(getHeight(y.left),getHeight(y.right))+1;
        x.height = Math.max(getHeight(x.left),getHeight(x.right))+1;
        return x;
    }

    //平衡因子小于负一使用
    private Node leftRotate(Node y){
        Node x = y.right;
        Node t2 = x.left;

        x.left = y;
        y.right = t2;
        y.height = Math.max(getHeight(y.left),getHeight(y.right))+1;
        x.height = Math.max(getHeight(x.left),getHeight(x.right))+1;
        return x;
    }

}
