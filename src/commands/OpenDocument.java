package commands;

import java.io.BufferedReader;
import java.io.FileReader;
import javax.swing.JTextArea;
import model.Document;

public class OpenDocument implements ActionListener {

	public OpenDocument() {}
	
	public Document actionPerformed(String en, Document d, JTextArea t,String template,String [] info,int line,String TTS,int [] settings) {
		try (BufferedReader br = new BufferedReader(new FileReader(template))) {
			String next;
			String title= br.readLine();
			String author= br.readLine();
			String dateCreated= br.readLine();
			String dateSaved= br.readLine();
			String contents="";
			while ((next= br.readLine()) != null)
	        {
				contents+=next+"\n";
	        }
			t.setText(contents);
			d.setTitle(title);
			d.setAuthor(author);
			d.setDateCreated(dateCreated);
			d.setDateSaved(dateSaved);
			d.setContents(contents);
		}	
		catch(Exception e){
			e.printStackTrace();
		}
		return d;
	}
}
