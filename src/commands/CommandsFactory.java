 package commands;

public class CommandsFactory {
	
	public CommandsFactory() {}
	
	private SaveDocument saveDocument= new SaveDocument();
	private NewDocument newDocument=new NewDocument();
	private OpenDocument openDocument=new OpenDocument();
	private EditDocument editDocument= new EditDocument();
	private ReplayCommand replayCommand= new ReplayCommand();
	private TuneEncoding tuneEncoding= new TuneEncoding();
	private TuneAudio tuneAudio= new TuneAudio();
	private LineToSpeech lineToSpeech= new LineToSpeech();
	private ContentToSpeech contentToSpeech =new ContentToSpeech();
	private ReverseToSpeech reverseToSpeech= new ReverseToSpeech();
	private ReverseLineToSpeech reverseLineToSpeech= new ReverseLineToSpeech();
	private EncodedToSpeech encodedToSpeech= new EncodedToSpeech();
	private EncodedLineToSpeech encodedLineToSpeech= new EncodedLineToSpeech(); 
	
	
	public ActionListener createCommand(String a) {
		switch(a) {
		case "SaveDocument":
			return saveDocument;
		case "NewDocument":
			return newDocument;
		case "OpenDocument":
			return openDocument;
		case "EditDocument":
			return editDocument;
		case "ReplayCommand":
			return replayCommand;
		case "TuneEncoding":
			return tuneEncoding;
		case "TuneAudio":
			return tuneAudio;
		case "LineToSpeech":
			return lineToSpeech;
		case "ContentToSpeech":
			return contentToSpeech;
		case "ReverseToSpeech":
			return reverseToSpeech;
		case "ReverseLineToSpeech":
			return reverseLineToSpeech;
		case "EncodedToSpeech":
			return encodedToSpeech;
		case "EncodedLineToSpeech":
			return encodedLineToSpeech; 
		default:
			System.out.println("Error, no command");
			return null;
		}
	}

}
