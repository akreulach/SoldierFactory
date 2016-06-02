package baseCase;

import java.util.ArrayList;

import creatures.Creature;
import creatures.Goblin;
import creatures.Ogre;
import creatures.Orc;
import creatures.Soldier;

public class Army {
	ArrayList<Creature> army = new ArrayList<Creature>();
	public Army(){
		for(int n=0;n<100;n++)
			army.add(new Soldier());
	}
	//Constructor for randomly generated enemy armies, no need for 
	//remembering names
	public Army(int i,String a){
		switch(a){
			case("Soldier"):		
				for(int n=0;n<i;n++)
					army.add(new Soldier());
				break;
			case("Goblin"):
				for(int n=0;n<i;n++)
					army.add(new Goblin());
				break;
			case("Orc"):
				for(int n=0;n<i;n++)
					army.add(new Orc());
				break;
			case("Ogre"):
				for(int n=0;n<i;n++)
					army.add(new Ogre());
				break;
			case("Greenskins"):
				for(int n=0;n<5;n++)
					army.add(new Ogre());
				for(int n=0;n<20;n++)
					army.add(new Orc());
				for(int n=0;n<75;n++)
					army.add(new Goblin());
				break;
			default:
				for(int n=0;n<i;n++)
					army.add(new Soldier());
				break;
		}
	}
	//Constructor for player armies, allows for reloading "saved" armies
	public Army(String a){
		int[] stat = new int[6];
		String name="";
		int cnt=0;
		while(a.length()>0){
			while(a.indexOf("**")>a.indexOf("*")){
				if(a.indexOf(" ")<a.indexOf("*")&&a.indexOf(" ")!=-1){
					name=a.substring(0,a.indexOf("*"));
					a=a.substring(a.indexOf("*"));
				}
				a=a.substring(1);
				stat[cnt]=Integer.parseInt(a.substring(0,a.indexOf("*")));
				a=a.substring(a.substring(0,a.indexOf("*")).length());
				cnt++;					
			}
			cnt=0;
			a=a.substring(2);
			army.add(new Soldier(name,stat));
			stat=new int[6];
		}
	}
	public Creature getSoldier(int n){
		return army.get(n);
	}
	public int getSize(){
		return army.size();
	}
	public void dead(int n){
		army.remove(n);
	}
	public ArrayList<Creature> getArmy(){
		return army;
	}
	public void reinforce(Creature c){
		army.add(c);
	}
	public String toString(){
		String res="";
		char s='*';
		for(int n=0;n<army.size();n++){
			int[] st = army.get(n).getStats();
			res+=army.get(n).getName()+s+st[0]+s+st[1]+s+st[2]+s+st[3]+s+st[4]+s+st[5]+s+s;
		}
		return res;
	}
}
