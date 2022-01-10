package Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JTextArea;
import org.junit.jupiter.api.Test;
import commands.CommandManager;
import model.Document;
import model.Line;

class SaveTest {

	@Test
	void test() {
		CommandManager cm=new CommandManager();
		JTextArea t=new JTextArea();
		String d=(new Date()).toString();
		ArrayList <String> l1=new ArrayList<String>();
		l1.add("My Test Contents");
		Line l=new Line(l1);
		ArrayList <Line> lines=new ArrayList<Line>();
		lines.add(l);		
		Document document=new Document("MyTitle","MyAuthor",d,"",lines);
		cm.enact("1", document, t,"test", null, 0,null,null);
		
//read from file		
		String title="";
		String author="";
		String dateCreated="";
		String dateSaved="";
		String contents="";
		
		try {
			int counter=0;
			@SuppressWarnings("resource")
			BufferedReader reader = new BufferedReader(new FileReader("test.txt"));
			String line;
			while ((line = reader.readLine()) != null)
			{
				
				if(counter==0) {
					title=line;
				}
				else if(counter==1) {
					author=line;
				}
				else if(counter==2) {
					dateCreated=line;
				}
				else if(counter==3) {
					dateSaved=line;
				}
				else {
					contents=contents + line;
				}
				counter++;
			}
		}catch (Exception ex) {
			System.out.println("Error not created");
			ex.printStackTrace();
		}
		
		
//test		
		if(!document.getTitle().equals(title)) {
			System.out.println("Fail on Title");
			return;
		}
		
		if(!document.getAuthor().equals(author)) {
			System.out.println("Fail on Author");
			return;
		}
		
		if(!document.getDateCreated().equals(dateCreated)) {
			System.out.println("Fail on DateCreated");
			return;
		}
		
		if(!document.getDateSaved().equals(dateSaved)) {
			System.out.println("Fail on DateCreated");
			return;
		}
		
		if(!document.getContents().equals(contents)) {
			System.out.println("Fail on Contents");
			return;
		}
		
		System.out.print("Pass: <<Save Test>>");
		
	}
}
