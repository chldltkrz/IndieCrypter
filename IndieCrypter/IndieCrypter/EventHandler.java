package IndieCrypter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

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
		g.passwd.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
					g.passwd.setText("");
			}						
		});	
	}

	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		
		if(source == g.enc){
			g.result.setText(Encryption(g.string.getText(), g.passwd.getText()));
		}
		else if(source==g.dec){
			g.result.setText(Decryption(g.string.getText(), g.passwd.getText()));
		}
		else if(source==g.cop){
			g.result.selectAll();
			g.result.copy();			
		}
		else if(source==g.pas){
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
