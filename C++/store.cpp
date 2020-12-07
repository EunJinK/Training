#include <iostream>
#include <string>
using namespace std;

class Meal
{
protected:
	string m1, m2, m3, s1, s2, s3;
	string menu, store;
	int price, p1, p2, p3;
public:
	Meal(string m = "", int p = 0, string s = "") {
		menu = m;
		price = p;
		store = s;
	};
	void input() {
		int i;

		for (i = 1; i < 4; i++) {
			cout << i << "��° �޴��� �Է� �ϼ��� : " << endl;
			Meal inn(menu, price, store);
			cout << "�޴� : ";
			cin >> menu;
			cout << "����(��) : ";
			cin >> price;
			cout << "���� : ";
			cin >> store;
			switch (i) {
			case 0:
			case 1:
				m1 = menu;
				p1 = price;
				s1 = store;
				break;
			case 2:
				m2 = menu;
				p2 = price;
				s2 = store;
				break;
			case 3:
				m3 = menu;
				p3 = price;
				s3 = store;
			}
		}
	}

	void showinput()
	{
		cout << "�޴� : " << m1 << ", ����(��) : " << p1 << ", ���� : " << s1 << endl;
		cout << "�޴� : " << m2 << ", ����(��) : " << p2 << ", ���� : " << s2 << endl;
		cout << "�޴� : " << m3 << ", ����(��) : " << p3 << ", ���� : " << s3 << endl;
	}

	void psoon()
	{
		cout << "���ݼ� ���� �Դϴ�.(���� ���� ��)" << endl;
		if (p1 >= p2) {
			if (p1 >= p3) {
				if (p3 >= p2)
					cout << m1 << ", " << m3 << ", " << m2 << endl;
				else if (p2 >= p3)
					cout << m1 << ", " << m2 << ", " << m3 << endl;
			}
			else if (p3 >= p1) {
				cout << m3 << ", " << m1 << ", " << m2 << endl;
			}
		}
		else if (p2 >= p1) {
			if (p1 >= p3)
				cout << m2 << ", " << m1 << ", " << m3 << endl;
			else if (p3 >= p1)
				if (p3 >= p2) {
					cout << m3 << ", " << m2 << ", " << m1 << endl;
				}
				else if (p2 >= p3) {
					cout << m2 << ", " << m3 << ", " << m1 << endl;
				}
		}
	}

	void search()
	{
		string se;
		cout << "���� �̸��̳� ���Ը� �˻����ּ��� : ";
		cin >> se;

		if (se == m1 || se == s1) {
			cout << s1 << " " << m1 << " " << p1 << "��" << endl;
		}
		else if (se == m2 || se == s2) {
			cout << s2 << " " << m2 << " " << p2 << "��" << endl;
		}
		else if (se == m3 || se == s3) {
			cout << s3 << " " << m3 << " " << p3 << "��" << endl;
		}
		else
			cout << "�߸� �Է��ϼ̽��ϴ�." << endl;
	}
};

void main()
{
	int bun;
	Meal ii;

	do {
		cout << "---------------------------" << endl;
		cout << "   1. �Է�         " << endl;
		cout << "   2. ��ü�޴�Ȯ�� " << endl;
		cout << "   3. ����         " << endl;
		cout << "   4. �˻�         " << endl;
		cout << "   5. ����         " << endl;
		cout << "---------------------------" << endl;
		cout << " ���ϴ� Ȱ���� ����ּ��� : ";
		cin >> bun;

		switch (bun) {
		case 1:
			ii.input();
			break;
		case 2:
			ii.showinput();
			break;
		case 3:
			ii.psoon();
			break;
		case 4:
			ii.search();
			break;
		}
	} while (bun != 5);
}