// Place your Spring DSL code here
beans = {
  tenantResolver(bookstore.SpringSecurityTenantResolver) {
    springSecurityService = ref('springSecurityService')
  }
  tenantRepository(bookstore.SpringSecurityTenantRepository)

}


// Activate these bean definitions
// Documentation http://grails.org/doc/latest/guide/single.html#14.2%20Configuring%20Additional%20Beans
// tenantResolver(bookstore.SpringSecurityTenantResolver) {
//	springSecurityService = ref('springSecurityService')
// }
// tenantRepository(bookstore.SpringSecurityTenantRepository)


