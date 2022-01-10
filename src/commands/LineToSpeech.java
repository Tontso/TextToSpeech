package commands;

import javax.swing.JTextArea;
import model.Document;

public class LineToSpeech implements ActionListener{
	
	public LineToSpeech() {}
	
	public Document actionPerformed(String en, Document d, JTextArea t,String template,String [] info,int line,String TTS,int [] settings) {
		d.PlayLine(line);
		return d;
	}
}
