// 프린터 큐 - S3
// 구현 문제였음. 문제를 따라가다보면 deque로 구현이 가능함

#include <iostream>
#include <queue>
#include <vector>

using namespace std;

int t, n, m;
int a;
vector<int> ans;

int main() {
    cin >> t;
    for (int i=0; i<t; i++) {
        deque<pair<int, int>> q;
        int cnt = 0;
        cin >> n >> m;
        for (int j=0; j<n; j++) {
            cin >> a;
            q.push_back({a, j});
        }
        while (true) {
            pair<int, int> temp = q.front();
            q.pop_front();
            int flag = 0;
            for (pair<int, int> qu: q) {
                if (temp.first < qu.first) {
                    flag = 1;
                }
            }
            if (flag) q.push_back(temp);
            else {
                cnt++;
                if (temp.second == m) {
                    ans.push_back(cnt);
                    break;
                }
            }
        }
    }

    for (int i: ans) {
        cout<<i<<'\n';
    }
}