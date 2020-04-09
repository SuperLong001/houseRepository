package com.yidu.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * 模型工厂
 * @author Administrator
 *
 */
public class ModelFactory {

	public static void main(String[] args) {
		
		
	
		println(readFile());
		
	}
	
	/**
	 * 判断是否为英文字母
	 * @param s
	 * @return
	 */
	public static boolean test(char c){     
		   
		 
		  int   i   =(int)c;     
		  if((i>=65&&i<=90)||(i>=97&&i<=122)){     
			  return   true;     
		  }else{     
			  return   false;     
		  }     
	}  
	
	/**
	 * 读取文件
	 * @return
	 */
	public static String readFile(){
		File file = new File("d:\\test.txt");
		FileInputStream inputStream=null;
		String message =null;
		try {
			inputStream = new FileInputStream(file);
			
			int i=0;
			
			int length = (int)file.length();
			
			byte[] b = new byte[length];
			
			while((i = inputStream.read(b))!= -1){
				String str = new String(b);
				message=str;
			}
			
		} catch (IOException e) {
			System.err.println("异常：找不到文件地址！");
			e.printStackTrace();
		}finally {
			try {
				inputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return message;
	}
	
	
	
	
	/**
	 * 处理字符
	 * @param message
	 */
	public static void println(String message){
		
		String[] strings = message.split(",");
		
		for (int j=0;j<strings.length;j++) {
			 
			String[] grid = strings[j].trim().split(" ");
				
			StringBuffer buffer = new StringBuffer("private");
			
				if(strings[j].length()>5){
					
					for(int i=1;i>=0;i--){
						
						if(i==0){
							
							if(grid[i].indexOf("_")==0){
								
								buffer.append(" "+grid[i]+";");
								
							}else{
								
								
								char c = grid[i].charAt(grid[i].indexOf("_")+1);
								
								String r = grid[i].replace("_"+c, String.valueOf(c).toUpperCase());
								
								buffer.append(" "+r+";");
							}
							
							
						}else{
							
							String g = grid[i].substring(0, 2);
							
							if(g.equals("IN")){
								buffer.append(" int");
							}else if(g.equals("DA") || g.equals("VA")){
								buffer.append(" String");
							}else if(g.equals("DE") || g.equals("DO")){
								buffer.append(" double");
							}
							
						}
						
					}
				}
			
			if(buffer.length()>8){
				System.out.println(buffer);
			}
			
		}
	}
}
