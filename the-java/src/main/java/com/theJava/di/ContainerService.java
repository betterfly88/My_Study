package com.theJava.di;

import java.util.Arrays;

public class ContainerService {

    // 어떤 타입의 클래스가 들어오면, 그 클래스의 인스턴스를 리턴하는 방법
    public static<T> T getObject(Class<T> classType) {
        T instance = createInstance(classType);

        Arrays.stream(classType.getDeclaredFields())
                .filter(f -> f.getAnnotation(Inject.class) != null)
                .forEach(annotation ->{
                    Object fieldObject = createInstance(annotation.getType());
                    annotation.setAccessible(true);
                    try{
                        annotation.set(instance, fieldObject);
                    }catch (IllegalAccessException e){
                        throw new RuntimeException(e);
                    }
                });


        return instance;
    }

    private static <T> T createInstance(Class<T> classType){
        try {
            return classType.getConstructor(null).newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
