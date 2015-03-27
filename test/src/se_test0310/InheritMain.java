package se_test0310;

public class InheritMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Elec_interface ec = new Tv_inter() ;
		Elec_interface ec1 = new Radio_inter() ;
		
		ec.up();
		ec.down();
		
		ec1.up();
		ec1.down();
		
		System.out.println(ec);
		System.out.println(ec1);
		

	}

}
