package daejeon.collection;

public class Tv_inter implements Elec_interface {

	@Override
	public void up() {
		System.out.println("TV클래스에서 볼륨 업");

	}

	@Override
	public void down() {
		System.out.println("TV클래스에서 볼륨 다운");
		
	}
	

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "요놈은 Tv 클래스 입니다" ; 
	}
	

}
