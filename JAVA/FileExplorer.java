package FileExplorer;

import java.io.File;
import java.util.Scanner;

public class FileExplorer {
	static boolean bool = false;
	static String input = "";
	static String current = "C:\\"; //��� ����� �� 
	static String inputlocation = "";
	static File inputfile = new File("c:\\"); //����
	static String beforeinput = ""; //�������
	static String fileinput = "";
	
	public static void printList(File file) { //����Ʈ ����Ʈ
		File[] subFiles = file.listFiles();
		String res = "";
		System.out.println();
		for(int i=0;i<subFiles.length;i++) {
			File f = subFiles[i];
			if(f.isFile()) res = "[F]";
			else if(f.isDirectory()) res = "[D]";
			System.out.println(res+" "+f.getName());
		}
	}
	
	public static boolean whattype(File file) { //�������� ���丮����
		File file1 = new File(file.getPath());
		if(file1.isFile() || !file1.exists()) {
			return true;
		}
		else return false;
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		printList(inputfile); //ù ������ c����̺� ���� ���� ���
		while(true) {
			System.out.print(current+" >> ");
			input = scanner.next();
			if(input.equals("exit")) break; //�Է¹��� ��ΰ� exit�� break
			else if(input.equals("..")) { //�Է¹��� ��ΰ� ..�� ��������
				if(current.equals("C:\\")) { //���������� �Է� �޾Ҵµ� ���� ��ġ�� ���� c����̺��
					current = "C:\\"; //���� �״�� ������
					inputfile = new File("c:\\"+inputlocation); //c����̺��� ���� ����
					printList(inputfile);
				}
				else { //���������� �Է¹޾Ҵµ� ���������� �����Ѵٸ�
					inputlocation = inputlocation.replace(beforeinput, ""); //inputlocation ���ڿ� �� beforeinput�� ã�Ƽ� ""���� �ٲ�
					inputfile = new File("c:\\"+inputlocation); // ���� ���(.. �Է� ���� ���)�� ���� inputlocation ���� ����
					current = current.replace(beforeinput, "");	// ���� ��ġ ����� current������ ���� ��θ� ""�� �ٲ�
					beforeinput = inputfile.getName().concat("\\"); //���� ��θ� �ٽ� �������� (������ ����������η� �ٲ������ϱ� �װſ� ���� ���������� �ٽ� ���� ex - C:\\A\\B\\D\\.. -> ���� ���� ��δ� D
					//D�� ���� �� ����� ��δ� C:\\A\\B\\ �ε� ���⼭ ..�� �Է��ϸ� ���� ��ΰ� B���Ǵ°Ŵϱ� B�� beforeinput���� �ٽ� �����ϴ� ��
					printList(inputfile);
				}
			}
			else {
				fileinput = input; //�Է¹��� ��θ� fileinput�� ����
				inputlocation = inputlocation+input+"\\"; //�������ǿ� �� inputlocation�� �Է¹��� �ſ� ��ġ��
				inputfile = new File("c:\\"+inputlocation);
				bool = whattype(inputfile); //���͸����� �ƴ��� Ȯ��
				if(bool == true) { //���͸��� �ƴ϶��
					inputlocation = inputlocation.replace(fileinput, ""); //�Ʊ� ��ģ inputlocation���� input�ٽ� ����(���͸��� �ƴϴϱ�)
					inputfile = new File("c:\\"+inputlocation);
					printList(inputfile);
				}
				else if(bool == false) { //���͸����
					beforeinput = input.concat("\\"); //beforeinput(���� ���)�� �Է¹��� ���� ���� +"\\"����(�׷��� ���߿� ""ó���Ҷ� ����)
					current = current+input+"\\"; //���� ��� ����� ��
					printList(inputfile);
				}
			}
		}
		scanner.close();
	}
}