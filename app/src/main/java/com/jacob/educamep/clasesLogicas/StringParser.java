package com.jacob.educamep.clasesLogicas;

import java.io.Serializable;
import java.util.ArrayList;

public class StringParser implements Serializable {
    public ArrayList<String[]> convert (String line){
        ArrayList<String[]> list = new ArrayList<String[]>();
        if (!line.equals("")){
            String[] rows = line.split("#", 0);
            for (int i=0; i<rows.length; i++){
                String[] row = rows[i].split(";", 0);
                list.add(row);
            }
        }
        return list;
    }
}
