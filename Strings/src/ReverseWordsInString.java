import java.util.Stack;

class ReverseWordsInString {
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
        while(i<ar.length && ar[i]==' '){
            i++;
        }
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


    public static void main(String[] args) {
        System.out.println(reverseWords("a good   example"));
    }
}