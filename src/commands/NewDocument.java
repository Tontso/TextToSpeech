package commands;

import javax.swing.JTextArea;
import model.Document;

public class NewDocument implements ActionListener{

	public NewDocument() {}
	
	public Document actionPerformed(String en, Document d, JTextArea t,String template,String [] info,int line,String TTS,int [] settings) {
		t.setEditable(true);
		t.setText(d.getContents());
		d.setTitle(info[0]);
		d.setAuthor(info[1]);
		d.setDateCreated(info[2]);
		System.out.println("date created: "+info[2]);
		return d;
	}
}
