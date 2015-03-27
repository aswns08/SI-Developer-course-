package se_test0305;

public class Mabangjin {
	
	
	public Mabangjin(int n){
		test(n) ;
	}

	public void test(int n) {
		int x=0 ; 
		int y=n/2 ;	
		
		int[][] mabang = new int[n][n] ;

		mabang[x][y] = 1 ;



		for(int i=2 ; i<=n*n ; i++) {

			//mabang[0][0]�ΰ��
			if(x-1<0 && y-1<0) {
				x+=1 ;
			}

			//�迭�� ���� ��� ���
			else if(x-1<0) {					
				x=n-1 ;
				y-=1 ;		
			}

			//�迭�� �������� ��� ���
			else if(y-1<0){
				x=x-1 ; 
				y=n-1 ;
			}

			//�̵��Ϸ��� ĭ�� ���� �����Ѵ� ���
			else if(mabang[x-1][y-1]!=0) {
				x+=1 ;				
			}

			//��Ģ��� �̵��Ҽ��ִ� ���
			else {
				x-=1 ;
				y-=1 ;					
			}
			mabang[x][y] = i ;
		}
		
		//���
		for(int i=0 ; i<n ; i++) {
			for(int j=0 ; j<n ; j++) {
				System.out.print(mabang[i][j] + "  ");
			}			
			System.out.println();
			
		}
	
	}	

	
}
