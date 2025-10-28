package domainapp.modules.simple.dom.so;

import org.apache.causeway.applib.annotation.Action;
import org.apache.causeway.applib.annotation.ActionLayout;
import org.apache.causeway.applib.annotation.DomainService;
import org.apache.causeway.applib.annotation.SemanticsOf;
import org.apache.causeway.applib.services.inject.ServiceInjector;

import domainapp.modules.simple.SimpleModule;
import jakarta.inject.Named;
import lombok.RequiredArgsConstructor;

@Named(SimpleModule.NAMESPACE + ".AssistantMenu")
@DomainService
@RequiredArgsConstructor
public class AssistantMenu {

    private final ServiceInjector serviceInjector;

    @Action(semantics = SemanticsOf.NON_IDEMPOTENT)
    @ActionLayout(cssClassFa = "random")
    public Object openAssistant() {
        return serviceInjector.injectServicesInto(new Assistant());
    }

}
