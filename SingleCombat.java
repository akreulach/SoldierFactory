package baseCase;

import creatures.Creature;
import creatures.Soldier;

public class SingleCombat {
	DieRoller d = new DieRoller();
	boolean fist=false;
	int[] ax,bx;
	
	public SingleCombat(){
		fight(new Soldier(),new Soldier());
	}
	public SingleCombat(Creature a,Creature b){
		fight(a,b);
	}
	public void fight(Creature a, Creature b){
		ax=a.getStatx();
		bx=b.getStatx();
		int aIn=DieRoller.d(20)+a.getINIT();
		int bIn=DieRoller.d(20)+b.getINIT();
		while(bIn==aIn){
			bIn=DieRoller.d(20)+b.getINIT();
		}
		if(aIn>bIn){
			fist=true;
		}
		while(a.getHP()>0&&b.getHP()>0){
			int dam=0;
			if(fist){
				if(a.getBAB()+ax[0]+DieRoller.d(20)>=b.getAC()){
					for(int n=0;n<a.getDNum();n++)
						dam+=DieRoller.d(a.getDSize());
					dam+=ax[0];
					b.incHP(-dam);
				}
				if(b.getBAB()+bx[0]+DieRoller.d(20)>=a.getAC()&&b.getHP()>0){
					for(int n=0;n<b.getDNum();n++)
						dam+=DieRoller.d(b.getDSize());
					dam+=bx[0];
					a.incHP(-dam);
				}
			}
			else{
				if(b.getBAB()+bx[0]+DieRoller.d(20)>=a.getAC()){
					for(int n=0;n<b.getDNum();n++)
						dam+=DieRoller.d(b.getDSize());
					dam+=bx[0];
					a.incHP(-dam);
				}
				if(a.getBAB()+ax[0]+DieRoller.d(20)>=b.getAC()&&a.getHP()>0){
					for(int n=0;n<a.getDNum();n++)
						dam+=DieRoller.d(a.getDSize());
					dam+=ax[0];
					b.incHP(-dam);
				}
			}
		}
	}
}
