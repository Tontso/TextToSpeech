package text2speechapis;

public class FakeTextToSpeechAPI implements TextToSpeechAPI{

	public FakeTextToSpeechAPI() {}
	
	private String cont="";
	private int volume;
	private int pitch;
	private int rate;
	
	@Override
	public void play(String s) {
		this.cont=s;
	}
	@Override
	public void setVolume(int volume) {
		this.volume=volume;
	}
	@Override
	public void setPitch(int pitch) {
		this.pitch=pitch;
	}
	@Override
	public void setRate(int rate) {
		this.rate=rate;
	}
	public String getContents() {
		return cont;
	}
	public int getVolume() {
		return volume;
	}
	public int getPitch() {
		return pitch;	
	}
	public int gettRate() {
		return rate;
	}
}
