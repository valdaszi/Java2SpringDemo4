package lt.bta.java2.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] { AppConfig.class };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] { MvcConfig.class };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

}

//public class WebInit implements WebApplicationInitializer {
//
//    public WebInit() {
//        super(AppConfig.class, WebSecurityConfig.class);
//    }
//
//    @Override
//    public void onStartup(ServletContext servletContext) {
//
//        // Create the 'root' Spring application context
//        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
//        rootContext.register(AppConfig.class);
//
//        // Manage the lifecycle of the application context
//        servletContext.addListener(new ContextLoaderListener(rootContext));
//
//        // Register and map the Spring Data Rest dispatcher servlet (must be before DispatcherServlet, why???):
//        ServletRegistration.Dynamic rest = servletContext.addServlet("rest", RepositoryRestDispatcherServlet.class);
//        rest.setLoadOnStartup(1);
//        rest.addMapping("/api/*");
//
//        // Create Dispatcher context
//        AnnotationConfigWebApplicationContext dispatcherContext = new AnnotationConfigWebApplicationContext();
//        dispatcherContext.register(MvcConfig.class);
//
//        // Register and map the dispatcher servlet:
//        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher", new DispatcherServlet(dispatcherContext));
//        dispatcher.setLoadOnStartup(1);
//        dispatcher.addMapping("/");
//    }
//}
