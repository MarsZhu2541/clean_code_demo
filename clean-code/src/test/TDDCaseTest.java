package test;

import main.errorHandling.TDDCase;
import org.junit.Test;

import java.security.InvalidParameterException;
import java.util.Map;
import java.util.TreeMap;

public class TDDCaseTest {

    private Map<String, String> headerAttributes;

    @Test(expected = InvalidParameterException.class)
    public void indexOfshouldThrowOnIndexOutOfBounds(){
        new TDDCase().indexOf(5);
    }

    @Test
    public void test1(){
        headerAttributes = new TreeMap<>((o1, o2) -> {
            if("X-Dummy".equals(o1)){
                return -1;
            }
            return 1;
        });

        headerAttributes.put("a","1");

        headerAttributes.put("X-Dummy","1");
        headerAttributes.put("b","2");
        headerAttributes.put("z","1");
        headerAttributes.put("c","1");

        headerAttributes.forEach((k,v)->{
            System.out.println("key:"+k);
            System.out.println("value:"+v);
        });
    }


}
