package io.evilcorp.step02

object Step02ScalaImperative {
	def apply(censored: Set[String])(text: String): String = {
		var result = text
		for (verboten <- censored) {
			result = result.replaceAll(verboten, fillString('X', verboten.length))
		}
		result
	}
		
	//This is for illustrative purpose
	//It's reasonable to expect this to be implemented the same way as Marked.apply
	def fillString(char: Char, size: Int): String = {
		var builder = new StringBuilder(size)
		var i = size
		while (i > 0) { 
			builder.append(char)
			i -= 1
		}
		return builder.toString
	}
}

object Step02ScalaFunctional {
	def apply(censored: Set[String])(text: String): String = 
		censored.foldLeft(text) {
			(txt, verboten) => txt.replaceAll(verboten, Marked(verboten))
		}
}

object Marked {
	private val marker = 'X'
	//could be memoized
	def apply(word: String): String = Array.fill(word.size)(marker).mkString
}