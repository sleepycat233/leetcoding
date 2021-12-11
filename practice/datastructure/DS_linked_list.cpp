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
    int data;
    Node();
    Node(int dat, Node *pN = nullptr);

    Node* NextNode();
    void InsertAfter(int *pN, int dat);
};

Node::Node()
{
    data = 404;
}

Node::Node(int dat, Node *pN)
{
    this->data = dat;
    this->pNext = pN;
}  

Node* Node::NextNode()
{
    return this->pNext;
}

void Node::InsertAfter(int *pN, int dat)
{
    ;
}

int main()
{
    Node *pE = new Node(14);    // 
    Node *pD = new Node(13, pE);
    Node *pC = new Node(12, pD);
    // Node nC = *pC;   
    Node nB(11, pC);
    Node *pB = &nB;
    Node nA(10, pB);
    Node *pA = &nA; 

    cout << "nA: " << nA.data << " nA NextNode data: " << pA->NextNode()->data << endl; 
    cout << "nC: " << pC->data << " nC NextNode data: " << pC->NextNode()->data << endl;
    cout << "nE: " << pE->data << endl; // << " nE NextNode data: " << pE->NextNode()->data << endl;
    // cout << "nE: " << pE->data << " nE NextNode data: " << pE->NextNode()->data << endl;
}