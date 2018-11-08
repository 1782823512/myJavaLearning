package Array;
//实现二维数组的转置
public class Matrixtranspose {

	public static void main(String[] args) {
		int [][] arr2 = {{1,2,3},{4,5,6},{7,8,9}};
		System.out.println("转置前的数组");
		printArray(arr2);
		System.out.println("转置后的数组");
		int [][] newarr = new int[arr2.length][arr2.length];
		for(int i=0;i<newarr.length;i++) {
			for(int j=0;j<newarr.length;j++) {
				newarr[i][j] = arr2[j][i];
			}}
		printArray(newarr);
		
	}
	//重构
	public static void printArray(int [][] arr) {
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr.length;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}

}
