//Driver Class
//Runs the game
import java.util.Scanner;
import java.util.Random;
public class TannerBrownEscapeRoom {
	public static void main(String[] args)
	{
		//Variables for Scanner, Random, and Input
		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		String input = "";
		
		//Creates the objects for the game to run
		Player player = new Player();
		Toolbox toolbox = new Toolbox();
		Firepit pit = new Firepit();
		Safe safe = new Safe();
		
		//Code to randomize the code for combination lock
		int one = r.nextInt(99) + 1;
		int two = r.nextInt(99) + 1;
		int three = r.nextInt(99) + 1;
		String combination = one + "-" + two + "-" + three;
		player.setCombination(combination);
		
		//Creates combinationlock object for the safe
		CombinationLock lock = new CombinationLock(combination);
		
		//Introduction to Game
		System.out.println("You wake up on an empty beach on an island. Your goal is to escape the island.");
		System.out.println("You can quit at anytime by typing \"quit\".");
		
		//While loop that runs the game. Loops until player has escaped or if player quits
		while(player.getHasEscaped() == false)
		{
			System.out.println("Enter an input: ");
			input = sc.nextLine();
			
			if(input.equals("quit"))
			{
				break;
			}
			
			else if(input.equals("look"))
			{
				player.look(pit, toolbox, safe);
			}
			
			else if(input.equals("move"))
			{
				System.out.println("Where do you want to go? (beach, boat, forest, cave)");
				input = sc.nextLine();
				
				if(input.equals("cave") && player.getIsBlocked())
				{
					System.out.println("The cave is blocked off by some big rocks.");
					continue;
				}
				
				if(!input.equals("beach") && !input.equals("boat") && !input.equals("forest") && !input.equals("cave"))
				{
					System.out.println("Not a valid location. You stay in the same place.");
				}
				else if(input.equals(player.getLocation()))
				{
					System.out.println("You are already at the " + input);
				}
				else
				{
					player.move(input);
				}
			}
			
			else if(input.equals("check inventory") || input.equals("inventory"))
			{
				player.takeInventory();
			}
			
			else if(input.equals("grab tool") || input.equals("pickup tool"))
			{
				if(!player.getLocation().equals("beach"))
				{
					System.out.println("The toolbox is at the beach.");
				}
				else
				{
					System.out.println("What tool would you like to grab? (axe, torch, pickaxe, lighter)");
					input = sc.nextLine();
					if(!input.equals("axe") && !input.equals("pickaxe") && !input.equals("torch") && !input.equals("lighter"))
					{
						System.out.println("That tool is not in the toolbox. You grab nothing.");
					}
					else if(player.getTool().equals(input))
					{
						System.out.println("you are already carrying the " + input);
					}
					else if(input.equals("axe"))
					{
						toolbox.takeAxe(player);
					}
					else if(input.equals("pickaxe"))
					{
						toolbox.takePickaxe(player);
					}
					else if(input.equals("torch"))
					{
						toolbox.takeTorch(player);
					}
					else
					{
						toolbox.takeLighter(player);
					}
				}
			}
			
			else if(input.equals("drop tool"))
			{
				toolbox.dropTool(player);
			}
			
			else if(input.equals("grab leaves") || input.equals("pickup leaves") || input.equals("gather leaves"))
			{
				player.pickupLeaves();
			}
			
			else if(input.equals("collect wood") || input.equals("gather wood") || input.equals("chop wood"))
			{
				player.collectWood();
			}
			
			else if(input.equals("grab key") || input.equals("pickup keys"))
			{
				player.grabKey(safe);
			}
			
			else if(input.equals("open safe") || input.equals("unlock safe"))
			{
				if(!player.getLocation().equals("boat"))
				{
					System.out.println("There is no safe nearby.");
				}
				else
				{
					safe.openSafe(lock);
				}
			}
			
			else if(input.equals("add leaves") || input.equals("add kindling"))
			{
				pit.addKindling(player);
			}
			
			else if(input.equals("add wood"))
			{
				pit.addWood(player);
			}
			
			else if(input.equals("light fire") || input.equals("start fire"))
			{
				pit.lightFire(player);
			}
			
			else if(input.equals("open cave") || input.equals("unblock cave"))
			{
				player.openCave();
			}
			
			else if(input.equals("light torch"))
			{
				player.lightTorch(pit);
			}
			
			else if(input.equals("start boat"))
			{
				player.startBoat();
			}
			
			else if(input.equals("examine firepit"))
			{
				if(!player.getLocation().equals("beach"))
				{
					System.out.println("The firepit is at the beach.");
				}
				else
				{
					pit.inspect();
				}
			}
			
			else if(input.equals("examine safe"))
			{
				if(!player.getLocation().equals("boat"))
				{
					System.out.println("The safe is on the boat");
				}
				else
				{
					safe.inspect(player);
				}
			}
			
			else if(input.equals("examine toolbox"))
			{
				if(!player.getLocation().equals("beach"))
				{
					System.out.println("The toolbox is on the beach");
				}
				else
				{
					toolbox.inspect();
				}
			}
			
			else
			{
				System.out.println("Invalid Command, Try something else.");
			}
		}
		//End of the game
		//Prints code whether player won or not
		if(player.getHasEscaped())
		{
			System.out.println("You have successfully escaped the island. Good Job!");
		}
		else
		{
			System.out.println("You failed, Bye!");
		}
		
		sc.close();
	}
}
