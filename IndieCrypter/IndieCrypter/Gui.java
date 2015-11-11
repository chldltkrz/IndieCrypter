package IndieCrypter;

import javax.swing.*;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class Gui {
	// Swing components for building
	// Mpanel=main Panel | PPanel=Popup Panel 
	JFrame frame;
	JPanel Mpanel, PPanel;
	JOptionPane Popup;
	JTextArea string, passwd ,result;
	JButton enc,dec,cop,pas,exp,imp;
	JLabel stringL,resultL;
	//JComboBox menubar;
	//Design of Gui feature
	public Gui(){
			
		//Code for Main program Gui
		frame = new JFrame("IndieCrypter");
		Mpanel= new JPanel();
		string = new JTextArea("String to be Encrypted or Decrypted");
		result = new JTextArea("Result");
		enc = new JButton("Encryption");
		dec = new JButton("Decryption");
		cop = new JButton("Copy");
		pas = new JButton("Paste");
		exp = new JButton("Export");
		imp = new JButton("Import");
		stringL = new JLabel("Input");
		stringL.setLabelFor(string);
		resultL = new JLabel("En&De coded Text");
		
		//Setting
		resultL.setHorizontalAlignment(SwingConstants.CENTER);
		stringL.setHorizontalAlignment(SwingConstants.CENTER);
		resultL.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 17));
		stringL.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 17));

		frame.setSize(722, 499);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		Mpanel.setLayout(null);
		Mpanel.setVisible(true);
		
		string.setBounds(12, 36, 336, 302);
		result.setBounds(360, 36, 336, 302);
		enc.setBounds(12, 348, 104, 90);
		dec.setBounds(128, 347, 104, 92);	
		cop.setBounds(244, 348, 104, 90);
		pas.setBounds(360, 348, 104, 90);
		exp.setBounds(592, 348, 104, 90);
		imp.setBounds(476, 348, 104, 90);
		stringL.setBounds(106,10,152,23);
		resultL.setBounds(436, 4, 173, 34);
		
		Mpanel.add(string);
		Mpanel.add(result);
		Mpanel.add(enc);
		Mpanel.add(dec);
		Mpanel.add(cop);
		Mpanel.add(pas);
		Mpanel.add(exp);
		Mpanel.add(imp);
		Mpanel.add(stringL);
		Mpanel.add(resultL);
		frame.getContentPane().add(Mpanel);
	}
	public int Show(){
	//Create new panel to get inputs of passwd and type of cipher
		//String[] type = {"AES256bit","Customized"};
		//menubar = new JComboBox(type); 
		passwd = new JTextArea("passwd");
		passwd.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
					passwd.setText("");					
			}
		});
		PPanel= new JPanel(new GridLayout(0,1));
		//PPanel.add(menubar);
		PPanel.add(new JLabel("Type password!:"));
		PPanel.add(passwd);
		return JOptionPane.showConfirmDialog(null, PPanel, "PASSWARD",
		JOptionPane.OK_CANCEL_OPTION,JOptionPane.PLAIN_MESSAGE);						
	}
}
