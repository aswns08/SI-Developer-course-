package se_test0304;

public class ArrayTest {
	//1���� �迭
	int[] gd = {1, 3, 5, 7, 9} ;
	//int[] human = new int[5] ;
	
	//2���� �迭
	int[][] top = new int[5][5] ;
	
	char[][] diamond = new char[9][9] ;
	
	int value = 1 ;

	public void test() {
		System.out.println("*** 1�� �迭 ***");
		
		for(int i=0 ; i<gd.length ; i++) {
			System.out.println("GD[" + i + "] = " + gd[i]);
		}
		
		System.out.println();	
	}

	
	public void test1() {
		System.out.println("*** 2�� �迭 ***");
		
		for(int i=0 ; i<top.length ; i++){
			for(int j=0 ; j<top[i].length ; j++) {
				
				top[i][j] = value ;
				System.out.print("Top[" + i + "][" + j+ "] = " + top[i][j] + "\t");
				
				value++ ;
			}
			System.out.println();
		}
	}
	
	public void test_dia() {
		System.out.println("*** ���̾Ƹ�� ����� ***");
		
		for(int i=0 ; i<diamond.length ; i++) {
			for(int j=0 ; j<diamond[i].length ; j++){
				
				/*
				if(i<5&&j<5)
					{
						if((i+j)==4)
							diamond[i][j] = '��';
					}
				else if(i<5&&j>=5)
				{
					if((j-i)==4)
						diamond[i][j] = '��';					
				}
				
				else if(i>=5&&j<5)
				{
					if((i-j)==4)
						diamond[i][j] = '��';
				}
				else if(i>=5&&j>=5)
				{
					if((i+j)==12)
						diamond[i][j] = '��';
				}				
				*/
				
				if((i+j)==4 || (j-i)==4 || (i-j)==4 || (i+j)==12)
					diamond[i][j] = '��';
					
				System.out.print(diamond[i][j]);
			}
			System.out.println();
			
		}		
		
	}
}


