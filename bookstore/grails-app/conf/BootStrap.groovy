import bookstore.*

class BootStrap {

  def init = { servletContext ->
    /////////
    // Users
    /////////
    def u1 = new User(username: "him",
                      password: "him",
                      enabled: true,
                      accountExpired: false,
                      accountLocked: false,
                      passwordExpired: false,
                      userTenantId: 1)
    u1.save(failOnError:true)

    def u2 = new User(username: "her",
                      password: "her",
                      enabled: true,
                      accountExpired: false,
                      accountLocked: false,
                      passwordExpired: false,
                      userTenantId: 2)
    u2.save(failOnError:true)

    /////////
    // Roles
    /////////
    def r1 = new Role(authority:"User")
    r1.save(failOnError:true)

    // assign roles to users, flush to db
    UserRole.create u1, r1, true
    UserRole.create u2, r1, true  



    /////////
    // Books
    /////////
    def b1 = new Book(title:"Groovy Recipes", author:"Scott Davis")
    b1.save(failOnError:true)

    def b2 = new Book(title:"Five Days in Paris", author:"Danielle Steel")
    b2.save(failOnError:true)

    ///////
    // CDs
    ///////
    def c1 = new Cd()    
    User.withTenantId(1){
      c1 = new Cd(title:"Let It Be", artist: "Beatles")
      c1.save(failOnError:true)
    }

    def c2 = new Cd()    
    User.withTenantId(2){
      c2 = new Cd(title:"Like a Virgin", artist: "Madonna")
      c2.save(failOnError:true)
    }

      

  }
  def destroy = {
  }
}
