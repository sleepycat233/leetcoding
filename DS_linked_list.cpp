#include <iostream>
using namespace std;

// P Q R S T Y
// A B C D E F

// member: next; data
// fuctions:
//      CreateNode
//      DeleteNode
//      InsertAfter
//      NextNode

// template<class T>
class Node
{
private:
    Node *pNext;

public:
    char data;
    Node();
    Node(char dat, Node *pN = nullptr);
};

Node::Node()
{
    data = 'X';
}

Node::Node(char dat, Node *pN)
{
    this->data = dat;
    this->pNext = pN;
}


int main()
{
    Node n1;
    Node nA('A');
    Node *p;

    cout << "nA " << nA.data << " n1 " << n1.data << endl; 
}