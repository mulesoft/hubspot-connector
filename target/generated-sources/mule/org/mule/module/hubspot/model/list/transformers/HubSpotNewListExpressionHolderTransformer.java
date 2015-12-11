
package org.mule.module.hubspot.model.list.transformers;

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
import org.mule.module.hubspot.model.list.HubSpotListMetadata;
import org.mule.module.hubspot.model.list.HubSpotNewList;
import org.mule.module.hubspot.model.list.holders.HubSpotNewListExpressionHolder;
import org.mule.transformer.types.DataTypeFactory;
import org.mule.transport.NullPayload;
import org.mule.util.TemplateParser;

@SuppressWarnings("all")
@Generated(value = "Mule DevKit Version 3.7.2", date = "2015-12-11T05:23:24-03:00", comments = "Build 3.7.x.2633.51164b9")
public class HubSpotNewListExpressionHolderTransformer
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
        return (aClass == HubSpotNewListExpressionHolder.class);
    }

    public boolean isSourceDataTypeSupported(DataType<?> dataType) {
        return (dataType.getType() == HubSpotNewListExpressionHolder.class);
    }

    public List<Class<?>> getSourceTypes() {
        return Arrays.asList(new Class<?> [] {HubSpotNewListExpressionHolder.class });
    }

    public List<DataType<?>> getSourceDataTypes() {
        return Arrays.asList(new DataType<?> [] {DataTypeFactory.create(HubSpotNewListExpressionHolder.class)});
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
        return HubSpotNewList.class;
    }

    public void setReturnDataType(DataType<?> type) {
        throw new UnsupportedOperationException();
    }

    public DataType<?> getReturnDataType() {
        return DataTypeFactory.create(HubSpotNewList.class);
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
        HubSpotNewListExpressionHolder holder = ((HubSpotNewListExpressionHolder) src);
        HubSpotNewList result = new HubSpotNewList();
        try {
            final String _transformedPortalId = ((String) evaluateAndTransform(this.muleContext, event, HubSpotNewListExpressionHolder.class.getDeclaredField("_portalIdType").getGenericType(), null, holder.getPortalId()));
            result.setPortalId(_transformedPortalId);
            final String _transformedListId = ((String) evaluateAndTransform(this.muleContext, event, HubSpotNewListExpressionHolder.class.getDeclaredField("_listIdType").getGenericType(), null, holder.getListId()));
            result.setListId(_transformedListId);
            final String _transformedInternalListId = ((String) evaluateAndTransform(this.muleContext, event, HubSpotNewListExpressionHolder.class.getDeclaredField("_internalListIdType").getGenericType(), null, holder.getInternalListId()));
            result.setInternalListId(_transformedInternalListId);
            final Long _transformedCreatedAt = ((Long) evaluateAndTransform(this.muleContext, event, HubSpotNewListExpressionHolder.class.getDeclaredField("_createdAtType").getGenericType(), null, holder.getCreatedAt()));
            result.setCreatedAt(_transformedCreatedAt);
            final Long _transformedUpdatedAt = ((Long) evaluateAndTransform(this.muleContext, event, HubSpotNewListExpressionHolder.class.getDeclaredField("_updatedAtType").getGenericType(), null, holder.getUpdatedAt()));
            result.setUpdatedAt(_transformedUpdatedAt);
            final Boolean _transformedDynamic = ((Boolean) evaluateAndTransform(this.muleContext, event, HubSpotNewListExpressionHolder.class.getDeclaredField("_dynamicType").getGenericType(), null, holder.getDynamic()));
            result.setDynamic(_transformedDynamic);
            final Boolean _transformedDeleted = ((Boolean) evaluateAndTransform(this.muleContext, event, HubSpotNewListExpressionHolder.class.getDeclaredField("_deletedType").getGenericType(), null, holder.getDeleted()));
            result.setDeleted(_transformedDeleted);
            final String _transformedName = ((String) evaluateAndTransform(this.muleContext, event, HubSpotNewListExpressionHolder.class.getDeclaredField("_nameType").getGenericType(), null, holder.getName()));
            result.setName(_transformedName);
            final Boolean _transformedInternal = ((Boolean) evaluateAndTransform(this.muleContext, event, HubSpotNewListExpressionHolder.class.getDeclaredField("_internalType").getGenericType(), null, holder.getInternal()));
            result.setInternal(_transformedInternal);
            final HubSpotListMetadata _transformedMetaData = ((HubSpotListMetadata) evaluateAndTransform(this.muleContext, event, HubSpotNewListExpressionHolder.class.getDeclaredField("_metaDataType").getGenericType(), null, holder.getMetaData()));
            result.setMetaData(_transformedMetaData);
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
