package java202009;

public class NumberFrequency {
	private static int N,M,S;
	
	private static int[] generateRandomNumber() {
		//0이상 maxValue 미만인 int형 난수 size개를 생성하고, 배열로 리턴한다.
		
		int[] ransize = new int[N];
		for(int i=0;i<N;i++)
		{
			int size = (int)(Math.random() *M); //0~M미만 난수 발생
			ransize[i] = size; //난수를 int배열에 넣기
		}
		return ransize;
	}
	private static int[] countFrequency(int[] numbers) {	
		//srcArray의 원소들을 구간별로 분류한다.
		//구간은 0~S-1, S~(S*2-1), (S*2)~(S*3-1), ...로 나눈다.
		
		int secnum = 0; //구간 int배열을 생성할 때 쓰이는 크기 section number
		if((M%S) != 0)
			secnum = (M/S)+1; //0~max값이 구간 범위에 딱 떨어지지 않을 경우 ex)max=100, 구간=12
		else 
			secnum = M/S; //0~max값이 구간 범위에 딱 떨어질 경우
		int[] section = new int[secnum]; //구간 int배열 생성
		
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
				else //max값과 구간범위크기가 같을 경우 모든 난수는 하나의 구간에 포함된다.
					section[j] = N;
			}
		}
		return section; //각 범위 별 난수의 갯수를 저장한 int배열을 리턴
	}
	private static void printFrequency(int[] frequencies) {
		//각 구간별로 구간과 도수를 출력한다.
		
		for(int l= 0;l<frequencies.length;l++)
		{
			if((S*l)+S > M || S==M) //마지막 구간임을 판단
			{
				System.out.println("["+S*l+", "+M+") : " + frequencies[l]); //마지막 구간 출력 후 break
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