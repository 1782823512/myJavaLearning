package Array;
//获取数组中的最大值与最小值
public class maxandmin {

	public static void main(String[] args) {
		int[] arr = {22,97,34,10};//创建数组
		int min,max ;
		min=max=arr[0];
		System.out.print("数组的元素包括：");
		for(int i=0;i < arr.length;i++) {
			System.out.print(arr[i]+"  ");
			if (arr[i]>max) 
				max = arr[i];
			if(arr[i]<min)
				min = arr[i];
			
		}
		System.out.println("\n最大元素："+max);
		System.out.println("最小元素："+min);
		
	}

}
