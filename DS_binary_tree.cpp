//  insert
//  search
//  get_hight
//  print tree
//  destroy tree

#include <iostream>
using namespace std;

struct Node
{
    int data;
    Node *left;
    Node *right;
};

class btree
{
    public:
        btree();
        ~btree();
        
        Node *root;
        void insert(int key);
        Node *search(int key);

        void printTree();
        void printTreeGraph(); // 
        void destroyTree();

    private:
        void insert(int key, Node *leaf);        
        Node *search(int key, Node *leaf);
        void destroyTree(Node *leaf);
        void printTree(Node *leaf);
};

btree::btree()
{
    root = nullptr;
}

btree::~btree()
{
    // destroyTree();
}

void btree::insert(int key)
{
    if(root != nullptr)
    {
        insert(key, root);
    }
    else
    {
        root = new Node;
        root->data = key;
        root->left = nullptr;
        root->right = nullptr;
    }
}

void btree::insert(int key, Node *leaf)
{
    if(key < leaf->data)
    {
        if(leaf->left != nullptr)
        {
            insert(key, leaf->left);
        }
        else
        {
            leaf->left = new Node;
            leaf->left->data = key;
            leaf->left->left = nullptr;
            leaf->left->right = nullptr;
        }
    }
    else if(key >= leaf->data)
    {
        if(leaf->right != nullptr)
        {
            insert(key, leaf->right);
        }
        else
        {
            leaf->right = new Node;
            leaf->right->data = key;
            leaf->right->left = nullptr;
            leaf->right->right = nullptr;
        }        
    }
}

Node *btree::search(int key, Node *leaf)
{

}

void btree::printTree()
{
    // cout << root->data;
    printTree(root);
}

int cleft = 0, cright = 0;

void btree::printTree(Node *leaf)
{
    cout << leaf->data;

    if(leaf->left != nullptr)
    {
        cout << "print left";
        cleft += 1;
        printTree(leaf->left);
    }
    else
    {
        cout << "left empty" << cleft << "\n";
    }

    if(leaf->right != nullptr)
    {
        cout << "print right";
        cright += 1;
        printTree(leaf->right);
    }
    else
    {
        cout << "right empty " << cright << "\n";
    }
}

int main()
{
    btree mytree;

    mytree.insert(10);
    mytree.insert(6);
    mytree.insert(14);
    mytree.insert(5);
    mytree.insert(8);
    mytree.insert(11);
    mytree.insert(18);

    // cout << "root data:" << mytree.root->data << " root left data: " << mytree.root->left->data << " root right data: " << mytree.root->right->data;

    mytree.printTree();
}