package creatures;

import baseCase.DieRoller;

public class Goblin extends Creature{
	String[] names = {"Grop","Hurtbutts"};
	public Goblin(){
		rollStats();
		stat[0]-=2;
		stat[1]+=2;
		stat[5]-=2;
		statLogic(stat);
		HP=DieRoller.d(8)+statx[2];
		BAB=1;
		INIT=statx[1];
		AC=14+statx[1];
		TAC=11+statx[1];
		FAC=14;
		DSize=6;
		DNumber=1;
		FORT=2+statx[2];
		REF=statx[1];
		WILL=statx[4];
		Class="Goblin";
		name=setName(names);
		atk="Morningstar "+"+"+(BAB+statx[0])+" (1d6+"+statx[0]+")";
		LVL=1;
		feats="Power Attack, Cleave";
	}
}
