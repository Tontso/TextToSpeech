package text2speechapis;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

public class FreeTTSAdapter implements TextToSpeechAPI{

	private int volume=3;
	private int pitch=150;
	private int rate=190;
	
	public FreeTTSAdapter() {}
	
	@Override
	public void play(String s) {
		try {
			Voice voice;
			System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
			VoiceManager freeVM = VoiceManager.getInstance();
			voice = freeVM.getVoice("kevin16");
	    	if (voice != null) {
	    		
	    		System.out.println("volume: "+this.volume);
	    		System.out.println("pitch: "+ this.pitch);
	    		System.out.println("rate: "+this.rate);
	    		
	        	voice.allocate();// Allocating Voice
	            voice.setRate(this.rate);// Setting the rate of the voice
	            voice.setPitch(this.pitch);// Setting the Pitch of the voice
	            voice.setVolume(this.volume);// Setting the volume of the voice
	            voice.speak(s);// Calling speak()
	            System.out.println("speak: "+ s);
	    	} else {
	        	throw new IllegalStateException("Cannot find voice: kevin16");
	    	}
		} catch (Exception e1) {
            e1.printStackTrace();
        }
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
