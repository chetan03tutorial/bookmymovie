package com.bmm.reservation.system;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.core.Conventions;
import org.springframework.util.ObjectUtils;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.FrameworkServlet;
import javax.servlet.*;


public class ApplicationInitializerUsingSpringWebApplicationInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        // These are the context initializers which will be used later to customize the root application context.
        ApplicationContextInitializer<?>[] rootContextInitializers = new ApplicationContextInitializer[2];
        // These are the context initializers which will be used later to customize the servlet application context.
        ApplicationContextInitializer<?>[] servletContextInitializers = new ApplicationContextInitializer[2];

        /** 1.
         * The first step is to prepare the context which would be the root application contex.
         * This context will be used to initialize the contextLoaderListener, which is a servletcontextlistener,
         * when the servlet context is initialized
         */
        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.register(RootConfig.class);


        /** 2.
         * Now we will use the ContextLoaderListener to register this rootContext as the root Context of the application
         * The above ContextLoaderListener will listen to servletContext ContextInitialized Event and
         * will start doing the following
         * Register this rootContext as the rootApplicationContext using ::
         * servletContext.setAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE, rootContext);
         * It also assign a context Id to this application context
         * It also tries to assign a parent to this rootcontext. In case of no parent, the root context has null parent
         * It also set the servletContext object itself in rootContext.
         * It also customize the rootContext before it gets refreshed,  by using ApplicationContextInitializer before
         * Finally it refreshes the rootContext and thus actually creating the beans from the configuration files. (RootConfig.class)
         */
        ContextLoaderListener listener = new ContextLoaderListener(rootContext);

        /** 3.
         * Register the contextInitializer to customize the contexts
         */
        listener.setContextInitializers(rootContextInitializers);

        /** 4.
         * Register the servletContextListener ( listener we created above)
         * to the servletContext so that it will be called when the context is initialized
         */
        servletContext.addListener(listener);

        /** 5.
         * Create the servlet application Context which will be used to initialize the Dispatcher servlet
         */
        AnnotationConfigWebApplicationContext servletWebApplicationContext = new AnnotationConfigWebApplicationContext();
        servletWebApplicationContext.register(WebConfig.class);


        /** 6.
         * Create instance of Dispatcher servlet.
         * The dispatcher servlet will be registered to the servlet context.
         * The dispatcher servlet will perform the following in its init() method
         * Hence when web-container initialize this servlet, It does the following
         *  1. Set the rootContext as the parent context of it's servletWebApplicationContext
         *  2. Assign an Id to servletApplicationContext
         *  3. Refresh the servletApplicationContext and thus actually create the bean from the config file register ( WebConfig.class)
         */
        FrameworkServlet dispatcherServlet = new DispatcherServlet(servletWebApplicationContext);
        String servletName = DispatcherServlet.class.getName();

        /** 7.
         * Set the contextInitializers for the servletApplicationContext so that
         * the serlvetApplicationContext can be customized according to the passed initializers
         */
        dispatcherServlet.setContextInitializers(servletContextInitializers);

        /** 8.
         * Register the dispatcher servlet in the servletContext object
         */
        ServletRegistration.Dynamic registration = servletContext.addServlet(servletName, dispatcherServlet);
        if (registration == null) {
            throw new IllegalStateException("Failed to register servlet with name '" + servletName + "'. " +
                    "Check if there is another servlet registered under the same name.");
        }

        /**9.
         * Set Load on startup value for the dispatcher servlet
         */
        registration.setLoadOnStartup(1);

        /**10.
         * Set the path for which this servlet service method's will be invoked
         */
        registration.addMapping(getServletMappings());


        /** 11.
         * Add the filters in the servlet context object
         */
        Filter[] filters = getServletFilters();
        if (!ObjectUtils.isEmpty(filters)) {
            for (Filter filter : filters) {
                registerServletFilter(servletContext, filter);
            }
        }
    }

    private Filter[] getServletFilters() {
        return null;
    }

    private String[] getServletMappings() {
        return new String[]{"/","/app"};
    }

    protected FilterRegistration.Dynamic registerServletFilter(ServletContext servletContext, Filter filter) {
        String filterName = Conventions.getVariableName(filter);
        FilterRegistration.Dynamic registration = servletContext.addFilter(filterName, filter);
        return registration;
    }
}
