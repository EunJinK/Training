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
			cout << i << "번째 메뉴를 입력 하세요 : " << endl;
			Meal inn(menu, price, store);
			cout << "메뉴 : ";
			cin >> menu;
			cout << "가격(원) : ";
			cin >> price;
			cout << "가게 : ";
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
		cout << "메뉴 : " << m1 << ", 가격(원) : " << p1 << ", 가게 : " << s1 << endl;
		cout << "메뉴 : " << m2 << ", 가격(원) : " << p2 << ", 가게 : " << s2 << endl;
		cout << "메뉴 : " << m3 << ", 가격(원) : " << p3 << ", 가게 : " << s3 << endl;
	}

	void psoon()
	{
		cout << "가격순 정렬 입니다.(높은 가격 순)" << endl;
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
		cout << "음식 이름이나 가게를 검색해주세요 : ";
		cin >> se;

		if (se == m1 || se == s1) {
			cout << s1 << " " << m1 << " " << p1 << "원" << endl;
		}
		else if (se == m2 || se == s2) {
			cout << s2 << " " << m2 << " " << p2 << "원" << endl;
		}
		else if (se == m3 || se == s3) {
			cout << s3 << " " << m3 << " " << p3 << "원" << endl;
		}
		else
			cout << "잘못 입력하셨습니다." << endl;
	}
};

void main()
{
	int bun;
	Meal ii;

	do {
		cout << "---------------------------" << endl;
		cout << "   1. 입력         " << endl;
		cout << "   2. 전체메뉴확인 " << endl;
		cout << "   3. 정렬         " << endl;
		cout << "   4. 검색         " << endl;
		cout << "   5. 종료         " << endl;
		cout << "---------------------------" << endl;
		cout << " 원하는 활동을 골라주세요 : ";
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