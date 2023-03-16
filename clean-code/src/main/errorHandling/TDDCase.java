package main.errorHandling;

import java.security.InvalidParameterException;
import java.util.List;

public class TDDCase {

    private String[] str ={"A","B","C","D","E"};

    public String indexOf(int index) {

        try {
            String Section=str[index];

        }catch (Exception e){
            throw new InvalidParameterException("retrieval error");
        }
        return "";


    }
}
