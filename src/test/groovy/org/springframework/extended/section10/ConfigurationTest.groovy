package org.springframework.extended.section10

import org.hsqldb.lib.HsqlArrayHeap
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.FilterType
import org.springframework.context.annotation.Import
import org.springframework.context.annotation.Profile
import org.springframework.extended.section10.impl.BarService
import org.springframework.extended.section10.impl.FooService
import org.springframework.extended.section10.interfaces.MarkerInterface
import org.springframework.jdbc.datasource.DataSourceTransactionManager
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType
import org.springframework.stereotype.Repository
import org.springframework.stereotype.Service
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.ContextConfiguration
import org.springframework.transaction.PlatformTransactionManager
import spock.lang.Specification

import javax.sql.DataSource

@ContextConfiguration(classes = TestConfiguration)
// TODO activate Profile
@ActiveProfiles("H2")
class ConfigurationTest extends Specification {

    @Autowired
    private ApplicationContext applicationContext

    @Autowired
    private MarkerInterface service

    @Autowired
    private BarService barService

    @Autowired
    private FooService fooService

    def "configuration class test"() {

        expect:
            applicationContext != null
            service != null
            fooService == barService.fooService

    }

    @Configuration
    // TODO add scan
    @ComponentScan("org.springframework.extended.section10")
    // implement @Beans
    // include DBConfiguration
    @Import(DBConfiguration)
    public static class TestConfiguration {

        @Bean
        BarService barService() {
            BarService service = new BarService()
            service.setFooService(fooService())

            return service
        }

        @Bean
        FooService fooService() {
            return new FooService()
        }


    }


    @Configuration
    // TODO include datasource configurations
    @Import(value = [HSQLConfiguration, H2Configuration])
    public static class DBConfiguration {

        @Autowired
        DataSource ds

        @Bean
        PlatformTransactionManager transactionManager() {
            return new DataSourceTransactionManager(ds)
        }

    }

    @Configuration
    // TODO add Profile
    @Profile("HSQLDB")
    public static class HSQLConfiguration {

        @Bean
        public DataSource dataSource() {
            return new EmbeddedDatabaseBuilder()
                    .setType(EmbeddedDatabaseType.HSQL)
                    .build();
        }
    }

    @Configuration
    // TODO add Profile
    @Profile("H2")
    public static class H2Configuration {

        @Bean
        public DataSource dataSource() {
            return new EmbeddedDatabaseBuilder()
                    .setType(EmbeddedDatabaseType.H2)
                    .build();
        }
    }


}
