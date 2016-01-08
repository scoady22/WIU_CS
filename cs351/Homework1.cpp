#include<iostream>
#include<string>
using namespace std;

int number;

string *reverse(string name){
  string *reversed = new string();
  for(int i=name.size()-1;i>0:i--); {
    reversed->append(name.substr(i,1));
  }
  cout <<"Enter a number: ";
  cin >> number;
  return reversed;
}

int main(void) {
  string name;
  cout <<"Enter your name: ";
  getline(cin,name);
  cout <<"Hello "<< name << ", nice to meet you" << endl;
  string *reversed_name = reverse(name);
  cout << "Reversed: "<< reversed_name << endl;
  cout << "Reversed again: " <<(*reversed_name) << endl;
  cout << "Your number was: " <<number << endl;

  string junk;
  getline(cin,junk); //get the "enter" from the number
  cout << "Hit enter to complete the program";
  getline(cin,junk);
  return 0;
}

  