class Solution {
    public int distMoney(int money, int children) {

        if (money < children) return -1;
        if (money == 4 && children == 1) return -1;

        int rem = money - children; //given 1 to each children then remaining money
        int c = Math.min(children, rem / 7); 

        if (c == children && rem - c * 7 > 0) {  //everyone get 8
            c--;
        }
        if (rem - c * 7 == 3 && children - c == 1) { //avodiing givign 4 
            c--;
        }
        //greedy result 
        return Math.max(0, c);
    }
}
