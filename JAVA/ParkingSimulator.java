package HW3;
import java.util.Arrays;
import java.util.Scanner;

class Parking{
	private boolean exist;
	private static int row, column;
	private String[][] registered = {{"1111","Kim"},{"2222","Lee"},{"3333","Gong"},{"4444","Yoon"},{"5555","Park"},{"6666","Kwon"},{"7777","Park"},{"8888","Choi"}};
	private String[][][] sucparked; //�����Ϸ�� ���� : [��][��][0] = �� ��ȣ , [��][��][1] = �� �����̸��� ����� �迭
	private String carowner; //registered���� sucparked�� �������̸��� �����ϱ����� ��ġ�� String

	//���������迭 �����ϴ� �Լ�
	public Parking(int r, int c) {
		row = r; column = c;
		sucparked = new String[row][column][2];
		for(int i=0;i<row;i++) {
			for(int j=0;j<column;j++) {
				Arrays.fill(sucparked[i][j], " "); //�����Ϸ�� ����ȣ,�����̸��� ����� �迭 �ʱ�ȭ
			}
		}
		System.out.println();
	}
	
	//�������� ����Ʈ�Լ�
	public void printArea() {
		String parkedcar; //��������� ����Ʈ�� String
		for(int i=0;i<row;i++) {
			for(int j=0;j<column;j++) {
				if(!sucparked[i][j][0].equals(" ")) //���������� ������� �ʴٸ�(������ �����ϰ��ִٸ�) parkedcar�� "������ �� ��ȣ + ����" ����
					parkedcar = sucparked[i][j][0]+"("+sucparked[i][j][1]+")";
				else
					parkedcar = "____";
				System.out.print("("+i+", "+j+") : "+ parkedcar+" ");
			}
			System.out.println();
		}
	}

	//��ϵǾ��ִ� �������� Ȯ���ϴ� �Լ�
	public void checkreg(String carnum) {
		int count=0;
		for(int i=0;i<registered.length;i++) {
			if(registered[i][0].equals(carnum)) {
				carowner = registered[i][1]; //�ش� ���� �����̸��� carowner�� ������ ��
				goParking(carnum); //����,����,���������ϴ� �Լ� ȣ��
				break;//for�� ���� - ���̻� Ȯ���� �ʿ䰡 ���� ������
			}
			else if(!registered[i][0].equals(carnum)){ //�Է¹��� carnum�� ��ϵ� ������ ��ġ�����ʴ´ٸ� count++
				count++;
			}
		}
		if(count >= registered.length) //count���� ��ϵǾ��ִ� ���������̻��̶��(�� ��ϾȵǾ�����)
			System.out.println("��ϵ��� ���� �����Դϴ�.\n");
	}

	 //����, ����, ���������Ͽ� �˷��ִ� �Լ�
	public void goParking(String carnum) {
		int fullcount = 0;
		for(int z=0;z<row;z++) {
			for(int w=0;w<column;w++) {
				if(!sucparked[z][w][0].equals(" "))
					fullcount++;
			}
		}
		
		exist = Deduplication(carnum); //�̹� �����Ȱ����� Ȯ���Ͽ� boolean ���Ϲ��� ��
		loop:
			for(int i=0;i<row;i++) {
				for(int j=0;j<column;j++) {
					if(fullcount < row*column) { //�ڸ��� �ִ� ���
						if(exist == true) { //�̹� ������ �Ǿ� �ִٸ�
							if(sucparked[i][j][0].equals(carnum)) {
								System.out.println("����"+sucparked[i][j][1]+", "+sucparked[i][j][0]+"�� ���� �����߽��ϴ�.\n");
								sucparked[i][j][0] = " ";
								break loop;
							}
						}
						else if(exist == false) { //���� ������ �ȵǾ��ִٸ�
							if(sucparked[i][j][0].equals(" ")) {
								sucparked[i][j][0] = carnum;
								sucparked[i][j][1] = carowner;
								System.out.println(sucparked[i][j][0]+"�� ����, ("+i+", "+j+")�� �����߽��ϴ�.\n");
								break loop;
							}
						}
					}
					else if(fullcount == row*column) { //����
						if(exist == true) { //�̹� ������ �Ǿ� �ִٸ�
							if(sucparked[i][j][0].equals(carnum)) {
								System.out.println("����"+sucparked[i][j][1]+", "+sucparked[i][j][0]+"�� ���� �����߽��ϴ�.\n");
								sucparked[i][j][0] = " ";
								break loop;
							}
						}
						else if(exist == false) {//���� ������ �ȵǾ��ִٸ�
							if(!sucparked[i][j][0].equals(carnum)) {
								System.out.println("�����Դϴ�.\n");
								break loop;
							}
						}
					}
				}
			}
	}

	//�̹� �����Ǿ��ִ��� Ȯ�� (�ߺ����� X)
	public boolean Deduplication(String carnum) {
		for(int i=0;i<row;i++) {
			for(int j=0;j<column;j++) {
				if(sucparked[i][j][0].equals(carnum)) //�����Ǿ��ִ� �����̸� true ����
					return true;
			}
		}
		return false;
	}
}

public class ParkingSimulator {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int r,c; String num;
		System.out.print("������ ũ��(��,��)�� �Է��ϼ��� : ");
		r = scanner.nextInt(); c = scanner.nextInt();
		System.out.println("������ �ٹ��� �����մϴ�");
		Parking parking = new Parking(r,c);
		//�����ý��� �ݺ� "���"�Է� ������
		while(true) {
			parking.printArea();
			System.out.print("���� ��ȣ�� �Է��ϼ��� : ");
			num = scanner.next();
			if(num.equals("���")) {
				System.out.println("������ ����մϴ�.");
				break;
			}
			else
				parking.checkreg(num);
		}
		scanner.close();	
	}
}