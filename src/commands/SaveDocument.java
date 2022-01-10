package commands;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

import javax.swing.JTextArea;

import model.Document;

public class SaveDocument implements ActionListener{
	
	public SaveDocument() {}
	@Override
	public Document actionPerformed(String en, Document d, JTextArea t,String template,String [] info,int line,String TTS,int [] settings) {
		d.setDateSavedNow(new Date());
		try {
			StringBuilder contentBuilder = new StringBuilder();
			contentBuilder.append(d.getTitle()).append("\n");
			contentBuilder.append(d.getAuthor()).append("\n");
			contentBuilder.append(d.getDateCreated()).append("\n");
			contentBuilder.append(d.getDateSaved()).append("\n");
			contentBuilder.append(d.getContents()).append("\n");
			String x=contentBuilder.toString();
			//d.setContents(contentBuilder.toString());
			//System.out.println(d.getContents());
			FileWriter fw;
			fw = new FileWriter(template+".txt");
			BufferedWriter buf=new BufferedWriter (fw);
			buf.write(x);
			buf.close();
		    fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("date saved: "+ d.getDateSaved());
		return d;
	}
}
