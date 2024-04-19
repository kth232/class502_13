package exam03;

public class HighschoolStudent extends Student{
    public HighschoolStudent() {
        super(202401, "lee"); //객체 생성할 수 없을 때만 컴파일러가 매개변수 없는 기본 생성자 자동 추가
        //매개변수 추가해서 생성자 함수 호출
    }
    @Override
    public String toString() {
        return "HighschoolStudent{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
