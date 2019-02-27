package com.betterfly;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import sun.plugin.viewer.LifeCycleManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by betterfly
 * Date : 2019.02.26
 */
public class SpringApplication {
    public static void main(String[] args) throws LifecycleException {
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);

        Context context = tomcat.addContext("/", "/");

        HttpServlet servlet = new HttpServlet() {
            @Override
            protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                PrintWriter pw = resp.getWriter();
                pw.println("<html><head><title>");
                pw.println("Spring boot Tomcat Server");
                pw.println("</title></head>");
                pw.println("<body> Hello betterFLY </body>");
                pw.println("</html>");
            }
        };

        String servletName = "helloServlet";
        tomcat.addServlet("/", servletName, servlet);
        context.addServletMappingDecoded("/hello", servletName);

        tomcat.start();
        tomcat.getServer().await();

        // 이렇게 톰캣을 생성해주는 것이 바로
        //autoconfigure.spring.factories > org.springframework.boot.autoconfigure.web.servlet.ServletWebServerFactoryAutoConfiguration,\
        // 위 객체를 타고 가다보면 tomcat 을 생성하고 세팅을 해주는 것을 볼 수 있음 (스샷 참고)

        // 그 후 servlet 환경을 구성해야하는데
        // 우리가 일반적으로 스프링프레임워크에서 익숙한 dispatcher-servlet이 바로 그 것
//        org.springframework.boot.autoconfigure.web.servlet.DispatcherServletAutoConfiguration,\
        // 이 클래스에서 dispatcher servlet이 만들어지는데, 이것이 결국 httpServlet 을 상속해서 만든 SpringMVC의 핵심 클래스
        //
        // 결국 스프링부트는
        // ServletWebServerFactoryAutoConfiguration (서블릿 웹 서버 생성)
        // .DispatcherServletAutoConfiguration (서블릿 만들고 등록)
        // 위와 같은 작업을 통해 웹서버가 동작한다는 개념을 가지고 갈 것.

    }
}
