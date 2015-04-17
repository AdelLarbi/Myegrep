package filesReader;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class BufferReader {
	
	private ArrayList<Integer> lignes;

	public BufferReader() {
		this.lignes = new ArrayList<Integer>();
	}
	
	public void getLignes() {
		if (lignes.size() == 0) {
			System.out.println("Le mot " + + " n'existe pas.");
		} else {
			
		}
	}
	
	public void imprimer(String chemin) {
		try (BufferedReader br = new BufferedReader(new FileReader(chemin))) {
			String ligneCourante;
 
			while ((ligneCourante = br.readLine()) != null) {
				System.out.println(ligneCourante);
			}
 
		} catch (IOException e) {
			System.err.println("Aucun fichier ou répertoire de ce nom.");
		}
	}
	
	public void trouver(String chemin, String mot) {
		int numLigneCourante = 0;		
		
		try (BufferedReader br = new BufferedReader(new FileReader(chemin))) {
			String ligneCourante;
 
			while ((ligneCourante = br.readLine()) != null) {				
				numLigneCourante++; 
				if (ligneCourante.toLowerCase().contains(mot.toLowerCase())) {
					lignes.add(numLigneCourante);
				}			
			}
 
		} catch (IOException e) {
			System.err.println("Aucun fichier ou répertoire de ce nom.");
		}
	}
}
