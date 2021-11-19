package reflection.reflections;

import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        Class<?> reflectionClass = Reflection.class;

        System.out.println("class " + reflectionClass.getSimpleName());

        Class<?> superClass = reflectionClass.getSuperclass();
        System.out.println(superClass);

        Class<?>[] interfaces = reflectionClass.getInterfaces();

        for (Class<?> anInterface : interfaces) {
            System.out.println(anInterface);
        }
        Object instance = reflectionClass.getDeclaredConstructor().newInstance();
        System.out.println(instance);
    }
}
