package common.common.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;  
  
  
public class ReflectUtil {  
      
    /* 
     *  根据某个对象的名称和方法去执行该方法 
     *  
     */  
    public static void execute(Object object,String methodName) {
         
        Class clazz = object.getClass();   
        Method m1;  
        try {  
            m1 = clazz.getDeclaredMethod(methodName);  
            m1.invoke(object);   
        } catch (NoSuchMethodException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        } catch (IllegalAccessException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        } catch (IllegalArgumentException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        } catch (InvocationTargetException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }    
      
    }  
      
}