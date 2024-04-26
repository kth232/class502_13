package exam02;

import exam02.MyAnno;

import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.util.Arrays;

public class Ex03 {
    public static void main(String[] args) {
        Class cls = Ex02.class;

        MyAnno anno = (MyAnno)cls.getAnnotation(MyAnno.class);
        int min = anno.min();
        int max = anno.max();

        System.out.printf("min=%d, max=%d%n", min, max);

        String[] names = anno.names();
        System.out.println(Arrays.toString(names));

        String[] value = anno.names();
        System.out.println(value);
    }
}