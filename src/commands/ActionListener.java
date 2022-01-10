package commands;

import javax.swing.JTextArea;

import model.Document;

public interface ActionListener {

	public Document actionPerformed(String en, Document d, JTextArea t,String template,String [] info,int line,String TTS,int [] settings);

}
