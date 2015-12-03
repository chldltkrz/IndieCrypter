package IndieCrypter;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.*;


public class Function {
	JFileChooser fC = new JFileChooser();
	JFileChooser fC1= new JFileChooser();

	FileNameExtensionFilter textfilter = new FileNameExtensionFilter("TEXT files (*.txt)", "txt");
	FileNameExtensionFilter ImagefilterPng = new FileNameExtensionFilter("png files (*.png)", "png");

	File file;
	BufferedImage image;
	AES AES = new AES();
	
	public Function(){
		fC.setFileFilter(textfilter);
		fC1.setFileFilter(ImagefilterPng);
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
					file = fC.getSelectedFile();
					Scanner input = new Scanner(file, "UTF-8");
					while(input.hasNext()){
						sB.append(input.nextLine());
						if(input.hasNext()){sB.append("\n");}		//to support line delimiter when import multiline text file
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
	
	public String Select(){
		int buffer = fC1.showOpenDialog(null);
		file = fC1.getSelectedFile();
		if(fC1.getSelectedFile()!=null && (buffer==fC1.APPROVE_OPTION)){
			try{
				image=ImageIO.read(file);
			}catch(IOException e){
				JOptionPane.showMessageDialog(null, "Image Loading failed!");
				return "";
			}
			return file.getPath();
		}else{
			JOptionPane.showMessageDialog(null, "Canceled!");
			return "";
		}				
	}
	
	public void StegaEnc(String input, String passwd){
		
		AES.setKey(passwd);
		String encData = AES.Encrypt(input);
		encData = StringtoBinary(encData);	
		String encDataSize = String.format("%32s", Integer.toBinaryString(encData.length()/32));

		for(int i = 0; i < 32; i++){
			String temp = intToBinary(image.getRGB(i, 0));
			if(encDataSize.charAt(i)=='1'){
				temp = temp.substring(0,31)+'1';
			}else{
				temp = temp.substring(0,31)+'0';
			}
			image.setRGB(i, 0, binaryToInt(temp));	
		}
		
		for(int i = 1; i <encData.length()/32+1; i++){
			for(int j = 0; j<32; j++){
				String temp = intToBinary(image.getRGB(j, i));
				temp = temp.substring(0,31)+ encData.charAt(((i-1)*32)+j);
				image.setRGB(j, i, binaryToInt(temp));
			}
		}
	
		if(fC1.showOpenDialog(null)==JFileChooser.APPROVE_OPTION){
			try{
				File file = new File(fC1.getSelectedFile(),"");
				ImageIO.write(image, "png", file);
			}catch(Exception e){
				JOptionPane.showMessageDialog(null, "ERRRROORRRR");
			}
		}
	}
	
	public String StegaDec(){
		AES.setKey(file.getName().substring(0,file.getName().length()-4));
		String length = "",data="";
		
		for(int i = 0; i<32; i++){
			length = length + intToBinary(image.getRGB(i, 0)).charAt(31);
		}
		int dataSize = binaryToInt(length);

		for(int i = 1; i<dataSize; i++){
			for(int j = 0; j < 32; j++){
				String temp = intToBinary(image.getRGB(j,i));
				data = data + temp.charAt(31);
			}
		}
		data = BinarytoString(data);
		return AES.Decrypt(data);
	}
	
	public String StringtoBinary(String input){
		String temp = "";
		for(int i = 0; i < input.length(); i++){
			temp = temp + String.format("%8s", Integer.toBinaryString(input.charAt(i) & 0xFF)).replace(' ','0');
		}
		return temp;
	}
	
	public String BinarytoString(String input){
		String[] temp = new String[input.length()/8];
		StringBuilder sB= new StringBuilder();
			for(int i = 0; i < input.length()/8; i++){	
					temp[i] = input.substring(i*8, (i+1)*8);
			}
			for(int i=0; i < temp.length; i++){
				sB.append((char)Integer.parseInt(temp[i],2));
			}
		return sB.toString();
	}
	
	public String intToBinary(int input){
		return  String.format("%32s", Integer.toBinaryString(input).replace(' ', '0'));
	}
	
	public int binaryToInt(String input){
		return ((int)Long.parseLong(input, 2));
	}
}
	

