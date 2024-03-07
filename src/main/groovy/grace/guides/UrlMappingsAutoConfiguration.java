package grace.guides;

import grails.web.mapping.LinkGenerator;
import grails.web.mapping.UrlMappingsHolder;
import org.grails.web.mapping.DefaultLinkGenerator;
import org.grails.web.mapping.DefaultUrlMappingsHolder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;

/**
 * This Configuration is just a workaround for GSP plugin,
 * because the GSP plugin will create UrlMappingTagLib which is not required in Spring Boot application.
 * Grace will make this taglib move to UrlMappings plugin.
 *
 * @author Michael Yan
 */
@Configuration
public class UrlMappingsAutoConfiguration {

    @Bean("grailsUrlMappingsHolder")
    public UrlMappingsHolder urlMappingsHolder() {
        return new DefaultUrlMappingsHolder(new ArrayList<>());
    }

    @Bean({"linkGenerator", "grailsLinkGenerator"})
    public LinkGenerator grailsLinkGenerator(UrlMappingsHolder urlMappingsHolder) {
        DefaultLinkGenerator linkGenerator = new DefaultLinkGenerator("/");
        linkGenerator.setUrlMappingsHolder(urlMappingsHolder);
        return linkGenerator;
    }

}
