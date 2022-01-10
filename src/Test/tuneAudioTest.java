package Test;

import java.util.Date;
import javax.swing.JTextArea;
import org.junit.jupiter.api.Test;
import commands.CommandManager;
import model.Document;

class tuneAudioTest {

	@Test
	void test() {
		CommandManager cm=new CommandManager();
		JTextArea t=new JTextArea();
		int [] Setting= {3,150,190};
		String d=(new Date()).toString();	
		Document document=new Document("MyTitle","MyAuthor",d,"",null);
		cm.enact("7", document, t, null, null, 0, "Fake",Setting);
		
		cm.enact("7", document, t, null, null, 0, "Fake",Setting);
		System.out.println(document.getAudioManager());
		
		//if() {}
		
		System.out.println("Pass Tune Audio");
	}

}
