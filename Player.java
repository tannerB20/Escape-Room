//Player class
//Handles location of the player
//as well as methods that the player
//must use to further progress in the escape room
//Also handles what the player is holding
public class Player 
{
	//instance variables
	private boolean hasLeaves, hasWood, hasTool, hasKey, hasEscaped, isBlocked;
	private String tool;
	private String location;
	private String combination;
	
	//Constructor
	public Player()
	{
		hasLeaves = false;
		hasWood = false;
		hasTool = false;
		hasKey = false;
		hasEscaped = false;
		isBlocked = true;
		combination = "";
		tool = "none";
		location = "beach";
	}
	
	//mutator methods
	public void setHasLeaves(boolean hasLeaves)
	{
		this.hasLeaves = hasLeaves;
	}
	
	public void setHasWood(boolean hasWood)
	{
		this.hasWood = hasWood; 
	}
	
	public void setHasTool(boolean hasTool)
	{
		this.hasTool = hasTool;
	}
	
	public void setHasKey(boolean hasKey)
	{
		this.hasKey = hasKey;
	}
	
	public void setHasEscaped(boolean hasEscaped)
	{
		this.hasEscaped = hasEscaped;
	}
	
	public void setIsBlocked(boolean isBlocked)
	{
		this.isBlocked = isBlocked;
	}
	
	public void setLocation(String location)
	{
		this.location = location;
	}
	
	public void setTool(String tool)
	{
		this.tool = tool;
	}
	
	public void setCombination(String combination)
	{
		this.combination = combination;
	}

	//accessor methods
	public boolean getHasLeaves()
	{
		return hasLeaves;
	}
	
	public boolean getHasWood()
	{
		return hasWood;
	}
	
	public boolean getHasTool()
	{
		return hasTool;
	}
	
	public boolean getHasKey()
	{
		return hasKey;
	}
	
	public boolean getHasEscaped()
	{
		return hasEscaped;
	}
	
	public boolean getIsBlocked()
	{
		return isBlocked;
	}
	
	public String getLocation()
	{
		return location;
	}
	
	public String getTool()
	{
		return tool;
	}
	
	public String getCombination()
	{
		return  combination;
	}
	
	//Method for player to start the boat. This is the win condition
	public void startBoat()
	{
		if(hasKey == true && location.equals("boat"))
		{
			System.out.println("You were able to start the boat and escape the island!");
			hasEscaped = true;
		}
		else if(hasKey == false && location.equals("boat"))
		{
			System.out.println("The boat needs a key for it to start.");
		}
		else if(hasKey == true && !location.equals("boat"))
		{
			System.out.println("You need to be on the boat to able to start it.");
		}
		else
		{
			System.out.println("You need a key and you aren't even on the boat.");
		}
	}
	
	//Method that allows Player to move between different locations
	public void move(String location)
	{
		this.location = location;
		System.out.println("You moved to the " + location +".");
	}
	
	//Method that allows player to look at objects around them.
	//Differs depending on what location they are in
	public void look(Firepit pit, Toolbox box, Safe safe)
	{
		if(location.equals("boat"))
		{
			System.out.println("You are on a boat with an ignition for a key");
			safe.look();
		}
		
		if(location.equals("beach"))
		{
			System.out.println("You are on a beach. You see a boat in the water, a forest entrance, and a cave entrace.");
			if(isBlocked)
			{
				System.out.println("The cave is closed. There are big rocks in the way.");
			}
			pit.look();
			box.look();
		}
		
		if(location.equals("forest"))
		{
			System.out.println("You are in a forest. You are surrounded by many trees and fallen leaves.");
		}
		
		if(location.equals("cave"))
		{
			if(tool.equals("litTorch"))
			{
				System.out.println("You are in a cave. Using your torch, you see '" + combination + "' written on the wall.");
			}
			else
			{
				System.out.println("You are in a cave. It is too dark for you to see.");
			}
		}
	}
	
	//Method that allows player to open cave
	public void openCave()
	{
		if(!location.equals("beach"))
		{
			System.out.println("The cave entrance is at the beach.");
		}
		else if(!tool.equals("pickaxe"))
		{
			System.out.println("You do not have the right tool to open the cave.");
		}
		else
		{
			System.out.println("You used your pickaxe to break the rocks and open the cave.");
			isBlocked = false;
		}
	}
	
	//Method that allows player to pickup leaves
	public void pickupLeaves()
	{
		if(hasLeaves)
		{
			System.out.println("You already have leaves.");
		}
		else if(location.equals("forest"))
		{
			System.out.println("You pick up some nearby leaves. This might be useful...");
			hasLeaves = true;
		}
		else
		{
			System.out.println("There are no leaves around.");
		}
	}
	
	//Method that allows player to collect wood
	public void collectWood()
	{
		if(hasWood)
		{
			System.out.println("You already have logs");
		}
		else if(hasTool = false)
		{
			System.out.println("You need some sort of tool to collect wood.");
		}
		else if(hasTool = true && !tool.equals("axe") && location.equals("forest"))
		{
			System.out.println("You don't have the correct tool to collect wood.");
		}
		else if(!location.equals("forest"))
		{
			System.out.println("There is no where to collect wood.");
		}
		else
		{
			System.out.println("You use your axe to collect wood.");
			hasWood = true;
		}
	}
	
	//Method that allows player to grab the key
	public void grabKey(Safe s)
	{
		if(location.equals("boat") && s.getIsOpen() == true && hasKey == false)
		{
			System.out.println("You grabbed the key from the safe.");
			hasKey = true;
		}
		else if(hasKey == true)
		{
			System.out.println("You are already holding the key");
		}
		else
		{
			System.out.println("There is no key to grab.");
		}
	}
	
	//Method that allows player to light their torch.
	public void lightTorch(Firepit f)
	{
		if(tool.equals("litTorch"))
		{
			System.out.println("Your torch is already lit.");
		}
		else if(f.getIsLit() && tool.equals("torch") && location.equals("beach"))
		{
			System.out.println("You lit the torch.");
			tool = "litTorch";
		}
		else if(tool.equals("torch") && !f.getIsLit() || !location.equals("beach"))
		{
			System.out.println("There is no where to light the torch");
		}
		else if(!tool.equals("torch"))
		{
			System.out.println("There is no torch to light.");
		}
	}
	
	//Method that allows player to look at their inventory.
	public void takeInventory()
	{
		if(!tool.equals("none"))
		{
			System.out.println("You are holding " + tool);
		}
		
		if(hasLeaves)
		{
			System.out.println("You have leaves. This may be useful.");
		}
		
		if(hasWood)
		{
			System.out.println("You have logs. They are a bit heavy.");
		}
		
		if(hasKey)
		{
			System.out.println("you have a key. This seems very useful");
		}
		
		if(tool.equals("none") && !hasLeaves && !hasWood && !hasKey)
		{
			System.out.println("You have nothing.");
		}
	}
}
