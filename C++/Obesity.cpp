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
		cout << "���� : " << name << ", Ű(cm) : " << height << ", ������(kg) : " << weight;
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
	cout << "���� : ";
	cin >> name;
	cout << "Ű(cm) : ";
	cin >> height;
	cout << "������(kg) : ";
	cin >> weight;

}

void Biman::output() {
	showBiman();
	pweight = (height - 100) * (0.9);
	biman = weight / pweight;

	cout << ", ǥ��ü��(kg) : " << pweight << endl << ", ����(%) : " << biman << endl;

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

	cout << "�񸸵��� �˾ƺ��ðڽ��ϱ�(Y/N) ? ";
	cin >> an;

	if (an == "Y") {
		cout << "������ �񸸵��� �˾ƺ��� �����ּ��� : ";
		cin >> who;
		for (int i = 0; i < 3; i++) {
			bim = ((bi + i)->biman) * 100;
			if (who.compare((bi + i)->name) == 0) {
				if (bim <= 90) {
					cout << (bi + i)->name << "���� ü�߹̴� �Դϴ�." << endl;
				}
				else if (bim > 90 && bim <= 110) {
					cout << (bi + i)->name << "���� ���� �Դϴ�." << endl;
				}
				else if (bim > 110 && bim <= 120) {
					cout << (bi + i)->name << "���� ��ü�� �Դϴ�." << endl;
				}
				else
					cout << (bi + i)->name << "���� ���� �Դϴ�." << endl;
			}
		}
	}
	else if (an == "N") {
		cout << "�񸸵� Ȯ���� �����մϴ�." << endl;
	}
}

void main()
{
	int bun;
	Biman* bi = new Biman[3];
	Human* h = new Human[3];

	do {
		cout << "---------------------------" << endl;
		cout << "   1. ȸ�� ���� �Է�         " << endl;
		cout << "   2. ȸ�� ���� ��� " << endl;
		cout << "   3. �̸� �� ����         " << endl;
		cout << "   4. �񸸵� �˾ƺ���         " << endl;
		cout << "   5. ����         " << endl;
		cout << "---------------------------" << endl;
		cout << " ���ϴ� Ȱ���� ����ּ��� : ";
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
			cout << "���α׷� ����!" << endl;
			break;
		}
	} while (bun != 5);
}