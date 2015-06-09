package p21;

import java.util.Scanner;

public class HashTest {
	public static void main(String[] args) { 
		String item = "";  // The user's input.
		int size = 10;
        BinarySearchTree bst1 = new BinarySearchTree();
        HashTable hash = new HashTable(size);
        
        HashTable hash2 = new HashTable(10);
        hash2.put("10", "o");
        hash2.put("hop", "far");
        hash2.size();
        
        Scanner scan = new Scanner(System.in);
	    String cmd;
	    
	    System.out.println("Commands:\n\tput String Value\n\tget\n\t" +
                "size\n\tkeys\n\thasKey\n\tDistribution\n\tquit");
      	    
		 while (!(cmd=scan.next()).equalsIgnoreCase("quit"))
 	    {
 	    	if (cmd.equalsIgnoreCase("put"))
 	    	{
 	    		hash.put(scan.next(), null);
 	    	}
 	    	else if (cmd.equalsIgnoreCase("get"))
 	    	{
 	    		System.out.println("Get: "+ hash.get(scan.next()));
 	    	}
 	    	else if (cmd.equalsIgnoreCase("size"))
 	    	{
 	    		System.out.println("Size: "+ hash.size());
 	    	}
 	    	else if (cmd.equalsIgnoreCase("keys"))
 	    	{
 	    		System.out.println("Keys: "+hash.keys());
 	    	}
 	    	else if (cmd.equalsIgnoreCase("hasKey"))
 	    	{
 	    		System.out.println("hasKey: "+hash.hasKey(scan.next()));
 	    	}
 	    	else if (cmd.equalsIgnoreCase("Distribution"))
 	    	{
 	    		//System.out.println("Distribution: "+hash.distribution());
 	    	}
 	    }
	}

}
