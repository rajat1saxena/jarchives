/*
* The demonstration of Abstract Factory Pattern
* 
* Here the 'DocumentFactory' creates documents of types 
* 'Resume' or 'Letter' which are concrete classes responsible to
* create things like 'FancyResume' or 'CoverLetter'
* 
* The example is inspired by Wikipedia documentation of Abstract
* Factory.
*/

interface Letter{
	void print();
}

class CoverLetter implements Letter{
	@Override
	public void print(){
		System.out.println("Cover letter printed");
	}
}

class FancyLetter implements Letter{
	@Override
	public void print(){
		System.out.println("Fancy letter printed");
	}
}

interface Resume{
	void process();
}

class CorporateResume implements Resume{
	@Override
	public void process(){
		System.out.println("Corporate resume processed");
	}
}

class FancyResume implements Resume{
	@Override
	public void process(){
		System.out.println("Fancy resume processed");
	}
}

//Create 'Concrete' factories 
class LetterFactory{
	public Letter getLetter(String type){
		switch(type){
			case "Fancy":
				return new FancyLetter();
			case "Cover":
				return new CoverLetter();
		}
		return null;
	}
}

class ResumeFactory{
	public Resume getResume(String type){
		switch(type){
			case "Fancy":
				return new FancyResume();
			case "Corporate":
				return new CorporateResume();
		}
		return null;
	}
}

// create abstract factory
abstract class DocumentFactory{
	abstract LetterFactory letterFactory();
	abstract ResumeFactory resumeFactory();
}

class DocumentCreator extends DocumentFactory{
	@Override
	LetterFactory letterFactory(){
		return new LetterFactory();
	}

	@Override
	ResumeFactory resumeFactory(){
		return new ResumeFactory();
	}
}

class abstractfactory{
	public static void main(String args[]){
		DocumentCreator creator = new DocumentCreator();

		// create a fancy letter
		// :; We can make it like creator.getFactory("letter").getType("fancy")
		Letter myLetter = creator.letterFactory().getLetter("Fancy");
		myLetter.print();

		// create a corporate resume
		Resume myResume = creator.resumeFactory().getResume("Corporate");
		myResume.process();
	}
}