package java202009;

import java.util.Scanner;

public class RPSGame {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("ù ��° �÷��̾��� �̸��� �Է��ϼ��� : ");
		String play1 = scanner.next();
		System.out.print("�� ��° �÷��̾��� �̸��� �Է��ϼ��� : ");
		String play2 = scanner.next();
		String a, b, e;
		
		do{
			while(true) {
				System.out.print("�÷��̾� "+play1+"��(��) �� ���ϱ�(����/����/��)?");
				a = scanner.next();
				if(a.equals("����") || a.equals("����") || a.equals("��"))
					break;
				else {
					System.out.println("�ٽ�!");
				}
			}
			while(true) {
				System.out.print("�÷��̾� "+play2+"��(��) �� ���ϱ�(����/����/��)?");
				b = scanner.next();
				if(b.equals("����") || b.equals("����") || b.equals("��"))
					break;
				else {
					System.out.println("�ٽ�!");
				}
			}
			if((a.equals("����") && b.equals("��"))||(a.equals("����") && b.equals("����")) || (a.equals("��") && b.equals("����"))) {
				System.out.println("�÷��̾� " + play1 + "�� �̰���ϴ�.\n");
			}
			else if((b.equals("����") && a.equals("��"))||(b.equals("����") && a.equals("����")) || (b.equals("��") && a.equals("����"))) {
				System.out.println("�÷��̾� " + play2 + "�� �̰���ϴ�.\n");
			}
			else {
				System.out.println("�����ϴ�.\n");
			}
			while(true) {
				System.out.print("����Ͻðڽ��ϱ�(y/n)?");
				e = scanner.next();
				if(e.equals("n") || e.equals("N")||e.equals("y")||e.equals("Y"))
					break;
			}
		}while(e.equals("Y")||e.equals("y"));
		System.out.println("���������� ������ �����մϴ�.");
		scanner.close();
	}
}
