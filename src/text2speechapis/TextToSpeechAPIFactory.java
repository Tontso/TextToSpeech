package text2speechapis;

public class TextToSpeechAPIFactory{

	public TextToSpeechAPIFactory() {}
	
	private TextToSpeechAPI ttsAPI=new FreeTTSAdapter();
	
	public TextToSpeechAPI CreateTTSAPI(String a) {
		switch(a) {
			case "Adapter":
				return new  FreeTTSAdapter();
			case "Fake":
				return new FakeTextToSpeechAPI();
			default:
				System.out.println("Error encode key");
				return null;
		}
	}
	
	public TextToSpeechAPI getTTSAPI() {
		return ttsAPI;
	}
	
}
