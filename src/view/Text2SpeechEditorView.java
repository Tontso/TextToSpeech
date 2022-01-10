package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import commands.CommandManager;
import model.Document;

public class Text2SpeechEditorView extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private JTextArea t;
	private JFrame f;
	private Document currentDocument=new Document(null,null,null,null,null);
	private int[] settings= {3,150,190};
	private boolean isReversed=false;
	private boolean isEncoded=false;
	
	public Text2SpeechEditorView(){
		CommandManager cm=new CommandManager();
		
		//frame
		f=new JFrame();
		f.setTitle("Text2SpeechEditor");
		f.getContentPane().setLayout(null);
		f.setSize(500, 500);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//text
		t = new JTextArea();
		t.setEditable(false);
		t.setLineWrap(true);
		t.setBounds(0,0, 500, 500);
		t.setFont(new Font("Arial",Font.BOLD,20));
		t.setEditable(false);
		f.add(t);
	
		//menu
		JMenuBar menuBar=new JMenuBar();
		setJMenuBar(menuBar);
		JMenu menu =new JMenu("Menu");  
		menuBar.add(menu);
		f.setJMenuBar(menuBar);
		
		JMenuItem Create = new JMenuItem("New Document");
		Create.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Thread() {
					public void run() {
						DocumentInfo doc=new DocumentInfo();
						doc.setVisible(true);
						t.setEditable(true);
						doc.setFlag(true);
						while(doc.getflag() == true) {
							System.out.println("");
						}
						currentDocument=new Document(null,null,null,null,null);
						cm.enact("2", currentDocument, t, null, doc.getInfo(),0,null,null);
					}
				}.start();
			}
		});
		menu.add(Create);
		
		JMenuItem Save = new JMenuItem("Save Document");
		Save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Thread(){
					public void run() {
						currentDocument.setContents(t.getText());
						try {
							//currentDocument.setContents(t.getText().toString());
							JFileChooser chooser = new JFileChooser();
							chooser.setCurrentDirectory(new File("/home/me/Documents"));
							int retrival = chooser.showSaveDialog(Text2SpeechEditorView.this);
							if (retrival == JFileChooser.APPROVE_OPTION) {
								String path=chooser.getSelectedFile().getAbsolutePath().toString();
								System.out.println(path);
								cm.enact("1", currentDocument, t, path, null,0,null,null);
						    }
						}catch (Exception ex) {
							ex.printStackTrace();
						}
					}
				}.start();
			}
		});
		menu.add(Save);
		
		JMenuItem Open = new JMenuItem("Open Document");
		Open.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {	
				new Thread(){
					public void run() {
						try {
							t.setEditable(true);
							JFileChooser file=new JFileChooser();
							file.setFileSelectionMode(JFileChooser.FILES_ONLY);
							int result=file.showOpenDialog(Text2SpeechEditorView.this);
							if(result==JFileChooser.APPROVE_OPTION) {
								String path=file.getSelectedFile().getAbsolutePath().toString();
								cm.enact("3", currentDocument, t, path, null,0,null,null);
							}
						}catch (Exception ex) {
				            ex.printStackTrace();
				        }
					}
				}.start();
			}
		});
		menu.add(Open);
		
		menu.addSeparator();
		
		JMenuItem Play = new JMenuItem("Play");
		Play.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Thread(){
					public void run() {
						currentDocument.setContents(t.getText());
						cm.enact("9", currentDocument, t, null,null, 0,"Adapter",null);
					}
				}.start();
			}
		});
		menu.add(Play);
		
		JMenuItem PlayLine = new JMenuItem("Play Line");
		PlayLine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Thread(){
					public void run() {
						currentDocument.setContents(t.getText());
						try {
							int l = t.getLineOfOffset( t.getCaretPosition() );
							cm.enact("6", currentDocument, t, null,null, l,"Adapter",null);
						}catch(Exception ex) {
							ex.printStackTrace();
						}
					}
				}.start();
			}
		});
		menu.add(PlayLine);
		
		menu.addSeparator();
		
		JMenuItem PlayInReverse = new JMenuItem("Play In Reverse");
		PlayInReverse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Thread(){
					public void run() {
						currentDocument.setContents(t.getText());
						cm.enact("10", currentDocument, t, null, null,0,"Adapter",null);
					}
				}.start();
			}
		});
		menu.add(PlayInReverse);
		
		JMenuItem PlayLineInReverse = new JMenuItem("Play Line In Reverse");
		PlayLineInReverse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Thread(){
					public void run() {
						currentDocument.setContents(t.getText());
						try {
							int l = t.getLineOfOffset( t.getCaretPosition());
							cm.enact("11", currentDocument, t, null, null,l,"Adapter",null);
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					}
				}.start();
			}
		});
		menu.add(PlayLineInReverse);
		
		menu.addSeparator();
		
		JMenuItem PlayEncoded = new JMenuItem("Play Rot13");
		PlayEncoded.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Thread(){
					public void run() {
						currentDocument.setContents(t.getText());
						cm.enact("12", currentDocument, t, "Rot13", null,0,"Adapter",null);
						t.setText(currentDocument.getContents());
					}
				}.start();
			}
		});
		menu.add(PlayEncoded);
		
		JMenuItem PlayLineEncoded = new JMenuItem("Play Line Rot13");
		PlayLineEncoded.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Thread(){
					public void run() {
						currentDocument.setContents(t.getText());
						try {
							int l = t.getLineOfOffset( t.getCaretPosition());
							cm.enact("13", currentDocument, t, "Rot13", null,l,"Adapter",null);
						} catch (Exception e1) {
							e1.printStackTrace();
						}
						t.setText(currentDocument.getContents());
					}
				}.start();
			}
		});
		menu.add(PlayLineEncoded);
		
		menu.addSeparator();
		
		JMenuItem AtBash = new JMenuItem("Play AtBash");
		AtBash.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Thread(){
					public void run() {
						currentDocument.setContents(t.getText());
						cm.enact("12", currentDocument, t, "AtBash", null,0,"Adapter",null);
						t.setText(currentDocument.getContents());
					}
				}.start();
			}
		});
		menu.add(AtBash);
		
		JMenuItem PlayLineAtBash = new JMenuItem("Play Line AtBash");
		PlayLineAtBash.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Thread(){
					public void run() {
						currentDocument.setContents(t.getText());
						try {
							int l = t.getLineOfOffset( t.getCaretPosition());
							cm.enact("13", currentDocument, t, "AtBash", null,l,"Adapter",null);
						} catch (Exception e1) {
							e1.printStackTrace();
						}
						t.setText(currentDocument.getContents());
					}
				}.start();
			}
		});
		menu.add(PlayLineAtBash);
		
		menu.addSeparator();
		
		JMenuItem Replay = new JMenuItem("Replay");
		Replay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Thread(){
					public void run() {
						currentDocument.setContents(t.getText());
						try {
							cm.enact("8", currentDocument, t, null,null, 0,null,null);
						} catch (Exception e1) {
							e1.printStackTrace();
						}
						t.setText(currentDocument.getContents());
					}
				}.start();
			}
		});
		menu.add(Replay);
		
		menu.addSeparator();
		
		JMenuItem Settings = new JMenuItem("Settings");
		Settings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Thread(){
					public void run() {
						Settings s=new Settings(settings[0],settings[1],settings[2]);
						s.setVisible(true);
						s.setFlag(true);
						while(s.getflag()==true) {
							System.out.println("");
						}
						settings[0]=s.getSettings()[0];
						settings[1]=s.getSettings()[1];
						settings[2]=s.getSettings()[2];
						
						
						cm.enact("7", currentDocument, t, null, null, 0,null,settings);
					}
				}.start();
			}
		});
		menu.add(Settings);				
	}
	
	public boolean isReversed() {
		return isReversed;
	}
	
	public boolean isEncoded() {
		return  isEncoded;
	}
	
	public int getVolume() {
		return settings[0];
	}
	
	public int getRate() {
		return settings[1];
	}
	
	public int getPitch() {
		return settings[2];
	}
		
	public Document getCurrentDocument() {
		return currentDocument;
	}
	
	public Text2SpeechEditorView getSingletonView() {
		return null;
	}
		
	public static void main(String[] args){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new Text2SpeechEditorView();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
 }
