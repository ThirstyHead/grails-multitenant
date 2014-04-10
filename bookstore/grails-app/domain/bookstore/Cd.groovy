package bookstore
import grails.plugin.multitenant.core.annotation.MultiTenant

// NOTE: adds tenantId field via AST 
@MultiTenant
class Cd {
  String title
  String artist

  static constraints = {
  }

  static mapping = {
    tenantIdIndex indexColumn: [name: "tenantId", type:Integer]
  }
}
