package Test;

import java.util.ArrayList;
import java.util.Date;
import javax.swing.JTextArea;
import org.junit.jupiter.api.Test;
import commands.CommandManager;
import model.Document;
import model.Line;

class ReverseContentsTest {

	@Test
	void test() {
		CommandManager cm=new CommandManager();
		JTextArea t=new JTextArea();
		int [] Setting= {3,150,190};
		String d=(new Date()).toString();
		String info[]= {"MyTitle","MyAuthor",d};
		ArrayList <String> l1=new ArrayList<String>();
		l1.add("My Test Contents");
		Line l=new Line(l1);
		ArrayList <Line> lines=new ArrayList<Line>();
		lines.add(l);		
		Document document=new Document("MyTitle","MyAuthor",d,"",lines);
	
		cm.enact("10", document, t, null, info, 0, "Fake",Setting);
		
		//if() {}
		
		System.out.println("Pass: <<ReverseContnents Test>>");
	}

}
