package commands;

import javax.swing.JTextArea;

import model.Document;
//import text2speechapis.TextToSpeechAPIFactory;

public class ContentToSpeech implements ActionListener{
	
	
	//private TextToSpeechAPIFactory APIFactory=new TextToSpeechAPIFactory();
	public ContentToSpeech() {}

	@Override
	public Document actionPerformed(String en, Document d, JTextArea t, String template, String[] info,int line,String TTS,int [] settings) {
		//d.tuneTextToSpeechAPI(APIFactory.CreateTTSAPI(TTS));
		d.PlayContents();
		return d;
	}
}
