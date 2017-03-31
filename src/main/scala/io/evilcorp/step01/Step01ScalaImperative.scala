object Step01ScalaImperative{
  def apply(string : String) : String = {
    val array = string.split(" ")
    val builder = StringBuilder.newBuilder
    for(s <- array){
      if(s.equals("nice")){
        builder.append("XXXX ")
      }else{
        builder.append(s)
        builder.append(" ")
      }
    }
    builder.toString()
  }

  def main(args: Array[String]): Unit = {
    println(apply("You are a nice person"))
  }
}