package encodingstrategies;

public class StrategiesFactory {

	public StrategiesFactory(){}
	
	private EncodingStrategy ret=new Rot13Encoding();
	
	public EncodingStrategy CreateStrategy(String a) {
		switch(a) {
			case "Rot13":
				return new Rot13Encoding();
			case "AtBash":
				return new AtBashEncoding();
			default:
				System.out.println("Error encodes");
				return null;	
		}
	}
	public EncodingStrategy getEncodingStrategy() {
		return ret;
	}
}
