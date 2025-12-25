// Last updated: 12/25/2025, 6:48:47 PM
1class Solution {
2    public int distMoney(int money, int children) {
3
4        if (money < children) return -1;
5        if (money == 4 && children == 1) return -1;
6
7        int rem = money - children; //given 1 to each children then remaining money
8        int c = Math.min(children, rem / 7); 
9
10        if (c == children && rem - c * 7 > 0) {  //everyone get 8
11            c--;
12        }
13        if (rem - c * 7 == 3 && children - c == 1) { //avodiing givign 4 
14            c--;
15        }
16        //greedy result 
17        return Math.max(0, c);
18    }
19}
20