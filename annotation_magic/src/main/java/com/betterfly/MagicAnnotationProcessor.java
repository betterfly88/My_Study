package com.betterfly;

import com.google.auto.service.AutoService;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

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
import java.lang.reflect.Type;
import java.util.Set;

/*
    Service Provider Interface
 */
@EnableAutoConfiguration(exclude = JavaFile.class)
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
            MethodSpec pullOut = MethodSpec.methodBuilder("pullOut")
                    .addModifiers(Modifier.PUBLIC)
                    .returns(String.class)
                    .addStatement("return $S", "Rabbit")
                    .build();

            TypeSpec mojaFactory = TypeSpec.classBuilder("MojaFactory")
                    .addModifiers(Modifier.PUBLIC)
                    .addMethod(pullOut)
                    .build();

            // Filer interface : 소스콛, 클래스 코드 및 리소스를 생성할 수 있는 인터페이스
            Filer filer = processingEnv.getFiler();

            TypeElement typeElement = (TypeElement)e;
            ClassName className = ClassName.get(typeElement);

            try {
                JavaFile.builder(className.packageName(), mojaFactory).build().writeTo(filer);
            } catch (IOException ioException) {
                processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR, "FATAL ERROR" + e);
            }
        }
        return true; // 처리 후 다른곳에 넘겨주고 싶은 경우 false, 여기서만 끝낼거면 true
    }
}
