package Array;
//������1��2��3��4��ɵ���λ�������
public class threedigit {

	public static void main(String[] args) {
		int [] arr = {1,2,3,4};
		
		System.out.println("������������ϣ�");
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
