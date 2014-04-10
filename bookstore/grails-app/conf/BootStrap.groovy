import bookstore.*

class BootStrap {

  def init = { servletContext ->
    def b1 = new Book(title:"Groovy Recipes", author:"Scott Davis")
    b1.save(failOnError:true)

    def b2 = new Book(title:"Five Days in Paris", author:"Danielle Steel")
    b2.save(failOnError:true)


  }
  def destroy = {
  }
}
