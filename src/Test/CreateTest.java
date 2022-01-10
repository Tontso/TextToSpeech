package Test;

import java.util.Date;
import javax.swing.JTextArea;
import org.junit.jupiter.api.Test;
import commands.CommandManager;
import model.Document;

class CreateTest {

	@Test
	void test() {
		CommandManager cm=new CommandManager();
		Document document=new Document("","","","",null);
		JTextArea t=new JTextArea();

		String d=(new Date()).toString();
		String info[]= {"MyTitle","MyAuthor",d,null,null};
		cm.enact("2", document, t,null, info, 0,null,null);
		
		if(!document.getTitle().equals("MyTitle")) {
			System.out.println("Fail on Title");
			return;
		}
		
		if(!document.getAuthor().equals("MyAuthor")) {
			System.out.println("Fail on Author");
			return;
		}
		
		if(!document.getDateCreated().equals(d)) {
			System.out.println("Fail on DateCreated");
			return;
		}
		
		if(!document.getContents().equals("")) {
			System.out.println("Fail on Contents");
			return;
		}
		
		System.out.print("Pass: <<Create Test>>");
	}
}
