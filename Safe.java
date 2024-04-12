//Safe class
//Interacts with CombinationLock class.
//Players goal is to get the safe open
//to get a key which is required for winning
public class Safe {
	//instance variable
	private boolean isOpen;
	
	//constructor
	public Safe()
	{
		isOpen = false;
	}
	
	//mutator method
	public void setIsOpen(boolean isOpen)
	{
		this.isOpen = isOpen;
	}
	
	//accessor method;
	public boolean getIsOpen()
	{
		return isOpen;
	}
	
	//Method to open safe, interacts with combination lock
	public void openSafe(CombinationLock lock)
	{
		if(lock.unlock())
		{
			System.out.println("The safe was unlocked. You see a key inside.");
			isOpen = true;
		}
		else
		{
			System.out.println("Wrong code.The safe remains locked.");
		}
	}
	
	//Look Method
	public void look()
	{
		System.out.println("You see a safe");
	}
	
	//Method that allows player to further examine the safe
	public void inspect(Player p)
	{
		if(!isOpen)
		{
			System.out.println("The safe is unopened. Looks like you need a code for it.");
		}
		else
		{
			if(p.getHasKey())
			{
				System.out.println("The safe is opened and empty.");
			}
			else
			{
				System.out.println("The safe is opened and has a key inside.");
			}
		}
	}
}
