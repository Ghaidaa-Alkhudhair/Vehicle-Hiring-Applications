
public class TreeLocatorMap<K extends Comparable<K>> implements LocatorMap<K> {
Locator<K> Loc_Loc;
Map<K,Location> Map_BST;

//Default constructor
public TreeLocatorMap() {
	Loc_Loc=new TreeLocator<K>();
	Map_BST=new BST<K,Location>();
}



	@Override
	public Map<K, Location> getMap() {
		
		return Map_BST;
	}

	@Override
	public Locator<K> getLocator() {
		
		return Loc_Loc;
	}

	@Override
	public Pair<Boolean, Integer> add(K k, Location loc) {//this method may be changed!!
	
		int numOfComForLocation=0;
		
		boolean is_it_inserted=false;
		
		Pair<Boolean, Integer> is_it_added= Map_BST.insert(k, loc);
		
		is_it_inserted=is_it_added.first;
		
		if(is_it_inserted==false) {
			return new Pair<Boolean, Integer>(false,is_it_added.second);
		}
		
		else if(is_it_inserted==true) {
			numOfComForLocation=Loc_Loc.add(k, loc);
		}
		
		
		 return new Pair<Boolean, Integer>(is_it_inserted,is_it_added.second);
	}

	@Override
	public Pair<Boolean, Integer> move(K k, Location loc) {
		int from_find=0;
		boolean is_it_found=false;
		boolean f_u;
		int f_u_Treelocator=0;
		boolean final_deleted_or_not=false;
		Pair<Boolean, Integer> could_moved=Map_BST.find(k);
		is_it_found=could_moved.first;
		if(is_it_found==false) {
			//return new Pair<Boolean, Integer>(false,could_moved.second);
			final_deleted_or_not=false;
		}
		
		else if (is_it_found==true) {
			Pair<Boolean, Integer> delet_from_loc=Loc_Loc.remove(k, Map_BST.retrieve());
			f_u=delet_from_loc.first;
			if(f_u==true) { //delet in treelocator occured 
				Map_BST.update(loc);
				f_u_Treelocator=Loc_Loc.add(k, loc);
				final_deleted_or_not=true;
			////here may be return 			
			} 
			else if (f_u==false) {
				System.out.println("Entered the never entering f_u");
				final_deleted_or_not=false;
			}
			}
		
		return new Pair<Boolean, Integer>(final_deleted_or_not,could_moved.second);
	}

	@Override
	public Pair<Location, Integer> getLoc(K k) {
		
boolean is_it_found_to_get_it;
int numnum;
Pair<Boolean, Integer> can_we_get=Map_BST.find(k);
is_it_found_to_get_it=can_we_get.first;
numnum=can_we_get.second;
if(is_it_found_to_get_it==false) {
	return new Pair<Location, Integer>(null,numnum);
}
else  
return  new Pair<Location, Integer>((Map_BST.retrieve()),numnum);
	}

	@Override
	public Pair<Boolean, Integer> remove(K k) {
		boolean can_we_delet=false;
		boolean check=false;//////this is may be replaced with -> is_it_found.second;
		Pair<Boolean, Integer> is_it_found=Map_BST.find(k);
		can_we_delet=is_it_found.first;
		if(can_we_delet==false) {
			check=false;
		}
		else if(can_we_delet==true){
			Loc_Loc.remove(k, Map_BST.retrieve());
			Map_BST.remove(k);
			check=true;
	
		}
		
		return new Pair<Boolean, Integer>(check,is_it_found.second) ;
	}

	@Override
	public List<K> getAll() {
		
		return Map_BST.getAll();
	}

	@Override
	public Pair<List<K>, Integer> getInRange(Location lowerLeft, Location upperRight) {
		List<Pair<Location,List<K>>> collected_data;
		List<K> new_list_adding_data;
		
		Pair <List<Pair<Location,List<K>>>,Integer> coming_pair=Loc_Loc.inRange(lowerLeft, upperRight);
		collected_data=coming_pair.first;
		new_list_adding_data=new LinkedList<K>();
		if(collected_data.empty()) {
         System.out.println(" Entered collected_data.empty()");
			return new Pair<List<K>, Integer>(new_list_adding_data,coming_pair.second);
		}
		else if(!collected_data.empty()) {
			collected_data.findFirst();
			while(!collected_data.last()) {
				
				MyMethodToAddGetInRange(new_list_adding_data,collected_data.retrieve().second);
				
				collected_data.findNext();
			}
			////checking the last element
			MyMethodToAddGetInRange(new_list_adding_data,collected_data.retrieve().second);
			
		}//end else if(!collected_data.empty())
		
			
		
		
		
		
		
		return new Pair<List<K>, Integer>(new_list_adding_data,coming_pair.second);
	}
	private void MyMethodToAddGetInRange(List<K> new_arr,List<K> old_is_gold) {
		
		if(!old_is_gold.empty()) {
			old_is_gold.findFirst();
			while(!old_is_gold.last()) {
				new_arr.insert(old_is_gold.retrieve());
				old_is_gold.findNext();
			}//end while
			new_arr.insert(old_is_gold.retrieve());
		}//end if (!old_is_gold.empty())
		
		
		
		
		
	}

}
