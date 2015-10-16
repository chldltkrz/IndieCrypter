package IndieCrypter;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.DefaultEditorKit;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.*;


public class Function {
	DefaultEditorKit CCP = new DefaultEditorKit();
	JFileChooser fC = new JFileChooser();
	FileNameExtensionFilter textfilter = new FileNameExtensionFilter("TEXT files (*.txt)", "txt");
	public Function(){
		fC.setFileFilter(textfilter);
	}

	public String Encryption(String input, String passwd){
		String temp="";
			if(passwd.length()<1){
				JOptionPane.showMessageDialog(null, "Password Should be At Least 1 Character");		
			}
			char[] encchar = (input.toCharArray());
			char[] encpasswd = (passwd.toCharArray());
			String encString="", encPasswd = "";
				for(int i=0; i<encchar.length; i++){
					encString=encString+String.valueOf((int)encchar[i]);
				}
				for(int i=0; i<encpasswd.length; i++){
					encPasswd = encPasswd+String.valueOf((int)encpasswd[i]);
				}
				
		return encString+encPasswd;
	}
	public String Decryption(String input, String passwd){
		String temp="";
		return temp;
	}
	public String Import(){
		StringBuilder sB = new StringBuilder();
		if(fC.showOpenDialog(null)== JFileChooser.APPROVE_OPTION){
			java.io.File file = fC.getSelectedFile();
				try {
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
					FileWriter fW = new FileWriter(fC.getSelectedFile()+".txt");
					fW.write(result);
					fW.flush();
					fW.close();
				}catch(Exception e){
					JOptionPane.showMessageDialog(null, "ERRRROORRRR");
				}
			}
	}
	
}

