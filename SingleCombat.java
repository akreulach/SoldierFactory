package baseCase;

public class SingleCombat {
	DieRoller d = new DieRoller();
	boolean fist=false;
	
	public SingleCombat(){
		fight(new Soldier(),new Soldier());
	}
	public SingleCombat(Soldier a,Soldier b){
		fight(a,b);
	}
	public void fight(Soldier a, Soldier b){
		int aIn=d.d(20)+a.INIT;
		int bIn=d.d(20)+b.INIT;
		while(bIn==aIn){
			bIn=d.d(20)+b.INIT;
		}
		if(aIn>bIn){
			fist=true;
		}
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
		}
	}
}
