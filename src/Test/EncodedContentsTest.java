package Test;

import java.util.ArrayList;
import java.util.Date;
import javax.swing.JTextArea;
import org.junit.jupiter.api.Test;
import commands.CommandManager;
import model.Document;
import model.Line;

class EncodedContentsTest {

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
	
		cm.enact("12", document, t, "AtBash", info, 0, "Fake",Setting);
		if(!document.getContents().equals("Nb Gvhg Xlmgvmgh")) {
			System.out.println("Fail on Contect Atbash");
			return;
		}
		cm.enact("12", document, t, "Rot13", info, 0, "Fake",Setting);
		if(!document.getContents().equals("Ao Tiut Kyztiztu")) {
			System.out.println("Fail on Contect Rot13");
			return;
		}
		System.out.println("Pass: <<EncodedContents Test>>");
	}

}
