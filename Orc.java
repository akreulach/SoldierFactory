package creatures;

import baseCase.DieRoller;

public class Orc extends Creature{
	String[] names = {"Todd","Wendelthorp","George","Messenbrew"};
	public Orc(){
		rollStats();
		//while(stat[0]+stat[2]<25)
			//rollStats();
		stat[0]+=4;
		stat[3]-=2;
		stat[4]-=2;
		stat[5]-=2;
		statLogic(stat);
		HP=DieRoller.d(8)+statx[2];
		BAB=1;
		INIT=statx[1];
		AC=13+statx[1];
		TAC=10+statx[1];
		FAC=13;
		DSize=4;
		DNumber=2;
		FORT=2+statx[2];
		REF=statx[1];
		WILL=statx[4];
		Class="Orc";
		name=setName(names);
		atk="Morningstar "+"+"+(BAB+statx[0])+" (1d6+"+statx[0]+")";
		LVL=1;
		feats="Power Attack, Cleave";
	}
}
