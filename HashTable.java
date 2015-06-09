package p21;

public class HashTable {
	BinarySearchTree []HashTable;
	BinarySearchTree hashtree = new BinarySearchTree();
	int size = 0;
	
	public HashTable(){ //basic constructor
		//the hashtable grows with the root which is defined by hashtree.size(root)
	HashTable =  new BinarySearchTree[hashtree.size(hashtree.root)];
	}
	
	public HashTable(int size){
		//creates a hashtable of a specific size
		if(size <= 0){
			throw new IllegalArgumentException("illegal table size");
		}
	HashTable =  new BinarySearchTree[size];
	}
	
	//make a better hash, but this is good for right now
	public int hash(String string){ //a string hash function
	int hash=7; //goes through an ascii table and hashes through the entire string 
		for (int i=0; i < string.length(); i++) {
	    hash = hash*31+string.charAt(i); 
	}
		return hash;//returns a hash	
	}
	
	boolean put(String key, Object value){
		int place = hash(key); //hash a key
		HashTable[] hash = new HashTable[place];
		hashtree.insert(key, value); //put that key into the value of the hashtable using trees
		size++;
		return true;	
	//else return false (if not inserted properly)
	}
	
	Object get(String key){
		int bucket = hash(key);
		BinarySearchTree t = HashTable[bucket];
	while(t.root != null){
		if(t.root.key.equals(key)){	
				return t.root.key;
		}
	}
		System.out.print("key " + t.root.key + " value " + t.root.value);	
		return key; //and value pair
	}
	
	//if it has a key
	boolean hasKey(String key){
		int bucket = hash(key); //the bucket is hashed into that specific hash function
		BinarySearchTree t = HashTable[bucket]; //the t pointer points to the Hashtable
		while(t != null){ //while the pointer t is null
		if(t.root.key.equals(key)) { //if that pointer equals key
			return true; //return true
			//t = t.root.right;  
			}
		}
		return false; //return false
	}
	
	public void remove(String key){
		hashtree.delete(key);
	}
	
	public int size() { //simply returns the size  
        return size; 
    }  
	
	int[] distribution(){
		int[] something = new int[HashTable.length];
		int count = 0;
		//for each bucket in the hashtable which, identify how many entries are there
		for(int i = 0; i < HashTable.length; i++){
			if(hashtree.root.key != null){ //goes through the entire table, and checks it out
 				count++;
			}
		}
		return something;
	}
	//returns a set of strings in the hash table
	String[] keys(){
		String[] keyarray = new String[HashTable.length];
		for(int i = 0; i < HashTable.length; i++){
			if(HashTable[i] != null){ //returns the set of strings
				return keyarray;
			}
		}
		return keyarray;
	}
}
