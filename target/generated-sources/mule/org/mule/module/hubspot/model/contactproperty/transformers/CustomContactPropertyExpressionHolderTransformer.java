
package org.mule.module.hubspot.model.contactproperty.transformers;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Generated;
import org.mule.api.MuleContext;
import org.mule.api.MuleEvent;
import org.mule.api.endpoint.ImmutableEndpoint;
import org.mule.api.lifecycle.InitialisationException;
import org.mule.api.transformer.DataType;
import org.mule.api.transformer.DiscoverableTransformer;
import org.mule.api.transformer.MessageTransformer;
import org.mule.api.transformer.TransformerException;
import org.mule.api.transformer.TransformerMessagingException;
import org.mule.config.i18n.CoreMessages;
import org.mule.devkit.processor.ExpressionEvaluatorSupport;
import org.mule.module.hubspot.model.contactproperty.CustomContactProperty;
import org.mule.module.hubspot.model.contactproperty.CustomContactPropertyFieldType;
import org.mule.module.hubspot.model.contactproperty.CustomContactPropertyOptions;
import org.mule.module.hubspot.model.contactproperty.CustomContactPropertyType;
import org.mule.module.hubspot.model.contactproperty.holders.CustomContactPropertyExpressionHolder;
import org.mule.transformer.types.DataTypeFactory;
import org.mule.transport.NullPayload;
import org.mule.util.TemplateParser;

