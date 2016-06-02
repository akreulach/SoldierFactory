package creatures;

import baseCase.DieRoller;

public class Ogre extends Creature{
	String[] names = {"WAAAGH","Glipthon"};
	public Ogre(){
		rollStats();
		stat[0]+=10;
		stat[1]-=2;
		stat[2]+=4;
		stat[3]-=4;
		stat[5]-=4;
		statLogic(stat);
		LVL=4;
		for(int n=0;n<LVL;n++)
			HP+=DieRoller.d(8);
		HP+=statx[2]*LVL;
		BAB=3;
		INIT=statx[1];
		AC=17+statx[1];
		TAC=9+statx[1];
		FAC=17;
		DSize=8;
		DNumber=2;
		FORT=4+statx[2];
		REF=1+statx[1];
		WILL=1+statx[4];
		Class="Ogre";
		name=setName(names);
		atk="Greatclub "+"+"+(BAB+statx[0])+" ("+DNumber+"d"+DSize+"+"+statx[0]+")";
		LVL=1;
		feats="Power Attack, Cleave";
	}
}
