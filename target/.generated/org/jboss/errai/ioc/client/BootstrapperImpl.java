package org.jboss.errai.ioc.client;

import java.lang.annotation.Annotation;
import javax.enterprise.event.Event;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Default;
import javax.inject.Provider;
import org.company.firestorm2.client.local.App;
import org.company.firestorm2.client.shared.HelloMessage;
import org.company.firestorm2.client.shared.Response;
import org.jboss.errai.bus.client.ErraiBus;
import org.jboss.errai.bus.client.framework.Subscription;
import org.jboss.errai.enterprise.client.cdi.AbstractCDIEventCallback;
import org.jboss.errai.enterprise.client.cdi.CDIEventTypeLookup;
import org.jboss.errai.enterprise.client.cdi.EventProvider;
import org.jboss.errai.enterprise.client.cdi.InstanceProvider;
import org.jboss.errai.enterprise.client.cdi.api.CDI;
import org.jboss.errai.ioc.client.api.ContextualTypeProvider;
import org.jboss.errai.ioc.client.api.builtin.CallerProvider;
import org.jboss.errai.ioc.client.api.builtin.DisposerProvider;
import org.jboss.errai.ioc.client.api.builtin.IOCBeanManagerProvider;
import org.jboss.errai.ioc.client.api.builtin.InitBallotProvider;
import org.jboss.errai.ioc.client.api.builtin.MessageBusProvider;
import org.jboss.errai.ioc.client.api.builtin.RequestDispatcherProvider;
import org.jboss.errai.ioc.client.api.builtin.RootPanelProvider;
import org.jboss.errai.ioc.client.api.builtin.SenderProvider;
import org.jboss.errai.ioc.client.container.CreationalCallback;
import org.jboss.errai.ioc.client.container.CreationalContext;
import org.jboss.errai.ioc.client.container.DestructionCallback;
import org.jboss.errai.ioc.client.container.IOCBeanManager;
import org.jboss.errai.ioc.client.container.InitializationCallback;
import org.jboss.errai.ui.nav.client.local.Navigation;
import org.jboss.errai.ui.nav.client.local.PageTransitionProvider;

