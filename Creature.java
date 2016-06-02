package creatures;

import baseCase.DieRoller;

public class Creature {
	int LVL;
	int AC,TAC,FAC;
	int BAB,HP,INIT,DSize,DNumber;
	int stat[];
	int statx[]=new int[6];
	String Class,name,atk,race;
	String feats;
	int FORT,REF,WILL;
	public Creature(){
		stat = rollStats();
		statLogic(stat);
		HP=4+statx[2];
		BAB=LVL;
		INIT=statx[1];
		AC=10+statx[1];
		TAC=10+statx[1];
		FAC=10;
		DSize=6;
		DNumber=1;
		FORT=statx[2];
		REF=statx[1];
		WILL=statx[4];
		Class="Fighter";
		name="Ted";
		atk="Fist " + (BAB+statx[0])+" (1d4+"+statx[0]+")";
	}
	public int[] rollStats(){
		int[] s = new int[6];
		for(int n=0;n<6;n++)
			s[n]=DieRoller.d(6)+DieRoller.d(6)+DieRoller.d(6);
		return s;
	}
	public void statLogic(int[] s){
		//Priority order: 0,2,1,4,3,5
		int[] base = new int[6];
		for(int n=0;n<6;n++)
			base[n]=s[n];
		int maximum=0;
		int index=0;
		for(int n=0;n<base.length;n++)
			if(base[n]>maximum){
				maximum=base[n];
				index=n;
			}
		stat[0]=base[index];
		statx[0]=modifierLogic(stat[0]);
		base[index]=0;
		maximum=0;
		for(int n=0;n<base.length;n++)
			if(base[n]>maximum){
				maximum=base[n];
				index=n;
			}
		stat[2]=base[index];
		statx[2]=modifierLogic(stat[2]);
		base[index]=0;
		maximum=0;
		for(int n=0;n<base.length;n++)
			if(base[n]>maximum){
				maximum=base[n];
				index=n;
			}
		stat[1]=base[index];
		statx[1]=modifierLogic(stat[1]);
		base[index]=0;
		maximum=0;
		for(int n=0;n<base.length;n++)
			if(base[n]>maximum){
				maximum=base[n];
				index=n;
			}
		stat[4]=base[index];
		statx[4]=modifierLogic(stat[4]);
		base[index]=0;
		maximum=0;
		for(int n=0;n<base.length;n++)
			if(base[n]>maximum){
				maximum=base[n];
				index=n;
			}
		stat[3]=base[index];
		statx[3]=modifierLogic(stat[3]);
		base[index]=0;
		maximum=0;
		for(int n=0;n<base.length;n++)
			if(base[n]>maximum){
				maximum=base[n];
				index=n;
			}
		stat[5]=base[index];
		statx[5]=modifierLogic(stat[5]);
		base[index]=0;
		maximum=0;
	}
	public int modifierLogic(int x){
		return (int)Math.floor(((double)(x-10))/2);
	}
	//Getters
	public String getName(){return name;}
	public int getHP(){return HP;}
	public int getLVL(){return LVL;}
	public int getAC(){return AC;}
	public int getBAB(){return BAB;}
	public int getINIT(){return INIT;}
	public int getDSize(){return DSize;}
	public int getDNum(){return DNumber;}
	public int[] getStats(){return stat;}
	public int[] getStatx(){return statx;}
	
	//Increment
	public void incHP(int i){HP+=i;}
	public String setName(String[] names){
		return names[DieRoller.d(names.length)-1]+" "+names[DieRoller.d(names.length)-1];
	}
	public String toString(){
		return "Name: "+name+"\n"+
			   "Class: "+Class+" "+LVL+"\n"+
			   "HP: "+HP+"\n"+
			   "Initiative: "+INIT+"\n"+
			   "AC: "+AC+"\n"+
			   "BAB: "+BAB+"\n\n"+
			   "Attack: "+atk+"\n\n"+
			   "Str: "+stat[0]+", "+statx[0]+"\n"+
			   "Dex: "+stat[1]+", "+statx[1]+"\n"+
			   "Con: "+stat[2]+", "+statx[2]+"\n"+
			   "Int: "+stat[3]+", "+statx[3]+"\n"+
			   "Wis: "+stat[4]+", "+statx[4]+"\n"+
			   "Cha: "+stat[5]+", "+statx[5]+"\n\n"+
			   "Saves: "+"Fort +"+FORT+", Ref +"+REF+", Will +"+WILL+"\n\n"+
			   "Feats: "+feats;
	}
}
