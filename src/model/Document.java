package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import encodingstrategies.EncodingStrategy;
import encodingstrategies.Rot13Encoding;
import text2speechapis.FreeTTSAdapter;
import text2speechapis.TextToSpeechAPI;

public class Document {
	private String title;
	private String author;
	private String dateCreated;
	private String dateSaved;
	private ArrayList<Line> lines;

	private EncodingStrategy encodingStrategy=new Rot13Encoding() ;
	private TextToSpeechAPI audioManager=new FreeTTSAdapter();
	
	public Document(String title,String author,String dateCreated,String dateSaved,ArrayList<Line> lines) {
		this.title = title;
		this.author = author;
		this.dateCreated = dateCreated;
		this.dateSaved=dateSaved;
		this.lines=lines;
	}
	
	public void PlayContents() {
		audioManager.play(this.getContents());
	}
	
	public void PlayReverseContents() {
		String w[]=this.getContents().split("\\s");
		String reverse="";
		for(int i= w.length-1;i>=0;i--) {
			reverse=reverse+w[i]+" ";
		}
		audioManager.play(reverse);
	}
	
	public void PlayLine(int x) {
		String l=lines.get(0).getLine(x);
		System.out.println(l);
		audioManager.play(l);
	}
	
	public void PlayReverseLine(int x) {
		String w[]=lines.get(0).getLine(x).toString().split("\\s");
		String reverse="";
		for(int i= w.length-1;i>=0;i--) {
			reverse=reverse+w[i]+" ";
		}
		audioManager.play(reverse);
	}
	
	public void PlayEncodedLine(int x) {
		String en=encodingStrategy.encode(lines.get(0).getLine(x).toString());
		audioManager.play(en);
	}
	
	public void PlayEncodedContents() {
		String en=encodingStrategy.encode(getContents());
		this.setContents(en);
		audioManager.play(en);
	}
	
//SET
	public void setTitle(String title) {
		this.title=title;
	}
	public void setAuthor(String author) {
		this.author=author;
	}
	public void setDateCreated(String d) {
		this.dateCreated=d;
	}
	public void setDateSaved(String d) {
		this.dateSaved=d;
	}
	
	public void setDateSavedNow(Date date) {
		this.dateSaved=date.toString();
	}
	public void setDateCreatedNow(Date date) {
		this.dateCreated = date.toString();
	}
	public void setContents(String contents) { 
		this.lines=new ArrayList<Line>();

		String line[] = contents.split("\\r?\\n");
		for(int i=0;i<line.length;i++) 
		{
			ArrayList<String> arraystring = new ArrayList<>(Arrays.asList(line)) ;
			Line newline=new Line(arraystring);
			lines.add(newline);			
		}
	}
//GET
	public String getTitle() {
		return title;
	}
	public String getAuthor() {
		return author;
	}
	public String getDateCreated() {
		return dateCreated;
	} 
	public String getDateSaved() {
		return dateSaved;	
	}
	public String getContents() {
		String x="";
		try {
			for(int i=0;i<lines.size();i++) 
			{
				x += lines.get(0).getLine(i).toString();	
				if(i!=lines.size()-1) {
					x+="\n";
				}
			}
		} catch (Exception e1) {
			
		}
		return x;	
	}
	
	public String getLine(int l) {
		String x=this.lines.get(l).toString();
		System.out.print("Get line: " +x);
		return x; 
	}
		
	public void tuneTextToSpeechAPI(TextToSpeechAPI x) {
		this.audioManager=x;
	}
	
	public void tuneEncodingStrategy(EncodingStrategy x) {
		this.encodingStrategy=x;
	}
	
	public EncodingStrategy getEncodingStrategy() {
		return this.encodingStrategy;
	}
	
	public TextToSpeechAPI getAudioManager() {
		return this.audioManager;
	}
}