@SuppressWarnings("all")
@Generated(value = "Mule DevKit Version 3.7.2", date = "2015-12-11T05:23:24-03:00", comments = "Build 3.7.x.2633.51164b9")
public class CustomContactPropertyExpressionHolderTransformer
    extends ExpressionEvaluatorSupport
    implements DiscoverableTransformer, MessageTransformer
{

    private int weighting = DiscoverableTransformer.DEFAULT_PRIORITY_WEIGHTING;
    private ImmutableEndpoint endpoint;
    private MuleContext muleContext;
    private String name;

    public int getPriorityWeighting() {
        return weighting;
    }

    public void setPriorityWeighting(int weighting) {
        this.weighting = weighting;
    }

    public boolean isSourceTypeSupported(Class<?> aClass) {
        return (aClass == CustomContactPropertyExpressionHolder.class);
    }

    public boolean isSourceDataTypeSupported(DataType<?> dataType) {
        return (dataType.getType() == CustomContactPropertyExpressionHolder.class);
    }

    public List<Class<?>> getSourceTypes() {
        return Arrays.asList(new Class<?> [] {CustomContactPropertyExpressionHolder.class });
    }

    public List<DataType<?>> getSourceDataTypes() {
        return Arrays.asList(new DataType<?> [] {DataTypeFactory.create(CustomContactPropertyExpressionHolder.class)});
    }

    public boolean isAcceptNull() {
        return false;
    }

    public boolean isIgnoreBadInput() {
        return false;
    }

    public Object transform(Object src)
        throws TransformerException
    {
        throw new UnsupportedOperationException();
    }

    public Object transform(Object src, String encoding)
        throws TransformerException
    {
        throw new UnsupportedOperationException();
    }

    public void setReturnClass(Class<?> theClass) {
        throw new UnsupportedOperationException();
    }

    public Class<?> getReturnClass() {
        return CustomContactProperty.class;
    }

    public void setReturnDataType(DataType<?> type) {
        throw new UnsupportedOperationException();
    }

    public DataType<?> getReturnDataType() {
        return DataTypeFactory.create(CustomContactProperty.class);
    }

    public void setEndpoint(ImmutableEndpoint ep) {
        endpoint = ep;
    }

    public ImmutableEndpoint getEndpoint() {
        return endpoint;
    }

    public void dispose() {
    }

    public void initialise()
        throws InitialisationException
    {
    }

    public void setMuleContext(MuleContext context) {
        muleContext = context;
    }

    public void setName(String newName) {
        name = newName;
    }

    public String getName() {
        return name;
    }

    public Object transform(Object src, MuleEvent event)
        throws TransformerMessagingException
    {
        return transform(src, null, event);
    }

    public Object transform(Object src, String encoding, MuleEvent event)
        throws TransformerMessagingException
    {
        if (src == null) {
            return null;
        }
        CustomContactPropertyExpressionHolder holder = ((CustomContactPropertyExpressionHolder) src);
        CustomContactProperty result = new CustomContactProperty();
        try {
            final String _transformedName = ((String) evaluateAndTransform(this.muleContext, event, CustomContactPropertyExpressionHolder.class.getDeclaredField("_nameType").getGenericType(), null, holder.getName()));
            result.setName(_transformedName);
            final String _transformedLabel = ((String) evaluateAndTransform(this.muleContext, event, CustomContactPropertyExpressionHolder.class.getDeclaredField("_labelType").getGenericType(), null, holder.getLabel()));
            result.setLabel(_transformedLabel);
            final String _transformedDescription = ((String) evaluateAndTransform(this.muleContext, event, CustomContactPropertyExpressionHolder.class.getDeclaredField("_descriptionType").getGenericType(), null, holder.getDescription()));
            result.setDescription(_transformedDescription);
            final String _transformedGroupName = ((String) evaluateAndTransform(this.muleContext, event, CustomContactPropertyExpressionHolder.class.getDeclaredField("_groupNameType").getGenericType(), null, holder.getGroupName()));
            result.setGroupName(_transformedGroupName);
            final CustomContactPropertyType _transformedType = ((CustomContactPropertyType) evaluateAndTransform(this.muleContext, event, CustomContactPropertyExpressionHolder.class.getDeclaredField("_typeType").getGenericType(), null, holder.getType()));
            result.setType(_transformedType);
            final CustomContactPropertyFieldType _transformedFieldType = ((CustomContactPropertyFieldType) evaluateAndTransform(this.muleContext, event, CustomContactPropertyExpressionHolder.class.getDeclaredField("_fieldTypeType").getGenericType(), null, holder.getFieldType()));
            result.setFieldType(_transformedFieldType);
            final Boolean _transformedFormField = ((Boolean) evaluateAndTransform(this.muleContext, event, CustomContactPropertyExpressionHolder.class.getDeclaredField("_formFieldType").getGenericType(), null, holder.getFormField()));
            result.setFormField(_transformedFormField);
            final Integer _transformedDisplayOrder = ((Integer) evaluateAndTransform(this.muleContext, event, CustomContactPropertyExpressionHolder.class.getDeclaredField("_displayOrderType").getGenericType(), null, holder.getDisplayOrder()));
            result.setDisplayOrder(_transformedDisplayOrder);
            final Boolean _transformedReadOnlyValue = ((Boolean) evaluateAndTransform(this.muleContext, event, CustomContactPropertyExpressionHolder.class.getDeclaredField("_readOnlyValueType").getGenericType(), null, holder.getReadOnlyValue()));
            result.setReadOnlyValue(_transformedReadOnlyValue);
            final Boolean _transformedReadOnlyDefinition = ((Boolean) evaluateAndTransform(this.muleContext, event, CustomContactPropertyExpressionHolder.class.getDeclaredField("_readOnlyDefinitionType").getGenericType(), null, holder.getReadOnlyDefinition()));
            result.setReadOnlyDefinition(_transformedReadOnlyDefinition);
            final Boolean _transformedHidden = ((Boolean) evaluateAndTransform(this.muleContext, event, CustomContactPropertyExpressionHolder.class.getDeclaredField("_hiddenType").getGenericType(), null, holder.getHidden()));
            result.setHidden(_transformedHidden);
            final Boolean _transformedMutableDefinitionNotDeletable = ((Boolean) evaluateAndTransform(this.muleContext, event, CustomContactPropertyExpressionHolder.class.getDeclaredField("_mutableDefinitionNotDeletableType").getGenericType(), null, holder.getMutableDefinitionNotDeletable()));
            result.setMutableDefinitionNotDeletable(_transformedMutableDefinitionNotDeletable);
            final Boolean _transformedFavorited = ((Boolean) evaluateAndTransform(this.muleContext, event, CustomContactPropertyExpressionHolder.class.getDeclaredField("_favoritedType").getGenericType(), null, holder.getFavorited()));
            result.setFavorited(_transformedFavorited);
            final Integer _transformedFavoritedOrder = ((Integer) evaluateAndTransform(this.muleContext, event, CustomContactPropertyExpressionHolder.class.getDeclaredField("_favoritedOrderType").getGenericType(), null, holder.getFavoritedOrder()));
            result.setFavoritedOrder(_transformedFavoritedOrder);
            final List<CustomContactPropertyOptions> _transformedOptions = ((List<CustomContactPropertyOptions> ) evaluateAndTransform(this.muleContext, event, CustomContactPropertyExpressionHolder.class.getDeclaredField("_optionsType").getGenericType(), null, holder.getOptions()));
            result.setOptions(_transformedOptions);
        } catch (NoSuchFieldException e) {
            throw new TransformerMessagingException(CoreMessages.createStaticMessage("internal error"), event, this, e);
        } catch (TransformerException e) {
            throw new TransformerMessagingException(e.getI18nMessage(), event, this, e);
        }
        return result;
    }

    public MuleEvent process(MuleEvent event) {
        return null;
    }

    public String getMimeType() {
        return null;
    }

    public String getEncoding() {
        return null;
    }

    public MuleContext getMuleContext() {
        return muleContext;
    }

    private Object evaluateTransformForPayload(MuleContext muleContext, MuleEvent muleEvent, Type objectType, String mimeType, Object object)
        throws TransformerException, TransformerMessagingException
    {
        Object transformedObject;
        try {
            transformedObject = evaluateAndTransform(muleContext, muleEvent, objectType, mimeType, object);
            if (transformedObject instanceof NullPayload) {
                transformedObject = null;
            }
        } catch (TransformerException e) {
            transformedObject = evaluate(TemplateParser.createMuleStyleParser().getStyle(), muleContext.getExpressionManager(), muleEvent.getMessage(), object);
            if (transformedObject instanceof NullPayload) {
                transformedObject = null;
            } else {
                throw e;
            }
        } catch (TransformerMessagingException e) {
            transformedObject = evaluate(TemplateParser.createMuleStyleParser().getStyle(), muleContext.getExpressionManager(), muleEvent.getMessage(), object);
            if (transformedObject instanceof NullPayload) {
                transformedObject = null;
            } else {
                throw e;
            }
        }
        return transformedObject;
    }

}
