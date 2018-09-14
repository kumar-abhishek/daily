/*
zig zag iterator
*/

class ZigzagIterator {
    vector<int>::iterator it1, it2;
    vector<int> &v1;
    vector<int> &v2;
    bool turn=true;
public:
    ZigzagIterator(vector<int>& p1, vector<int>& p2): v1(p1), v2(p2) {
        it1=v1.begin();
        it2=v2.begin();
    }

    int next() {
        int ret=-1;
        if(turn) {
            if(it1 != v1.end()) {
                ret =*it1;   
                ++it1;
            }
            else {
                ret = *it2;
                ++it2;
            }
        }
        else {
            if(it2 !=v2.end()) {
                ret =*it2;   
                ++it2;
            }
            else {
                ret = *it1;
                ++it1;
            }   
        }
        turn = !turn;
        return ret;
    }

    bool hasNext() {
        return ((it1!=v1.end()) || (it2 !=v2.end()));
    }
};

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i(v1, v2);
 * while (i.hasNext()) cout << i.next();
 */
