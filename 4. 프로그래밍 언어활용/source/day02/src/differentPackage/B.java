package differentPackage;

import samePackage.A;

public class B extends A { //b가 a를 상속받음
    void print() {
        protectedNum=100;
        System.out.println(protectedNum);
    }
}
