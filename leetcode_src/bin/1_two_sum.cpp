#include <iostream>
#include <vector>

using namespace std;

int GetSumIndex(vector<int> nums, int target)
{
    // int a, b;

    for(auto a = nums.begin(); a != nums.end(); ++a)
    {
        cout << a << " ";
    }

    // for(int a : nums)
    // {
    //     // cout << a << " ";

    //     for(int b : nums)
    //     {

    //     }
    // }
}

int main()
{
    // int nums[] = {2, 7, 11, 15};

    vector<int> nums {2, 7, 11, 15};


    GetSumIndex(nums, 13);
}