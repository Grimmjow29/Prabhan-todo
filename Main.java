package com.prabhan.todo;


import java.util.Scanner;



public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Select storage type (MySQL/MongoDB/PostgreSQL): ");
		String storageType = scanner.nextLine();

		TodoStorage storage = StorageFactory.getStorage(storageType);
		TodoService service = new TodoService(storage);

		boolean running = true;
		while (running) {
			System.out.println("\n1. Create TODO");
			System.out.println("2. Retrieve TODO by ID");
			System.out.println("3. Retrieve All TODOs");
			System.out.println("4. Update TODO");
			System.out.println("5. Delete TODO by ID");
			System.out.println("6. Exit");
			System.out.print("Enter choice: ");

			int choice = scanner.nextInt();
			scanner.nextLine(); // Consume newline

			switch (choice) {
				case 1:
					Todo todo = new Todo();
					System.out.print("Enter ID: ");
					todo.setId(scanner.nextLine());
					System.out.print("Enter title: ");
					todo.setTitle(scanner.nextLine());
					System.out.print("Enter description: ");
					todo.setDescription(scanner.nextLine());
					todo.setCompleted(false);
					service.create(todo);
					break;
				case 2:
					System.out.print("Enter ID: ");
					Todo retrievedTodo = service.retrieve(scanner.nextLine());
					System.out.println(retrievedTodo != null ? retrievedTodo : "TODO not found.");
					break;
				case 3:
					service.retrieveAll().forEach(System.out::println);
					break;
				case 4:
					System.out.print("Enter ID: ");
					Todo updateTodo = service.retrieve(scanner.nextLine());
					if (updateTodo != null) {
						System.out.print("Enter new title: ");
						updateTodo.setTitle(scanner.nextLine());
						System.out.print("Enter new description: ");
						updateTodo.setDescription(scanner.nextLine());
						System.out.print("Is completed? (true/false): ");
						updateTodo.setCompleted(scanner.nextBoolean());
						service.update(updateTodo);
					} else {
						System.out.println("TODO not found.");
					}
					break;
				case 5:
					System.out.print("Enter ID: ");
					service.delete(scanner.nextLine());
					break;
				case 6:
					running = false;
					break;
				default:
					System.out.println("Invalid choice.");
			}
		}

		scanner.close();
	}
}

