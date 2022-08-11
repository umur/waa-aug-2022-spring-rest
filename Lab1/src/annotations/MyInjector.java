
package annotations;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.reflections.Reflections;
import exceptions.BeanNotFoundException;

@MyBean
public class MyInjector {
	Map<String, Object> ioc = new HashMap<String, Object>();
	
	
	public <T> T getInstance(Class<T> clazz) throws Exception {
        Constructor<?> constructor = clazz.getConstructor();
        T object = (T)constructor.newInstance();

        Field[] declaredFields = clazz.getDeclaredFields();
        injectAnnotatedFields(object, declaredFields);

        return object;
    }
	
	
	private <T> void injectAnnotatedFields(T object, Field[] declaredFields) throws Exception {
        for (Field field : declaredFields) {
            if (field.isAnnotationPresent(MyAutowired.class)) {
                field.setAccessible(true);
                Class<?> type = field.getType();
                Object innerObject = type.getDeclaredConstructor().newInstance();

                field.set(object, innerObject);
                injectAnnotatedFields(innerObject, type.getDeclaredFields());
    			ioc.put(type.getName(), innerObject);

            }
        }
    }

	private void scanAll() throws Exception {

		Set<Class<?>> classess = new Reflections().getTypesAnnotatedWith(MyAutowired.class);

		for (Class<?> clazz : classess) {
			ioc.put(clazz.getName(), getInstance(clazz));
			for (Method method : clazz.getDeclaredMethods()) {
				if (method.isAnnotationPresent(MyAutowired.class)) {
					method.setAccessible(true);
					method.invoke(clazz);
				}

			}
		}
	}

	Object getBean(Class<?> clazz) throws BeanNotFoundException {
		Object obj = ioc.get(clazz.getName());
		if (obj == null) {
			throw new BeanNotFoundException("BeanNotFoundException");
		}
		return obj;

	}

}
