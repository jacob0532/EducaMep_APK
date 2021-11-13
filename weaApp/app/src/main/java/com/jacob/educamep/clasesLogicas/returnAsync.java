package com.jacob.educamep.clasesLogicas;

import java.util.ArrayList;

public class returnAsync {
    public String result = "";
    public ArrayList<String[]> result2 = null;

    public returnAsync(String result, ArrayList<String[]> result2){
        this.result = result;
        this.result2 = result2;
    }
    public returnAsync(String result){
        this.result = result;
    }
}
