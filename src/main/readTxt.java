package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Random;
public class readTxt {
	String[] split_str;
	public static void main(String[] args) {
		 readTxt rd = new readTxt();
		 rd.read_QandA();	
		 int line=10;
		  //创建一个对象
		Random df = new Random(); 
		//引用nextInt()方法
		int number = df.nextInt(3);
		//输出number
		System.out.println(number);
		
		 int start=0;
		 int index=0;
		 for(int i=start;i<5;i++) {
			 System.out.print("题干：");
			 System.out.println(rd.split_str[2*i]);
			 System.out.print("选项");
			 index=(i+df.nextInt(10))%line;
			 number = df.nextInt(3);
			 if(number==0) {//A
				 System.out.println("A. "+rd.split_str[2*i+1]);
				 System.out.println("B. "+rd.split_str[index]);
				 System.out.println("C. "+rd.split_str[(index+3)%line]);
				 System.out.println("D. "+rd.split_str[(index+7)%line]);
				 
			 }
			 else if(number==1) {//B
				 System.out.println("A. "+rd.split_str[index]);
				 System.out.println("B. "+rd.split_str[2*i+1]);
				 System.out.println("C. "+rd.split_str[(index+3)%line]);
				 System.out.println("D. "+rd.split_str[(index+7)%line]);
				 System.out.println("答案："+rd.split_str[2*i+1]);
			 }
			 else if(number==2) {//C
				 System.out.println("A. "+rd.split_str[index]);
				 System.out.println("B. "+rd.split_str[(index+3)%line]);
				 System.out.println("C. "+rd.split_str[2*i+1]);
				 System.out.println("D. "+rd.split_str[(index+7)%line]);
				 System.out.println("答案："+rd.split_str[2*i+1]);		 
			 }
			 else {//D
				 System.out.println("A. "+rd.split_str[(index+7)%line]);
				 System.out.println("B. "+rd.split_str[(index+3)%line]);
				 System.out.println("C. "+rd.split_str[index]);
				 System.out.println("D. "+rd.split_str[2*i+1]);

				 System.out.println("答案："+rd.split_str[2*i+1]);		
			 }
		 }
		 
		
		
	}
	public void read_QandA() {
		//读入文件
		 File file = new File("definition2.txt");// 创建目录
	        Scanner sc;
	        String str="";	
			try {
				sc = new Scanner(file);
		        //StringBuffer buff2 = new StringBuffer();
		                
		        while (sc.hasNext()) {
		        	str+=sc.nextLine();//按行读取文件   	
		        	str+="::";//用特殊字符分割字符串
		        }
		       sc.close();  
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//System.out.println(str);
			split_str=str.split("::");
			for(int i=0;i<split_str.length;i++) {
				System.out.println(split_str[i]);
			}
			System.out.println(split_str.length);
			//0,2,4
			System.out.print("题干：");
			for(int i=0;i<split_str.length/2;i++) {
				System.out.println(split_str[2*i]);
			}
			System.out.print("选项：");
			for(int i=0;i<split_str.length/2;i++) {
				System.out.println(split_str[2*i+1]);
			}
	}

}
