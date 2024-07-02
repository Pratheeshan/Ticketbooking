import java.lang.reflect.Method;
import java.lang.reflect.Field;
import java.lang.reflect.Constructor;

public class ReflectionUtils {

    public static void printClassDetails(Class<?> clazz) {
        System.out.println("Class Name: " + clazz.getName());
        System.out.println("Fields:");
        for (Field field : clazz.getDeclaredFields()) {
            System.out.println("  " + field.getName() + " : " + field.getType().getName());
        }
        System.out.println("Methods:");
        for (Method method : clazz.getDeclaredMethods()) {
            System.out.println("  " + method.getName());
        }
        System.out.println("Constructors:");
        for (Constructor<?> constructor : clazz.getDeclaredConstructors()) {
            System.out.println("  " + constructor.getName());
        }
    }

    public static Object invokeStaticMethod(Class<?> clazz, String methodName, Class<?>[] parameterTypes, Object[] args) throws Exception {
        Method method = clazz.getDeclaredMethod(methodName, parameterTypes);
        method.setAccessible(true);  // Ensure we can access private methods
        return method.invoke(null, args);
    }
}
