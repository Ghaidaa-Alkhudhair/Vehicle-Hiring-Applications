
public class BST<K extends Comparable<K>, T> implements Map<K, T> {
	
	/////////////////////////////////
	public class BSTNode <K extends Comparable<K>,T>{
		public K key;  
        public T data;
        public BSTNode<K,T> left, right;

		
		
		
		/** Creates a new instance of BSTNode */
		public BSTNode(K key, T data) {
			  this.key = key  ;  
              this.data = data;
              left = right = null;
		}
		
		 public BSTNode(K key, T data, BSTNode<K,T> l, BSTNode<K,T> r) {
			 this.key = key  ;  
             this.data = data;
             left = l;
             right = r;
		}
	}
	BSTNode<K,T> current2;
	BSTNode<K,T> root; 
	BSTNode<K,T>current;
	
	/////////default constructor
	public BST() {
		root = current = null;
	}


	@Override
	public boolean empty() {
		
		// TODO Auto-generated method stub
		return root==null;
	}

	@Override
	public boolean full() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T retrieve() {
		// TODO Auto-generated method stub
		return current.data;
	}

	@Override
	public void update(T e) {
		// TODO Auto-generated method stub
		current.data=e;

	}

	@Override
	public Pair<Boolean, Integer> find(K key) {/////////may be not efficient
		BSTNode<K,T> p = root,q = root;
		Pair<Boolean, Integer> p_return;
		boolean f=false;
		int numOfCmparison=0;
		p_return = new Pair < Boolean , Integer >(f,  numOfCmparison);
		
		if(empty())
			return p_return;
		
		while(p != null) {
			numOfCmparison++;
			q = p;
			
			if((key.compareTo(p.key))==0) {////wrong K
				f=true;	
				current=p;
				current2=p;
				
				return new Pair < Boolean , Integer >(f,  numOfCmparison);
			}
			else if((key.compareTo(p.key))>0)////wrong K
				p = p.right;
				
			else
				p = p.left;
		}
		
		current2 = q;
		

		return ( new Pair < Boolean , Integer >(f,  numOfCmparison));
	}

		
		// TODO Auto-generated method stub
	
	@Override
	public Pair<Boolean, Integer> insert(K key, T data) {
		BSTNode<K,T> p, q = current;

	
		
		Pair<Boolean, Integer> p_find=find(key);

		if((p_find.first)==true) {//if k existe
			p_find.first=false;
			current=q;
			return p_find;
		}
		
		p = new BSTNode<K,T>(key, data);
		if (empty()) {
			root = current =current2= p;}
			

		else {
			if((key.compareTo(current2.key))>0)
				current2.right=p;
			else 
				current2.left=p;
				
				
			current=current2=p;
			
		}
		
		p_find.first=true;
		return p_find;
	
	}

	@Override
	public Pair<Boolean, Integer> remove(K key) {
		// TODO Auto-generated method stub
		
		        BSTNode<K,T>  c = current;
		        Pair < Boolean , Integer > pair = find (key );
		        if (pair.first == true)  
		        {
		            K k1 = key;
		            BSTNode<K,T> p = root;
		            BSTNode<K,T> q = null; // Parent of p
		            
		            while (p != null) 
		            {
	if (k1.compareTo(p.key) <   0) 
		 {
		  q =p;
		    p = p.left;
		  } 
	  else if (k1.compareTo(p.key) > 0) 
	{    
		 q = p;
		 p = p.right;
		  }
		 else 
		 { // Found the key
		                        // Check the three cases
	 if ((p.left != null) && (p.right != null)) 
	{ 
		                            // Case 3: 
	 BSTNode<K,T> min = p.right;
	 q = p;
		   while (min.left != null) 
	   {
	  q = min;
	    min = min.left;
	    }
	p.key = min.key;
	  p.data = min.data;
	  k1 = min.key;
	  p = min;
		                            // Now fall back to either case 1 or 2
	   }
		                        // The subtree rooted at p will change here
	  if (p.left != null) 
		{ 
		                            // One child
  p = p.left;
	  } 
	   else 
	 { 
		                          
		  p = p.right;
	  }
	  if (q == null)
		    { 
		                          
	  root = p;
		 } 
		 else 
		    {
		      if (k1.compareTo(q.key) < 0) 
		     q.left = p;
		      else {
		       q.right = p;}
		                 }
		           current = root;
		         } 
		        } 
		            current = root;
		    pair.first = true;
		        }
		        else
		        {
		        
		            current = c;
		            pair.first = false;
		        }
		        return pair;
		    }
		
		


	@Override
	public List<K> getAll() {
		
		// TODO Auto-generated method stub
		List<K> list=new LinkedList<K>();
		MyRecMethod(list,root);
		return list;
	}
	private void MyRecMethod(List<K> array,BSTNode<K,T> root1) {
		if(root1==null) 
			return;
		MyRecMethod(array,root1.left);
		array.insert(root1.key);
		MyRecMethod(array,root1.right);
		
	}
	

}
