package task4;

public class OutOfBoundException {

	public static void main(String[] args) {
		int arr[]= {1,3,5,8,9};
		String str="String Exception";
		for(int i=0;i<=arr.length;i++) {
			try {
				System.out.print(arr[i]+" ");
			}
			catch(ArrayIndexOutOfBoundsException e){
				System.out.println();
				System.out.println("Arrayindex out of bound exception occured");
			}
		}
		try {
			System.out.println(str.charAt(20));
		}
		catch(StringIndexOutOfBoundsException e){
			System.out.println("Stringindex out of bound exception occured");
		}
		
	}

}
