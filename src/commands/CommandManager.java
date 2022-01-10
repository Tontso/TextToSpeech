package commands;


import java.util.HashMap;

import javax.swing.JTextArea;

import model.Document;

public class CommandManager {
	private HashMap<String, String> map = new HashMap<String, String>();
	private Document doc; 
	private CommandsFactory cf = new CommandsFactory();
	
	public CommandManager() {
		map.put("1","SaveDocument");
		map.put("2","NewDocument");
		map.put("3","OpenDocument");
		map.put("4","EditDocument");
		map.put("5","TuneEncoding");
		map.put("6","LineToSpeech");
		map.put("7","TuneAudio");
		map.put("8","ReplayCommand");
		map.put("9","ContentToSpeech");
		map.put("10","ReverseToSpeech");
		map.put("11","ReverseLineToSpeech");
		map.put("12","EncodedToSpeech");
		map.put("13","EncodedLineToSpeech");
	}
	
	public void enact(String en,Document d,JTextArea t,String template,String [] info,int line,String TTS,int [] settings) {
		String temp = map.get(en);
		d=cf.createCommand(temp).actionPerformed(en,d,t,template,info,line,TTS,settings);
	}
	
	public Document getDocument() {
		return doc;
	}
}
