package Strings;

import java.util.Stack;

class Reverse {
    public static String reverseWords(String s) {
        char ar[]= s.toCharArray();
        return reverseWords(ar, 0);
    }

    public static String reverseWords(char ar[], int i) {
        int o = i;
        if(i>=ar.length){
            return "";
        }
        StringBuilder s = new StringBuilder();
        while(i<ar.length && ar[i]==' '){
            i++;
        }
        while(i<ar.length && ar[i]!=' '){
            s.append(ar[i++]);
        }
//        while(i<ar.length && ar[i]==' '){
//            i++;
//        }
        String x = reverseWords(ar, i);
        if(o==0)
            return x+ s;
        return x + s + " ";
    }

    public String reverseWords1(String s) {
        StringBuilder sb = new StringBuilder();
        char[] ca = s.toCharArray();
        Stack<String> st = new Stack<>();
        for(int i=0;i<ca.length;i++){
            if(ca[i]==' '){
                if(sb.length()>0){
                    st.push(sb.toString());
                    sb= new StringBuilder();
                }
            }else{
                sb.append(ca[i]);
                if(i==ca.length-1) {
                    st.push(sb.toString());
                    sb= new StringBuilder();
                }
            }
        }
        while(!st.isEmpty()){
            sb.append(st.pop());
            if(st.size()!=0)
                sb.append(" ");
        }
        return sb.toString();
    }

    public static void  reverse(char[] ar, int i, int j){
        for(;i<j;i++,j--){
            char t=ar[i];
            ar[i]=ar[j];
            ar[j]=t;
        }
    }

    public static String reverseWords2(String s) {
        char[] ar = s.toCharArray();
        int  n = ar.length, j=0, i=0;
        reverse(ar,0, n-1); //reverse complete string
        while(i<n) {
            int st = j; //start of a word
            while (i < n && ar[i] == ' ') i++; //remove initial spaces
            while (i < n && ar[i] != ' ') ar[j++] = ar[i++]; //copy values
            while (i < n && ar[i] == ' ') i++; //remove end spaces
            reverse(ar, st, j-1); //reverse the word from initial to end
            if (i < n) ar[j++] = ' '; // add space if completer string is not traversed
        }
        return new String(ar, 0, j); // return string
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("a good        example"));
    }
}
