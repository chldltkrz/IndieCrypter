package IndieCrypter;
import java.awt.event.*;

import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class EventHandler extends Function implements ActionListener{
	Gui g;

	/**
	 * @wbp.parser.entryPoint
	 */
	public EventHandler(){
		g = new Gui();
		g.enc.addActionListener(this);
		g.dec.addActionListener(this);
		g.cop.addActionListener(this);
		g.pas.addActionListener(this);
		g.exp.addActionListener(this);
		g.imp.addActionListener(this);
		g.string.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
					g.string.setText("");					
			}
		});
	}

	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		
		if(source == g.enc){
			if(g.Show()== JOptionPane.OK_OPTION){
			g.result.setText(Encryption(g.string.getText(), g.passwd.getText()));
			}else{
				JOptionPane.showMessageDialog(null, "Canceled");
			}
		}
		else if(source==g.dec){
			if(g.Show()== JOptionPane.OK_OPTION){
			g.result.setText(Decryption(g.string.getText(), g.passwd.getText()));
			}else{
				JOptionPane.showMessageDialog(null, "Canceled");
			}
		}
		else if(source==g.cop){
			g.result.selectAll();
			g.result.copy();			
		}
		else if(source==g.pas){
			g.string.setText("");
			g.string.paste();
		}
		else if(source==g.exp){
			Export(g.result.getText());
		}
		else if(source==g.imp){
			g.string.setText(Import());
		}

	}
}
