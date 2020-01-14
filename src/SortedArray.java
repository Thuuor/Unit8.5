
public class SortedArray {

	private int[] array;
	private int numElements;
	
	public SortedArray(int size) {
		numElements = 0;
		array = new int[size];
		for (int i = 0; i < array.length; i++) {
			array[i] = -1;
		}
	}
	
	public void put(int num) {
		
		int i = 0;
		
		while (i < numElements && array[i] < num) {
			i++;
		}
		
		// i has now the position in which to insert
		
		for (int j = numElements; j > i ; j--) {
			if (j < array.length) {
			array[j] = array[j - 1];
			}
		}
		
		if (i < array.length) {
			array[i] = num;
		}
		
		if (numElements < array.length) {
			numElements++;
		}
		
	}
	
	@Override
	public String toString() {
		String res = "";
		if (numElements == 0) {
			return res;
		} else {
			res += array[0];
			for (int i = 1; i < numElements;i++) {
				res += ", " + array[i];
			}
			return res;
		}
		
	}
	
	public int getNumElements() {
		return numElements;
	}
	
	public int getSize() {
		return array.length;
	}
	
	public int getElementAt(int pos) {
		return array[pos];
	}
	
	public void removeElementAt(int pos) {
		if (pos >= numElements) {
			return;
		}
		for (int i = pos; i <= numElements - 2; i++) {
					array[i] = array[i + 1];
			}
		
		array[numElements - 1] = -1;
		numElements --;
	}
	
	public boolean isEmpty() {
		if (numElements == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isFull() {
		if (numElements == array.length) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean existsElement(int element) {
		//return binarySearch(element,0,numElements-1);
		return binarySearchNoRecurs(element, 0, numElements-1);
		/*int pos = 0;

		while (pos < numElements && array[pos] < element) {
			pos ++;
		}
		
		if (pos < numElements && array[pos] == element) {
			return true;
		}
		return false;*/
		
	}

	public boolean binarySearch(int element, int minor, int upper) {
		int middle = (minor + upper) / 2;
		if (minor > upper) return false;
		if (array[middle] == element) return true;
		if (element < array[middle]) {
			return binarySearch(element, minor, middle - 1);
		} else {
			return binarySearch(element, middle + 1, upper);
		}
		
	}
	
	public boolean binarySearchNoRecurs(int element, int minor, int upper) {
		while (minor <= upper) {
			int middle = (minor + upper) / 2;
			if (array[middle] == element) return true;
			if (element < array[middle]) {
				upper = middle - 1;
			} else {
				minor = middle + 1;
			}
		}
		return false;
	}
}
