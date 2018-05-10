package com.google.interview.questions;

import java.util.Date;
import java.util.LinkedList;

public class QueAnyCatsAndDogs {

	private class Animal {

		private String name;

		private Date arrivalTime;

		public Animal(String name, Date arrivalTime) {
			this.name = name;
			this.arrivalTime = arrivalTime;
		}
	}

	public class Cat extends Animal {
		public Cat(String name, Date arrivalTime) {
			super(name, arrivalTime);
		}

	}

	public class Dog extends Animal {
		public Dog(String name, Date arrivalTime) {
			super(name, arrivalTime);
		}
	}

	public class AnimalShelter {

		private LinkedList<Animal> cats;

		private LinkedList<Animal> dogs;

		public AnimalShelter() {
			cats = new LinkedList<>();
			dogs = new LinkedList<>();
		}

		public void enqueue(Animal animal) {
			//animal.arrivalTime = new Date();
			if (animal instanceof Cat) {
				System.out.print("Cat enqueued at ");
				cats.addLast(animal);
			} else if (animal instanceof Dog) {
				System.out.print("Dog enqueued at ");
				dogs.addLast(animal);
			}
			System.out.println(animal.arrivalTime.toString());
		}

		public Animal dequeueAny() {
			if (dogs.size() == 0 || (cats.size() != 0 && cats.peekFirst().arrivalTime.before(dogs.peekFirst().arrivalTime))) {
				return dequeueCat();
			} else {
				return dequeueDog();
			}
		}

		public Animal dequeueCat() {
			return cats.size() == 0 ? null : cats.removeFirst();
		}

		public Animal dequeueDog() {
			return dogs.size() == 0 ? null : dogs.removeFirst();
		}

		public boolean isEmpty() {
			return cats.size() == 0 && dogs.size() == 0;
		}
	}

	static Cat c1;
	static Cat c2;
	static Cat c3;
	static Dog d1;
	static Dog d2;
	static Dog d3;
	static AnimalShelter shelter;

	public QueAnyCatsAndDogs() {
		c1 = new Cat("Cat1", new Date(100));
		d1 = new Dog("Dog1", new Date(200));
		c2 = new Cat("Cat2", new Date(400));
		c3 = new Cat("Cat3", new Date(500));
		d2 = new Dog("Dog2", new Date(600));
		d3 = new Dog("Dog3", new Date(800));
		shelter = new AnimalShelter();
	}

	public static void main(String[] args) {
		QueAnyCatsAndDogs q = new QueAnyCatsAndDogs();
		Animal animal;

		shelter.enqueue(c1);
		shelter.enqueue(d1);
		shelter.enqueue(c2);
		shelter.enqueue(c3);
		shelter.enqueue(d2);
		shelter.enqueue(d3);

		while (!shelter.isEmpty()) {
			animal = shelter.dequeueAny();
			System.out.println(animal == null ? "NULL" : animal.name);
		}
	}

}
