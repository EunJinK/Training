package FileExplorer;

import java.io.File;
import java.util.Scanner;

public class FileExplorer {
	static boolean bool = false;
	static String input = "";
	static String current = "C:\\"; //경로 출력할 것 
	static String inputlocation = "";
	static File inputfile = new File("c:\\"); //파일
	static String beforeinput = ""; //이전경로
	static String fileinput = "";
	
	public static void printList(File file) { //리스트 프린트
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
	
	public static boolean whattype(File file) { //파일인지 디렉토리인지
		File file1 = new File(file.getPath());
		if(file1.isFile() || !file1.exists()) {
			return true;
		}
		else return false;
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		printList(inputfile); //첫 시작인 c드라이브 파일 내용 출력
		while(true) {
			System.out.print(current+" >> ");
			input = scanner.next();
			if(input.equals("exit")) break; //입력받은 경로가 exit면 break
			else if(input.equals("..")) { //입력받은 경로가 ..면 상위폴더
				if(current.equals("C:\\")) { //상위폴더를 입력 받았는데 현재 위치한 곳이 c드라이브면
					current = "C:\\"; //현재 그대로 경로출력
					inputfile = new File("c:\\"+inputlocation); //c드라이브경로 파일 정의
					printList(inputfile);
				}
				else { //상위폴더를 입력받았는데 상위폴더가 존재한다면
					inputlocation = inputlocation.replace(beforeinput, ""); //inputlocation 문자열 중 beforeinput을 찾아서 ""으로 바꿈
					inputfile = new File("c:\\"+inputlocation); // 이전 경로(.. 입력 직전 경로)를 지운 inputlocation 파일 정의
					current = current.replace(beforeinput, "");	// 현재 위치 출력할 current에서도 이전 경로를 ""로 바꿈
					beforeinput = inputfile.getName().concat("\\"); //이전 경로를 다시 정의해줌 (위에서 상위폴더경로로 바꿔줬으니까 그거에 대한 상위폴더를 다시 정의 ex - C:\\A\\B\\D\\.. -> 에서 이전 경로는 D
					//D를 지운 후 출력할 경로는 C:\\A\\B\\ 인데 여기서 ..를 입력하면 이전 경로가 B가되는거니까 B를 beforeinput으로 다시 정의하는 것
					printList(inputfile);
				}
			}
			else {
				fileinput = input; //입력받은 경로를 fileinput에 저장
				inputlocation = inputlocation+input+"\\"; //파일정의에 들어갈 inputlocation을 입력받은 거와 합치기
				inputfile = new File("c:\\"+inputlocation);
				bool = whattype(inputfile); //디렉터리인지 아닌지 확인
				if(bool == true) { //디렉터리가 아니라면
					inputlocation = inputlocation.replace(fileinput, ""); //아까 합친 inputlocation에서 input다시 빼기(디렉터리가 아니니까)
					inputfile = new File("c:\\"+inputlocation);
					printList(inputfile);
				}
				else if(bool == false) { //디렉터리라면
					beforeinput = input.concat("\\"); //beforeinput(이전 경로)에 입력받은 것을 저장 +"\\"까지(그래야 나중에 ""처리할때 쉬움)
					current = current+input+"\\"; //현재 경로 출력할 때
					printList(inputfile);
				}
			}
		}
		scanner.close();
	}
}