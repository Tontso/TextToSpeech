package model;

import java.util.ArrayList;
import encodingstrategies.EncodingStrategy;
import encodingstrategies.Rot13Encoding;
//import encodingstrategies.StrategiesFactory;
import text2speechapis.FreeTTSAdapter;
import text2speechapis.TextToSpeechAPI;
//import text2speechapis.TextToSpeechAPIFactory;

public class Line {
	private ArrayList<String> words;
	
	private EncodingStrategy encodingStrategy=new Rot13Encoding() ;
	private TextToSpeechAPI audioManager=new FreeTTSAdapter();
	
	//private StrategiesFactory strategiesFactory=new StrategiesFactory();
	//private TextToSpeechAPIFactory audioFactory=new TextToSpeechAPIFactory();
	
	public Line(ArrayList<String> w) {
		this.words=w;
	}
	
	public void PlayLine() {
		audioManager.play(words.toString());
	}
	
	@SuppressWarnings("null")
	public void PlayReverseLine() {
		String w[]=words.toString().split("\\s");
		String reverse="";
		for(int i= w.length-1;i>=0;i--) {
			reverse=reverse+w[i]+" ";
		}
		ArrayList<String> s = null ;
		s.add(reverse);
		this.setLine(s);
		audioManager.play(reverse);
	}
	
	@SuppressWarnings("null")
	public void PlayEncodedLine() {
		String en=encodingStrategy.encode(words.toString());
		ArrayList<String> s = null ;
		s.add(en);
		this.setLine(s);
		audioManager.play(en);
	}
	
	public void EncodingStrategy(EncodingStrategy es) {
		encodingStrategy=es;
	}
	
	public String getLine(int i){
		return words.get(i).toString();
	}
	
	public void setLine(ArrayList<String> w){
		this.words=w;
	}
}
