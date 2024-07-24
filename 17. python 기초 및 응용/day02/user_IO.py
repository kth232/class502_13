#사용자 입출력
'''
a = input("숫자를 입력하세요: ") #무엇을 입력해야할지 모른다..->안내 문구 입력
print(a) #입력받은 값은 문자열!
type(a)

#파이썬은 같은 자료형이 아니면 무조건 오류 발생함/자바는 숫자가 문자열로 바뀐 후 문자열 결합됨
b = a + str(100) #변환 함수로 자료형 맞춰줘야 함
print(b) #문자열 결합

c = int(a) + 100
print(c) #숫자 계산
'''

#큰따옴표로 둘러싸인 문자열은 +연산과 동일
print('aa' 'bb' 'cc')
print('aa' + 'bb' + 'cc')

#콤마=띄어쓰기
print('aa', 'bb', 'cc')

chars = ['a', 'b', 'c', 'd', 'e']

for char in chars:
    #print(char) #end 매개변수가 있어 출력마다 줄 개행하는 것이 기본값
    print(char, end=' ') #출력마다 한 칸 띄우는 것으로 변경