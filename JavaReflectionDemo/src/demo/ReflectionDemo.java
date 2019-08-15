package demo;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionDemo {

	public static void main(String[] args) throws Exception{
		
		Class studentClass = Class.forName("demo.Student");
		System.out.println("\"" + studentClass.getName() +"\"" );
		System.out.println("---------------------------------------");
		System.out.println("isInterface :" + studentClass.isInterface());
		System.out.println("Superclass: " + studentClass.getSuperclass());
				
		Student student = (Student) studentClass.newInstance();
		
		System.out.println("Invoke a private method:");
		Method m = studentClass.getDeclaredMethod("bark", null);
		m.setAccessible(true);
		m.invoke(student, null);
		
		System.out.println("Declared fields:");
		Field[] declaredFields = studentClass.getDeclaredFields();
		for(Field f : declaredFields) {
			System.out.println(f.getName());
		}
		
	}

}
