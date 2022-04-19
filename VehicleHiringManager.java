public class VehicleHiringManager {
LocatorMap Loc_Loc_Map;
	public VehicleHiringManager() {
		Loc_Loc_Map=new TreeLocatorMap();
		
	}

	public LocatorMap<String> getLocatorMap() {
		return Loc_Loc_Map;
	}

	
	public void setLocatorMap(LocatorMap<String> locatorMap) {
		Loc_Loc_Map=locatorMap;
	}

	public boolean addVehicle(String id, Location loc) {
		boolean added_first;
		Pair<Boolean,Integer> is_added=Loc_Loc_Map.add(id, loc);
		added_first=is_added.first;
		return added_first;
		
	
	}

	
	public boolean moveVehicle(String id, Location loc) {
		boolean does_the_vehicle_moved;
		Pair<Boolean,Integer> is_moved=Loc_Loc_Map.move(id, loc);
		does_the_vehicle_moved=is_moved.first;
		
		
		return does_the_vehicle_moved;
	}

	public boolean removeVehicle(String id) {
		boolean does_the_vehicle_removed;
		Pair<Boolean,Integer> is_removed=Loc_Loc_Map.remove(id);
		does_the_vehicle_removed=is_removed.first;
		
		return does_the_vehicle_removed;
	}

	public Location getVehicleLoc(String id) {
		Pair<Location,Integer> getLocationFromTreeLocator =Loc_Loc_Map.getLoc(id);
		
		return getLocationFromTreeLocator.first;
	}

	
	public List<String> getVehiclesInRange(Location loc, int r) {
		Pair<List<String>,Integer> get_theArray_fromTreeLocatorMap=Loc_Loc_Map.getInRange(new Location(loc.x-r,loc.y-r), new Location(loc.x+r,loc.y+r));
		return get_theArray_fromTreeLocatorMap.first;
	}
}
