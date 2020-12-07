#include <iostream>
#include <string>
using namespace std;

class Info
{
private:
	int number, grade, phone;
	string name, major;
public:
	Info(int n, string na, string ma, int g = 0, int p = 0) :number(n), name(na), major(ma), grade(g), phone(p) {}
	void inputInfo()
	{
		cout << "학번 입력 : ";
		cin >> number;
	
		cout << "이름 입력 : ";
		cin >> name;
	
		cout << "학과 입력 : ";
		cin >> major;

		cout << "학년 입력 : ";
		cin >> grade;

		cout << "번호 입력(뒤에 8자리) : ";
		cin >> phone;
	
	}
	void showinfo()
	{
		cout << "---------------------------------------" << endl;
		cout << "   학번     이름   학과  학년  연락처    " << endl;
		cout << "---------------------------------------" << endl;
		cout << number << " " << name << " " << major << "   " << grade << "  " << phone << endl;
		
	}
};

void main()
{
	Info i(2016146011, "김은진", "IT융합", 2, 45348347);
	i.showinfo();
	cout << endl;
	for (int n = 1; n < 4; n++) {

		cout << n << "번째 학생" << endl;
		i.inputInfo();
		i.showinfo();
		cout << endl;
	}
}