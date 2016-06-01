package baseCase;

import java.util.ArrayList;

public class Army {
	ArrayList<Soldier> army = new ArrayList<Soldier>();
	public Army(){
		for(int n=0;n<100;n++)
			army.add(new Soldier());
	}
	public Army(int i){
		for(int n=0;n<i;n++)
			army.add(new Soldier());
	}
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
	public Soldier getSoldier(int n){
		return army.get(n);
	}
	public int getSize(){
		return army.size();
	}
	public void dead(int n){
		army.remove(n);
	}
	public ArrayList<Soldier> getArmy(){
		return army;
	}
	public String toString(){
		String res="";
		char s='*';
		for(int n=0;n<army.size();n++){
			res+=army.get(n).name+s+army.get(n).stat[0]+s+army.get(n).stat[1]+s+army.get(n).stat[2]+s+army.get(n).stat[3]+s+army.get(n).stat[4]+s+army.get(n).stat[5]+s+s;
		}
		return res;
	}
}
