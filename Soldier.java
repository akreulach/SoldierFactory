package creatures;

public class Soldier extends Creature{
	String[] names = {"Aelian","Aemilian","Aemil","Agrippa","Aheno","Alban","Anton","Aquilan",
			"Augusta","Aulan","Aurelan","Avitan","Balbin","Blandan","Blasian","Caecilan",
			"Calian","Caelinian","Cain","Camill","Cassian","Cicero","Cnaeus","Crispin",
			"Deciman","Diocletian","Domitan","Drusan","Ennian","Fabian","Fabrican","Faust",
			"Felix","Festan","Flavian","Florian","Gaius","Gallan","German","Glaucan",
			"Gnaeus","Gordian","Hadrian","Hilar","Horace","Hortense","Jovian","Julian",
			"Juvenal","Laelian","Laurence","Livian","Longinian","Lucan","Luchi","Lucian",
			"Lucretian","Manian","Manlian","Marcellan","Marcan","Marcus","Marian","Martial",
			"Martin","Maxan","Naevian","Nero","Nonan","Octavian","Ovid","Otho","Paul","Petron",
			"Plinian","Pompon","Pontin","Porcian","Publian","Quint","Quintan","Regulan",
			"Rufus","Sabine","Saturn","Scaevol","Secund","Senecan","Septim","Sergian","Servum",
			"Severus","Sextilian","Silvanian","Tacitan","Tatian","Trajan","Tullian","Valens",
			"Valentian","Valerian","Varian","Vergil","Virgian","Vespasian","Vibian","Vitan"
	};
	public Soldier(){
		stat = rollStats();
		stat[0]+=2;
		statLogic(stat);
		HP=10+statx[2];
		BAB=1;
		INIT=statx[1];
		AC=16+statx[1];
		TAC=10+statx[1];
		FAC=16;
		DSize=6;
		DNumber=1;
		FORT=2+statx[2];
		REF=statx[1];
		WILL=statx[4];
		Class="Fighter";
		name=setName(names);
		atk="Longsword "+"+"+(BAB+statx[0])+" (1d6+"+statx[0]+")";
		LVL=1;
		feats="Power Attack, Cleave";
	}
	public Soldier(String n, int[] stats){
		name=n;
		stat=stats;
		statLogic(stats);
		HP=10+statx[2];
		BAB=1;
		INIT=statx[1];
		AC=16+statx[1];
		TAC=10+statx[1];
		FAC=16;
		FORT=2+statx[2];
		REF=statx[1];
		WILL=statx[4];
		Class="Fighter";
		atk="Longsword "+"+"+(BAB+statx[0])+" (1d6+"+statx[0]+")";
		LVL=1;
		feats="Power Attack, Cleave";
	}
}
