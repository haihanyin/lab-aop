package com.github.hh.labaop.nca;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.LoaderClassPath;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

public class NullCheckTransformer implements ClassFileTransformer {
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined,
                            ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
        final String replacedClassName = className.replace('/', '.');
        if (replacedClassName.startsWith("p.hh.topics.tryagent")) {
            ClassPool pool = new ClassPool();
            LoaderClassPath loaderClassPath = new LoaderClassPath(loader);
            pool.insertClassPath(loaderClassPath);
            try {
                CtClass ctClass = pool.get(replacedClassName);
                final CtMethod[] declaredMethods = ctClass.getDeclaredMethods();
                for (CtMethod declaredMethod : declaredMethods) {
                    System.out.println("Transform method " + declaredMethod.getLongName());
                    declaredMethod.insertBefore("for(int i=0; i<$args.length; i++) { " +
                            "if($args[i]==null) throw new NullPointerException" +
                            "(\"Don't give me a null object for parameter \" + i); " +
                            "}");
                }
                return ctClass.toBytecode();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
