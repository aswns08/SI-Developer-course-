package daejeon.Exception.Stream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;

public class Stream_test {
	int temp ;
	
	//1. FileInputStream : read() �޼ҵ� ���
	public void test() {
		try {
			FileInputStream fs = new FileInputStream("d:/a.txt") ;
			long before = System.currentTimeMillis() ;
			while((temp=fs.read())!=-1) {	//���̻� �����Ծ��� �� -1
				System.out.print((char)temp);
			}
			long amount = System.currentTimeMillis()-before ;
			System.out.print("while������ �ɸ� �ð� : " + amount);
			fs.close();
		}catch(Exception e) {
			e.printStackTrace(); 
		}
	}
	
	//2. FileReader ���
	//���� �о �ٸ� ���Ͽ� ����
	public void test1() {
		try {
			FileReader fr = new FileReader("d:/a.txt") ;
			FileWriter fw = new FileWriter("d:/test1.txt") ;
			
			long before = System.currentTimeMillis() ;
			
			while((temp=fr.read())!=-1) {
				fw.write(temp);
				System.out.println((char)temp);
			}
			long amount = System.currentTimeMillis()-before ;
			System.out.println("����ð� (Reader, Writer) while������ �ɸ� �ð� : " + amount);
			fr.close();
			fw.close();
		}catch(Exception e) {
			e.printStackTrace(); 
		}
	}
	
	//3. BufferedReader, BufferedWriter ���
	public void test2() {
		String tempStr ;
		
		try {
			BufferedReader br = new BufferedReader(new FileReader("d:/a.txt"));
			BufferedWriter bw = new BufferedWriter(new FileWriter("d:/test2.txt"));
						
			long before = System.currentTimeMillis() ;
			
			while((tempStr=br.readLine())!=null) {
				System.out.println(tempStr);
				bw.write(tempStr + "\r\n");
			}
			long amount = System.currentTimeMillis()-before ;
			System.out.println("BufferedReader, BufferedWriter while������ �ɸ� �ð� : " + amount);
			br.close();
			bw.close();
		}catch(Exception e) {
			e.printStackTrace(); 
		}
		
	}
	
	//4.
	public void test3() {
		String tempStr ;
		
		try(BufferedReader br = new BufferedReader(new FileReader("d:/a.txt"));
			BufferedWriter bw = new BufferedWriter(new FileWriter("d:/test9.txt"));) {
			
			while((tempStr=br.readLine())!=null) {
				System.out.println(tempStr);
				bw.write(tempStr + "\r\n");
			}
			
		}catch(Exception e) {
			e.printStackTrace(); 
		}
		
	}
	
}
