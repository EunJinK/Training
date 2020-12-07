package java202009;

public class NumberFrequency {
	private static int N,M,S;
	
	private static int[] generateRandomNumber() {
		//0�̻� maxValue �̸��� int�� ���� size���� �����ϰ�, �迭�� �����Ѵ�.
		
		int[] ransize = new int[N];
		for(int i=0;i<N;i++)
		{
			int size = (int)(Math.random() *M); //0~M�̸� ���� �߻�
			ransize[i] = size; //������ int�迭�� �ֱ�
		}
		return ransize;
	}
	private static int[] countFrequency(int[] numbers) {	
		//srcArray�� ���ҵ��� �������� �з��Ѵ�.
		//������ 0~S-1, S~(S*2-1), (S*2)~(S*3-1), ...�� ������.
		
		int secnum = 0; //���� int�迭�� ������ �� ���̴� ũ�� section number
		if((M%S) != 0)
			secnum = (M/S)+1; //0~max���� ���� ������ �� �������� ���� ��� ex)max=100, ����=12
		else 
			secnum = M/S; //0~max���� ���� ������ �� ������ ���
		int[] section = new int[secnum]; //���� int�迭 ����
		
		for(int i=0;i<numbers.length;i++)
		{
			for(int j=0;j<secnum;j++)
			{
				if(M!=S)
				{
					if((numbers[i] >= (S*j)) && (numbers[i] < (S*j)+S))
					{
						section[j]++;
					}
				}
				else //max���� ��������ũ�Ⱑ ���� ��� ��� ������ �ϳ��� ������ ���Եȴ�.
					section[j] = N;
			}
		}
		return section; //�� ���� �� ������ ������ ������ int�迭�� ����
	}
	private static void printFrequency(int[] frequencies) {
		//�� �������� ������ ������ ����Ѵ�.
		
		for(int l= 0;l<frequencies.length;l++)
		{
			if((S*l)+S > M || S==M) //������ �������� �Ǵ�
			{
				System.out.println("["+S*l+", "+M+") : " + frequencies[l]); //������ ���� ��� �� break
				break;
			}
			else
				System.out.println("["+S*l+", "+(S*l+S)+") : " + frequencies[l]);
		}
	}
	public static void main(String[] args) {
		N = Integer.parseInt(args[0]);
		M = Integer.parseInt(args[1]);
		S = Integer.parseInt(args[2]);
		System.out.println(N+" "+M+" "+S);
		
		int[] randomNumbers = generateRandomNumber();
		int[] frequencies = countFrequency(randomNumbers);
		printFrequency(frequencies);
	}
}