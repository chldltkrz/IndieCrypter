package IndieCrypter;

import javax.swing.*;
import java.awt.Font;
public class Gui {
	// Swing components for building
	JFrame frame;
	JPanel Mpanel, Bpanel;
	JTextField string, passwd ,result;
	JButton enc,dec,cop,pas,exp,imp;
	JLabel stringL,passwdL,resultL;
	//Design of Gui feature
	public Gui(){		
		frame = new JFrame("IndieCrypter");
		Mpanel= new JPanel();	
		Bpanel= new JPanel();
		string = new JTextField("String to be Encrypted or Decrypted");
		result = new JTextField("Result");
		passwd = new JTextField("passwd");
		enc = new JButton("Encryption");
		dec = new JButton("Decryption");
		cop = new JButton("Copy");
		pas = new JButton("Paste");
		exp = new JButton("Export");
		imp = new JButton("Import");
		stringL = new JLabel("Input");
		stringL.setLabelFor(string);
		passwdL = new JLabel("PassWord");
		resultL = new JLabel("En&De coded Text");
		
		resultL.setHorizontalAlignment(SwingConstants.CENTER);
		string.setHorizontalAlignment(SwingConstants.CENTER);
		result.setHorizontalAlignment(SwingConstants.CENTER);
		passwd.setHorizontalAlignment(SwingConstants.CENTER);
		stringL.setHorizontalAlignment(SwingConstants.CENTER);
		stringL.setHorizontalAlignment(SwingConstants.CENTER);
		passwdL.setHorizontalAlignment(SwingConstants.CENTER);
		passwdL.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 17));
		resultL.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 17));
		stringL.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 17));

		frame.setSize(511, 410);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		Mpanel.setLayout(null);
		Mpanel.setVisible(true);
		
		string.setBounds(12, 36, 320, 185);
		result.setBounds(12, 268, 320, 87);
		passwd.setBounds(363, 307, 104, 34);
		enc.setBounds(363, 34, 104, 34);
		dec.setBounds(363, 78, 104, 34);	
		cop.setBounds(363, 117, 104, 23);
		pas.setBounds(363, 149, 104, 23);
		exp.setBounds(363, 182, 104, 23);
		imp.setBounds(363, 215, 104, 23);
		stringL.setBounds(96,10,152,23);
		passwdL.setBounds(341, 268, 142, 23);
		resultL.setBounds(85, 231, 173, 34);
		
		frame.getContentPane().add(Mpanel);
		Mpanel.add(string);
		Mpanel.add(result);
		Mpanel.add(enc);
		Mpanel.add(dec);
		Mpanel.add(cop);
		Mpanel.add(pas);
		Mpanel.add(exp);
		Mpanel.add(imp);
		Mpanel.add(passwd);
		Mpanel.add(stringL);
		Mpanel.add(passwdL);
		Mpanel.add(resultL);
	}


}
