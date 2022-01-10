package commands;

import javax.swing.JTextArea;

import encodingstrategies.StrategiesFactory;
import model.Document;
//import text2speechapis.TextToSpeechAPIFactory;

public class EncodedToSpeech implements ActionListener{
	
	private StrategiesFactory sf=new StrategiesFactory();
	//private TextToSpeechAPIFactory APIFactory=new TextToSpeechAPIFactory();
	
	public EncodedToSpeech() {}
	
	@Override
	public Document actionPerformed(String en, Document d, JTextArea t, String template, String[] info,int line,String TTS,int [] settings) {
		//d.tuneTextToSpeechAPI(APIFactory.CreateTTSAPI(TTS));
		d.tuneEncodingStrategy(sf.CreateStrategy(template));
		t.setText(d.getContents());
		d.PlayEncodedContents();
		return d;
	}

}
