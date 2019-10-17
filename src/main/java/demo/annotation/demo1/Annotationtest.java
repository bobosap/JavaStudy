package demo.annotation.demo1;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static java.lang.Class.forName;

public class Annotationtest {
    public Annotationtest() {
        try {
            Class<?> clz = Class.forName("demo.annotation.demo1.bobo");
//            //获取方法
//            Method[] methods = clz.getMethods();
//            for (Method m1:methods
//            ) {
//                System.out.println(m1.toString());
//            }
            //获取私有字段
            Field[] deprecateds = clz.getDeclaredFields();
            for (Field depf:deprecateds
                 ) {
                System.out.println(depf.toString());
            }


            //获取字段
            Field[] fields = clz.getFields();
            for (Field f:fields
                 ) {
                System.out.println(f.toString());

            }

            Method method = clz.getMethod("sing");
            System.out.println(method.toString());

            Object sing = method.invoke(clz.newInstance());

            bobo bo1 = (bobo) clz.newInstance();
            Method method1 = clz.getMethod("setName", String.class);

            Object name = method1.invoke(bo1,"bobo1");
            System.out.println(name);

//            Constructor constructor = (Constructor) clz.getConstructor().newInstance();

            //获取注解
//            Annotation[] annotations = method.getAnnotations();
//            for (Annotation ano:annotations
//                 ) {
//                System.out.println(ano.toString());
//            }

            ztest annotation = method.getAnnotation(ztest.class);
            System.out.println(annotation.toString());
            System.out.println(annotation.age()+annotation.name());




        } catch (ClassNotFoundException | NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {

        Annotationtest annotationtest = new Annotationtest();
    }



}
