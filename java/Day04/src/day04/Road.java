package day04;

public class Road {

	public static void main(String[] args) {
		Starbucks gangnam = new Starbucks();
		
		gangnam.register(new Cafe() { // Q.new Cafe() 하는 이유 
			
			@Override
			public void sell(String menu) throws Exception {
				String[] arMenu = getMenu();
				boolean isOk = false;
				for(int i=0; i <arMenu.length; i++) {
					if(arMenu[i].equals(menu)) {
						isOk = true;
					}
				}
				if(!isOk) {throw new Exception();}
				
			}
			
			@Override
			public int[] getPrice() {
				int [] arPrice = {3000, 4000, 3500};
				return arPrice;
			}
			
			@Override
			public String[] getMenu() {
				String[] arMenu = {"아메리카노", "카페라떼", "콜라"};
				return arMenu;
			}
		});
		
		System.out.println("=========================");
		Starbucks jamsil = new Starbucks();
		
		jamsil.register(new CafeAdapter() { //부모타입에 자식값들어가니까 업캐스팅
			
			@Override
			public String[] getMenu() {
				String[] arMenu = {"아메리카노", "카페라떼", "콜라"};
//				return getMenu();
				return arMenu;
			}
			
		
		});
	}
}

