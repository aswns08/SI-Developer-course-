package se_test0305;

import java.util.Random;

public class Lotto {
	
	int num[] = new int[6] ;
	int count = 0 ;


	public void ran_making() {
		Random rd = new Random() ;	
		
		num[0] = rd.nextInt(45)+1 ;	//ù��° ������ ����		
		count++ ;

		while(count<=6) {
			for(int i=1 ; i<6 ; i++) {

				num[i] = rd.nextInt(45)+1 ;	//������ ����

				for(int j=0 ; j<i ; j++){	//������ ���� ��
					if(num[i]==num[j]){		//���� ���� ������
						num[i] = rd.nextInt(45)+1 ;	//���ο� ������ ����
						i-- ;
						break ;
						
						//continue ���� ������
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
		System.out.print("�̹� �ζǹ�ȣ�� " );
		for(int i=0 ; i<num.length ; i++){
			System.out.print(num[i] + " ");
		}
		System.out.println("�Դϴ�!");
	}
}


