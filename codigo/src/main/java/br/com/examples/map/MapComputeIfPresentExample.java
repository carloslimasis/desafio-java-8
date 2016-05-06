package br.com.examples.map;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import br.com.examples.ExampleUtil;
import br.com.examples.builder.UserListBuilder;
import br.com.examples.model.User;

public class MapComputeIfPresentExample {

	public static void main(String[] args) {
		
		final List<User> users = UserListBuilder.builder().createListUsers();
		final Map<String, Integer> usersByName = users.stream().collect(Collectors.toMap(User::getName, (u) -> u.getPoints()));
		
		usersByName.forEach((name, points) -> ExampleUtil.printUser(name, points));
		
		ExampleUtil.printBlankLine();
		System.out.println(usersByName.computeIfPresent("Carlos", (name, points) -> points + 2));
		System.out.println(usersByName.computeIfPresent("Novo Usuário", (name, points) -> 200));
		usersByName.forEach((name, points) -> ExampleUtil.printUser(name, points));

		ExampleUtil.printBlankLine();
		System.out.println(usersByName.computeIfPresent("Carlos", (name, points) -> null));
		usersByName.forEach((name, points) -> ExampleUtil.printUser(name, points));
	}
	
}
