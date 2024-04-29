package exam04;

import java.util.ArrayList;

public class Ex01 {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        names.add("name1");
        names.add("name2");
        names.add("name3");
        names.add("name4");
        names.add("name5");

        /*
        for(int i=0;i<names.size();i++){
            names.remove(i); // 2, 4번 요소는 안 지워짐->요소가 비워질 때마다 새로운 배열이 되기 때문
        }


        //System.out.println(names); //names.toString(); ->담긴 값을 확인할 수 있도록 재정의
        for(int i=0;i<names.size();i++){ //순서가 있는 배열 요소 출력 반복
            String name = names.get(i); //ArrayList 요소의 개수: size(), 요소 가져오기: get();
            System.out.println(name);
        }
        */

        for (int i = names.size() - 1; i >= 0; i--) {
            System.out.println(names);
            names.remove(i);
        }
    }
}
