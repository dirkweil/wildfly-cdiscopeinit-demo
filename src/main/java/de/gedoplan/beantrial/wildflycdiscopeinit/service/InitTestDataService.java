package de.gedoplan.beantrial.wildflycdiscopeinit.service;

import de.gedoplan.beantrial.wildflycdiscopeinit.entity.Dummy;
import de.gedoplan.beantrial.wildflycdiscopeinit.interceptor.TraceCall;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Initialized;
import javax.enterprise.event.Observes;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@ApplicationScoped
public class InitTestDataService
{
  @PersistenceContext
  EntityManager      entityManager;

  private static Log log = LogFactory.getLog(InitTestDataService.class);

  @Transactional
  @TraceCall
  /*
   * TODO WildFly 9 ignores the interceptors when the method is private
   */
  private void createTestData(@Observes @Initialized(ApplicationScoped.class) Object object)
  {
    try
    {
      this.entityManager.persist(new Dummy());
      log.debug("Demo data created");
    }
    catch (Exception e)
    {
      log.warn("Cannot create demo data", e);
    }
  }

}
