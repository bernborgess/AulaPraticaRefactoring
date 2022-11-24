


all:
	javac Customer.java Main.java Movie.java Rental.java
	clear
	@echo "RUN:"
	java Main

clean:
	rm *.class