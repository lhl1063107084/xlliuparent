package com.xlliu.controller;

import com.xlliu.config.AppConfigBean;
import com.xlliu.po.Student;
import com.xlliu.service.spring.beanpostprocess.applicationaware.StaticService;
import com.xlliu.service.spring.beanpostprocess.applicationaware.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

/**
 * @author liuxiaolun
 * @Description: 测试控制器
 * @date 2018-09-29 15:01:48
 **/
@RestController
@RequestMapping("/xlliu/test")
public class TestController {
    @Autowired
    TestService testService;
    @Autowired
    AppConfigBean appConfigBean;
//    @ApolloConfig
//    private Config config;

    @PostMapping("/get")
    public String test(@RequestBody String paramStr) {
        return testService.printStr(paramStr);
    }

    @PostMapping("/get/context")
    public String testContext() {
        String test = StaticService.test();
        return test;
    }

    @PostMapping("/refresh/scope")
    public void testRefreshScope() {
        System.out.println(appConfigBean);
    }


    public static void main(String a[]) throws Exception {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = documentBuilderFactory.newDocumentBuilder();

        Document doc = builder.parse(new File("/Users/g2/Documents/project/xlliuparent/xlliuweb/src/main/resources/config.xml"));
        NodeList nodeList = doc.getElementsByTagName("Type");
        Node firstChild = nodeList.item(0).getFirstChild();
        String value = firstChild.getNodeValue();

        System.out.println(value);


        Student student = new Student();
        student.setMarry("123");


    }
}
