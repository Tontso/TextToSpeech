package commands;

import javax.swing.JTextArea;
import model.Document;

public class TuneAudio implements ActionListener {
		
	
	
	public TuneAudio() {}
	
	@Override
	public Document actionPerformed(String en, Document d, JTextArea t, String template, String[] info,int line,String TTS,int [] settings) {
		d.getAudioManager().setVolume(settings[0]);
		d.getAudioManager().setPitch(settings[1]);
		d.getAudioManager().setRate(settings[2]);

		return d;
	}

}
