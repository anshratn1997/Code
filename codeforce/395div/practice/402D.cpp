#include <bits/stdc++.h>
using namespace std;
char mn[100002];
stack<char>st;
int main() {
    string s;cin>>s;
    char x = 'z';x++;
    int n = s.size();
    mn[n-1] = s[n-1];
    for(int i=n-2;i>=0;i--)
        mn[i] = min(mn[i+1],s[i]);
    for(int i=0;i<n;i++){
        while(!st.empty() && st.top() <= mn[i] )
        cout<<st.top(),st.pop();
        st.push(s[i]);
    }
    while(!st.empty() )
        cout<<st.top(),st.pop();
    return 0;}