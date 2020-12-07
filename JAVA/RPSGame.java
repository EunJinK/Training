package java202009;

import java.util.Scanner;

public class RPSGame {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("첫 번째 플레이어의 이름을 입력하세요 : ");
		String play1 = scanner.next();
		System.out.print("두 번째 플레이어의 이름을 입력하세요 : ");
		String play2 = scanner.next();
		String a, b, e;
		
		do{
			while(true) {
				System.out.print("플레이어 "+play1+"은(는) 뭘 냅니까(가위/바위/보)?");
				a = scanner.next();
				if(a.equals("가위") || a.equals("바위") || a.equals("보"))
					break;
				else {
					System.out.println("다시!");
				}
			}
			while(true) {
				System.out.print("플레이어 "+play2+"은(는) 뭘 냅니까(가위/바위/보)?");
				b = scanner.next();
				if(b.equals("가위") || b.equals("바위") || b.equals("보"))
					break;
				else {
					System.out.println("다시!");
				}
			}
			if((a.equals("가위") && b.equals("보"))||(a.equals("바위") && b.equals("가위")) || (a.equals("보") && b.equals("바위"))) {
				System.out.println("플레이어 " + play1 + "가 이겼습니다.\n");
			}
			else if((b.equals("가위") && a.equals("보"))||(b.equals("바위") && a.equals("가위")) || (b.equals("보") && a.equals("바위"))) {
				System.out.println("플레이어 " + play2 + "가 이겼습니다.\n");
			}
			else {
				System.out.println("비겼습니다.\n");
			}
			while(true) {
				System.out.print("계속하시겠습니까(y/n)?");
				e = scanner.next();
				if(e.equals("n") || e.equals("N")||e.equals("y")||e.equals("Y"))
					break;
			}
		}while(e.equals("Y")||e.equals("y"));
		System.out.println("가위바위보 게임을 종료합니다.");
		scanner.close();
	}
}
