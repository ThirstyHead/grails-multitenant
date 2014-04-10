package bookstore

import grails.plugin.multitenant.core.exception.TenantResolveException
import grails.plugin.multitenant.core.resolve.TenantResolver

import javax.servlet.http.HttpServletRequest

/**
 * Spring Security Tenant Resolver
 * Extracts the userTenantId
 * @see http://multi-tenant.github.com/grails-multi-tenant-single-db/
 */
class SpringSecurityTenantResolver implements TenantResolver {
    def springSecurityService

    Integer resolve(HttpServletRequest request) throws TenantResolveException {
        def user = springSecurityService.getCurrentUser()
        /*
        if (!user) {
            throw new TenantResolveException('Tenant could not be resolved using SpringSecurity')
        }
        */
        return user?.userTenantId
    }
}
