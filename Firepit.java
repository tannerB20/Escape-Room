//Firepit class
//Includes methods needed to start the fire
//Player must interact with firepit class
//to light their torch to be able
//to see in the cave that reveals
//a code for the safe
public class Firepit {
	//instance variables
	private boolean hasKindling, hasWood, isLit;
	
	//constructor
	public Firepit()
	{
		hasKindling = false;
		hasWood = false;
		isLit = false;
	}
	
	//Mutator Methods
	public void setHasKindling(boolean hasKindling)
	{
		this.hasKindling = hasKindling;
	}
	
	public void setHasWood(boolean hasWood)
	{
		this.hasWood = hasWood;
	}
	
	public void setIsLit(boolean isLit)
	{
		this.isLit = isLit;
	}
	
	//Accessor methods
	public boolean getHasKindling()
	{
		return hasKindling;
	}
	
	public boolean getHasWood()
	{
		return hasWood;
	}
	
	public boolean getIsLit()
	{
		return isLit;
	}
	
	//Method that allows player to light fire
	public void lightFire(Player p)
	{
		if(isLit)
		{
			System.out.println("The fire is already lit.");
		}
		else if(!p.getLocation().equals("beach"))
		{
			System.out.println("The firepit is at the beach.");
		}
		else if(!hasKindling || !hasWood)
		{
			System.out.println("There isn't enough in the firepit to make a fire.");
		}
		else if(!p.getTool().equals("lighter"))
		{
			System.out.println("You need some sort of tool to light the fire.");
		}
		else
		{
			System.out.println("You started the fire.");
			isLit = true;
			hasKindling = false;
			hasWood = false;
		}
	}
	
	//Method to allow player to add kindling to firepit
	public void addKindling(Player p)
	{
		if(isLit)
		{
			System.out.println("The fire is already lit. No need for more kindling.");
		}
		else if(hasKindling)
		{
			System.out.println("There is already kindling in the firepit.");
		}
		else if(!p.getLocation().equals("beach"))
		{
			System.out.println("The firepit is at the beach.");
		}
		else if(!p.getHasLeaves())
		{
			System.out.println("You do not have any kindling to add to the firepit.");
		}
		else
		{
			System.out.println("You add kindling to the fire.");
			hasKindling = true;
			p.setHasLeaves(false);
		}
	}
	
	//Method that allows player to add wood to firepit
	public void addWood(Player p)
	{
		if(isLit)
		{
			System.out.println("The fire is already lit. No need for more wood.");
		}
		else if(hasWood)
		{
			System.out.println("There is already wood in the firepit.");
		}
		else if(!p.getLocation().equals("beach"))
		{
			System.out.println("The firepit is at the beach.");
		}
		else if(!p.getHasWood())
		{
			System.out.println("You do not have any wood to add to the firepit.");
		}
		else
		{
			System.out.println("You add wood to the fire.");
			hasWood = true;
			p.setHasWood(false);
		}
	}
	
	//Look Method
	public void look()
	{
		System.out.println("You see a firepit");
	}
	
	//Inspect method that allows player to further examine firepit
	public void inspect()
	{
		if(isLit)
		{
			System.out.println("There is a fire burning within the firepit.");
		}
		else
		{
			System.out.println("The fire is not lit.");
			if(hasKindling)
			{
				System.out.println("There are leaves in the fire for kindling.");
			}
			else
			{
				System.out.println("There is no kindling");
			}
			
			if(hasWood)
			{
				System.out.println("There is wood in the fire.");
			}
			else
			{
				System.out.println("There is no wood in the fire");
			}
		}
	}
}
