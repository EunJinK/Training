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
		cout << "�й� �Է� : ";
		cin >> number;
	
		cout << "�̸� �Է� : ";
		cin >> name;
	
		cout << "�а� �Է� : ";
		cin >> major;

		cout << "�г� �Է� : ";
		cin >> grade;

		cout << "��ȣ �Է�(�ڿ� 8�ڸ�) : ";
		cin >> phone;
	
	}
	void showinfo()
	{
		cout << "---------------------------------------" << endl;
		cout << "   �й�     �̸�   �а�  �г�  ����ó    " << endl;
		cout << "---------------------------------------" << endl;
		cout << number << " " << name << " " << major << "   " << grade << "  " << phone << endl;
		
	}
};

void main()
{
	Info i(2016146011, "������", "IT����", 2, 45348347);
	i.showinfo();
	cout << endl;
	for (int n = 1; n < 4; n++) {

		cout << n << "��° �л�" << endl;
		i.inputInfo();
		i.showinfo();
		cout << endl;
	}
}