package com.betterfly;

import com.google.auto.service.AutoService;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;
import java.io.IOException;
import java.util.Set;

/*
    Service Provider Interface
 */
@AutoService(Processor.class)
public class MagicAnnotationProcessor extends AbstractProcessor {
    @Override
    public Set<String> getSupportedAnnotationTypes() {
        return Set.of(Magic.class.getName()); // method element
    }


    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latestSupported(); // jvm 소스버전
    }


    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        Set<? extends Element> elementsAnnotatedWith = roundEnv.getElementsAnnotatedWith(Magic.class);
        for( Element e : elementsAnnotatedWith){
            if(e.getKind() != ElementKind.INTERFACE){
                processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR, "Magic annotation cant not be casted." + e.getSimpleName());
            }else{
                processingEnv.getMessager().printMessage(Diagnostic.Kind.NOTE, "Processing " + e.getSimpleName());
            }


            // source code를 객체화하는 작업
            TypeElement typeElement = (TypeElement)e;
            ClassName className = ClassName.get(typeElement);

            // 메서드 생성
            MethodSpec pullOut = MethodSpec.methodBuilder("pullOut") // 메서드명
                    .addModifiers(Modifier.PUBLIC)                   // 접근제어자 설정
                    .returns(String.class)                           // 리턴 타입
                    .addStatement("return $S", "Rabbit")             // 상태 정의
                    .build();

            // 클래스 생성
            TypeSpec mojaFactory = TypeSpec.classBuilder("MojaFactory") // 클래스명(풀패키지명이 아닌 SimpleClass명)
                    .addModifiers(Modifier.PUBLIC)                      // 접근 제어자
                    .addSuperinterface(className)                       // 구현하고자하는 인터페이스
                    .addMethod(pullOut)                                 // 클래스에 포함할 메서드 추가
                    .build();

            // Filer interface : 소스 코드, 클래스 코드 및 리소스를 생성할 수 있는 인터페이스
            // 위에 생성한 메서드와 클래스를 담는 실질적인 파일화 작업
            Filer filer = processingEnv.getFiler();

            try {
                // javapoet을 이용한 java file 만들기
                JavaFile.builder(className.packageName(), mojaFactory).build().writeTo(filer);
            } catch (IOException ioException) {
                processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR, "FATAL ERROR" + e);
            }
        }
        return true; // 처리 후 다른곳에 넘겨주고 싶은 경우 false, 여기서만 끝낼거면 true
    }
}
