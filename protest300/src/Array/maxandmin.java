package Array;
//��ȡ�����е����ֵ����Сֵ
public class maxandmin {

	public static void main(String[] args) {
		int[] arr = {22,97,34,10};//��������
		int min,max ;
		min=max=arr[0];
		System.out.print("�����Ԫ�ذ�����");
		for(int i=0;i < arr.length;i++) {
			System.out.print(arr[i]+"  ");
			if (arr[i]>max) 
				max = arr[i];
			if(arr[i]<min)
				min = arr[i];
			
		}
		System.out.println("\n���Ԫ�أ�"+max);
		System.out.println("��СԪ�أ�"+min);
		
	}

}
