package br.com.examples.map;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import br.com.examples.ExampleUtil;
import br.com.examples.builder.UserListBuilder;
import br.com.examples.model.User;

public class MapRemoveExample {

	public static void main(String[] args) {
		
		final List<User> users = UserListBuilder.builder().createListUsers();
		final Map<String, Integer> usersByName = users.stream().collect(Collectors.toMap(User::getName, (u) -> u.getPoints()));
		usersByName.forEach((name, points) -> ExampleUtil.printUser(name, points));
		
		usersByName.remove("Carlos");
		usersByName.remove("Maria", 20);
		usersByName.remove("Jose", 21);
		usersByName.remove("Jose");
		
		ExampleUtil.printBlankLine();
		usersByName.forEach((name, points) -> ExampleUtil.printUser(name, points));
		
		
		
	}
	
}
