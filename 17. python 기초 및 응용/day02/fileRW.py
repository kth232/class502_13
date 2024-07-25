#파일 읽기, 쓰기
#파일 쓰기
'''
f = open("D:/태현/17. python 기초 및 응용/day02/test.txt", "w") #파일 열기
for i in range(5):
    f.write("%d row write\n" % (i+1)) #작성, write()는 기존 데이터 지우고 그 위에 덮어씀


f.close() #파일 닫기
'''

#파일 읽기
'''
f = open("D:/태현/17. python 기초 및 응용/day02/test.txt", "r") #파일 열기
data = f.read() #읽어와서 변수에 담음
print(data)
f.close() #파일 닫기


while True:
    line = f.readline() #한줄씩 읽어오기
    if not line:
        break #다 읽어오면 반복 중단
    print(line) #print()의 매개변수 end도 줄개행 ->줄개행이 2번 적용됨


while True: #while문으로 출력 반복
    line = f.readline() #한줄씩 읽어오기
    if not line:
        break #다 읽어오면 반복 중단
    print(line.strip()) #strip(): 양쪽 공백 문자 제거
'''
'''
f = open("D:/태현/17. python 기초 및 응용/day02/test.txt", "r") #파일 열기
lines = f.readlines() #한줄씩 잘라서 리스트 형태로 모든 행 읽어옴

print(lines)
print(type(lines)) #리스트 타입

for line in lines: #for문으로 반복 출력
    print(line, end='')


for line in f: #파일 객체 바로 대입 가능
    print(line, end='')
'''
#기존 파일에 이어서 쓰기
'''
f = open("D:/태현/17. python 기초 및 응용/day02/test.txt", "a") #append, 기존 파일에 이어서 입력

for i in range(11, 16):
    f.write("%d row write\n" % i)

f.close() #실수로 안닫으면 엄청 많이 입력될 것..
'''
#with문과 함께 사용하면 자동으로 자원 해제
with open("D:/태현/17. python 기초 및 응용/day02/test.txt", "a") as f:
    f.write("the end")
