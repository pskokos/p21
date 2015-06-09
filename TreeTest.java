package p21;

import java.util.Scanner;

public class TreeTest {

    public static void main(String[] args) {        
            String item = "";  // The user's input.
            BinarySearchTree bst1 = new BinarySearchTree();
     

                bst1.addRoot("E", null);  // Add user's string to the tree.
                System.out.println("The tree has " + bst1.size(bst1.root) + " items.");
                bst1.insert("A", "bop");  // Add user's string to the tree.
                System.out.println("The tree has " + bst1.size(bst1.root) + " items.");
                bst1.insert("B", "bimp");  // Add user's string to the tree.
                System.out.println("The tree has " + bst1.size(bst1.root) + " items.");
                System.out.println("Contents:");
                bst1.inOrder(bst1.root, 0);

                BinarySearchTree bst = new BinarySearchTree();
        	    //Create a scanner object and a string for storing the input
        	    Scanner scan = new Scanner(System.in);
        	    String cmd;
        	    Object value = null;
        	    //Print the program's commands to the user.
        	    System.out.println("Commands:\n\taddRoot String Object\n\tinsert String Object\n\tfindMin\n\t" +
                  "size\n\tdepth\n\tfindNode\n\tfindSuccessor\n\theight\n\tLeftRotation\n\tRightRotation\n\tbalance\n\tquit");
        	    
        	 
        	    //Loop through, accepting input and printing returned information until quit
        	    while (!(cmd=scan.next()).equalsIgnoreCase("quit"))
        	    {
        	    	if (cmd.equalsIgnoreCase("addRoot"))
        	    	{
        	    		bst.addRoot(scan.next(), value);
        	    	}
        	    	if (cmd.equalsIgnoreCase("insert"))
        	    	{
        	    		bst.insert(scan.next(), value);
        	    	}
        	    	else if (cmd.equalsIgnoreCase("findMin"))
        	    	{
        	    		System.out.println("Min is: "+bst.findMin());
        	    	}
        	    	else if (cmd.equalsIgnoreCase("size"))
        	    	{
        	    		System.out.println("Size: "+ bst.size(bst.root));
        	    	}
        	    	else if (cmd.equalsIgnoreCase("findNode"))
        	    	{
        	    		System.out.println("Node: "+ bst.findNode(bst.root, bst.root.key));
        	    	}
        	    	else if (cmd.equalsIgnoreCase("depth"))
        	    	{
        	    		System.out.println("Depth: "+bst.depth(bst.root));
        	    	}
        	    	else if (cmd.equalsIgnoreCase("Height"))
        	    	{
        	    		System.out.println("Height: "+bst.height(bst.root));
        	    	}
        	    	else if (cmd.equalsIgnoreCase("findSuccessor"))
        	    	{
        	    		System.out.println("Find Successor: "+bst.findSuccessor(bst.root.key));
        	    	}
        	    	else if (cmd.equalsIgnoreCase("hasLeft"))
        	    	{
        	    		System.out.println("HasLeft: "+bst.hasLeft());
        	    	}
        	    	else if (cmd.equalsIgnoreCase("HasRight"))
        	    	{
        	    		System.out.println("HasRight: "+bst.hasRight());
        	    	}
        	    	else if (cmd.equalsIgnoreCase("isEmpty"))
        	    	{
        	    		System.out.println("IsEmpty: "+bst.isEmpty());
        	    	}
        	    	else if (cmd.equalsIgnoreCase("isRoot"))
        	    	{
        	    		System.out.println("IsRoot: "+bst.isRoot());
        	    	}
        	    	else if (cmd.equalsIgnoreCase("isLeftChild"))
        	    	{
        	    		System.out.println("IsLeftChild: "+bst.isLeftChild());
        	    	}
        	    	else if (cmd.equalsIgnoreCase("isRightChild"))
        	    	{
        	    		System.out.println("IsRightChild: "+bst.isRightChild());
        	    	}
        	    	//Show what the tree looks like
        	    	bst.inOrder(bst.root, 0);
        	    }
        	}
		
   
}
