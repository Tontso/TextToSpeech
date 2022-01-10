package text2speechapis;

public interface TextToSpeechAPI {
	
	public void play(String s);
	public void setVolume(int volume);
	public void setPitch(int pitch);
	public void setRate(int rate);
	
	public int getVolume();
	public int getPitch();
	public int gettRate();
}
