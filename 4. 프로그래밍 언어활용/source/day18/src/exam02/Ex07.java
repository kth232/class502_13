package exam02;

import java.text.MessageFormat;
import java.text.ParseException;

public class Ex07 {
    public static void main(String[] args) throws ParseException {
        String str = "name: lee, call: 010-0000-0000";
        String pattern = "name: {0}, call: {1}";
        MessageFormat mf = new MessageFormat(pattern);
        Object[] data = mf.parse(str); //다양한 형태의 자료형이 올 수 있기 때문에 Object형
        String name = (String)data[0];
        String mobile = (String)data[1];
        System.out.println(name);
        System.out.println(mobile);
    }
}
