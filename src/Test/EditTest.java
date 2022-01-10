package Test;

import java.util.ArrayList;
import java.util.Date;
import javax.swing.JTextArea;
import org.junit.jupiter.api.Test;
import commands.CommandManager;
import model.Document;
import model.Line;

class EditTest {

	@Test
	void test() {
		CommandManager cm=new CommandManager();
		JTextArea t=new JTextArea();
		String d=(new Date()).toString();
		String info[]= {"MyTitle","MyAuthor",d};
		ArrayList <String> l1=new ArrayList<String>();
		l1.add("MyTestContents");
		Line l=new Line(l1);
		ArrayList <Line> lines=new ArrayList<Line>();
		lines.add(l);		
		Document document=new Document("MyTitle","MyAuthor",d,"",lines);
//change content
		t.setText("New Text");
		cm.enact("4", document, t, null, info, 0, "Fake",null);
	
		
		if(!document.getContents().equals("New Text")) {
			System.out.println("Fail on Contect");
			return;
		}
		System.out.println("Pass: <<Edit Test>>");
	}
}
