
public class Main {
	public static void main(String[] args){
		String[] array = {"at","","","","ball","","","car","","","dad","",""};
		String element = "carasdf";
		int result = findElementOrNot(array, 0, array.length - 1, element);
		System.out.println(result);
	}
	public static int findElementOrNot(String[] array, int low, int high, String element){
		if(low <= high){
			int middle = (low+high)/2;
			int temp = middle;
			while(middle <= high && array[middle].equals(""))
				middle++;
			if(array[middle].equals(element))
				return middle;
			else{
				if(middle == high)
					return findElementOrNot(array, low, temp - 1, element);
				else{
					int result = array[middle].compareTo(element);
					if(result > 0)
						return findElementOrNot(array, low, temp -1, element);
					else
						return findElementOrNot(array, temp+1, high, element);
				}
			}
		}
		return -1;
	}
}
