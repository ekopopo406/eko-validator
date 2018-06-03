package customclassloader;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Collection;

public class ProxyTest {

	public static void main(String[] args) {
		Class clazzProxy1 = Proxy.getProxyClass(Collection.class.getClassLoader(), Collection.class);
		System.out.println(clazzProxy1.getName());
		System.out.println(clazzProxy1.getConstructors());
		System.out.println("-------------------------constructor list");
		Constructor[] cons = clazzProxy1.getConstructors();
		for(Constructor temp:cons){
//			System.out.println(temp.getDeclaringClass());
//			System.out.println(temp.getName());
			String name = temp.getName();
			StringBuilder sb = new StringBuilder(name);
			sb.append("(");
			Class[] classParameers = temp.getParameterTypes();
			for(Class tempParamers:classParameers){
				sb.append(tempParamers.getName()).append(",");
				
			}
			if(classParameers!=null&&classParameers.length!=0){
				sb.deleteCharAt(sb.length()-1);
				sb.append(")");
			}
			System.out.println(sb.toString());
		}
		
		Method[] methods = clazzProxy1.getMethods();
		for(Method temp:methods){
//			System.out.println(temp.getDeclaringClass());
//			System.out.println(temp.getName());
			String name = temp.getName();
			StringBuilder sb = new StringBuilder(name);
			sb.append("(");
			Class[] methodParameers = temp.getParameterTypes();
			for(Class tempParamers:methodParameers){
				sb.append(tempParamers.getName()).append(",");
				
			}
			if(methodParameers!=null&&methodParameers.length!=0){
				sb.deleteCharAt(sb.length()-1);
				sb.append(")");
			}else{
				sb.append(")");
			}
			System.out.println(sb.toString());
		}
	}

}
