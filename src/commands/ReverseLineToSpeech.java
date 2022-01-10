package commands;

import javax.swing.JTextArea;
import model.Document;

public class ReverseLineToSpeech implements ActionListener{
	
	public ReverseLineToSpeech() {}

	@Override
	public Document actionPerformed(String en, Document d, JTextArea t, String template, String[] info,int line,String TTS,int [] settings) {
		d.PlayReverseLine(line);
		return d;
	}
}
