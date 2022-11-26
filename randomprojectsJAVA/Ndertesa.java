public class Ndertesa{
	/*
		•	Ka emertimin (p.sh. A11) dhe një varg ku vendosën (ruhen) apartamentet
	*/
	public String emertimi;
	public Apartamenti[] vargu;
	int index;
	
	/*
		•	Ofroni konstruktorin e klasës që pranon si parametëra emertimin dhe numrin e apartamenteve 
		që do të vendosën (regjistrohen) në ndërtesë.
	*/
	
	public Ndertesa(String e, int kapaciteti){
		emertimi = e;
		vargu = new Apartamenti[kapaciteti];
	}
	
	/*
		•	Ofroni metodën regjistroApartamentin që mundëson 
		ruajtjen e një apartamenti në varg, nëse apartamenti i tillë nuk ekziston në varg si dhe nëse ka vend të lirë në varg, përndryshe metoda duhet të afishoj mesazhin:
		Apartamenti nuk u regjistrua! 

		Veni re: testimi nëse apartamenti ekziston duhet të realizohet përmes for loop.

	*/
	public void regjistroApartamentin(Apartamenti a){
		
			// e shikon a eshte null emri 
		if(a == null){
			System.out.println("Apartamenti nuk eshte inicializuar");
				return;
			}
			
			// e shikon a ka vende te lira 
			
		if(index >= vargu.length){
				System.out.println("Nuk ka vende te lira ne varg");
				return;
		}
			
			// e shikon a egziston ne varg 

		for(int i = 0; i < index; i++){
			if(vargu[i].equals(a)){
				System.out.println("Apartamenti ekziston ne varg");
					return;
			}
		}
			vargu[index++] = a;
	}
	
	/*
		•	Ofroni metoden fshijApartamentin 
		që mundëson fshirjen e të gjithë apartamenteve sipëfaqja e 
		të cilave është më e vogël se (siperfaqja) e caktuar. 
		Si rezultat të kthehet sa apartamente janë fshirë. 

		Veni re: pas fshirjes mos harroni të merreni me vendet e lëna zbrazët. 
	*/
	
	public int fshijApartamentin(float siperfaqja){
		int count = 0;
		
		for(int i = 0; i < index; i++){
			if(vargu[i].getSiperfaqja() < siperfaqja){
				count++;
				for(int j = i; j < index - 1; j++){
					vargu[j] = vargu[j+1];
				}
				vargu[--index] = null;
				i--;
			}
		}
		return count;
	}
	
	/*
		Ofroni metodën getNrSipasSiperfaqes që pranon si parametër siperfaqen (p.sh. 65.7)  dhe kthen numrin e apartamenteve 
		që sipërfaqja e tyre është më e madhe se vlera e parametrit të pranuar. 
	*/
	
	public int getNrSipasSiperfaqes(float siperfaqja){
		int count = 0;
		for(int i = 0; i < index; i++){
			if(vargu[i].getSiperfaqja() > siperfaqja){
				count++;
			}
			
		}
		return count;	
	}
	
	/*
		•	Ofroni metodën cmimiMesatar që pranon 
		si paramenter kaDepo dhe si rezultat kthen 
		mesataren e cmimit të apartamenteve që ndodhën në varg.
	*/
	
	public double cmimiMesatar(boolean ka){
		double sum = 0;
		int count = 0;
		
		for(int i = 0; i < index; i++){
			if(vargu[i].getKaDepo() == ka){
				sum = sum + vargu[i].getCmimi();	
				count++;
			}	
		}
		double mesatarja = sum / count;
		return mesatarja;
	
	}
	
	/*
		•	Ofroni metodën getTotali e cila si rezultat 
		kthen numrin e vendeve të lira që ndodhën në varg për regjistrimin e apartamenteve të reja.
	*/
	
		public int getTotali(){
			return vargu.length - index;
		}
		// METODA PRINTALL MI PRINTU KREJT
		public void printAll(){
			for(int i=0;i<vargu.length;i++){
				System.out.println(i+"."+vargu[i]);
			}
		}
				public static void main(String[]args){

			Ndertesa n = new Ndertesa("Test",15);
			/*Apartamenti a1 = new Apartamenti((short)1,(byte)1,80.5f,"Test",true) ;
			n.regjistroAparatemntin(a1);*/		//numri //kati  //siperf // emriPronarit //kaDEPO
			Apartamenti a1 = new Apartamenti((short)1,(byte)1,80.5f,"Redon redoni",true);
			Apartamenti a2 = new Apartamenti((short)2,(byte)5,50.5f,"Blerim 06",false);
			Apartamenti a3 = new Apartamenti((short)3,(byte)6,80.5f,"Trim chamberi",true);
			Apartamenti a4 = new Apartamenti((short)4,(byte)7,60.5f,"Lavda",false);
			Apartamenti a5 = new Apartamenti((short)5,(byte)2,40.5f,"Test",false);
			Apartamenti a6 = new Apartamenti((short)6,(byte)3,90.4f,"Tirol",true);
			Apartamenti a7 = new Apartamenti((short)7,(byte)5,45.5f,"Arian",true);
			Apartamenti a8 = new Apartamenti((short)8,(byte)6,33.3f,"Jeta",true);
			Apartamenti a9 = new Apartamenti((short)9,(byte)7,66.3f,"Ylli",false);
			Apartamenti a10 = new Apartamenti((short)10,(byte)2,25.3f,"Maliqi",false);
	
			n.regjistroApartamentin(a1);
			n.regjistroApartamentin(a2);
			n.regjistroApartamentin(a3);
			n.regjistroApartamentin(a4);
			n.regjistroApartamentin(a5);
			n.regjistroApartamentin(a6);
			n.regjistroApartamentin(a7);
			n.regjistroApartamentin(a8);
			n.regjistroApartamentin(a9);
			n.regjistroApartamentin(a10);
			System.out.println("Cmimi mesatar i baneses: " + n.cmimiMesatar(true));
			System.out.println("Totali i banesave te zbrazeta: " + n.getTotali());
			System.out.println("nr i Siperfaqes per 80m kati i 4: " + n.getNrSipasSiperfaqes(80.4f));
            System.out.println("Banesa e pare e blere");
			System.out.println(a1);
			System.out.println("");
			System.out.println("Te gjitha banesat");
			n.printAll();
		}
}
