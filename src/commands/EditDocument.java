package commands;

import javax.swing.JTextArea;
import model.Document;

public class EditDocument implements ActionListener{
	
	public EditDocument() {}
	
	public Document actionPerformed(String en, Document d, JTextArea t,String template,String [] info,int line,String TTS,int [] settings) {
		d.setContents(t.getText().toString());
		return d;
	}
	
}
