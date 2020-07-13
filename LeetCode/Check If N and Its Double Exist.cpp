#include <bits/stdc++.h>
using namespace std;

//         unordered_set<int> hashset;
        
//         for (int num : arr) {
//             if (hashset.find(num * 2) != hashset.end()) return true;
//             else if (num % 2 == 0 && hashset.find(num / 2) != hashset.end()) return true;
//             else hashset.insert(num);
//         }
//         return false;
//     }

bool checkIfExist(vector<int>& arr) {
  unordered_set<int> hashset;

  for (int num : arr) {
    if (hashset.find(num * 2) != hashset.end())
      return true;
    else if (num % 2 == 0 && hashset.find(num / 2) != hashset.end())
      return true;
    else
      hashset.insert(num);
  }
  
  return false;
}

bool validMountainArray(vector<int>& A) {
    if (A.size() < 3)
      return false;
    
    // left pointer
    int left;
    for (int i=0; i<A.size(); i++) {
      if (A[i+1] < A[i]) {
        left = i;
        break;
      }
    }
    // right pointer
    int right;
    for (int j=A.size()-1; j>=0; j--) {
      if (A[j-1] < A[j]) {
        right = j;
        break;
      }
    }
    cout << left << " " << right << "\n";
    // Checking if it's a valid mountain
    if (left == right && left > 0 && right < A.size()-1)
      return true;
    
    return false;
}


int main() {
  int t, n;
  vector<int> arr;

  cin >> t;

  while(t--) {
    cin >> n;
    arr.push_back(n);
    cout << n << " ";
  }
  cout << "\n";

  cout << validMountainArray(arr) << "\n";
}