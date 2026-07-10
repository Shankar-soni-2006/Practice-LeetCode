class Solution {
    public String interpret(String cmd) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while(i < cmd.length()){
            if(cmd.charAt(i) == 'G'){
                sb.append(cmd.charAt(i));
                i+=1;
            } 
            else if(cmd.charAt(i) == '(' && cmd.charAt(i+1) == ')'){
                sb.append("o");
                i+=2;
            }else{
                sb.append("al");
                i+=4;
            }
        }
        return sb.toString();
    }
}