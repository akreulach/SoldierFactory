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
	public static void main(String[] args){
		input();
		begin();
	}
	public static void input(){
		System.out.println("Battle begins! Who is the aggressor?");
		atck = new Army(s.nextLine());
		System.out.println("And who are they attacking?");
		defd = new Army(s.nextLine());
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
		
			if(defd.getSoldier(dSold).HP<1){
				defd.dead(dSold);
				if(atck.getSize()>aSold+1)
					aSold++;
				if(defd.getSize()<dSold+1)
					dSold--;
			}
			if(atck.getSoldier(aSold).HP<1){
				atck.dead(aSold);			
				if(defd.getSize()>dSold+1)
					dSold++;
				if(atck.getSize()<aSold+1)
					aSold--;
			}
		}
	}
	public static void score(){
		if(hasASoldier(atck))
			System.out.println("The attackers are victorious, but at what cost?");
		else if(hasASoldier(defd))
			System.out.println("The defenders have held the line, but at what cost?");
		else
			System.out.println("Only crows will feast tonight.");
		System.out.println(atck);
		System.out.println(defd);
	}
	
	public static boolean hasASoldier(Army a){
		if(a.getSize()>0)
			return true;
		return false;
	}
}
