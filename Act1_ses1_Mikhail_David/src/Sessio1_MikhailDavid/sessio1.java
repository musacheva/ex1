package Sessio1_MikhailDavid;

import Keyboard.*;

public class sessio1 {

	public static void main(String args[]) {

		int files = files();
		int columnes = columnes();

		int tauler[][] = new int[files][columnes]; // Creació del tauler

		valor(tauler,files, columnes);
		RecorreTauler(tauler);
		bucle(tauler,files,columnes);
	}

	
	
	public static int files() {
		System.out.println("Indica les dimensions del taulell");
		System.out.println("Entra un número de files>2 i <=12");
		int files = Keyboard.readInt();

		while (files <= 2 || files > 12) {
			System.out.println("Incorrecte. Entra files files>2 i <=12");
			files = Keyboard.readInt();
		}

		return files;
	}

	public static int columnes() {

		System.out.println("Entra un número de columnes >2 i <=12");
		int columnes = Keyboard.readInt();

		while (columnes <= 2 || columnes > 12) {
			System.out.println("Incorrecte. Entra numero columnes >2 i <=12");
			columnes = Keyboard.readInt();
		}
		return columnes;
	}

	public static void valor(int [][] tauler,int files, int columnes) {
		int maxim = ((files * columnes) / 6);
		System.out.println("Indica quantes bombetes vols encendre");
		System.out.println("Especifica un valor dins de l'interval [0," + maxim + "]");
		int valor = Keyboard.readInt();

		while (valor < 0 || valor > maxim) {
			System.out.println("Valor incorrecte.Ha d'estar dins de l'interval [0," + maxim + "]");
			valor = Keyboard.readInt();
		}
		EncenAleatori(files, columnes, tauler, valor);
	}

	public static void EncenAleatori(int files, int columnes, int tauler[][], int valor) {
		int i = 0;
		while (i < valor) {
			int filaAleatoria = (int) Math.round(Math.random() * (files - 1));
			int ColumnaAleatoria = (int) Math.round(Math.random() * (columnes - 1));

			if (tauler[filaAleatoria][ColumnaAleatoria] == 0) {
				tauler[filaAleatoria][ColumnaAleatoria] = 1;
			} else {
				while (tauler[filaAleatoria][ColumnaAleatoria] == 1) {
					filaAleatoria = (int) Math.round(Math.random() * (files - 1));
					ColumnaAleatoria = (int) Math.round(Math.random() * (columnes - 1));
				}
				tauler[filaAleatoria][ColumnaAleatoria] = 1;
			}
			System.out.println("Encenem la posició "+filaAleatoria+","+ColumnaAleatoria);
			i++;
		}
		
		
	}

	public static void RecorreTauler(int tauler[][]) {

		for (int i = 0; i < tauler.length; i++) {
			for (int a = 0; a < tauler[0].length; a++) {
				System.out.print(tauler[i][a]);
			}
			System.out.println();
		}
	}

	public static int NTirades() {

		System.out.println("Especifica el numero máxim de tirades");
		int tirades = Keyboard.readInt();
		return tirades;
	}

	public static void tirades(int [][] tauler,int files, int columnes) {

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
		
		CanviEstat(tauler,fila,columna);

	}

