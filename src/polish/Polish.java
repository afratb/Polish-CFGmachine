package polish;

import java.util.Stack;

public class Polish {
    private String ifade;
    private Stack<String> stack = new Stack();
    Polish(String str){
        ifade = str;
    }
    
    public int Sonuc(){
        String[] dizi = ifade.split(" ");
        for(int i=0;i<dizi.length;i++){
            if((dizi[i].equals("+") || dizi[i].equals("-") || dizi[i].equals("/") || dizi[i].equals("*")) && stack.isEmpty()==false){
                int number1 = Integer.valueOf(stack.pop());
                int number2 = Integer.valueOf(stack.pop());
                int yeni = 0;
                switch(dizi[i]){
                    case "+" : {
                        yeni = number2 + number1 ;
                        stack.push(String.valueOf(yeni));
                        break;
                    }
                    case "*" : {
                        yeni = number2 * number1 ;
                        stack.push(String.valueOf(yeni));
                        break;
                    }
                    case "-" : {
                        yeni = number2 - number1 ;
                        stack.push(String.valueOf(yeni));
                        break;
                    }
                    case "/" : {
                        yeni = number2 / number1 ;
                        stack.push(String.valueOf(yeni));
                        break;
                    }
                }
            }
            else{
                stack.push(dizi[i].toString());
            }
            
        }
        int sonuc = Integer.valueOf(stack.pop());
        return sonuc;
    }
}
