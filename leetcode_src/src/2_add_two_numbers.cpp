#include <iostream>
#include <iomanip>

using namespace std;

class Node
{
public:
    Node *pNext;
    int data;

    Node();
    Node(int dat, Node *pNex = nullptr);

    Node *NextNode();
    Node *InsertAfter(int dat);
};

Node::Node()
{
    data = NULL;
    pNext = nullptr;
}

Node::Node(int dat, Node *pNex)
{
    data = dat;
    pNext = pNex;
}

Node *Node::NextNode()
{
    return pNext;
}

Node *Node::InsertAfter(int dat)
{
    Node *pNew;

    if(this->pNext != nullptr)
    {
        pNew = new Node(dat, this->pNext);
    }
    else
    {
        pNew = new Node(dat, nullptr);
    }

    this->pNext = pNew;

    return pNew;
}

class Solution
{
public:
    Node *AddTwoList(Node *list1, Node *list2)
    {
        Node *pHead = new Node();
        Node *pTail = pHead;

        int n1, n2, temp, increment = 0;

        while(list1 || list2 || increment)
        {
            if(list1)
            {
                n1 = list1->data;
                list1 = list1->NextNode();
            }
            else
            {
                n1 = 0;
            }
            if(list2)
            {
                n2 = list2->data;
                list2 = list2->NextNode();
            }
            else
            {
                n2 = 0;
            }

            // cout << setw(5) << n1 << n2 << endl;

            temp = n1 + n2;
            if(increment == 1)
            {
                temp += 1;
                increment = 0;
            }
            if(temp / 10 >= 1)
            {
                temp %= 10;
                increment = 1;
            }

            pTail->pNext = new Node(temp);
            pTail = pTail->pNext;
        }

        return pHead->pNext;
    }
};

void printList(Node *pNode)
{
    while(pNode != nullptr)
    {
        cout << setw(5) << pNode->data;
        pNode = pNode->NextNode();
    }

    cout << endl;
}

int main()
{
    Node *head1;
    head1 = new Node(1);
    Node *head2 = new Node(2);

    Solution sol;
    Node *pSumList;

    head1->InsertAfter(2)->InsertAfter(4)->InsertAfter(3)->InsertAfter(6)->InsertAfter(6);
    head2->InsertAfter(5)->InsertAfter(6)->InsertAfter(4)->InsertAfter(4)->InsertAfter(4);

    // cout << head1->data << head1->NextNode()->data << p1->NextNode()->data << p2->data << endl;

    printList(head1);
    printList(head2);
    pSumList = sol.AddTwoList(head1, head2);
    printList(pSumList);
}