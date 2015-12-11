
package org.mule.module.hubspot.model.contactproperty.transformers;

import javax.annotation.Generated;
import org.mule.api.transformer.DiscoverableTransformer;
import org.mule.api.transformer.TransformerException;
import org.mule.module.hubspot.model.contactproperty.CustomContactPropertyFieldType;
import org.mule.transformer.AbstractTransformer;
import org.mule.transformer.types.DataTypeFactory;

@SuppressWarnings("all")
@Generated(value = "Mule DevKit Version 3.7.2", date = "2015-12-11T05:23:24-03:00", comments = "Build 3.7.x.2633.51164b9")
public class CustomContactPropertyFieldTypeEnumTransformer
    extends AbstractTransformer
    implements DiscoverableTransformer
{

    private int weighting = DiscoverableTransformer.DEFAULT_PRIORITY_WEIGHTING;

    public CustomContactPropertyFieldTypeEnumTransformer() {
        registerSourceType(DataTypeFactory.create(String.class));
        setReturnClass(CustomContactPropertyFieldType.class);
        setName("CustomContactPropertyFieldTypeEnumTransformer");
    }

    protected Object doTransform(Object src, String encoding)
        throws TransformerException
    {
        CustomContactPropertyFieldType result = null;
        result = Enum.valueOf(CustomContactPropertyFieldType.class, ((String) src));
        return result;
    }

    public int getPriorityWeighting() {
        return weighting;
    }

    public void setPriorityWeighting(int weighting) {
        this.weighting = weighting;
    }

}
