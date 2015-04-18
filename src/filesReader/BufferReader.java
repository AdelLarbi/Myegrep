package filesReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class BufferReader {
	
	private boolean isTrouver = false;
	
	public void explorerDossier(String mot, String chemin) {
		File dossier = new File(chemin);
		File[] listeFichiers = dossier.listFiles();

    	for (int i = 0; i < listeFichiers.length; i++) {
    		if (listeFichiers[i].isFile()) {
    			System.out.println("Dans : " + chemin + listeFichiers[i].getName());
    			this.trouver(mot, chemin + listeFichiers[i].getName());
    			if (!isTrouver) {
    				System.out.println("Je ne trouve pas le mot : " + mot + "." );
    			}
    			System.out.print("\n-----------------------------------------");
    			System.out.println("---------------------------------------\n");    
    		} else if (listeFichiers[i].isDirectory()) {    			
    			this.explorerDossier(mot, chemin + listeFichiers[i].getName() + "/");
    		}
    	}	
	}
	
	private void trouver(String mot, String chemin) {
		int numLigneCourante = 0;				
		ArrayList<Integer> lignes = new ArrayList<Integer>();
		
		try (BufferedReader br = new BufferedReader(new FileReader(chemin))) {
			String ligneCourante;
 
			while ((ligneCourante = br.readLine()) != null) {				
				numLigneCourante++; 
				if (ligneCourante.toLowerCase().contains(mot.toLowerCase())) {					
					System.out.print("ligne [" + numLigneCourante + "] ");																												
					this.afficherLigne(mot.toLowerCase(), ligneCourante.toLowerCase());										
					lignes.add(numLigneCourante);						
				}
			}
			
			br.close();			
			
			if (lignes.size() == 0) {
				isTrouver = false;
			} else {
				isTrouver = true;
			}
			
		} catch (IOException e) {
			System.err.println("Aucun fichier ou répertoire de ce nom");
		}
	}
	
	private void afficherLigne(String mot, String ligneCourante) {
		String[] split = ligneCourante.split(mot);
		String avant = split[0];
		String apres = split[1];
		
		int tailleAvant = avant.length();
		int tailleApres = apres.length();
		
		// J'affiche uniquement les 20 premier char avant le mot
		if (tailleAvant > 20) {
			char[] avantTmp = avant.toCharArray();
			avant = "";
			for (int i = tailleAvant-20; i < tailleAvant; i++) {
				avant += avantTmp[i];
			}
		}
		
		// J'affiche uniquement les 20 premier char aprés le mot
		if (tailleApres > 20) {
			char[] apresTmp = apres.toCharArray();
			apres = "";
			for (int i = 0; i < 20; i++) {
				apres += apresTmp[i];
			}
		}
		
		System.out.print("..." + avant + "{");
		System.out.print(mot);
		System.out.println("}" + apres + "...");
	}
}
