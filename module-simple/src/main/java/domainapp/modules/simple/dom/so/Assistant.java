package domainapp.modules.simple.dom.so;

import java.util.List;

import org.apache.causeway.applib.annotation.DomainObject;
import org.apache.causeway.applib.annotation.Editing;
import org.apache.causeway.applib.annotation.Nature;
import org.apache.causeway.applib.annotation.Optionality;
import org.apache.causeway.applib.annotation.Property;
import org.apache.causeway.applib.jaxb.PersistentEntityAdapter;

import domainapp.modules.simple.SimpleModule;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.XmlTransient;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import lombok.Getter;
import lombok.Setter;

@XmlRootElement
@XmlType
@XmlAccessorType(XmlAccessType.FIELD)
@Named(SimpleModule.NAMESPACE + ".Assistant")
@DomainObject(nature = Nature.VIEW_MODEL, editing = Editing.ENABLED)

public class Assistant {

    @Inject
    @XmlTransient
    private SimpleObjectRepository simpleObjectRepository;

    @Getter
    @Setter
    @XmlJavaTypeAdapter(PersistentEntityAdapter.class)
    @Property(optionality = Optionality.MANDATORY, editing = Editing.ENABLED)
    private SimpleObject simpleObject;

    public List<SimpleObject> choicesSimpleObject() {
        return simpleObjectRepository.findAll();
    }

}