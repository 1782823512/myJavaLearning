package Array;
//给出由1，2，3，4组成的三位数的组合
public class threedigit {

	public static void main(String[] args) {
		int [] arr = {1,2,3,4};
		
		System.out.println("满足条件的组合：");
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr.length;j++) {
				if(i==j) {
					continue;
				}
				for(int k=0;k<arr.length;k++) {
					if(k==i || k==j) {
						continue;
					}
					String s = " "+arr[i]+arr[j]+arr[k]; 
					System.out.println(s);
				}
			}
		}

	}

}
