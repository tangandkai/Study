package com.tang.study.Algorithms.tree;


import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree <Key extends Comparable<Key>, Value>{

    private class Node{
        public Key key;
        public Value value;
        public Node left,right;

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
            left = right = null;
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

    private Node root;      //根节点
    private Integer count;  //树中节点个数

    /**
     * 构造一颗空的二分搜索树
     */
    public BinarySearchTree() {
        this.root = null;
        this.count = 0;
    }

    /**
     * 返回二分搜索树的节点个数
     * @return
     */
    public int size() {
        return count;
    }

    /**
     * 返回二分搜索树是否为空
     * @return
     */
    public boolean isEmpty() {
        return count == 0;
    }

    /**
     * 向二分搜索树中插入一个新的(key, value)数据对
     * @param key
     * @param value
     */
    public void insert(Key key,Value value){
        root = insert(root,key,value);
        System.out.println(root.toString());
    }

    /**
     * 查看二分搜索树中是否存在键key
     * @param key
     * @return
     */
    public boolean containss(Key key){
        return contains(root,key);
    }

    /**
     * 查找二分搜索树中key对应的value
     * @param key
     * @return
     */
    public Value search(Key key){
        return search(root,key);
    }

    /**
     *
     */
    public void LevScan(){
        LevScan(root);
    }
    /**
     * 先序遍历二分查找树
     * @return
     */
    public void preScan(){
        preScan(root);
    }

    /**
     * 查找二分搜索树最小节点的值
     */
    public void minNum(){
        Node node = minNum(root);
        System.out.println(node.key+" "+node.value);
    }

    /**
     * 查找二分搜索树最大节点的值
     */
    public void maxNum(){
        Node node = maxNum(root);
        System.out.println(node.key+" "+node.value);
    }

    /**
     *
     */
    public void removeMinNode(){
        root = removeMinNode(root);
        System.out.println(root.toString());
    }

    public void removeMaxNode(){
        root = removeMaxNum(root);
        System.out.println(root.toString());
    }

    public void remove(Key key){
        root = remove(root,key);
        System.out.println(root.toString());
    }

    private Node remove(Node node,Key key){
        if (node==null){
            return null;
        }
        if (node.key.compareTo(key)<0){
            node.right = remove(node.right,key);
            return node;
        }
        else if (node.key.compareTo(key)>0){
            node.left = remove(node.left,key);
            return node;
        }
        else {
            if (node.left == null){
                Node rightnode = node.right;
                node.right = null;
                count--;
                return rightnode;
            }
            if (node.right==null){
                Node leftnode = node.left;
                node.left = null;
                count--;
                return leftnode;
            }
            Node successor = new Node(minNum(node.right));
            count ++;
            successor.right = removeMinNode(node.right);
            successor.left = node.left;

            node.left = node.right = null;
            count --;
            return successor;
        }
    }
    /**
     * 删除二分搜索树最小节点
     * @param node
     * @returnMin
     */
    private Node removeMinNode(Node node){
        if (node.left==null){
            Node rightNode = node.right;
            node.right = null;
            count--;
            return rightNode;
        }
        node.left = removeMinNode(node.left);
        return node;
    }

    /**
     * 删除二分搜索树最大节点
     * @param node
     * @return
     */
    private Node removeMaxNum(Node node){
        if (node.right==null){
            Node leftNode = node.left;
            count--;
            node.right = null;
            return leftNode;
        }
        node.right = removeMaxNum(node.right);
        return node;
    }
    /**
     * 查找二分搜索树最大节点
     * @param node
     * @return
     */
    private Node maxNum(Node node){
        if (node.right==null){
            return node;
        }
        return maxNum(node.right);
    }
    /**
     * 查找二分搜索树最小节点
     * @param node
     * @return
     */
    private Node minNum(Node node){
        if (node.left==null){
            return node;
        }
        return minNum(node.left);
    }
    /**
     * 从根节点处查找key对应的value
     * @param node
     * @param key
     * @return
     */
    private Value search(Node node,Key key){
        if (node==null)
            return null;
        if (node.key.compareTo(key)==0)
            return node.value;
        else if (node.key.compareTo(key)>0)
            return search(node.left,key);
        else
            return search(node.right,key);
    }
    /**
     * 向以node为根的二分搜索树中, 插入节点(key, value), 使用递归算法
     * 返回插入新节点后的二分搜索树的根
     * @param node
     * @param key
     * @param value
     * @return
     */
    private Node insert(Node node,Key key,Value value){
        if (node == null){
            count++;
            return new Node(key,value);
        }

        if (node.key.compareTo(key)==0){
            node.value = value;
        }
        else if (node.key.compareTo(key)>0){
            node.left = insert(node.left,key,value);
        }
        else
            node.right = insert(node.right,key,value);
        return node;
    }

    /**
     * 查看以node为根的二分搜索树中是否包含键值为key的节点, 使用递归算法
     * @param node
     * @param key
     * @return
     */
    private boolean contains(Node node,Key key){
        if (node==null)
            return false;
        if (node.key.compareTo(key)==0)
            return true;
        else if (node.key.compareTo(key)>0)
            return contains(node.left,key);
        else
            return contains(node.right,key);
    }

    /**
     * 先序遍历二分查找树
     * @param node
     * @return
     */
    private void preScan(Node node){
        if (node !=null){
            Key key = node.key;
            Value value = node.value;
            System.out.println(key+"-->"+value+"\n");
            preScan(node.left);
            preScan(node.right);
        }
    }

    /**
     * 层次遍历二分查找树
     * @param node
     */
    private void LevScan(Node node){
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()){
            Node node1 = queue.remove();
            System.out.println(node1.key);
            if (node1.left != null)
                queue.add(node1.left);
            if (node1.right != null)
                queue.add(node1.right);
        }
    }

    /**
     * 树的最大深度
     * @param node
     * @return
     */
    private int calMaxDepth(Node node){
        if(node==null){return 0;}
//        int leftDepth = calMaxDepth(node.left);
        int rightDepth = calMaxDepth(node.right);
//        System.out.println(leftDepth);
        System.out.println(rightDepth);
//        return Math.max(leftDepth,rightDepth)+1;
        return rightDepth+1;
    }

    public int getMaxDepth(){
        return calMaxDepth(root);
    }


    @Test
    public void test(){
        int N = 10;

        // 创建一个数组，包含[0...N)的所有元素
        Integer[] arr = new Integer[N];
        for(int i = 0 ; i < N ; i ++)
            arr[i] = new Integer(i);

        // 打乱数组顺序
//        for(int i = 0 ; i < N ; i ++){
//            int pos = (int) (Math.random() * (i+1));
//            Integer t = arr[pos];
//            arr[pos] = arr[i];
//            arr[i] = t;
//        }
        BinarySearchTree<Integer,String> bst = new BinarySearchTree<Integer,String>();
        for(int i = 0 ; i < N ; i ++)
            bst.insert(new Integer(arr[i]), Integer.toString(arr[i]));

        // 对[0...2*N)的所有整型测试在二分搜索树中查找
        // 若i在[0...N)之间，则能查找到整型所对应的字符串
        // 若i在[N...2*N)之间，则结果为null
        for(int i = 0 ; i < 2*N ; i ++){
            String res = bst.search(new Integer(i));
            if( i < N )
                assert res.equals(Integer.toString(i));
            else
                assert res == null;
        }
        System.out.println(bst.search(new Integer(7)));
//        bst.preScan();
//        bst.LevScan();
        bst.maxNum();
        bst.minNum();
//        bst.removeMaxNode();
//        bst.removeMinNode();
//        bst.maxNum();
//        bst.minNum();
//        bst.remove(15);

        System.out.println(bst.getMaxDepth());
    }
}
