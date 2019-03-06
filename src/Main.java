import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) throws IOException {

		JFrame frame = new JFrame("TP6");
		String fileDirectory = null;
	    while(fileDirectory == null) {
	    	fileDirectory = JOptionPane.showInputDialog(
	    			frame, 
	        	"Entrez le nom du fichier", 
	        	"Fichier", 
	        	JOptionPane.QUESTION_MESSAGE
	    			);
	    }
	    
		File defaut = new File(System.getProperty("user.dir") + File.separator + fileDirectory);
		try {
			lectureFichier(defaut);
				
		}
		catch (IOException e) {
			e.printStackTrace();
			BufferedWriter bw;
			
			bw = new BufferedWriter(new FileWriter(defaut));
		 
			bw.write("Je suis a present bien rempli !");
			bw.close();
			System.out.println("Le fichier a bien été créé");
		}

	}
	
	public static void lectureFichier(File fichier) throws IOException {
		if (!fichier.exists()) {
			System.out.println("Le fichier n'existe pas");
			throw new IOException("Le fichier n'existe pas");
		}
		else {
			System.out.println(fichier.getAbsolutePath());
			if(fichier.isDirectory())
				System.out.println("It is a directory");
			else
				System.out.println("It is a file");
			System.out.println("Name= "+fichier.getName());
			System.out.println("Size= "+fichier.length() +" octets");
			System.out.println("Contenu du fichier :");
			BufferedReader objReader = new BufferedReader(new FileReader(fichier));
			String charToPrint = objReader.readLine();
			int nbOfLine = 0;
			ArrayList<Forme> formes = new ArrayList<Forme>();
			
			while (charToPrint != null) {
				String tmpLine = charToPrint;
				Forme tmpForme = new Forme();
				if(tmpLine.startsWith("<p>")) {
					tmpForme.setType(tmpLine.substring(28, (tmpLine.indexOf("</b>") - 1) ));
					tmpForme.setDebutX(Integer.parseInt( tmpLine.substring(tmpLine.indexOf("<b>debut</b>") + 16, (tmpLine.indexOf(",y=")) ) ));
					tmpForme.setDebutY(Integer.parseInt( tmpLine.substring(tmpLine.indexOf(",y=") + 3, (tmpLine.indexOf("<b>fin</b>") - 2) ) ));
					tmpForme.setFinX(Integer.parseInt( tmpLine.substring(tmpLine.indexOf("<b>fin</b>") + 14, (tmpLine.indexOf(",y=", tmpLine.indexOf("<b>fin</b>"))) ) ));
					tmpForme.setFinY(Integer.parseInt( tmpLine.substring(tmpLine.indexOf(",y=", tmpLine.indexOf("<b>fin</b>")) + 3, (tmpLine.indexOf("<b>couleur</b>") - 2) ) ));
					tmpForme.setCouleurR(Integer.parseInt( tmpLine.substring(tmpLine.indexOf("<b>couleur</b>") + 18, (tmpLine.indexOf(", v=")) ) ));
					tmpForme.setCouleurV(Integer.parseInt( tmpLine.substring(tmpLine.indexOf(", v=") + 4, (tmpLine.indexOf(", b=")) ) ));
					tmpForme.setCouleurB(Integer.parseInt( tmpLine.substring(tmpLine.indexOf(", b=") + 4, (tmpLine.indexOf("</p>") -1) ) ));
					System.out.println(tmpForme.getCouleurB());
					formes.add(tmpForme);
				}
				
				
				
				
			    System.out.println(charToPrint + " ==> "+charToPrint.length() + " Octets");
			    charToPrint = objReader.readLine();
				nbOfLine++;
			}
			System.out.println("nbLignes = "+nbOfLine);
			objReader.close();
			for (Forme object : formes) {
				System.out.println(object);
			}
		}
		
	}

}
