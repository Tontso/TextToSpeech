package view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton; 
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Date;

public class DocumentInfo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private String title;
	private String author;
	private String dateCreated;
	private String []info= {null,null,null};
	private JTextField Title;
	private JTextField Author;	
	private boolean flag;
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DocumentInfo frame = new DocumentInfo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public DocumentInfo() {
		setBounds(400,200, 500, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	
		
		JLabel lblFileName = new JLabel("Title:");
		lblFileName.setFont(new Font("Arial", Font.PLAIN, 18));
		lblFileName.setBounds(50, 25, 180, 16);
		contentPane.add(lblFileName);
		Title = new JTextField();
		Title.setBounds(200, 25, 200, 25);
		contentPane.add(Title);
		Title.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Author:");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel.setBounds(50, 75, 160, 16);
		contentPane.add(lblNewLabel);	
		Author = new JTextField();
		Author.setBounds(200, 75, 200, 25);
		contentPane.add(Author);
		Author.setColumns(10);
		
		dateCreated=(new Date()).toString();
		JLabel DateLabel = new JLabel("Date: "+dateCreated);
		DateLabel.setFont(new Font("Arial", Font.PLAIN, 18));
		DateLabel.setBounds(50, 90, 500, 100);
		contentPane.add(DateLabel);
		
		JButton btnCreate = new JButton("Create");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Thread() {
					public void run() {
						title=Title.getText();
						author=Author.getText();
						dateCreated=(new Date()).toString();
						DateLabel.setText("Date: "+dateCreated.toString());
						
						if(Title.getText().equals("")|| Author.getText().equals("")){
							JOptionPane.showMessageDialog(rootPane,"One or more fields are empty\nPlease fill the empty fields");
						}else {
							info[0]=title;
							info[1]=author;
							info[2]=dateCreated;
							
							setVisible(false);
							flag = false;
							Title.setText(null);
							Author.setText(null);
						}
					}
				}.start();
			}
		});
		btnCreate.setBounds(200, 200, 97, 25);
		contentPane.add(btnCreate);
	}
	
	public String [] getInfo(){
		return info;
	}
	public boolean getflag() {
		return flag;
	}
	
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
}
 