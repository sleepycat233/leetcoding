//  insert
//  search
//  get_hight
//  print tree
//  destroy tree

#include <iostream>
#include <iomanip>
using namespace std;

struct Node
{
    int data;
    Node* left;
    Node* right;
};
//asdfasdfasdf
class btree
{
public:
    btree();
    ~btree();

    Node* root;
    void insert(int key);
    Node* search(int key);

    void printTreePreOrder();
    void printTreeInOrder();
    void printTreeGraph(); // 
    void destroyTree();

private:
    void insert(int key, Node* leaf);
    Node* search(int key, Node* leaf);
    void destroyTree(Node* leaf);
    void printTreePreOrder(Node* leaf);
    void printTreeInOrder(Node* leaf);
};

btree::btree()
{
    root = nullptr;
}

btree::~btree()
{
    destroyTree(root);
}

void btree::destroyTree(Node* leaf)
{
    if(leaf != nullptr)
    {
        destroyTree(leaf->left);
        destroyTree(leaf->right);
        delete leaf;
    }
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

void btree::insert(int key, Node* leaf)
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

Node* btree::search(int key, Node* leaf)
{

}

void btree::printTreePreOrder()
{
    // cout << root->data;
    printTreePreOrder(root);
}

int cleft = 0, cright = 0;

void btree::printTreePreOrder(Node* leaf)
{
    cout << leaf->data << " ";

    if(leaf->left != nullptr)
    {
        // cout << "print left";
        cleft += 1;
        printTreePreOrder(leaf->left);
    }
    else
    {
        // cout << "left empty" << cleft << "\n";
    }

    if(leaf->right != nullptr)
    {
        // cout << "print right";
        cright += 1;
        printTreePreOrder(leaf->right);
    }
    else
    {
        // cout << "right empty " << cright << "\n";
    }
}

/* 
     10
   /    \
  6      14
 / \    /  \
5   8  11  18
 */

int treeHight = 0;

void btree::printTreeInOrder()
{
    printTreeInOrder(root);
}

void btree::printTreeInOrder(Node* leaf)
{
    treeHight++;
    if(leaf == nullptr)
    {
        treeHight--;
        return;
    }

    printTreeInOrder(leaf->left);
    cout << setw(30 - (5 * treeHight)) << leaf->data << endl;
    // cout << setw(30 - (5 * treeHight)) << leaf->data << "hight: " << treeHight << endl;
    printTreeInOrder(leaf->right);

    treeHight--;
}

int main()
{
    btree mytree;

    mytree.insert(10);
    mytree.insert(6);
    mytree.insert(14);
    mytree.insert(4);
    mytree.insert(8);
    mytree.insert(11);
    mytree.insert(18);

    mytree.insert(13);
    mytree.insert(9);
    mytree.insert(10);
    mytree.insert(2);
    mytree.insert(7);
    mytree.insert(5);
    // mytree.insert(7);
    mytree.insert(15);
    mytree.insert(15);
    mytree.insert(18);

    // cout << "root data:" << mytree.root->data << " root left data: " << mytree.root->left->data << " root right data: " << mytree.root->right->data;

    mytree.printTreePreOrder();
    cout << "\n";
    mytree.printTreeInOrder();
}