	private static void CanviEstat(int[][] tauler, int fila, int columna) {
		
		if(columna==0 && fila==0){
			CanviEstat2(tauler,0,0);//columna==0 fila==0
			CanviEstat2(tauler,0,1);//columna==1 fila==0      
			CanviEstat2(tauler,1,0);//columna==0 fila==1
			CanviEstat2(tauler,tauler.length-1,0);//columna==0 fila==tauler.length-1
			CanviEstat2(tauler,0,tauler[0].length-1);//columna==tauler[0].length-1	fila==0
		}
		else if(columna==tauler[0].length-1 && fila==0){
			
			CanviEstat2(tauler,0,tauler[0].length-1);//columna==tauler[0].length-1 && fila==0
			CanviEstat2(tauler,1,tauler[0].length-1);//columna==tauler[0].length-1 && fila==1
			CanviEstat2(tauler,tauler.length-1,tauler[0].length-1);//columna==tauler[0].length-1 && fila==tauler.length-1
			CanviEstat2(tauler,0,tauler[0].length-2);//columna==tauler[0].length-2 && fila==0
			CanviEstat2(tauler,0,0);//columna==0 && fila==0
		}
		else if(columna==0 && fila==tauler.length-1){
			
			CanviEstat2(tauler,tauler.length-1,0);//columna==0 && fila==tauler.length-1
			CanviEstat2(tauler,tauler.length-1,1);//columna==1 && fila==tauler.length-1
			CanviEstat2(tauler,tauler.length-2,0);//columna==0 && fila==tauler.length-2
			CanviEstat2(tauler,0,0);//columna==0 && fila==0	
			CanviEstat2(tauler,tauler.length-1,tauler[0].length-1);//columna=tauler[0].length-1 && fila=tauler.length-1
		}
		
		else if(columna==tauler[0].length-1 && fila==tauler.length-1){
			
			CanviEstat2(tauler,tauler.length-1,tauler[0].length-1);//columna==tauler[0].length-1 && fila==tauler.length-1
			CanviEstat2(tauler,tauler.length-2,tauler[0].length-1);//columna==tauler[0].length-1 && fila==tauler.length-2
			CanviEstat2(tauler,0,tauler[0].length-1);//columna==tauler[0].length-1 && fila==0
			CanviEstat2(tauler,tauler.length-1,tauler[0].length-2);//columna==tauler[0].length-2 && fila==tauler.length-1
			CanviEstat2(tauler,tauler.length-1,0);//columna==0 && fila==tauler.length-1
		}
	
		else if(fila==0){
				CanviEstat2(tauler,0,columna);//fila==0 && columna==columna que el me pasa
				CanviEstat2(tauler,0,columna-1);//fila==0 && columna==comuna que el me psa -1
				CanviEstat2(tauler,1,columna);//fila=1 && columna==columna que le me psa
				CanviEstat2(tauler,tauler.length-1,columna);//fila=tauler.length-1 && columna==columna que el me pasa
			}
			else if(fila==tauler.length-1){
				CanviEstat2(tauler,tauler.length-1,columna);//fila==tauler.length-1 && columna==columna que me pasa
				CanviEstat2(tauler,tauler.length-1,columna-1);//fila=tauler.length-1 && columna=columna que me pasa -1
				CanviEstat2(tauler,tauler.length-1,columna+1);//fila=tauler.length-1 && columna=columna que me pasa +1
				CanviEstat2(tauler,tauler.length-2,columna);//fila=tauler.length-2 && columna==columna que me pasa
				CanviEstat2(tauler,0,columna);//fila==0 && columna==columna que me pasa
			}

			else if(columna==0){
						CanviEstat2(tauler,fila,0);//columna==0 && fila==fila que me pasa
						CanviEstat2(tauler,fila+1,0);//columna==0 && fila=fila que me pasa +1
						CanviEstat2(tauler,fila+1,0);//columna==0 && fila=fila que me pasa +1
						CanviEstat2(tauler,fila,1);//columna==1 && fila=fila que me pasa
						CanviEstat2(tauler,fila,tauler[0].length-1);//columna==tauler[0].length-1 && fila=fila que me pasa
					}
			else if(columna==tauler[0].length-1){
						CanviEstat2(tauler,fila,tauler[0].length-1);//columna==tauler[0].length-1 && fila==fila que pasa 
						CanviEstat2(tauler,fila+1,tauler[0].length-1);//columna==tauler[0].length-1 && fila==fila que pasa +1
						CanviEstat2(tauler,fila-1,tauler[0].length-1);//columna==tauler[0].length-1 && fila==fila que pasa -1
						CanviEstat2(tauler,fila,tauler[0].length-2);//columna==tauler[0].length-2 && fila==fila que pasa
						CanviEstat2(tauler,fila,0);//columna==0 && fila==fila que pasa
			}else{
			
				CanviEstat2(tauler,fila,columna);
				CanviEstat2(tauler,fila,columna+1);
				CanviEstat2(tauler,fila,columna-1);
				CanviEstat2(tauler,fila+1,columna);
				CanviEstat2(tauler,fila-1,columna);				
		}
	
	}

	public static void CanviEstat2(int[][] tauler, int fila, int columna){
		
		if(tauler[fila][columna]==1){
			tauler[fila][columna]=0;
		}else{
			tauler[fila][columna]=1;
		}	
	}
	
	public static void bucle(int [][] tauler,int files,int columnes){
		
		int maxim=NTirades();
		int [] encessos=new int [maxim];
		int [] apagats=new int [maxim];
		
		for (int i = 1; i <= maxim; i++) {
			System.out.println("Tirada " + i + ":");
			tirades(tauler,files, columnes);
			encessos[i]=contador(tauler);
			apagats[i]=(files*columnes)-encessos[i];
			RecorreTauler(tauler);
		}
		System.out.println("Ja no tens més tirades.El joc ha acabat");
		
	}
	
	public static int contador (int [][] tauler){
		int cont=0;
		for(int i=0;i<tauler.length;i++){
			for(int a=0;a<tauler[0].length;a++){
				if(tauler[i][a]==1){
					cont++;
				}
			}
		}
		return cont;
	}
	
	public static void revisioFinal(int maxim,int [] encessos,int [] apagats){
		int i=0;
		while(i<maxim){
			System.out.println("Tirada : "+i+++"---> tens "+encessos[i-1]+"encesos i "+apagats[i-1]+" apagades");	
		}
		System.out.println("La tirada amb més bombetes apagades ha estat");//falta acabar aixo
		
		
	}
	
	
	
	
	

}
