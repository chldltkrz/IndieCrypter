package IndieCrypter;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.DefaultEditorKit;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.util.*;


public class Function {
	DefaultEditorKit CCP = new DefaultEditorKit();
	JFileChooser fC = new JFileChooser();
	FileNameExtensionFilter textfilter = new FileNameExtensionFilter("TEXT files (*.txt)", "txt");
	AES AES = new AES();
	public Function(){
		fC.setFileFilter(textfilter);
	}

	public String Encryption(String input, String passwd){
		AES.setKey(passwd);				
		return AES.Encrypt(input);
	}
	public String Decryption(String input, String passwd){
		AES.setKey(passwd);
		return AES.Decrypt(input);
	}
	public String Import(){
		StringBuilder sB = new StringBuilder();
		if(fC.showOpenDialog(null)== JFileChooser.APPROVE_OPTION){
				try {
					File file = fC.getSelectedFile();
					Scanner input = new Scanner(file, "UTF-8");
					while(input.hasNext()){
						sB.append(input.nextLine());
					}
				}catch (FileNotFoundException e) {
					JOptionPane.showMessageDialog(null, "File not Found! Try other file");
					Import();
				}
		}else{
			JOptionPane.showMessageDialog(null, "Select Canceled");
			return "String to be Encrypted or Decrypted";
		}
		return sB.toString();
	}
	
	public void Export(String result){
			if(fC.showOpenDialog(null)==JFileChooser.APPROVE_OPTION){
				try{
					File file = new File(fC.getSelectedFile()+".txt");
					BufferedWriter br= new BufferedWriter(new 
					OutputStreamWriter(new FileOutputStream(file,true), "UTF-8"));
					br.write(result);
					br.flush();
					br.close();
					/* this code below Does not export encrypted string properly
					FileWriter fW = new FileWriter(fC.getSelectedFile()+".txt");
					fW.write(result);
					fW.flush();
					fW.close();
					*/
				}catch(Exception e){
					JOptionPane.showMessageDialog(null, "ERRRROORRRR");
				}
			}
	}
	
}

