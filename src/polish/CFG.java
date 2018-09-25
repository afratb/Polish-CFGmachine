package polish;

import java.util.ArrayList;

public class CFG {
    private String alfabe;
    private String terminal;
    ArrayList<String> alf = new ArrayList<String>();
    ArrayList<String> S = new ArrayList<String>();
    ArrayList<String> X = new ArrayList<String>();
    ArrayList<String> Kelimeler = new ArrayList<String>();
    CFG(String alf,String term){
        alfabe = alf;
        terminal = term;
    }
    
    public ArrayList<String> cfg_start(){
        for (int i = 0; i < alfabe.length(); i++) {
	    if (alfabe.charAt(i) != ',') {
		alf.add(String.valueOf(alfabe.charAt(i)));
	    }
	}
        String str="";
        for (int j = 0; j < terminal.length(); j++){
            if(terminal.charAt(j)=='S'){
                if(terminal.charAt(j+1)=='-' && terminal.charAt(j+3)=='>'){
                    for (int k = j+4 ; k < terminal.length(); k++){
                        if(terminal.charAt(k)==','){
                            S.add(str);
                            str = "";
                            j=k;
                            break;
                        }
                        else if(terminal.charAt(k)=='|'){
                            S.add(str);
                            str = "";
                            continue;
                        }
                        else{
                            str += String.valueOf(terminal.charAt(k));
                            continue;
                        }
                    }
                    }
                }
            else if(terminal.charAt(j)=='X'){
                if(terminal.charAt(j+1)=='-' && terminal.charAt(j+3)=='>'){
                    for (int k = j+4 ; k < terminal.length(); k++){
                        if(terminal.charAt(k)==','){
                            X.add(str);
                            str = "";
                            j=k;
                            break;
                        }
                        else if(terminal.charAt(k)=='|'){
                            X.add(str);
                            str = "";
                            continue;
                        }
                        else{
                            str += String.valueOf(terminal.charAt(k));
                            continue;
                        }
                    }
                    X.add(str);
                    break;
                    }
                }
        }
        String kelime="";
        for ( int i = 0; i < S.size(); i++ ){
            if (S.get(i).indexOf("X")==-1){
                Kelimeler.add(S.get(i));
            }
            else{
                Ekle(S.get(i));
            }
        }
        return Kelimeler;
    }
    
    public void Ekle(String x){
        String temp = "";
        for(int i=0;i<x.length();i++){
            if(x.charAt(i)=='X'){
                for(int j=0;j<X.size();j++){
                    String str = temp;
                    str += X.get(j);
                    if((i+1)==x.length()){
                        Kelimeler.add(str);
                    }
                    else{
                        for(int k=i+1;k<x.length();k++){
                            str += x.charAt(k);
                            if(x.charAt(k)=='X'){
                                Ekle(str);
                                break;
                            }
                            else{
                                Kelimeler.add(str);
                                break;
                            }
                        }
                    }
                }
                return;
            }
            else{
                temp += x.charAt(i);
            }
        }
    }
}
