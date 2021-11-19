package reflection.harvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String command = scan.nextLine();

		Class<RichSoilLand> richSoilLandClass = RichSoilLand.class;
		Field[] declaredFields = richSoilLandClass.getDeclaredFields();

		while (!command.equals("HARVEST")) {


			switch (command) {
				case "private":
					Arrays.stream(declaredFields)
							.filter(f -> Modifier.isPrivate(f.getModifiers()))
							.forEach(n -> System.out.println("private " + n.getType().getSimpleName() + " " + n.getName()));
					break;
				case "protected":
					Arrays.stream(declaredFields)
							.filter(f -> Modifier.isProtected(f.getModifiers()))
							.forEach(n -> System.out.println("protected " + n.getType().getSimpleName() + " " + n.getName()));
					break;
				case "public":
					Arrays.stream(declaredFields)
							.filter(f -> Modifier.isPublic(f.getModifiers()))
							.forEach(n -> System.out.println("public " + n.getType().getSimpleName() + " " + n.getName()));
					break;
				case "all":
					for (Field field : declaredFields) {

						if (field.getModifiers() == Modifier.PUBLIC) {
							System.out.println("public " + field.getType().getSimpleName() + " " + field.getName());

						} else if (field.getModifiers() == Modifier.PRIVATE) {
							System.out.println("private " + field.getType().getSimpleName() + " " + field.getName());

						} else if (field.getModifiers() == Modifier.PROTECTED) {
							System.out.println("protected " + field.getType().getSimpleName() + " " + field.getName());
						}
					}

					break;

			}
			command = scan.nextLine();

		}

	}
}
