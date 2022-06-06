package com.exapmle;

import javassist.*;
import javassist.bytecode.FieldInfo;

import java.io.IOException;
import java.util.List;

public class TestMain {

    public static void main(String[] args) {
        ClassPool classPool = ClassPool.getDefault();
        classPool.appendClassPath(new ClassClassPath(TestMain.class));
        try {
            CtClass ctClass = classPool.get("com.exapmle.TestBean");
            CtField appKeyField = ctClass.getDeclaredField("appKey");
            CtConstructor constructor = ctClass.getConstructor("()V");
            constructor.insertBeforeBody("this.appKey = \"123qweasd\";\nInteger i = new Integer(2);\nfloat f = 0.5f;");
            ctClass.writeFile("");
        } catch (NotFoundException | CannotCompileException | IOException e) {
            e.printStackTrace();
        }
        TestBean testBean = new TestBean();
        System.out.println("test bean " + testBean);
    }
}
