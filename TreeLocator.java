
public class TreeLocator<T> implements Locator<T> {

	//////////class location 
	class LocationNode<T>{
		LocationNode<T> baby1;
		LocationNode<T> baby2;
		LocationNode<T> baby3;
		LocationNode <T>baby4;
		Location location_key;
		List<T> Ldata;
		
		LocationNode(Location loc,T d){
			baby1=null;
			baby2=null;
			baby3=null;
			baby4=null;
			this.location_key=loc;
			Ldata=new LinkedList<T>();
			Ldata.insert(d);
			
		}}
		
		 LocationNode<T> root,current;
		 
		 public TreeLocator(){
			 root=current=null;
			 
			 
		 }
	
	
	
	
	@Override///////////////////////////////////////////////////////////////
	public int add(T e, Location loc) {//////wrong completly!!!!
		int numComparisons=0;
		LocationNode<T> p=root;
		LocationNode<T> q=root;
		LocationNode<T> karant=current;
		
		boolean det=false;
		if(root==null) {
			root=current=(new LocationNode<T>(loc,e));
		}
		else {
			while(p!=null) {
				numComparisons++;
				q=p;
				if(MySearchMethod(loc,p)==0) {
					det=true;
					current=p;
					break;
				}
				else if(MySearchMethod(loc,p)==1) {
					p=p.baby1;
					
				}
				else if(MySearchMethod(loc,p)==2) {
					p=p.baby2;
				}
				else if(MySearchMethod(loc,p)==3) {
					p=p.baby3;
				}
				else if(MySearchMethod(loc,p)==4) {
					p=p.baby4;
				}
			}
			current=q;
			if(det==true) {
				current.Ldata.insert(e);
			}
			else if(det==false) {
				if(MySearchMethod(loc,q)==1) {
					current.baby1=new LocationNode<T>(loc,e);
				}
				else if(MySearchMethod(loc,q)==2) {
					current.baby2=new LocationNode<T>(loc,e);
				}
				else if(MySearchMethod(loc,q)==3) {
					current.baby3=new LocationNode<T>(loc,e);
				}
				else if (MySearchMethod(loc,q)==4) {
					current.baby4=new LocationNode<T>(loc,e);
				}
				
			
				
			}//end else if
		
		}//end else
		
	
		return numComparisons;
	}

	@Override////////////////////////////////////////////////////////////
	public Pair<List<T>, Integer> get(Location loc) {
		int numComparison=0;
		LocationNode<T> pp =root;
		LocationNode<T> qq=root;
		List<T> empty =new LinkedList<T>();
		if(pp==null) {
		
			return new Pair<List<T>, Integer>(empty,numComparison);
			
		}
		else {
			while(pp!=null) {
				qq=pp;
				numComparison++;
				
				int search=(MySearchMethod(loc,pp));
				if(search==0) {
					current=pp;
					return (new Pair<List<T>, Integer> (pp.Ldata,numComparison));}
				//
				else if (search==1)
					pp=pp.baby1;
				
				else if(search==2)
					pp=pp.baby2;
				
				else if(search==3)
					pp=pp.baby3;
				
				else if (search==4)
					pp=pp.baby4;
				
			}//end while
		}
		current =qq;
	
	
		return new Pair<List<T>, Integer>(empty,numComparison);
	}

	@Override//////////////////////////////////////////////////////////////////////
	public Pair<Boolean, Integer> remove(T e, Location loc) {
		
		LocationNode<T> pp =current;
	      LocationNode<T> p1=root;
	      LocationNode<T> q1=root;
			int numComparison=0;
			int zero=0;
			boolean check=false;
			
			if(root==null) {
	      return new Pair<Boolean, Integer>(check,zero);}
			
			while(p1!=null) {
	      numComparison++;
	     System.out.println("infinit");
				
				if((MySearchMethod(loc,p1))==0) {
	        
					if((p1.Ldata.empty()))
						return new Pair<Boolean, Integer>(check,numComparison); 
					if(!(p1.Ldata.empty())){
					p1.Ldata.findFirst();
	           
					while(!(p1.Ldata.last())) {
	          
						if(p1.Ldata.retrieve().equals(e)) {
							check=true;
							p1.Ldata.remove();
						}
	               else
	               p1.Ldata.findNext();
	               
					}//end while
					if(p1.Ldata.retrieve().equals(e)) {//check the last element
						check=true;
						p1.Ldata.remove();}
	        
	         }//end if(!(p1.Ldata.empty())
				   break;             
	               }//End if((MySearchMethod(loc,current))==0)
				 if ((MySearchMethod(loc,p1))==1)//My search method determine the loc is which child
					p1=p1.baby1;
				
				else if((MySearchMethod(loc,p1))==2)
					p1=p1.baby2;
				
				else if((MySearchMethod(loc,p1))==3)
					p1=p1.baby3;
				
				else if ((MySearchMethod(loc,p1))==4)
					p1=p1.baby4;
			}
			//current=q1;
			return new Pair<Boolean, Integer>(check,numComparison);

		
		
		
		
		
		
		
		////////My prevoius remove() it has infinit loop!!!
		
		
		/*
		LocationNode<T> pp =root;
		int numComparison=0;
		int zero=0;
		boolean check=false;
		
		if(root==null) return new Pair<Boolean, Integer>(check,zero);
		
		while(pp!=null) {
			numComparison++;
			
			if((MySearchMethod(loc,pp))==0) {
				if(pp.Ldata.empty())
					return new Pair<Boolean, Integer>(check,numComparison); 
				
				pp.Ldata.findFirst();
				while(!pp.Ldata.last()) {
					if(pp.Ldata.retrieve().equals(e)) {
						check=true;
						pp.Ldata.remove();
						
					}//remove if find
					pp.Ldata.findNext();
				}//end while
				if(pp.Ldata.retrieve().equals(e)) {//check the last element
					check=true;
					pp.Ldata.remove();}
			}//end if 
			
			else if ((MySearchMethod(loc,pp))==1)//My search method determine the loc is which child
				pp=pp.baby1;
			
			else if((MySearchMethod(loc,pp))==2)
				pp=pp.baby2;
			
			else if((MySearchMethod(loc,pp))==3)
				pp=pp.baby3;
			
			else if ((MySearchMethod(loc,pp))==4)
				pp=pp.baby4;
		}
		
		return new Pair<Boolean, Integer>(check,numComparison);*/
	}

