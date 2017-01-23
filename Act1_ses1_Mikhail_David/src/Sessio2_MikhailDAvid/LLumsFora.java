package Sessio2_MikhailDAvid;

import Keyboard.Keyboard;

public class LLumsFora {
	
	public static void main(String[] args) {
		
		Taulell taul = new Taulell();;
		int files = taul.getFiles();
		int columnes = taul.getColumnes();
		int nTirades;
		int valor= valor(files,columnes);
		int arrayEnc[],arrayAp[];
		int max,tirMax;
		
		boolean jugant = true;
		


		while(jugant){
			
			nTirades=numTirades();
			arrayEnc=new int[nTirades];
			arrayAp = new int [nTirades];
			max = 0;
			tirMax=0;
			
			taul.encendre(valor);
			taul.mostraTaula();
			
			
			for(int i=0;i<nTirades;i++){
				tira(files,columnes,taul);
				taul.mostraTaula();
				arrayEnc[i] = taul.getBombetesEnceses();
				arrayAp[i]= files*columnes-arrayEnc[i];
				if(arrayAp[i]>max){
					tirMax=i;
					max= arrayAp[i];
				}
			}
			end(nTirades,arrayEnc,arrayAp,tirMax);
			jugant = fin(files,columnes,valor);
			if(jugant)taul.apagarTot();
			else System.out.println("ADEU! ");
		}
	}

	private static int valor(int files, int columnes) {
		int maxim = ((files * columnes) / 6);
		System.out.println("Indica quantes bombetes vols encendre");
		System.out.println("Especifica un valor dins de l'interval [0," + maxim + "]");
		int valor = Keyboard.readInt();

		while (valor < 0 || valor > maxim) {
			System.out.println("Valor incorrecte.Ha d'estar dins de l'interval [0," + maxim + "]");
			valor = Keyboard.readInt();
		}
		return valor;
	}
	private static int numTirades(){
		
		System.out.println("Especifica el numero maxim de tirades");
		int tirades = Keyboard.readInt();
		while(tirades<=0){
			System.out.println("Incorrecte, especifica un valor superior a 0");
			tirades = Keyboard.readInt();
		}
		return tirades;
		
	}
	private static void tira(int files, int columnes,Taulell taul) {

		System.out.println("**************");
		System.out.println("Indica les coordenades del botó a premer");
		System.out.println("Indica la fila:");
		System.out.println("**************");
		System.out.println("Especifica un valor entre l'interval [0, " + (files - 1)+"]");
		int fila = Keyboard.readInt();

		while (fila < 0 || fila > files - 1) {
			System.out.print("Valor de la fila fora de l'interval.Ha d'estar entre [0, " + (files - 1)+"]");
			System.out.println("Torna a introduir el valor de la fila");
			fila = Keyboard.readInt();
		}

		System.out.println("Indica la columna:");
		System.out.println("**************");
		System.out.println("Especifica un valor entre l'interval [0, " + (columnes - 1)+"]");
		int columna = Keyboard.readInt();

		while (columna < 0 || columna > columnes - 1) {
			System.out.print("Valor de la columna fora de l'interval.Ha d'estar entre [0, " + (files - 1)+"]");
			System.out.println("Torna a introduir el valor de la columna");
			columna = Keyboard.readInt();
		}
		
		taul.setCasella(fila, columna);
	}
	
	private static boolean fin (int files,int columnes,int valor){
		
		System.out.println("Vols fer una altre partida amb aquest taulell de ["+files+","+columnes+"] i amb "+valor+" bombetes enceses?(S/N)");
		char resposta=Keyboard.readChar();
		
		while(resposta != 'S'&& resposta != 'N'){
			System.out.println("Resposta incorrecte, Introdueix S o N");
			resposta= Keyboard.readChar();
		}
		if(resposta=='S')return true;
		else return false;	
	}
	
	private static void end (int tir,int arrayE[],int arrayA[],int max){
		System.out.println("Ja no tens més tirades.El joc ha acabat");
		for(int i=1;i<=tir;i++){
			System.out.println("Tirada : "+i+"---> tens "+arrayE[i-1]+" encesos i "+arrayA[i-1]+" apagades");	
		}
		System.out.println("La tirada amb més bombetes apagades ha estat la "+(max+1));
	}

}
