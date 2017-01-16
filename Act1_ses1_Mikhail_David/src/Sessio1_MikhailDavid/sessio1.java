package Sessio1_MikhailDavid;

import Keyboard.*;

public class sessio1 {//comentario

	public static void main(String args[]) {

		int files = files();
		int columnes = columnes();

		int tauler[][] = new int[files][columnes]; // Creació del tauler

		int valor = valor(files, columnes);
		EncenAleatori(files, columnes, tauler, valor);
		RecorreTauler(tauler);

		for (int i = 0; i < NTirades(); i++) {
			System.out.println("Tirada " + i + ":");
			tirades(files, columnes);
			RecorreTauler(tauler);
		}

		
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

		System.out.println("Indica les dimensions del taulell");
		System.out.println("Entra un número de files>2 i <=12");
		int columnes = Keyboard.readInt();

		while (columnes <= 2 || columnes > 12) {
			System.out.println("Incorrecte. Entra files files>2 i <=12");
			columnes = Keyboard.readInt();
		}
		return columnes;
	}

	public static int valor(int files, int columnes) {
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
			}
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

		System.out.println("Especifica el numero de tirades");
		int tirades = Keyboard.readInt();
		return tirades;
	}

	public static void tirades(int files, int columnes) {

		System.out.println("**************");
		System.out.println("Indica les coordenades del botó a premer");
		System.out.println("Indica la fila:");
		System.out.println("**************");
		System.out.println("Especifica un valor entre l'interval [0, " + (files - 1));
		int fila = Keyboard.readInt();

		while (fila < 0 || fila > files - 1) {
			System.out.print("Valor de la fila fora de l'interval.Ha d'estar entre [0, " + (files - 1));
			System.out.println("Torna a introduir el valor de la fila");
			fila = Keyboard.readInt();
		}

		System.out.println("Indica la columna:");
		System.out.println("**************");
		System.out.println("Especifica un valor entre l'interval [0, " + (columnes - 1));
		int columna = Keyboard.readInt();

		while (columna < 0 || columna > columnes - 1) {
			System.out.print("Valor de la columna fora de l'interval.Ha d'estar entre [0, " + (files - 1));
			System.out.println("Torna a introduir el valor de la columna");
			columna = Keyboard.readInt();
		}

	}

	private static void CanviEstat(int[][] tauler, int fila, int columna) {
		
		
		if(columna==0 && fila==0){
			
			//columna==1 fila==0      //columna=columna+1 fila=fila
			//columna==0 fila==1
			//columna==0 fila==tauler.length-1
			//columna==tauler[0].length-1	fila==0
	
		}
		if(columna==tauler[0].length-1 && fila==0){
			
			//columna==tauler[0].length-1 && fila==0
			//columna==tauler[0].length-1 && fila==1
			//columna==tauler[0].length-1 && fila==tauler.length-1
			//columna==tauler[0].length-1 && fila==0
			//columna==0 && fila==0
		}
		if(columna==0 && fila==tauler.length-1){
			
			//columna==0 && fila==tauler.length-1
			//columna==1 && fila==tauler.length-1
			//columna==0 && fila==tauler.length-2
			//columna==0 && fila==0	
			//columna=tauler[0].length-1 && fila=tauler.length
		}
		
		if(columna==tauler[0].length-1 && fila==tauler.length-1){
			
			//columna==tauler[0].length && fila==0
			//
			//
			
		}
		

	}

}
