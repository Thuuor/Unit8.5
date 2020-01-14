
public class MainClass {

	public static void main(String[] args) {
		
		
		SortedArray array = new SortedArray(10000);

		for (int i = 0; i <= 10000;i++) {
			array.put(i);
		}
		System.out.println(array.existsElement(5000));

	}
	

}
