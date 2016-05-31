package baseCase;

public class SingleCombatTester {
	static DieRoller d = new DieRoller();
	static boolean fist=false;
	static int count1,count2;
	public static void main(String[] args){
		count1=count2=0;
		for(int n=0;n<1000000;n++)
			fight();
		System.out.println("Titanus won "+count2+" times, while Tim won "+count1+" times.");
	}
	public static void fight(){
		int[] beeg = {18,10,10,8,8,8};
		int[] smol = {10,10,18,8,8,8};
		Soldier a = new Soldier("Titanus",beeg);
		//System.out.println(a.getName());
		Soldier b = new Soldier("Tim",smol);
		//System.out.println(b.getName());
		//System.out.println("************************");
		//System.out.println("Initiative\n");
		int aIn=d.d(20)+a.INIT;
		int bIn=d.d(20)+b.INIT;
		while(bIn==aIn){
			bIn=d.d(20)+b.INIT;
		}
		//System.out.println(a.getName()+" rolled a " +aIn);
		//System.out.println(b.getName()+" rolled a " +bIn);
		if(aIn>bIn){
			//System.out.println(a.getName()+" takes the initiative and strikes first.");
			fist=true;
		}
			//System.out.println(b.getName()+" takes the initiative and strikes first.");
		//System.out.println();
		while(a.HP>0&&b.HP>0){
			if(fist){
				if(a.BAB+a.statx[0]+DieRoller.d(20)>=b.AC)
					b.HP-=DieRoller.d(6)+a.statx[0];
				if(b.BAB+b.statx[0]+DieRoller.d(20)>=a.AC)
					a.HP-=DieRoller.d(6)+b.statx[0];
			}
			else{
				if(b.BAB+b.statx[0]+DieRoller.d(20)>=a.AC)
					a.HP-=DieRoller.d(6)+b.statx[0];
				if(a.BAB+a.statx[0]+DieRoller.d(20)>=b.AC)
					b.HP-=DieRoller.d(6)+a.statx[0];
			}			
			//System.out.println("\nRound over, "+a.getName()+" has "+a.HP+" hitpoints left.");
			//System.out.println(b.getName()+" has "+b.HP+" hitpoints left.");
		}
		if(a.HP<=0&&b.HP>0){
			//System.out.println(b.getName()+" has slain "+a.getName()+" and won!");
			count1++;
		}
		else if(b.HP<=0&&a.HP>0){
			//System.out.println(a.getName()+" has slain "+b.getName()+" and won!");
			count2++;
		}
		else{
			fight();
		}
	}
}
