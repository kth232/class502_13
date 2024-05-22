package member;

import java.time.LocalDateTime;

public class User {
    private String userId; //멤버 변수 선언
    private String userNm;
    private String email;
    private LocalDateTime regDt;

    private User() {} //생성자 접근 통제 private

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", userNm='" + userNm + '\'' +
                ", email='" + email + '\'' +
                ", regDt=" + regDt +
                '}';
    }

    public static class Builder {
        private User user = new User(); //빌더 클래스 내부에 객체 생성

        public Builder userId(String userId) { //메소드 체이닝 방식
            user.userId = userId; //이름을 동일하게 해주는 것이 관례
            return this; //자신의 객체 반환
        }
        public Builder userNm(String userNm) {
            user.userNm = userNm;
            return this;
        }
        public Builder email(String email) {
            user.email = email;
            return this;
        }
        public Builder regDt(LocalDateTime regDt) {
            user.regDt = regDt;
            return this;
        }
        public User build() { //완성된 객체 반환
            return user;
        }
    }
}
