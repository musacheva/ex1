package Sessio2_MikhailDAvid;

import Keyboard.Keyboard;

public class Taulell {
	
	private int[][] taula;
	private int files;
	private int columnes;
	private int bombEnc=0;
	
	public Taulell(){
		files = files();
		columnes= columnes();
		taula = new int[files][columnes];
		
		apagarTot();
	}
	
	public void encendre(int n){
		
		bombEnc += n;
		
		for(int i=0;i<n;i++){
			
			int filaAleatoria = (int) Math.round(Math.random() * (files - 1));
			int ColumnaAleatoria = (int) Math.round(Math.random() * (columnes - 1));

			if (taula[filaAleatoria][ColumnaAleatoria] == 0) {
				taula[filaAleatoria][ColumnaAleatoria] = 1;
			} else {
				while (taula[filaAleatoria][ColumnaAleatoria] == 1) {
					filaAleatoria = (int) Math.round(Math.random() * (files - 1));
					ColumnaAleatoria = (int) Math.round(Math.random() * (columnes - 1));
				}
				taula[filaAleatoria][ColumnaAleatoria] = 1;
			}
					
		}
		
	}
	
	public void mostraTaula(){
		
		for(int i=0;i<files;i++){
			for(int j=0;j<columnes;j++){
				System.out.print(taula[i][j]);
			}
			System.out.println("");
		}
		
	}
	
	public void setCasella(int fila, int columna){
		if(columna==0 && fila==0){
			CanviEstat2(taula,0,0);//columna==0 fila==0
			CanviEstat2(taula,0,1);//columna==1 fila==0      
			CanviEstat2(taula,1,0);//columna==0 fila==1
			CanviEstat2(taula,taula.length-1,0);//columna==0 fila==tauler.length-1
			CanviEstat2(taula,0,taula[0].length-1);//columna==tauler[0].length-1	fila==0
		}
		else if(columna==taula[0].length-1 && fila==0){
			
			CanviEstat2(taula,0,taula[0].length-1);//columna==tauler[0].length-1 && fila==0
			CanviEstat2(taula,1,taula[0].length-1);//columna==tauler[0].length-1 && fila==1
			CanviEstat2(taula,taula.length-1,taula[0].length-1);//columna==tauler[0].length-1 && fila==tauler.length-1
			CanviEstat2(taula,0,taula[0].length-2);//columna==tauler[0].length-2 && fila==0
			CanviEstat2(taula,0,0);//columna==0 && fila==0
		}
		else if(columna==0 && fila==taula.length-1){
			
			CanviEstat2(taula,taula.length-1,0);//columna==0 && fila==tauler.length-1
			CanviEstat2(taula,taula.length-1,1);//columna==1 && fila==tauler.length-1
			CanviEstat2(taula,taula.length-2,0);//columna==0 && fila==tauler.length-2
			CanviEstat2(taula,0,0);//columna==0 && fila==0	
			CanviEstat2(taula,taula.length-1,taula[0].length-1);//columna=tauler[0].length-1 && fila=tauler.length-1
		}
		
		else if(columna==taula[0].length-1 && fila==taula.length-1){
			
			CanviEstat2(taula,taula.length-1,taula[0].length-1);//columna==tauler[0].length-1 && fila==tauler.length-1
			CanviEstat2(taula,taula.length-2,taula[0].length-1);//columna==tauler[0].length-1 && fila==tauler.length-2
			CanviEstat2(taula,0,taula[0].length-1);//columna==tauler[0].length-1 && fila==0
			CanviEstat2(taula,taula.length-1,taula[0].length-2);//columna==tauler[0].length-2 && fila==tauler.length-1
			CanviEstat2(taula,taula.length-1,0);//columna==0 && fila==tauler.length-1
		}
	
		else if(fila==0){
				CanviEstat2(taula,0,columna);//fila==0 && columna==columna que el me pasa
				CanviEstat2(taula,0,columna-1);//fila==0 && columna==comuna que el me psa -1
				CanviEstat2(taula,1,columna);//fila=1 && columna==columna que le me psa
				CanviEstat2(taula,taula.length-1,columna);//fila=tauler.length-1 && columna==columna que el me pasa
			}
			else if(fila==taula.length-1){
				CanviEstat2(taula,taula.length-1,columna);//fila==tauler.length-1 && columna==columna que me pasa
				CanviEstat2(taula,taula.length-1,columna-1);//fila=tauler.length-1 && columna=columna que me pasa -1
				CanviEstat2(taula,taula.length-1,columna+1);//fila=tauler.length-1 && columna=columna que me pasa +1
				CanviEstat2(taula,taula.length-2,columna);//fila=tauler.length-2 && columna==columna que me pasa
				CanviEstat2(taula,0,columna);//fila==0 && columna==columna que me pasa
			}

			else if(columna==0){
						CanviEstat2(taula,fila,0);//columna==0 && fila==fila que me pasa
						CanviEstat2(taula,fila+1,0);//columna==0 && fila=fila que me pasa +1
						CanviEstat2(taula,fila+1,0);//columna==0 && fila=fila que me pasa +1
						CanviEstat2(taula,fila,1);//columna==1 && fila=fila que me pasa
						CanviEstat2(taula,fila,taula[0].length-1);//columna==tauler[0].length-1 && fila=fila que me pasa
					}
			else if(columna==taula[0].length-1){
						CanviEstat2(taula,fila,taula[0].length-1);//columna==tauler[0].length-1 && fila==fila que pasa 
						CanviEstat2(taula,fila+1,taula[0].length-1);//columna==tauler[0].length-1 && fila==fila que pasa +1
						CanviEstat2(taula,fila-1,taula[0].length-1);//columna==tauler[0].length-1 && fila==fila que pasa -1
						CanviEstat2(taula,fila,taula[0].length-2);//columna==tauler[0].length-2 && fila==fila que pasa
						CanviEstat2(taula,fila,0);//columna==0 && fila==fila que pasa
			}else{
			
				CanviEstat2(taula,fila,columna);
				CanviEstat2(taula,fila,columna+1);
				CanviEstat2(taula,fila,columna-1);
				CanviEstat2(taula,fila+1,columna);
				CanviEstat2(taula,fila-1,columna);				
		}
	}
	
	private void CanviEstat2(int[][] tauler, int fila, int columna){
		
		if(tauler[fila][columna]==1){
			tauler[fila][columna]=0;
			bombEnc--;
		}else{
			tauler[fila][columna]=1;
			bombEnc++;
		}	
	}
	
	private static int files() {
		System.out.println("Indica les dimensions del taulell");
		System.out.println("Entra un número de files>2 i <=12");
		int files = Keyboard.readInt();

		while (files <= 2 || files > 12) {
			System.out.println("Incorrecte.Entra files>2 i <=12");
			files = Keyboard.readInt();
		}

		return files;
	}
	
	private static int columnes() {

		System.out.println("Entra un número de columnes >2 i <=12");
		int columnes = Keyboard.readInt();

		while (columnes <= 2 || columnes > 12) {
			System.out.println("Incorrecte. Entra numero columnes >2 i <=12");
			columnes = Keyboard.readInt();
		}
		return columnes;
	}
	
	public void apagarTot(){
		for (int i =0;i<files;i++){//Inicializaci�n a 0.
			for(int j=0;j<columnes;j++){
				taula[i][j]=0;
			}
		}
		bombEnc=0;
	}
	
	public int getFiles(){
		return files;
	}
	
	public int getColumnes(){
		return columnes;
	}
	
	public int getBombetesEnceses(){
		return bombEnc;
	}
}
