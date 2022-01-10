package commands;

import javax.swing.JTextArea;

import model.Document;

public class ReplayCommand implements ActionListener{

	private ReplayManager replayManager;
	
	public ReplayCommand() {}
	
	public Document actionPerformed(String en, Document d, JTextArea t,String template,String [] info,int line,String TTS,int [] settings) {
		return d;
	}
	public ReplayManager getReplayManager() {
		return replayManager;
	}
}
