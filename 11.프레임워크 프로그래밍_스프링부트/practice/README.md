## JPA_TEST
### 502_강태현

### 3조 평가 기준
1. TDD(테스트 주도 개발)이 이루어졌는가?
2. 의존성 주입이 제대로 되었는가?
3. DB 연결이 가능한가?
<br>  

* TDD 결과  
  - 코드 참고  
<br>
  - 
* 의존성 주입
  - 코드 참고
<br>  

- DB 연결
  1. DB 스키마 생성  
    ![스키마 생성](https://github.com/user-attachments/assets/3d0fa9d9-b4d5-4938-8b78-6b7755148a6f)  


  2. 디비버 연결  
    ![디비버 연결](https://github.com/user-attachments/assets/e1242513-11b8-41be-8b4d-f669b30763d9)  
    

  3. 환경 변수 설정  
    ![환경변수 설정](https://github.com/user-attachments/assets/33777356-778a-4802-b904-061f6657ec39)

```mermaid
classDiagram
    class Member {
        -LocalDateTime createdAt
        -LocalDateTime modifieddAt
        -Long seq
        -String email
        -String password
        -String userName
        -Authority authority
        -List~BoardData~ items
    }
    
    class BoardData {
        -LocalDateTime createdAt
        -LocalDateTime modifieddAt
        -Long seq
        -subject
        -content
        -mSeq
    }
    
    Member "1" --> "0..n" BoardData
    %%일대다 관계
    
    Member <|..|> BoardData
    %%연관관계
```
