 # This is a vehicle hiring applications done by Ghaida Alkhudair.

 ## Overview:
 -Building an efficient storage of vehicle locations for vehicle hiring applications, such efficient localization requires specialized data structures, and the goal  of this project is to implement and use of data structures that helps to store an manipulate data efficiently.
 
 -The programming language used in this project is Java.
  
  ### The code for this assignments consists of the following classes:
  | Class |Description|
  |-------|-----------|
  |Location|represent locations of elements|
  |Pair| represent pairs of elements|
  |VehicleHiringManager|stores the locations of vehicles and allows to add, remove and move vehicles to a new position. Vehicles are identified by a key of type String. An important functionality of this class is finding all vehicles within a square centered at the customer’s location.|
  |LinkedList|used to store data when needed.|
  |BST|used to map vehicle IDs to their locations.|
  |TreeLocator|which is used to store the vehicles available at every location using several methods.|
  |TreeLocatorMap| which is used to store the locations of vehicles by combining BST and TreeLocator to guarantee that vehicle IDs are unique (unlike the class TreeLocator, which only guarantees the uniqueness of the locations but not the data).|
  
  
  
  
 
