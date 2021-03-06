/**
 * 
 */
package example.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
public class CglibServiceInterceptor implements MethodInterceptor
{

	@SuppressWarnings("unchecked")
	public <T> T createObject(T t)
	{

		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(t.getClass());
		enhancer.setCallback(this);
		return (T) enhancer.create();
	}

	/**
	 * @see net.sf.cglib.proxy.MethodInterceptor#intercept(Object,
	 *      Method, Object[],
	 *      net.sf.cglib.proxy.MethodProxy)
	 */
	@Override
	public Object intercept(Object obj, Method method, Object[] args,
			MethodProxy proxy) throws Throwable
	{
		System.out.println("before...");
		Object returnObj = proxy.invokeSuper(obj, args);
		System.out.println("after...");
		return returnObj;
	}

}
