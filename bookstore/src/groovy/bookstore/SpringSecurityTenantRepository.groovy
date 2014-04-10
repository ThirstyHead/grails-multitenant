package bookstore

import grails.plugin.multitenant.core.CurrentTenant
import grails.plugin.multitenant.core.CurrentTenantAwareRepository
import grails.plugin.multitenant.core.Tenant

import org.codehaus.groovy.grails.commons.GrailsApplication
import org.slf4j.Logger
import org.slf4j.LoggerFactory

/**
 * Dummy implementation of TenantRepository
 *
 * @author Kim A. Betti
 * @author Steve Ronderos
 */
public class SpringSecurityTenantRepository implements CurrentTenantAwareRepository {

    private static final Logger log = LoggerFactory.getLogger(this)

    CurrentTenant currentTenant // will be injected
    GrailsApplication grailsApplication

    @Override
    Tenant getCurrentTenant() {
        Tenant tenantInstance = null
        Integer currentTenantId = currentTenant.get()
        if (currentTenantId != null) {
            tenantInstance = findByTenantId(currentTenantId)
        }

        tenantInstance
    }

    @Override
    Tenant findByTenantId(Integer tenantId) {
        def tenantClass = grailsApplication.getDomainClass(grailsApplication.config.multiTenant.tenantClass)
        tenantClass.clazz.get(tenantId); // Assumes that you use Tenant's primary key as tenant id
    }
}
