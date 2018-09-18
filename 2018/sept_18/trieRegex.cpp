#include <bits/stdc++.h>
using namespace std;

class TrieNode { 
public:
  TrieNode* children[26]={};
  bool isEndWord=false;
  TrieNode() {
    //fill(children, children+26, nullptr);
  }
};

TrieNode* root=new TrieNode();

void addWord(string word) {
  TrieNode* node = root;
  for(char ch: word) {
    if(node->children[ch-'a']==nullptr){
      node->children[ch-'a']= new TrieNode();
    }
    node=node->children[ch-'a'];
  }
  node->isEndWord=true;
}

bool searchWord(string pattern, TrieNode* node) {  // node is root.
  for(int i=0;i<pattern.size();i++) {
    char ch = pattern[i];
    if(ch=='.') {
      for(TrieNode* n: node->children) {
        if(n != nullptr) {
          if(searchWord(pattern.substr(i+1), n))
            return true;
        }
      }
    }
    else {
      TrieNode* n = node->children[ch-'a'];
      if(n==nullptr) return false;
      node=n;
    }
  }
  return /*pattern.size()==0 &&*/ node->isEndWord;
}

int main() {
  
  addWord("hello");/*
  addWord("h");
  addWord("h\n");
  addWord("h\n");
  addWord("h\n");
  addWord("00221");
  addWord("");
  addWord("\n");
  addWord("\r"); 
  */
  
cout<<  searchWord("hell.", root)<<endl; // T
cout<<searchWord("h...o", root)<<endl;//T
  cout<<searchWord(".....", root)<<endl; // T
  cout<<searchWord(".", root)<<endl;// F
  cout<<searchWord(".e...", root)<<endl;//T
  cout<<searchWord("", root)<<endl; // F
  
  return 0;
}
 
