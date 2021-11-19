package reflection.blackBoxInteger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Scanner scan = new Scanner(System.in);
        Class<BlackBoxInt> boxIntClass = BlackBoxInt.class;
        Constructor<BlackBoxInt> constructor = boxIntClass.getDeclaredConstructor();
        constructor.setAccessible(true);
        BlackBoxInt blackBoxInt = constructor.newInstance();

        Field innerValue = boxIntClass.getDeclaredField("innerValue");
        innerValue.setAccessible(true);

        String input = scan.nextLine();

        while (!input.equals("END")) {
            String[] line = input.split("_");
            String command = line[0];
            int value = Integer.parseInt(line[1]);

            Method method = boxIntClass.getDeclaredMethod(command, int.class);
            method.setAccessible(true);
            method.invoke(blackBoxInt, value);

            System.out.println(innerValue.get(blackBoxInt));
            input = scan.nextLine();
        }

    }
}
