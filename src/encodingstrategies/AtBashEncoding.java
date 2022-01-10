package encodingstrategies;

public class AtBashEncoding implements EncodingStrategy {

	public AtBashEncoding() {}
	
	public String encode(String en) 
	{
		try {
			String result="";
			char[] charArray = en.toCharArray();
			for (int i = 0; i < charArray.length; i++){
				char c = charArray[i];
				if (c >= 'a' && c <= 'z'){
					charArray[i] = (char) (96 + (123 - c));
				}
				else if (c >= 'A' && c <= 'Z'){
					charArray[i] = (char) (64 + (91 - c));
				}
				result+=charArray[i];
			}
			en=result;
		}catch (Exception e1) {
			System.out.println("something wrong with encode");
			e1.printStackTrace();
		}
		return en;
	}
	
	protected char mapCharachter(char c) {
		return c;
	}
}
