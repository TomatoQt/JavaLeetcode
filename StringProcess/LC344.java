package StringProcess;

public class LC344 {
    public void reverseString(char[] s) {
        int length = s.length;
        int left=0,right=length-1;
        while(left<right){
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
}
