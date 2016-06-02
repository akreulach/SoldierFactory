package baseCase;

import java.util.Scanner;

/*
 * Morale
 * A%=allies_alive/(allies_alive+allies_dead)
 * E%=enemies_alive/(enemies_alive+enemies_dead)
 * L%=A%/E%
 * 1st levels run at L%=.50
 * 2nd =.42
 * 3rd =.34
 * 4th =.26
 * 5th =.18
 * 6th =.10
 */

//Class should take two Army objects, calculate rounds until one has either been destroyed or 
//had their morale shattered, then return new Army objects containing the survivors.

public class Resolver {
	static Scanner s = new Scanner(System.in);
	static Army atck,defd;
	static int size1,size2;
	
	public static void main(String[] args){
		input();
		begin();
	}
	public static void input(){
		System.out.println("Battle begins! Who is the aggressor?");
		interpret(s.nextLine(),true);
		size1=atck.getSize();
		
		System.out.println("And who are they attacking?");
		interpret(s.nextLine(),false);
		size2=defd.getSize();
	}
	public static void interpret(String s, boolean a){
		if(a){
			if(s.contains("**"))
				atck = new Army(s);
			else if(s.equals("Greenskins"))
				atck = new Army(0,"Greenskins");
			else if(s.contains("Ogres")&&s.contains(" "))
				atck = new Army(Integer.parseInt(s.substring(0,s.indexOf(" "))),"Ogre");
			else if(s.contains("Ogres"))
				atck = new Army(100,"Ogre");
			else if(s.contains("Orcs")&&s.contains(" "))
				atck = new Army(Integer.parseInt(s.substring(0,s.indexOf(" "))),"Orc");
			else if(s.contains("Orcs"))
				atck = new Army(100,"Orc");
			else if(s.contains("Goblins")&&s.contains(" "))
				atck = new Army(Integer.parseInt(s.substring(0,s.indexOf(" "))),"Goblin");
			else if(s.contains("Goblins"))
				atck = new Army(100,"Goblin");
			else
				atck = new Army();
		}else{
			if(s.contains("**"))
				defd = new Army(s);
			else if(s.equals("Greenskins"))
				defd = new Army(0,"Greenskins");
			else if(s.contains("Ogres")&&s.contains(" "))
				defd = new Army(Integer.parseInt(s.substring(0,s.indexOf(" "))),"Ogre");
			else if(s.contains("Ogres"))
				defd = new Army(100,"Ogre");
			else if(s.contains("Orcs")&&s.contains(" "))
				defd = new Army(Integer.parseInt(s.substring(0,s.indexOf(" "))),"Orc");
			else if(s.contains("Orcs"))
				defd = new Army(100,"Orc");
			else if(s.contains("Goblins")&&s.contains(" "))
				defd = new Army(Integer.parseInt(s.substring(0,s.indexOf(" "))),"Goblin");
			else if(s.contains("Goblins"))
				defd = new Army(100,"Goblin");
			else
				defd = new Army();
		}
	}
	public static void begin(){
		alignment();
		fight();
		score();
	}
	public static void alignment(){
		//include piling multiple attacks on one defender in later updates
	}
	public static void fight(){
		int aSold=0;
		int dSold=0;
		while(hasASoldier(defd)&&hasASoldier(atck)){
			new SingleCombat(defd.getSoldier(dSold),atck.getSoldier(aSold));
		
			if(defd.getSoldier(dSold).getHP()<1){
				defd.dead(dSold);
				if(atck.getSize()>aSold+1)
					aSold++;
				if(defd.getSize()<dSold+1)
					dSold--;
			}
			if(atck.getSoldier(aSold).getHP()<1){
				atck.dead(aSold);			
				if(defd.getSize()>dSold+1)
					dSold++;
				if(atck.getSize()<aSold+1)
					aSold--;
			}
		}
	}
	public static void score(){
		if(hasASoldier(atck)){
			System.out.print("The attackers are victorious");
			if(atck.getSize()*2<size1)
				System.out.println(", but at what cost?");
			else
				System.out.println("! Glory to your name!");

			System.out.println(atck);
		}
		else if(hasASoldier(defd)){
			System.out.print("The defenders have held the line");
			if(defd.getSize()*2<size2)
				System.out.println(", but at what cost?");
			else
				System.out.println("! Glory to your name!");
			System.out.println(defd);
		}
		else{
			System.out.println("Only crows will feast tonight.");
		}
	}
	
	public static boolean hasASoldier(Army a){
		if(a.getSize()>0)
			return true;
		return false;
	}
}
