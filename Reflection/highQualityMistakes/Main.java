package reflection.highQualityMistakes;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {

        Class<Reflection> reflectionClass = Reflection.class;
        Field[] fields = reflectionClass.getDeclaredFields();

        Arrays.stream(fields).filter(field -> !Modifier.isPrivate(field.getModifiers()))
                .sorted(Comparator.comparing(Field::getName)).forEach(field ->
                        System.out.println(field.getName() + " must be private!"));


        Method[] declaredMethods = reflectionClass.getDeclaredMethods();

        Arrays.stream(declaredMethods).filter(method -> method.getName().startsWith("get") &&
                        !Modifier.isPublic(method.getModifiers())).sorted(Comparator.comparing(Method::getName))
                .forEach(method -> System.out.println(method.getName() + " have to be public!"));

        Arrays.stream(declaredMethods).filter(method -> method.getName().startsWith("set") &&
                        !Modifier.isPrivate(method.getModifiers())).sorted(Comparator.comparing(Method::getName))
                .forEach(method -> System.out.println(method.getName() + " have to be private!"));


    }
}
