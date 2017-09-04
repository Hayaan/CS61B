public class Dog {
	private int age;
	private String name;
	
	public Dog(int age, String name) {
			this.name = name;
			this.age = age;
	}
	public String toString() {
		return this.name + " is " + this.age + " years old."; 
	}	
}
