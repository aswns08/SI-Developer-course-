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

			//mabang[0][0]인경우
			if(x-1<0 && y-1<0) {
				x+=1 ;
			}

			//배열이 위로 벗어난 경우
			else if(x-1<0) {					
				x=n-1 ;
				y-=1 ;		
			}

			//배열이 왼쪽으로 벗어난 경우
			else if(y-1<0){
				x=x-1 ; 
				y=n-1 ;
			}

			//이동하려는 칸에 값이 존재한는 경우
			else if(mabang[x-1][y-1]!=0) {
				x+=1 ;				
			}

			//규칙대로 이동할수있는 경우
			else {
				x-=1 ;
				y-=1 ;					
			}
			mabang[x][y] = i ;
		}
		
		//출력
		for(int i=0 ; i<n ; i++) {
			for(int j=0 ; j<n ; j++) {
				System.out.print(mabang[i][j] + "  ");
			}			
			System.out.println();
			
		}
	
	}	

	
}
