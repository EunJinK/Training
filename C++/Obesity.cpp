#include <iostream>
#include <string>
using namespace std;

class Human
{
public:
	string name;
	float height, weight;
public:
	Human(string n = "", float h = 0, float w = 0) {
		name = n;
		height = h;
		weight = w;
	}
	void showhuman() {
		cout << "성명 : " << name << ", 키(cm) : " << height << ", 몸무게(kg) : " << weight;
	}
};

class Biman :public Human
{
private:
	float pweight, biman;
	float bim;
public:
	Biman(string n = "", float h = 0, float w = 0) {
		name = n;
		height = h;
		weight = w;
	}
	void showBiman() {
		showhuman();
	}
	void input();
	void output();
	void Jung(Biman* bi);
	void search(Biman* bi);
};

void Biman::input() {
	cout << "성명 : ";
	cin >> name;
	cout << "키(cm) : ";
	cin >> height;
	cout << "몸무게(kg) : ";
	cin >> weight;

}

void Biman::output() {
	showBiman();
	pweight = (height - 100) * (0.9);
	biman = weight / pweight;

	cout << ", 표준체중(kg) : " << pweight << endl << ", 비만율(%) : " << biman << endl;

}

void Biman::Jung(Biman* bi) {
	string max = (bi)->name, min;

	if (max.compare((bi + 1)->name) > 0) {
		if (((bi + 1)->name).compare((bi + 2)->name) < 0) {
			max = (bi + 1)->name;
			(bi + 1)->output();
		}
		else if (((bi + 1)->name).compare((bi + 2)->name) > 0) {
			max = (bi + 2)->name;
			(bi + 2)->output();
		}
	}
	else if (max.compare((bi + 1)->name) < 0) {
		if (max.compare((bi + 2)->name) > 0) {
			(bi + 2)->output();
			(bi + 2)->name = max;
		}
		else if (max.compare((bi + 2)->name) < 0) {
			(bi)->output();
		}
	}

	string mid = (bi)->name;

	if (mid.compare((bi + 1)->name) < 0) {
		if (mid.compare((bi + 2)->name) > 0) {
			mid = (bi)->name;
			(bi)->output();
		}
		else if (mid.compare((bi + 2)->name) < 0) {
			if (((bi + 1)->name.compare((bi + 2)->name)) < 0) {
				mid = (bi + 1)->name;
				(bi + 1)->output();
			}
			else if (((bi + 1)->name.compare((bi + 2)->name)) > 0) {
				mid = (bi + 2)->name;
				(bi + 2)->output();
			}
		}
	}
	else if (mid.compare((bi + 1)->name) > 0) {
		if (mid.compare((bi + 2)->name) < 0) {
			mid = (bi)->name;
			(bi)->output();
		}
		else if (mid.compare((bi + 2)->name) > 0) {
			if (((bi + 1)->name.compare((bi + 2)->name)) < 0) {
				mid = (bi + 2)->name;
				(bi + 2)->output();
			}
			else if (((bi + 1)->name.compare((bi + 2)->name)) > 0) {
				mid = (bi + 1)->name;
				(bi + 1)->output();
			}
		}
	}

	for (int i = 0; i < 3; i++) {
		if (((bi + i)->name) != max && ((bi + i)->name) != mid) {
			min = (bi + i)->name;
			(bi + i)->output();
		}
	}

}

void Biman::search(Biman* bi) {

	string an, who;

	cout << "비만도를 알아보시겠습니까(Y/N) ? ";
	cin >> an;

	if (an == "Y") {
		cout << "누구의 비만도를 알아볼지 적어주세요 : ";
		cin >> who;
		for (int i = 0; i < 3; i++) {
			bim = ((bi + i)->biman) * 100;
			if (who.compare((bi + i)->name) == 0) {
				if (bim <= 90) {
					cout << (bi + i)->name << "님은 체중미달 입니다." << endl;
				}
				else if (bim > 90 && bim <= 110) {
					cout << (bi + i)->name << "님은 정상 입니다." << endl;
				}
				else if (bim > 110 && bim <= 120) {
					cout << (bi + i)->name << "님은 과체중 입니다." << endl;
				}
				else
					cout << (bi + i)->name << "님은 고도비만 입니다." << endl;
			}
		}
	}
	else if (an == "N") {
		cout << "비만도 확인을 종료합니다." << endl;
	}
}

void main()
{
	int bun;
	Biman* bi = new Biman[3];
	Human* h = new Human[3];

	do {
		cout << "---------------------------" << endl;
		cout << "   1. 회원 정보 입력         " << endl;
		cout << "   2. 회원 정보 출력 " << endl;
		cout << "   3. 이름 순 정렬         " << endl;
		cout << "   4. 비만도 알아보기         " << endl;
		cout << "   5. 종료         " << endl;
		cout << "---------------------------" << endl;
		cout << " 원하는 활동을 골라주세요 : ";
		cin >> bun;

		switch (bun) {
		case 1:
			cout << endl;
			for (int i = 0; i < 3; i++) {
				(bi + i)->input();
			}
			cout << endl;
			break;
		case 2:
			cout << endl;
			for (int i = 0; i < 3; i++) {
				(bi + i)->output();
			}
			cout << endl;
			break;
		case 3:
			cout << endl;
			bi->Jung(bi);
			cout << endl;
			break;
		case 4:
			bi->search(bi);
			break;
		case 5:
			cout << "프로그램 종료!" << endl;
			break;
		}
	} while (bun != 5);
}