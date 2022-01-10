package commands;

import javax.swing.JTextArea;

import encodingstrategies.StrategiesFactory;
import model.Document;

public class TuneEncoding implements ActionListener{
	
	private StrategiesFactory sf=new StrategiesFactory();
	
	public TuneEncoding(){}
	
	public Document actionPerformed(String en, Document d, JTextArea t,String template,String [] info,int line,String TTS,int [] settings) {
		d.tuneEncodingStrategy(sf.CreateStrategy(template));
		t.setText(d.getContents());
		return d;
	}
}
