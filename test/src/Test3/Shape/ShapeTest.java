package Test3.Shape;

import java.util.ArrayList;

public class ShapeTest {
    public static void main(String[] args) {
        ArrayList<Shape> list = new ArrayList<Shape>(); //shape로 배열 자료형 지정
        list.add(new Circle()); //ArrayList의 add 속성으로 객체 배열에 추가, shape형으로 형변환
        list.add(new Triangle());
        list.add(new Shape());

        for(Shape s : list){ //for(자료형 변수(찾은 값 저장): 배열명)->처음부터 끝까지 반복, 수정 불가
            s.draw(); //배열 요소를 shape로 꺼내서 draw() 호출->재정의된 함수 호출됨
        }
    }
}