package baseCase;

import creatures.*;

public class SingleCombatTester {
	static DieRoller d = new DieRoller();
	static boolean fist=false;
	static int count1,count2;
	static int[] ax,bx;
	public static void main(String[] args){
		count1=count2=0;
		for(int n=0;n<1000000;n++)
			fight();
		System.out.println("Titanus won "+count2+" times, while Tim won "+count1+" times.");
	}
	public static void fight(){
		/*int[] beeg = {18,10,10,8,8,8};
		int[] smol = {10,10,18,8,8,8};*/
		Ogre a = new Ogre();
		//System.out.println(a.getName());
		Goblin b = new Goblin();
		ax=a.getStatx();
		bx=b.getStatx();
		//System.out.println(b.getName());
		//System.out.println("************************");
		//System.out.println("Initiative\n");
		int aIn=DieRoller.d(20)+a.getINIT();
		int bIn=DieRoller.d(20)+b.getINIT();
		while(bIn==aIn){
			bIn=DieRoller.d(20)+b.getINIT();
		}
		//System.out.println(a.getName()+" rolled a " +aIn);
		//System.out.println(b.getName()+" rolled a " +bIn);
		if(aIn>bIn){
			//System.out.println(a.getName()+" takes the initiative and strikes first.");
			fist=true;
		}
			//System.out.println(b.getName()+" takes the initiative and strikes first.");
		//System.out.println();
		while(a.getHP()>0&&b.getHP()>0){
			if(fist){
				if(a.getBAB()+ax[0]+DieRoller.d(20)>=b.getAC())
					b.incHP(-(DieRoller.d(6)+ax[0]));
				if(b.getBAB()+bx[0]+DieRoller.d(20)>=a.getAC())
					a.incHP(-(DieRoller.d(6)+bx[0]));
			}
			else{
				if(b.getBAB()+bx[0]+DieRoller.d(20)>=a.getAC())
					a.incHP(-(DieRoller.d(6)+bx[0]));
				if(a.getBAB()+ax[0]+DieRoller.d(20)>=b.getAC())
					b.incHP(-(DieRoller.d(6)+ax[0]));
			}		
			//System.out.println("\nRound over, "+a.getName()+" has "+a.HP+" hitpoints left.");
			//System.out.println(b.getName()+" has "+b.HP+" hitpoints left.");
		}
		if(a.getHP()<=0&&b.getHP()>0){
			//System.out.println(b.getName()+" has slain "+a.getName()+" and won!");
			count1++;
		}
		else if(b.getHP()<=0&&a.getHP()>0){
			//System.out.println(a.getName()+" has slain "+b.getName()+" and won!");
			count2++;
		}
		else{
			fight();
		}
	}
}
