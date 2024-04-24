package exam02;

public class Ex05 {
    public static void main(String[] args) {
        StringBuffer sb= new StringBuffer(100);
        String str=sb.append("ABC").append("DEF").append("GHI").toString(); //메서드 체이닝, 작업을 이어서 할 수 있음
        System.out.println(str);
        /*
        StringBuffer sb2 = sb.append("ABC"); //자기 자신을 반환(this)
        StringBuffer sb3 = sb2.append("DEF"); //stringbuffer 객체

        System.out.println(sb==sb2); //true->동일한 객체
        */
    }
}
