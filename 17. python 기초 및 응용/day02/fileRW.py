#파일 읽기, 쓰기
f=open("D:/태현/17. python 기초 및 응용/day02/test.txt", "w") #열기
for i in range(10):
    f.write("%d행 입력\n" % (i+1)) #작성ㄴ

f.close() #닫기