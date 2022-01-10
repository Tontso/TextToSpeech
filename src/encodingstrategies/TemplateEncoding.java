package encodingstrategies;

public abstract class TemplateEncoding implements EncodingStrategy{

	public TemplateEncoding(){}
	
	public String encode(String s) 
	{
		return s;
	}
	protected abstract char mapCharachter(char c);
}
