package day04;
//카페를 등록할 때 반드시 구현해야하는 메소드가 매장별로 다를 수 있다. 
//따라서 무료 나눔 카페인 경우 getMenu만 구현해야하고, 이를 위해 
//모든 메소드에 강제성을 없애준다. 
public abstract class CafeAdapter implements Cafe {

	@Override
	public String[] getMenu() {	return null;}

	@Override
	public int[] getPrice() {return null;}

	@Override
	public void sell(String menu) throws Exception {}

}
