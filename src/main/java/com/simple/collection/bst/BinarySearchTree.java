package com.simple.collection.bst;


import java.util.ArrayDeque;
import java.util.Queue;

public class BinarySearchTree <Key extends Comparable<Key>, Value>  implements BST<Key, Value> {

    Node root;

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Key key) {
        return this.get(key) != null;
    }

    @Override
    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if(x == null) {
            return 0;
        }
        return x.count;
    }

    @Override
    public Value get(Key key) {
        Node x = root;
        while (x != null) {
            int cmp = key.compareTo(x.key);

            if(cmp < 0) {
                x = x.left;
            } else if(cmp > 0) {
                x = x.right;
            }else if(cmp == 0) {
                return x.value;
            }
        }
        return null;
    }

    public Node get(Node x, Key key) {
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if(cmp < 0) {
                x = x.left;
            } else if(cmp > 0) {
                x = x.right;
            }else if(cmp == 0) {
                return x;
            }
        }
        return null;
    }

    @Override
    public void put(Key key, Value val) {
       root =  this.put(root, key, val);
    }

    private Node put(Node x, Key key, Value value) {
        if(x == null) {
            return new Node(key, value, 1);
        }
        int cmp = key.compareTo(x.key);

        if(cmp < 0) {
            x.left = put(x.left, key, value);
        } else if(cmp > 0) {
            x.right = put(x.right, key, value);
        } else if(cmp == 0) {
            x.value = value;
        }
        x.count = 1 + size(x.left) + size(x.right);
        return x;
    }

    @Override
    public void deleteMin() {
        root = deleteMin(root);
    }

    private Node deleteMin (Node x) {
        if(x.left == null) {
            return x.right;
        }

       x.left = deleteMin(x.left);
       x.count = 1 + size(x.left) + size(x.right);
        return x;
    }

    @Override
    public void deleteMax() {
        root = deleteMax(root);
    }

    private Node deleteMax (Node x) {
        if(x.right == null) {
            return x.left;
        }

        x.right = deleteMax(x.right);
        x.count = 1 + size(x.left) + size(x.right);
        return x;
    }

    @Override
    public Key min() {
        if(root == null) {
            return null;
        }

        return min(root).key;
    }

    private Node min(Node x) {
        if(x.left == null) {
            return x;
        }
        return min(x.left);
    }

    @Override
    public Key max() {
        if(root == null) {
            return null;
        }
        return max(root).key;
    }

    private Node max(Node x) {
        if(x.right == null) {
            return x;
        }
        return max(x.right);
    }

    @Override
    public int rank(Key key) {
        return rank(key, root);
    }

    private int rank(Key key, Node x) {
        if(x == null) {
            return  0;
        }
        int cmp = key.compareTo(x.key);

        if(cmp < 0) {
            return rank(key, x.left);
        } else if(cmp > 0) {
            return 1 + size(x.left) + rank(key, x.right);
        }
        return size(x.left);
    }

    //TODO: replace simple collections queue
    @Override
    public Iterable<Key> keys() {
        Queue<Key> q = new ArrayDeque<>();
        inorder(root,q);
        return q;
    }

    private void inorder(Node x, Queue<Key> q) {
        if(x == null) {
            return;
        }
        inorder(x.left, q);
        q.offer(x.key);
        inorder(x.right, q);
    }

    @Override
    public Iterable<Key> keys(Key lo, Key hi) {
        return null;
    }

    @Override
    public int size(Key lo, Key hi) {
        return 0;
    }

    @Override
    public Key floor(Key key) {
        Node x = floor(root, key);
        if (x == null) {
            return null;
        }
        return x.key;
    }

    private Node floor(Node x, Key key) {
        if(x == null) {
            return  null;
        }
        int cmp = key.compareTo(x.key);
        if(cmp == 0) {
            return x;
        }
        if(cmp < 0 ) {
            return floor(x.left, key);
        }
        Node t = floor(x.right, key);
            if(t != null) {
                return t;
            } else {
                return x;
            }

    }

    @Override
    public Key ceiling(Key key) {
        Node x = ceiling(root, key);
        if (x == null) {
            return null;
        }
        return x.key;
    }

    private Node ceiling(Node x, Key key) {
        if(x == null) {
            return  null;
        }
        int cmp = key.compareTo(x.key);
        if(cmp == 0) {
            return x;
        }
        if(cmp > 0 ) {
            return ceiling(x.right, key);
        }
        Node t = ceiling(x.left, key);
        if(t != null) {
            return t;
        } else {
            return x;
        }

    }


    @Override
    public void delete(Key key) {

        root = delete(root, key);
    }

    private Node delete (Node x, Key key) {
        if(x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if(cmp < 0) {
            x.left = delete(x.left, key);
        } else if(cmp > 0) {
            x.right = delete(x.right, key);
        } else {
            if(x.right == null) {
                return x.left;
            }

            Node t = x;
            x = min(t.right);
            x.right = deleteMin(x.right);
            x.left = t.left;
        }

        x.count = size(x.left) + size(x.right) + 1;

        return x;
    }



    private class Node {
        private Key key;
        private Value value;
        private Node left, right;
        int count;

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
        }

        public Node(Key key, Value value, int count) {
            this.key = key;
            this.value = value;
            this.count = count;
        }
    }
}
