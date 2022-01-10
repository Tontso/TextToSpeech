package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Settings extends JFrame{

	private static final long serialVersionUID = 1L;
	private	JPanel voiceFrame;
	private int[] info=new int[3];
	private JTextField Jvolume=new JTextField();
	private JTextField Jpitch=new JTextField();	
	private JTextField Jrate=new JTextField();
	private boolean flag;
	
	public Settings(int volume,int pitch,int rate) {
		info[0]=volume;
		info[1]=pitch;
		info[2]=rate;
		setBounds(400,200, 500, 300);
		voiceFrame = new JPanel();
		voiceFrame.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(voiceFrame);
		voiceFrame.setLayout(null);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	
		JLabel lblvol = new JLabel("Volume:");
		lblvol.setFont(new Font("Arial", Font.PLAIN, 18));
		lblvol.setBounds(50, 25, 180, 16);
		voiceFrame.add(lblvol);
		Jvolume = new JTextField();
		Jvolume.setBounds(200, 25, 200, 25);
		Jvolume.setText(String.valueOf(volume));
		voiceFrame.add(Jvolume);
		Jvolume.setColumns(10);
		
		JLabel lblpitch = new JLabel("Pitch:");
		lblpitch.setFont(new Font("Arial", Font.PLAIN, 18));
		lblpitch.setBounds(50, 75, 160, 16);
		voiceFrame.add(lblpitch);	
		Jpitch = new JTextField();
		Jpitch.setBounds(200, 75, 200, 25);
		Jpitch.setText(String.valueOf(pitch));
		voiceFrame.add(Jpitch);
		Jpitch.setColumns(10);
		
		JLabel lblNrate = new JLabel("Rate:");
		lblNrate.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNrate.setBounds(50, 125, 160, 16);
		voiceFrame.add(lblNrate);	
		Jrate = new JTextField();
		Jrate.setBounds(200, 125, 200, 25);
		Jrate.setText(String.valueOf(rate));
		voiceFrame.add(Jrate);
		Jrate.setColumns(10);
		
		JButton btnDone = new JButton("Done");
		btnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Thread() {
					public void run() {
						if(Jvolume.getText().equals("")|| Jpitch.getText().equals("")||Jrate.getText().equals("")){
							JOptionPane.showMessageDialog(rootPane,"One or more fields are empty\nPlease fill the empty fields");
						}else {
							System.out.println(" settings changed");
							info[0]=Integer.parseInt(Jvolume.getText());
							info[1]=Integer.parseInt(Jpitch.getText());
							info[2]=Integer.parseInt(Jrate.getText());
							setVisible(false);
							flag = false;
						}
					}
				}.start();
			}
		});
		btnDone.setBounds(150, 175, 100, 20);
		voiceFrame.add(btnDone);
	}
	
	public int[] getSettings() {
		return info;
	}
	
	public boolean getflag() {
		return flag;
	}
	
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
}
