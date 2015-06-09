package p21;


/**
 *  This program produces a binary tree of strings
 */
public class BinarySearchTree {
	   Node root = null;  

    /**
     * An object of type Node represents one node in a binary tree of strings with a value of null
     */
    public class Node {
        String key;      // The data in this node.
        Object value;
        Node left;    // Pointer to left subtree.
        Node right;   // Pointer to right subtree.
        Node parent;
        int height, bfactor; 
        
        Node(String str, Object val) {
                // Constructor, left and right are null
        	height = bfactor = 0;
            key = str;
            value = val;
        }
    }  
 
    public boolean hasLeft(){ //checks to see if there is a LeftNode
		return !root.left.equals(null); //boolean statement
	}
	
	public boolean hasRight(){ //checks to see if there is a right ndoe
		return !root.right.equals(null);	 
	}
	
	public boolean isLeaf(){ //check to see if it is a leaf
		return ((root.right.equals(null)) && (root.left.equals(null)));
	}
	
	public boolean isEmpty(){ //check to see if it is Empty if the root is null
	return root.equals(null);
	}
	
	public boolean isRoot(){
		return ((root.right.equals(null))  //if everything is null
				&& (root.left.equals(null))  //it is a root
				&& (root.equals(null)));
	}
	
	public boolean isLeftChild(){ //if it is a left child
		return root.left.equals(root.left);
	}
	public boolean isRightChild(){ //if it is a right child
		return root.right.equals(root.right);
	}
	public boolean hasParent(){ //else is an ORPHAN LIKE BATMAN
		return !root.equals(null);
	}

	public String findMin(){
		Node current = root; //pointer
		while(current.left != null){ //goes all the way to the left
			current = current.left;
		}
	return current.key; //returns current key
	}
	
    public void addRoot(String key, Object value){
		if (root == null) {// The tree is empty. Make a root
		root = new Node(key, value); //root becomes new
		}
	}
    
    /**
     * Add the item to the binary sort tree 
     */
    public void insert(String key, Object value) {
        if (root == null) { //if the root is null
               addRoot(key, value); //add the root, even though this is redundant, its a check
        }
        Node x;  // Runs down the tree to find a place for newItem.
        x = root;   // Start at the root.
        while (true){//because x is always going to be not null
            if (key.compareTo(x.key) < 0 ) { //compare the keys
                    //This goes to the left, or down
                if (x.left == null) { 
                    x.left = new Node(key, value);
                    return;  
                }else
                    x = x.left; //put to the left 
            }else{// This adds to the right tree if the key string is bigger
                if(x.right == null) {
                    x.right = new Node(key, value);
                    return;  //needed or else heap will fall
                }else
                    x = x.right;
            }
        } 
    }  
    /*
     * This method needs a lot of explanation
     */
    public String delete(String key){
    	Node x; //initialize x which is a pointer
    	if(root == null) { //if root is null, there's nothing
    		throw new NullPointerException("There is no  root in this tree");
    	}if(key.compareTo(root.key) < 0){ //if the key of root is less than 0
    			x = root; //root becomes x
    	}else{
    		findSuccessor(root.key); //find the successor of the key
    	}if(root.left != null){ //go to the left
    		x = root.left;
    	}else{ //go to the right
    		x = root.right;
    		}if(x == null){ //if x is null
    			x.parent = root.parent; //parent is root parent
    		}if(root.parent == null){ //root parent is null
    			root = x;
    			}else{
    				if(x == root.left.parent){ //if x root left parent is equal to x
    				root.left.parent = x; //then x is assigned to this
    				}else{
    					root.right.parent = x; //it is assigned to the right parent
    			}if(root.key == key){
    				key = root.key; //key is assigned to root key 
    			}
    		}
    	return root.key; //return what you have
    }
	

    /**
     * Return key is in the BST
     */
    Node findNode(Node root, String key) {
        if (root != null && !key.equals(root.key)) 
        {// Yes, item is in the root node
           root = findNode(root.left, key);
           if (root == null) {// If the item is there, it's in the left
            root = findNode(root.right, key);
           }
        }
        return root;
    } 
    /**
     * Return key is in the BST
     */
    Object search(Node root, String key) {
        if (root == null || key == root.key) {// Yes, item is in the root node
            return root.value;
        }else if (key.compareTo(root.key) < 0) {// If the item is there, it's in the left
            return findNode(root.left, key);
        } else {// If the item occurs, it is in the right 
            return findNode(root.right, key);
        }
    } 
    //first prints from left, then goes to right and does the same
    public void inOrder(Node root, int level){
    	if(root != null){
    		inOrder(root.left, level +1); //adds a level and preints it out from the left
    		for(int i = 0; i < level; i++){
    			System.out.print(" ");
    		}
    		System.out.println(root.key); //adds a lvel and prints it out on the right
    		inOrder(root.right, level +1);
    	}
    }
    public String findSuccessor(String key){
    		if(root.right != null){
    			return findMin();
    		}
    		Node w = root; //.parent
    		while(w != null && root == w.right){ //.equals node.right
    			root = w;
    			w = w.parent; // really w.parent
    }
    		System.out.println(w.key);
    		return w.key;
    	}
    //calculates an individual balance factor
    public int balanceFactor(){
		if(root.bfactor < 0){
			if(root.right.bfactor >0){
				//root.right.rightRotation();
				//root.leftRotation();
			}else{
				//bst.root.leftRotation();
			if(root.bfactor > 0){
				if(root.left.bfactor < 0){
					//root.left.leftRotation();
					//root.rightRotation();
				}else{
					//bst.root.rightRotation();
				}
			}
		}
		}
    	root.bfactor = root.left.height - root.right.height; //calcualtes the balance factor of a node
		return root.bfactor; //returns that balance factor
	}
	
    /**
     * Counts the nodes in a bst
     * @param node is the pointer to tree
     * @output is the number of nodes in the tree.
     */
    public int size(Node root) {
        if (root == null) { //tree is empty
            return 0;
        }else{       
            return 1 + size(root.left) + size(root.right);   //the size is 1 + the left + right #basic
        }
    } 
    //basically what we got on the lectures
    public void leftRotation(){
		Node u = root.parent; 
		Node v = root.right; 
		Node x = v.left; 
		root.right = x; 
		x.parent = root;
		v.left = root;
		root.parent = v;
		if(u != null) {
			if(u.right == null){
				u.right = v;
			}else{
				u.left = v;
			}
			v.parent = u;
		}
	}
    //see leftRotation
	public void rightRotation(){
		Node u = root.parent; 
		Node w = root.right; 
		Node x = w.left; 
		x = w.right; 
		root.parent = w;
		root.left = w;
		x.parent = root;
		if(!u.equals(null)) {
			if(u.left.equals(root)){
				u.left = root;
			}else{
				u.right = w;
			}
			w.parent = u;
		}
	}

	/*
	 * it's a method that gives you the height 
	 */
	public int height(Node current){
	if(root == null){ //if you're at the root or leaf, then 1
		return -1;
	}else{
		return Math.max(height(current.left), height(current.right)) +1; //height is the maximum of both trees + 1
		}
	}
	/*
	 * method that gives you the depth
	 */
	public int depth(Node node){
		if(root == null){ //if node is root, then the depth is 0
			return 0;
		}else{ 
		return 1+ depth(root); //else you must dig deeper
		}
	}
	

	public BinarySearchTree mirrorTree(BinarySearchTree t){ //returns tree but opposite
		return t;
	}
} 