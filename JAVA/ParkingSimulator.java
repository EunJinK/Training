package HW3;
import java.util.Arrays;
import java.util.Scanner;

class Parking{
	private boolean exist;
	private static int row, column;
	private String[][] registered = {{"1111","Kim"},{"2222","Lee"},{"3333","Gong"},{"4444","Yoon"},{"5555","Park"},{"6666","Kwon"},{"7777","Park"},{"8888","Choi"}};
	private String[][][] sucparked; //주차완료된 차량 : [행][열][0] = 차 번호 , [행][열][1] = 차 주인이름이 저장될 배열
	private String carowner; //registered에서 sucparked로 차주인이름을 저장하기위해 거치는 String

	//주차공간배열 생성하는 함수
	public Parking(int r, int c) {
		row = r; column = c;
		sucparked = new String[row][column][2];
		for(int i=0;i<row;i++) {
			for(int j=0;j<column;j++) {
				Arrays.fill(sucparked[i][j], " "); //주차완료된 차번호,주인이름이 저장될 배열 초기화
			}
		}
		System.out.println();
	}
	
	//주차공간 프린트함수
	public void printArea() {
		String parkedcar; //결론적으로 프린트할 String
		for(int i=0;i<row;i++) {
			for(int j=0;j<column;j++) {
				if(!sucparked[i][j][0].equals(" ")) //주차공간이 비어있지 않다면(누군가 주차하고있다면) parkedcar에 "주차할 차 번호 + 주인" 저장
					parkedcar = sucparked[i][j][0]+"("+sucparked[i][j][1]+")";
				else
					parkedcar = "____";
				System.out.print("("+i+", "+j+") : "+ parkedcar+" ");
			}
			System.out.println();
		}
	}

	//등록되어있는 차량인지 확인하는 함수
	public void checkreg(String carnum) {
		int count=0;
		for(int i=0;i<registered.length;i++) {
			if(registered[i][0].equals(carnum)) {
				carowner = registered[i][1]; //해당 차량 주인이름을 carowner에 저장한 후
				goParking(carnum); //출차,주차,만차구분하는 함수 호출
				break;//for문 정지 - 더이상 확인할 필요가 없기 때문에
			}
			else if(!registered[i][0].equals(carnum)){ //입력받은 carnum과 등록된 차량이 일치하지않는다면 count++
				count++;
			}
		}
		if(count >= registered.length) //count값이 등록되어있는 차량갯수이상이라면(즉 등록안되어있음)
			System.out.println("등록되지 않은 차량입니다.\n");
	}

	 //출차, 주차, 만차구분하여 알려주는 함수
	public void goParking(String carnum) {
		int fullcount = 0;
		for(int z=0;z<row;z++) {
			for(int w=0;w<column;w++) {
				if(!sucparked[z][w][0].equals(" "))
					fullcount++;
			}
		}
		
		exist = Deduplication(carnum); //이미 주차된것인지 확인하여 boolean 리턴받은 것
		loop:
			for(int i=0;i<row;i++) {
				for(int j=0;j<column;j++) {
					if(fullcount < row*column) { //자리가 있는 경우
						if(exist == true) { //이미 주차가 되어 있다면
							if(sucparked[i][j][0].equals(carnum)) {
								System.out.println("차주"+sucparked[i][j][1]+", "+sucparked[i][j][0]+"번 차량 출차했습니다.\n");
								sucparked[i][j][0] = " ";
								break loop;
							}
						}
						else if(exist == false) { //아직 주차가 안되어있다면
							if(sucparked[i][j][0].equals(" ")) {
								sucparked[i][j][0] = carnum;
								sucparked[i][j][1] = carowner;
								System.out.println(sucparked[i][j][0]+"번 차량, ("+i+", "+j+")에 주차했습니다.\n");
								break loop;
							}
						}
					}
					else if(fullcount == row*column) { //만차
						if(exist == true) { //이미 주차가 되어 있다면
							if(sucparked[i][j][0].equals(carnum)) {
								System.out.println("차주"+sucparked[i][j][1]+", "+sucparked[i][j][0]+"번 차량 출차했습니다.\n");
								sucparked[i][j][0] = " ";
								break loop;
							}
						}
						else if(exist == false) {//아직 주차가 안되어있다면
							if(!sucparked[i][j][0].equals(carnum)) {
								System.out.println("만차입니다.\n");
								break loop;
							}
						}
					}
				}
			}
	}

	//이미 주차되어있는지 확인 (중복주차 X)
	public boolean Deduplication(String carnum) {
		for(int i=0;i<row;i++) {
			for(int j=0;j<column;j++) {
				if(sucparked[i][j][0].equals(carnum)) //주차되어있는 차량이면 true 리턴
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
		System.out.print("주차장 크기(행,렬)을 입력하세요 : ");
		r = scanner.nextInt(); c = scanner.nextInt();
		System.out.println("김은진 근무를 시작합니다");
		Parking parking = new Parking(r,c);
		//주차시스템 반복 "퇴근"입력 전까지
		while(true) {
			parking.printArea();
			System.out.print("차량 번호를 입력하세요 : ");
			num = scanner.next();
			if(num.equals("퇴근")) {
				System.out.println("김은진 퇴근합니다.");
				break;
			}
			else
				parking.checkreg(num);
		}
		scanner.close();	
	}
}