	@Override///////////////////////////////////////////////////////////
	public List<Pair<Location, List<T>>> getAll() {
		
		List<Pair<Location,List<T>>> array= new LinkedList<Pair<Location, List<T>>>();
		LocationNode<T> pp =root;
		if(pp==null) return array;
		private_method_get_all(array,pp);
		return array;
		
		
		
		
	}

	@Override
	public Pair<List<Pair<Location, List<T>>>, Integer> inRange(Location lowerLeft, Location upperRight) {
		//System.out.println("hi inrange");
		List<Pair<Location, List<T>>> array=new LinkedList <Pair<Location, List<T>>>();
		int numofComparison;
		numofComparison=0;
		int recnum;
		recnum=inRecRang(lowerLeft,upperRight,(new Location(upperRight.x,lowerLeft.y)),(new Location (lowerLeft.x,upperRight.y)),array,root);
	numofComparison=recnum;
	return (new Pair<>(array,numofComparison));///////change the return type of integer
		
	}
	
	
	
	////////////////////////////My rec private method
	private int inRecRang(Location lowerLeft,Location upperRight, Location LowerRight, Location UpperLeft, List<Pair<Location, List<T>>> arr,LocationNode<T> rooot) {
		int pick=0;
		int numofComparison; if(rooot==null) /*Base case*/{
		return 0; }
		else {
		numofComparison=1;
		//insert
		if( (lowerLeft.y<=rooot.location_key.y && upperRight.y >= rooot.location_key.y) && (lowerLeft.x<=rooot.location_key.x&&upperRight.x>=rooot.location_key.x) )
		{ arr.insert(new Pair<Location,List<T>>(rooot.location_key,rooot.Ldata));}
		////////////////////////
		
		if((rooot.location_key.y >= lowerLeft.y)&&(rooot.location_key.x> lowerLeft.x)) /*||  ((rooot.location_key.y >= upperRight.y)&&(rooot.location_key.x > upperRight.x))) || ((rooot.location_key.y >= LowerRight.y) && (rooot.location_key.x >LowerRight.x)) || ((rooot.location_key.y>= UpperLeft.y) && (rooot.location_key.x > UpperLeft.x) ) */ {
			pick=1; 
			numofComparison+=inRecRang( lowerLeft, upperRight,  LowerRight,  UpperLeft,  arr, rooot.baby1) ;
			
		} 
		
		else if((rooot.location_key.y >= upperRight.y)&&(rooot.location_key.x > upperRight.x)) {
			numofComparison+=inRecRang( lowerLeft, upperRight,  LowerRight,  UpperLeft,  arr, rooot.baby1) ;
		}
		else if((rooot.location_key.y >= LowerRight.y) && (rooot.location_key.x >LowerRight.x)) {
			numofComparison+=inRecRang( lowerLeft, upperRight,  LowerRight,  UpperLeft,  arr, rooot.baby1) ;

		}
		
		else if((rooot.location_key.y>= UpperLeft.y) && (rooot.location_key.x > UpperLeft.x) ) {
			numofComparison+=inRecRang( lowerLeft, upperRight,  LowerRight,  UpperLeft,  arr, rooot.baby1) ;

			
		}
		
		if((rooot.location_key.y < lowerLeft.y)&&(rooot.location_key.x >= lowerLeft.x))  {
			pick=2;
			numofComparison+=inRecRang( lowerLeft, upperRight,  LowerRight,  UpperLeft,  arr, rooot.baby2);}
		 
			else if ((rooot.location_key.y < upperRight.y)&&(rooot.location_key.x >= upperRight.x)) {
				
				numofComparison+=inRecRang( lowerLeft, upperRight,  LowerRight,  UpperLeft,  arr, rooot.baby2);
			}
			else if ((rooot.location_key.y < LowerRight.y) && (rooot.location_key.x >= LowerRight.x)) {
				numofComparison+=inRecRang( lowerLeft, upperRight,  LowerRight,  UpperLeft,  arr, rooot.baby2);
				
			}
			else if ((rooot.location_key.y < UpperLeft.y) && (rooot.location_key.x >= UpperLeft.x)) {
				numofComparison+=inRecRang( lowerLeft, upperRight,  LowerRight,  UpperLeft,  arr, rooot.baby2);
				
			}
		
		if((rooot.location_key.y <= lowerLeft.y)&&(rooot.location_key.x < lowerLeft.x))
		{ 
			pick=3;
			numofComparison+=inRecRang( lowerLeft, upperRight,  LowerRight,  UpperLeft,  arr, rooot.baby3) ;
		
		} 
		else if ((rooot.location_key.y <= upperRight.y)&&(rooot.location_key.x < upperRight.x)) {
			numofComparison+=inRecRang( lowerLeft, upperRight,  LowerRight,  UpperLeft,  arr, rooot.baby3) ;
		}
		else if ((rooot.location_key.y <= LowerRight.y) && (rooot.location_key.x < LowerRight.x)) {
			numofComparison+=inRecRang( lowerLeft, upperRight,  LowerRight,  UpperLeft,  arr, rooot.baby3) ;
		}
		else if ((rooot.location_key.y<= UpperLeft.y) && (rooot.location_key.x < UpperLeft.x) ) {
			numofComparison+=inRecRang( lowerLeft, upperRight,  LowerRight,  UpperLeft,  arr, rooot.baby3) ;
		}
		
		if(((rooot.location_key.y > lowerLeft.y)&&(rooot.location_key.x <=  lowerLeft.x)) ) {
			pick=4;
			numofComparison+=inRecRang( lowerLeft, upperRight,  LowerRight,  UpperLeft,  arr, rooot.baby4) ;
		
		}
		
		
		else if ((rooot.location_key.y > upperRight.y)&&(rooot.location_key.x <= upperRight.x)) {
			numofComparison+=inRecRang( lowerLeft, upperRight,  LowerRight,  UpperLeft,  arr, rooot.baby4) ;
		}
		else if ((rooot.location_key.y > LowerRight.y) && (rooot.location_key.x <= LowerRight.x)) {
			numofComparison+=inRecRang( lowerLeft, upperRight,  LowerRight,  UpperLeft,  arr, rooot.baby4) ;
		}
		else if ((rooot.location_key.y > UpperLeft.y) && (rooot.location_key.x <= UpperLeft.x)) {
			numofComparison+=inRecRang( lowerLeft, upperRight,  LowerRight,  UpperLeft,  arr, rooot.baby4) ;
		}
		
		///////////////Start switch
		
		//switch(pick) { 
		//case 1:
			/*{ if(pick==1) {
				numofComparison+=inRecRang( lowerLeft, upperRight,  LowerRight,  UpperLeft,  arr, rooot.baby1) ; 
	
		}}
		//case 2: 
			{ if(pick==2) {
				numofComparison+=inRecRang( lowerLeft, upperRight,  LowerRight,  UpperLeft,  arr, rooot.baby2) ;
		
		}}
		//case 3: 
			{if(pick==3) {
				numofComparison+=inRecRang( lowerLeft, upperRight,  LowerRight,  UpperLeft,  arr, rooot.baby3);
		
		}}
		//case 4: 
			{if(pick==4) {
				numofComparison+=inRecRang( lowerLeft, upperRight,  LowerRight,  UpperLeft,  arr, rooot.baby4) ;
		
		}}*/

	
		//}//End switch
		}
		return numofComparison; }


		
		
	
	///////////////////////My method 
	private int MySearchMethod(Location search_loc,	LocationNode<T> pp) {
		int s=0;
		if(search_loc.y==pp.location_key.y&&search_loc.x==pp.location_key.x)
			s=0;
		else if (search_loc.x<pp.location_key.x && search_loc.y <= pp.location_key.y)
			s=1;
		else if (search_loc.x<=pp.location_key.x && search_loc.y > pp.location_key.y)//////make sure
			s=2;
		else if(search_loc.x > pp.location_key.x && search_loc.y >= pp.location_key.y)
			s=3;
		else if (search_loc.x >= pp.location_key.x && search_loc.y < pp.location_key.y)
			s=4;
		return s;
		
	
		
	}
	
	private void private_method_get_all( List<Pair<Location, List<T>>> array, LocationNode<T> pp) {
		if(pp==null) return;
		array.insert(new Pair<Location, List<T>> (pp.location_key,pp.Ldata));
		private_method_get_all(array,pp.baby1);
		private_method_get_all(array,pp.baby2);
		private_method_get_all(array,pp.baby3);
		private_method_get_all(array,pp.baby4);
		
		
	}

}
