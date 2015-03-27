package se_test0305;

import java.util.Random;

public class Lotto {
	
	int num[] = new int[6] ;
	int count = 0 ;


	public void ran_making() {
		Random rd = new Random() ;	
		
		num[0] = rd.nextInt(45)+1 ;	//첫번째 랜덤값 저장		
		count++ ;

		while(count<=6) {
			for(int i=1 ; i<6 ; i++) {

				num[i] = rd.nextInt(45)+1 ;	//랜덤값 배정

				for(int j=0 ; j<i ; j++){	//이전들 값과 비교
					if(num[i]==num[j]){		//같은 값이 있으면
						num[i] = rd.nextInt(45)+1 ;	//새로운 랜덤값 배정
						i-- ;
						break ;
						
						//continue 문을 쓰려면
						/*
						 * j=-1 ;
						 * continue ;
						 */
					}					
					else
						count++ ;
				}
			}
		}
	}
	
	public void print() {
		System.out.print("이번 로또번호는 " );
		for(int i=0 ; i<num.length ; i++){
			System.out.print(num[i] + " ");
		}
		System.out.println("입니다!");
	}
}


