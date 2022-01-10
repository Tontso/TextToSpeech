package encodingstrategies;

public class Rot13Encoding implements EncodingStrategy {

	public Rot13Encoding() {}
	
	public String encode(String en) 
	{
		int k=13;
		try {
			String encode="";
			char word[]=en.toCharArray();;
			for(int j=0;j<word.length;j++) {
				int val= word[j];
				if(val>=97 && val<=122) {
					int dup=k;
					if(val+k>122){
						k-=(122-val);
						k=k%26;
						word[j]=(char)(96+k);
					}else {
						word[j]=(char)(val+k);
					}
					k=dup;
				}	
				else if(val>=65 && val<=90) {
					int dup=k;
					if(val+k>90){
						k-=(90-val);
						k=k%26;
						word[j]=(char)(64+k);
					}else {
						word[j]=(char)(val+k);
					}
					k=dup;
				}
				else{
					word[j]=(char)val;
				}
				encode+=word[j];
			}
			en=encode;
			//System.out.println(en);
		}catch (Exception e1) {
			System.out.println("somethinf wrong with encode");
            e1.printStackTrace();
        }	
		return en;
	}
	
	protected char mapCharachter(char c) {
		return c;
	}
}

