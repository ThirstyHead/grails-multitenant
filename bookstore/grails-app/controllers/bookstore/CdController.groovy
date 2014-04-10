package bookstore

class CdController {
    static scaffold = true

    def debug(){
      def cd = new Cd()
      render cd.properties
    }
}