public class BootstrapperImpl implements Bootstrapper {
  {
    CDIEventTypeLookup.get().addLookup("org.company.firestorm2.client.shared.Response", "java.lang.Object");
    new CDI().initLookupTable(CDIEventTypeLookup.get());
  }
  private final Any _1998831462Any_11404355 = new Any() {
    public Class annotationType() {
      return Any.class;
    }
  };
  private final Default _1998831462Default_5714534 = new Default() {
    public Class annotationType() {
      return Default.class;
    }
  };
  private final Annotation[] arrayOf_19635043Annotation_8606317 = new Annotation[] { _1998831462Any_11404355, _1998831462Default_5714534 };
  private final BootstrapperInjectionContext injContext = new BootstrapperInjectionContext();
  private final CreationalContext context = injContext.getRootContext();
  private final CreationalCallback<CallerProvider> inj3694_CallerProvider_creational = new CreationalCallback<CallerProvider>() {
    public CallerProvider getInstance(final CreationalContext context) {
      final CallerProvider inj3689_CallerProvider = new CallerProvider();
      context.addBean(context.getBeanReference(CallerProvider.class, arrayOf_19635043Annotation_8606317), inj3689_CallerProvider);
      return inj3689_CallerProvider;
    }
  };
  private final CallerProvider inj3689_CallerProvider = inj3694_CallerProvider_creational.getInstance(context);
  private final CreationalCallback<RequestDispatcherProvider> inj3695_RequestDispatcherProvider_creational = new CreationalCallback<RequestDispatcherProvider>() {
    public RequestDispatcherProvider getInstance(final CreationalContext context) {
      final RequestDispatcherProvider inj3677_RequestDispatcherProvider = new RequestDispatcherProvider();
      context.addBean(context.getBeanReference(RequestDispatcherProvider.class, arrayOf_19635043Annotation_8606317), inj3677_RequestDispatcherProvider);
      return inj3677_RequestDispatcherProvider;
    }
  };
  private final RequestDispatcherProvider inj3677_RequestDispatcherProvider = inj3695_RequestDispatcherProvider_creational.getInstance(context);
  private InitializationCallback<Navigation> init_inj3696_Navigation = new InitializationCallback<Navigation>() {
    public void init(final Navigation obj) {
      _136504311_init(obj);
    }
  };
  private final CreationalCallback<Navigation> inj3697_Navigation_creational = new CreationalCallback<Navigation>() {
    public Navigation getInstance(final CreationalContext context) {
      final Navigation inj3696_Navigation = new Navigation();
      context.addBean(context.getBeanReference(Navigation.class, arrayOf_19635043Annotation_8606317), inj3696_Navigation);
      context.addInitializationCallback(inj3696_Navigation, init_inj3696_Navigation);
      return inj3696_Navigation;
    }
  };
  private final Navigation inj3696_Navigation = inj3697_Navigation_creational.getInstance(context);
  private final CreationalCallback<PageTransitionProvider> inj3698_PageTransitionProvider_creational = new CreationalCallback<PageTransitionProvider>() {
    public PageTransitionProvider getInstance(final CreationalContext context) {
      final PageTransitionProvider inj3673_PageTransitionProvider = new PageTransitionProvider();
      context.addBean(context.getBeanReference(PageTransitionProvider.class, arrayOf_19635043Annotation_8606317), inj3673_PageTransitionProvider);
      _395577528_navigation(inj3673_PageTransitionProvider, inj3696_Navigation);
      return inj3673_PageTransitionProvider;
    }
  };
  private final PageTransitionProvider inj3673_PageTransitionProvider = inj3698_PageTransitionProvider_creational.getInstance(context);
  private final CreationalCallback<SenderProvider> inj3699_SenderProvider_creational = new CreationalCallback<SenderProvider>() {
    public SenderProvider getInstance(final CreationalContext context) {
      final SenderProvider inj3693_SenderProvider = new SenderProvider();
      context.addBean(context.getBeanReference(SenderProvider.class, arrayOf_19635043Annotation_8606317), inj3693_SenderProvider);
      return inj3693_SenderProvider;
    }
  };
  private final SenderProvider inj3693_SenderProvider = inj3699_SenderProvider_creational.getInstance(context);
  private final CreationalCallback<RootPanelProvider> inj3700_RootPanelProvider_creational = new CreationalCallback<RootPanelProvider>() {
    public RootPanelProvider getInstance(final CreationalContext context) {
      final RootPanelProvider inj3679_RootPanelProvider = new RootPanelProvider();
      context.addBean(context.getBeanReference(RootPanelProvider.class, arrayOf_19635043Annotation_8606317), inj3679_RootPanelProvider);
      return inj3679_RootPanelProvider;
    }
  };
  private final RootPanelProvider inj3679_RootPanelProvider = inj3700_RootPanelProvider_creational.getInstance(context);
  private final CreationalCallback<InstanceProvider> inj3701_InstanceProvider_creational = new CreationalCallback<InstanceProvider>() {
    public InstanceProvider getInstance(final CreationalContext context) {
      final InstanceProvider inj3683_InstanceProvider = new InstanceProvider();
      context.addBean(context.getBeanReference(InstanceProvider.class, arrayOf_19635043Annotation_8606317), inj3683_InstanceProvider);
      return inj3683_InstanceProvider;
    }
  };
  private final InstanceProvider inj3683_InstanceProvider = inj3701_InstanceProvider_creational.getInstance(context);
  private final CreationalCallback<EventProvider> inj3702_EventProvider_creational = new CreationalCallback<EventProvider>() {
    public EventProvider getInstance(final CreationalContext context) {
      final EventProvider inj3687_EventProvider = new EventProvider();
      context.addBean(context.getBeanReference(EventProvider.class, arrayOf_19635043Annotation_8606317), inj3687_EventProvider);
      return inj3687_EventProvider;
    }
  };
  private final EventProvider inj3687_EventProvider = inj3702_EventProvider_creational.getInstance(context);
  private InitializationCallback<App> init_inj3703_App = new InitializationCallback<App>() {
    public void init(final App obj) {
      obj.buildUI();
    }
  };
  private final CreationalCallback<App> inj3704_App_creational = new CreationalCallback<App>() {
    public App getInstance(final CreationalContext context) {
      final App inj3703_App = new App();
      context.addBean(context.getBeanReference(App.class, arrayOf_19635043Annotation_8606317), inj3703_App);
      _1051008655_messageEvent(inj3703_App, inj3687_EventProvider.provide(new Class[] { HelloMessage.class }, null));
      final Subscription var3 = CDI.subscribe("org.company.firestorm2.client.shared.Response", new AbstractCDIEventCallback<Response>() {
        public void fireEvent(final Response event) {
          inj3703_App.response(event);
        }
        public String toString() {
          return "Observer: org.company.firestorm2.client.shared.Response []";
        }
      });
      final Subscription var4 = ErraiBus.get().subscribe("cdi.event:org.company.firestorm2.client.shared.Response", CDI.ROUTING_CALLBACK);
      context.addDestructionCallback(inj3703_App, new DestructionCallback<App>() {
        public void destroy(final App obj) {
          var3.remove();
          var4.remove();
        }
      });
      context.addInitializationCallback(inj3703_App, init_inj3703_App);
      return inj3703_App;
    }
  };
  private final App inj3703_App = inj3704_App_creational.getInstance(context);
  private final CreationalCallback<IOCBeanManagerProvider> inj3705_IOCBeanManagerProvider_creational = new CreationalCallback<IOCBeanManagerProvider>() {
    public IOCBeanManagerProvider getInstance(final CreationalContext context) {
      final IOCBeanManagerProvider inj3681_IOCBeanManagerProvider = new IOCBeanManagerProvider();
      context.addBean(context.getBeanReference(IOCBeanManagerProvider.class, arrayOf_19635043Annotation_8606317), inj3681_IOCBeanManagerProvider);
      return inj3681_IOCBeanManagerProvider;
    }
  };
  private final IOCBeanManagerProvider inj3681_IOCBeanManagerProvider = inj3705_IOCBeanManagerProvider_creational.getInstance(context);
  private final CreationalCallback<MessageBusProvider> inj3706_MessageBusProvider_creational = new CreationalCallback<MessageBusProvider>() {
    public MessageBusProvider getInstance(final CreationalContext context) {
      final MessageBusProvider inj3675_MessageBusProvider = new MessageBusProvider();
      context.addBean(context.getBeanReference(MessageBusProvider.class, arrayOf_19635043Annotation_8606317), inj3675_MessageBusProvider);
      return inj3675_MessageBusProvider;
    }
  };
  private final MessageBusProvider inj3675_MessageBusProvider = inj3706_MessageBusProvider_creational.getInstance(context);
  private final CreationalCallback<InitBallotProvider> inj3707_InitBallotProvider_creational = new CreationalCallback<InitBallotProvider>() {
    public InitBallotProvider getInstance(final CreationalContext context) {
      final InitBallotProvider inj3685_InitBallotProvider = new InitBallotProvider();
      context.addBean(context.getBeanReference(InitBallotProvider.class, arrayOf_19635043Annotation_8606317), inj3685_InitBallotProvider);
      return inj3685_InitBallotProvider;
    }
  };
  private final InitBallotProvider inj3685_InitBallotProvider = inj3707_InitBallotProvider_creational.getInstance(context);
  private final CreationalCallback<DisposerProvider> inj3708_DisposerProvider_creational = new CreationalCallback<DisposerProvider>() {
    public DisposerProvider getInstance(final CreationalContext context) {
      final DisposerProvider inj3691_DisposerProvider = new DisposerProvider();
      context.addBean(context.getBeanReference(DisposerProvider.class, arrayOf_19635043Annotation_8606317), inj3691_DisposerProvider);
      _$1300398733_beanManager(inj3691_DisposerProvider, inj3681_IOCBeanManagerProvider.get());
      return inj3691_DisposerProvider;
    }
  };
  private final DisposerProvider inj3691_DisposerProvider = inj3708_DisposerProvider_creational.getInstance(context);
  private void declareBeans_0() {
    injContext.addBean(CallerProvider.class, CallerProvider.class, inj3694_CallerProvider_creational, inj3689_CallerProvider, arrayOf_19635043Annotation_8606317, null, true);
    injContext.addBean(ContextualTypeProvider.class, CallerProvider.class, inj3694_CallerProvider_creational, inj3689_CallerProvider, arrayOf_19635043Annotation_8606317, null, false);
    injContext.addBean(RequestDispatcherProvider.class, RequestDispatcherProvider.class, inj3695_RequestDispatcherProvider_creational, inj3677_RequestDispatcherProvider, arrayOf_19635043Annotation_8606317, null, true);
    injContext.addBean(Provider.class, RequestDispatcherProvider.class, inj3695_RequestDispatcherProvider_creational, inj3677_RequestDispatcherProvider, arrayOf_19635043Annotation_8606317, null, false);
    injContext.addBean(Navigation.class, Navigation.class, inj3697_Navigation_creational, inj3696_Navigation, arrayOf_19635043Annotation_8606317, null, true);
    injContext.addBean(PageTransitionProvider.class, PageTransitionProvider.class, inj3698_PageTransitionProvider_creational, inj3673_PageTransitionProvider, arrayOf_19635043Annotation_8606317, null, true);
    injContext.addBean(ContextualTypeProvider.class, PageTransitionProvider.class, inj3698_PageTransitionProvider_creational, inj3673_PageTransitionProvider, arrayOf_19635043Annotation_8606317, null, false);
    injContext.addBean(SenderProvider.class, SenderProvider.class, inj3699_SenderProvider_creational, inj3693_SenderProvider, arrayOf_19635043Annotation_8606317, null, true);
    injContext.addBean(ContextualTypeProvider.class, SenderProvider.class, inj3699_SenderProvider_creational, inj3693_SenderProvider, arrayOf_19635043Annotation_8606317, null, false);
    injContext.addBean(RootPanelProvider.class, RootPanelProvider.class, inj3700_RootPanelProvider_creational, inj3679_RootPanelProvider, arrayOf_19635043Annotation_8606317, null, true);
    injContext.addBean(Provider.class, RootPanelProvider.class, inj3700_RootPanelProvider_creational, inj3679_RootPanelProvider, arrayOf_19635043Annotation_8606317, null, false);
    injContext.addBean(InstanceProvider.class, InstanceProvider.class, inj3701_InstanceProvider_creational, inj3683_InstanceProvider, arrayOf_19635043Annotation_8606317, null, true);
    injContext.addBean(ContextualTypeProvider.class, InstanceProvider.class, inj3701_InstanceProvider_creational, inj3683_InstanceProvider, arrayOf_19635043Annotation_8606317, null, false);
    injContext.addBean(EventProvider.class, EventProvider.class, inj3702_EventProvider_creational, inj3687_EventProvider, arrayOf_19635043Annotation_8606317, null, true);
    injContext.addBean(ContextualTypeProvider.class, EventProvider.class, inj3702_EventProvider_creational, inj3687_EventProvider, arrayOf_19635043Annotation_8606317, null, false);
    injContext.addBean(App.class, App.class, inj3704_App_creational, inj3703_App, arrayOf_19635043Annotation_8606317, null, true);
    injContext.addBean(IOCBeanManagerProvider.class, IOCBeanManagerProvider.class, inj3705_IOCBeanManagerProvider_creational, inj3681_IOCBeanManagerProvider, arrayOf_19635043Annotation_8606317, null, true);
    injContext.addBean(Provider.class, IOCBeanManagerProvider.class, inj3705_IOCBeanManagerProvider_creational, inj3681_IOCBeanManagerProvider, arrayOf_19635043Annotation_8606317, null, false);
    injContext.addBean(MessageBusProvider.class, MessageBusProvider.class, inj3706_MessageBusProvider_creational, inj3675_MessageBusProvider, arrayOf_19635043Annotation_8606317, null, true);
    injContext.addBean(Provider.class, MessageBusProvider.class, inj3706_MessageBusProvider_creational, inj3675_MessageBusProvider, arrayOf_19635043Annotation_8606317, null, false);
    injContext.addBean(InitBallotProvider.class, InitBallotProvider.class, inj3707_InitBallotProvider_creational, inj3685_InitBallotProvider, arrayOf_19635043Annotation_8606317, null, true);
    injContext.addBean(ContextualTypeProvider.class, InitBallotProvider.class, inj3707_InitBallotProvider_creational, inj3685_InitBallotProvider, arrayOf_19635043Annotation_8606317, null, false);
    injContext.addBean(DisposerProvider.class, DisposerProvider.class, inj3708_DisposerProvider_creational, inj3691_DisposerProvider, arrayOf_19635043Annotation_8606317, null, true);
    injContext.addBean(ContextualTypeProvider.class, DisposerProvider.class, inj3708_DisposerProvider_creational, inj3691_DisposerProvider, arrayOf_19635043Annotation_8606317, null, false);
  }

  private native static void _1051008655_messageEvent(App instance, Event value) /*-{
    instance.@org.company.firestorm2.client.local.App::messageEvent = value;
  }-*/;

  private native static void _$1300398733_beanManager(DisposerProvider instance, IOCBeanManager value) /*-{
    instance.@org.jboss.errai.ioc.client.api.builtin.DisposerProvider::beanManager = value;
  }-*/;

  private native static void _395577528_navigation(PageTransitionProvider instance, Navigation value) /*-{
    instance.@org.jboss.errai.ui.nav.client.local.PageTransitionProvider::navigation = value;
  }-*/;

  public native static void _136504311_init(Navigation instance) /*-{
    instance.@org.jboss.errai.ui.nav.client.local.Navigation::init()();
  }-*/;

  // The main IOC bootstrap method.
  public BootstrapperInjectionContext bootstrapContainer() {
    declareBeans_0();
    return injContext;
  }
}