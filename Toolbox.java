//Toolbox class
//handles all of the tools and allows the player
//to pick up tools and drop tools
//these tools are required to win
public class Toolbox {
	//instance variables
	private boolean hasAxe, hasTorch, hasPickaxe, hasLighter;
	
	//constructor
	public Toolbox()
	{
		hasAxe = true;
		hasTorch = true;
		hasPickaxe = true;
		hasLighter = true;
	}
	
	//mutator methods
	public void setHasAxe(boolean hasAxe)
	{
		this.hasAxe = hasAxe;
	}
	
	public void setHasTorch(boolean hasTorch)
	{
		this.hasTorch = hasTorch;
	}
	
	public void setHasPickaxe(boolean hasPickaxe)
	{
		this.hasPickaxe = hasPickaxe;
	}
	
	public void setHasLighter(boolean hasLighter)
	{
		this.hasLighter = hasLighter;
	}
	
	//accessor methods
	public boolean getHasAxe()
	{
		return hasAxe;
	}
	
	public boolean getHasTorch()
	{
		return hasTorch;
	}
	
	public boolean getHasPickaxe()
	{
		return hasPickaxe;
	}
	
	public boolean getHasLighter()
	{
		return hasLighter;
	}
	
	//Look Method
	public void look()
	{
		System.out.println("You see a toolbox");
	}
	
	//Method that allows player to further examine the toolbox
	public void inspect()
	{
		System.out.println("The toolbox consists of multiple tools.");
		if(hasAxe)
		{
			System.out.println("There is an axe.");
		}
		if(hasTorch)
		{
			System.out.println("There is a torch.");
		}
		if(hasPickaxe)
		{
			System.out.println("There is a pickaxe.");
		}
		if(hasLighter)
		{
			System.out.println("There is a lighter");
		}
	}
	
	//Method that allows player to pickup Axe
	public void takeAxe(Player p)
	{
		if(p.getTool().equals("none") && p.getLocation().equals("beach"))
		{
			System.out.println("You took the axe.");
			p.setTool("axe");
			p.setHasTool(true);
			hasAxe = false;
		}
		else if(!p.getLocation().equals("beach"))
		{
			System.out.println("There is no where to grab an axe from.");
		}
		else if(p.getHasTool())
		{
			System.out.println("You already have a tool. You can't carry more than one.");
		}
	}
	
	//Method that allows player to pickup Pickaxe
	public void takePickaxe(Player p)
	{
		if(p.getTool().equals("none") && p.getLocation().equals("beach"))
		{
			System.out.println("You took the Pickaxe.");
			p.setTool("pickaxe");
			p.setHasTool(true);
			hasPickaxe = false;
		}
		else if(!p.getLocation().equals("beach"))
		{
			System.out.println("There is no where to grab a Pickaxe from.");
		}
		else if(p.getHasTool())
		{
			System.out.println("You already have a tool. You can't carry more than one.");
		}
	}
	
	//Method that allows player to pickup torch
	public void takeTorch(Player p)
	{
		if(p.getTool().equals("none") && p.getLocation().equals("beach"))
		{
			System.out.println("You took the torch.");
			p.setTool("torch");
			p.setHasTool(true);
			hasTorch = false;
		}
		else if(!p.getLocation().equals("beach"))
		{
			System.out.println("There is no where to grab a torch from.");
		}
		else if(p.getHasTool())
		{
			System.out.println("You already have a tool. You can't carry more than one.");
		}
	}
	
	//Method that allows player to pick up lighter
	public void takeLighter(Player p)
	{
		if(p.getTool().equals("none") && p.getLocation().equals("beach"))
		{
			System.out.println("You took the lighter.");
			p.setTool("lighter");
			p.setHasTool(true);
			hasLighter = false;
		}
		else if(!p.getLocation().equals("beach"))
		{
			System.out.println("There is no where to grab a lighter from.");
		}
		else if(p.getHasTool())
		{
			System.out.println("You already have a tool. You can't carry more than one.");
		}
	}
	
	//Method that allows player to drop whatever tool they are holding
	public void dropTool(Player p)
	{
		if(p.getTool().equals("none"))
		{
			System.out.println("You have nothing to drop.");
		}
		else if(!p.getLocation().equals("beach"))
		{
			System.out.println("It is not a good idea to drop the " + p.getTool() + " here. You better hold on to it");
		}
		else
		{
			if(p.getTool().equals("litTorch"))
			{
				System.out.println("You burn out the torch.");
			}
			System.out.println("You put the " + p.getTool() + " back in the toolbox.");
			hasAxe = true;
			hasTorch = true;
			hasLighter = true;
			hasPickaxe = true;
			p.setTool("none");
			p.setHasTool(false);
		}
	}
	
}
