package exam02;

public class Ex04 {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer(100); //100byte(충분히 큰 크기)로 버퍼(배열) 정의
        sb.append("ABC");
        System.out.printf("sb adress: %d%n", System.identityHashCode(sb));

        sb.append("DEF"); //하나의 객체에 문자열 추가
        System.out.printf("sb adress: %d%n", System.identityHashCode(sb));

        sb.append("GHI"); //반환값 타입: stringbuffer->자기 자신을 반환(this)->메서드 체이닝
        System.out.printf("sb: %s, adress: %d%n",sb, System.identityHashCode(sb));
        
        String str = sb.toString();// 버퍼에서 문자열 꺼낼 때 주소 바뀜
        System.out.printf("str: %s, adress: %d%n",str, System.identityHashCode(str));
    }
}
