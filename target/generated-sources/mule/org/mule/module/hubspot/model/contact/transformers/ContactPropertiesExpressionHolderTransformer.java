
package org.mule.module.hubspot.model.contact.transformers;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
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
import org.mule.module.hubspot.model.contact.ContactProperties;
import org.mule.module.hubspot.model.contact.ContactPropertiesLifecycleStage;
import org.mule.module.hubspot.model.contact.ContactPropertiesNumberOfEmployees;
import org.mule.module.hubspot.model.contact.holders.ContactPropertiesExpressionHolder;
import org.mule.transformer.types.DataTypeFactory;
import org.mule.transport.NullPayload;
import org.mule.util.TemplateParser;

@SuppressWarnings("all")
@Generated(value = "Mule DevKit Version 3.7.2", date = "2015-12-11T05:23:24-03:00", comments = "Build 3.7.x.2633.51164b9")
public class ContactPropertiesExpressionHolderTransformer
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
        return (aClass == ContactPropertiesExpressionHolder.class);
    }

    public boolean isSourceDataTypeSupported(DataType<?> dataType) {
        return (dataType.getType() == ContactPropertiesExpressionHolder.class);
    }

    public List<Class<?>> getSourceTypes() {
        return Arrays.asList(new Class<?> [] {ContactPropertiesExpressionHolder.class });
    }

    public List<DataType<?>> getSourceDataTypes() {
        return Arrays.asList(new DataType<?> [] {DataTypeFactory.create(ContactPropertiesExpressionHolder.class)});
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
        return ContactProperties.class;
    }

    public void setReturnDataType(DataType<?> type) {
        throw new UnsupportedOperationException();
    }

    public DataType<?> getReturnDataType() {
        return DataTypeFactory.create(ContactProperties.class);
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
        ContactPropertiesExpressionHolder holder = ((ContactPropertiesExpressionHolder) src);
        ContactProperties result = new ContactProperties();
        try {
            final String _transformedFirstname = ((String) evaluateAndTransform(this.muleContext, event, ContactPropertiesExpressionHolder.class.getDeclaredField("_firstnameType").getGenericType(), null, holder.getFirstname()));
            result.setFirstname(_transformedFirstname);
            final String _transformedLastname = ((String) evaluateAndTransform(this.muleContext, event, ContactPropertiesExpressionHolder.class.getDeclaredField("_lastnameType").getGenericType(), null, holder.getLastname()));
            result.setLastname(_transformedLastname);
            final String _transformedSalutation = ((String) evaluateAndTransform(this.muleContext, event, ContactPropertiesExpressionHolder.class.getDeclaredField("_salutationType").getGenericType(), null, holder.getSalutation()));
            result.setSalutation(_transformedSalutation);
            final String _transformedEmail = ((String) evaluateAndTransform(this.muleContext, event, ContactPropertiesExpressionHolder.class.getDeclaredField("_emailType").getGenericType(), null, holder.getEmail()));
            result.setEmail(_transformedEmail);
            final String _transformedPhone = ((String) evaluateAndTransform(this.muleContext, event, ContactPropertiesExpressionHolder.class.getDeclaredField("_phoneType").getGenericType(), null, holder.getPhone()));
            result.setPhone(_transformedPhone);
            final String _transformedFax = ((String) evaluateAndTransform(this.muleContext, event, ContactPropertiesExpressionHolder.class.getDeclaredField("_faxType").getGenericType(), null, holder.getFax()));
            result.setFax(_transformedFax);
            final String _transformedAddress = ((String) evaluateAndTransform(this.muleContext, event, ContactPropertiesExpressionHolder.class.getDeclaredField("_addressType").getGenericType(), null, holder.getAddress()));
            result.setAddress(_transformedAddress);
            final String _transformedCity = ((String) evaluateAndTransform(this.muleContext, event, ContactPropertiesExpressionHolder.class.getDeclaredField("_cityType").getGenericType(), null, holder.getCity()));
            result.setCity(_transformedCity);
            final String _transformedState = ((String) evaluateAndTransform(this.muleContext, event, ContactPropertiesExpressionHolder.class.getDeclaredField("_stateType").getGenericType(), null, holder.getState()));
            result.setState(_transformedState);
            final String _transformedZip = ((String) evaluateAndTransform(this.muleContext, event, ContactPropertiesExpressionHolder.class.getDeclaredField("_zipType").getGenericType(), null, holder.getZip()));
            result.setZip(_transformedZip);
            final String _transformedCountry = ((String) evaluateAndTransform(this.muleContext, event, ContactPropertiesExpressionHolder.class.getDeclaredField("_countryType").getGenericType(), null, holder.getCountry()));
            result.setCountry(_transformedCountry);
            final String _transformedJobtitle = ((String) evaluateAndTransform(this.muleContext, event, ContactPropertiesExpressionHolder.class.getDeclaredField("_jobtitleType").getGenericType(), null, holder.getJobtitle()));
            result.setJobtitle(_transformedJobtitle);
            final String _transformedMessage = ((String) evaluateAndTransform(this.muleContext, event, ContactPropertiesExpressionHolder.class.getDeclaredField("_messageType").getGenericType(), null, holder.getMessage()));
            result.setMessage(_transformedMessage);
            final Long _transformedClosedate = ((Long) evaluateAndTransform(this.muleContext, event, ContactPropertiesExpressionHolder.class.getDeclaredField("_closedateType").getGenericType(), null, holder.getClosedate()));
            result.setClosedate(_transformedClosedate);
            final ContactPropertiesLifecycleStage _transformedLifecyclestage = ((ContactPropertiesLifecycleStage) evaluateAndTransform(this.muleContext, event, ContactPropertiesExpressionHolder.class.getDeclaredField("_lifecyclestageType").getGenericType(), null, holder.getLifecyclestage()));
            result.setLifecyclestage(_transformedLifecyclestage);
            final String _transformedCompany = ((String) evaluateAndTransform(this.muleContext, event, ContactPropertiesExpressionHolder.class.getDeclaredField("_companyType").getGenericType(), null, holder.getCompany()));
            result.setCompany(_transformedCompany);
            final String _transformedWebsite = ((String) evaluateAndTransform(this.muleContext, event, ContactPropertiesExpressionHolder.class.getDeclaredField("_websiteType").getGenericType(), null, holder.getWebsite()));
            result.setWebsite(_transformedWebsite);
            final ContactPropertiesNumberOfEmployees _transformedNumemployees = ((ContactPropertiesNumberOfEmployees) evaluateAndTransform(this.muleContext, event, ContactPropertiesExpressionHolder.class.getDeclaredField("_numemployeesType").getGenericType(), null, holder.getNumemployees()));
            result.setNumemployees(_transformedNumemployees);
            final Long _transformedAnnualrevenue = ((Long) evaluateAndTransform(this.muleContext, event, ContactPropertiesExpressionHolder.class.getDeclaredField("_annualrevenueType").getGenericType(), null, holder.getAnnualrevenue()));
            result.setAnnualrevenue(_transformedAnnualrevenue);
            final String _transformedIndustry = ((String) evaluateAndTransform(this.muleContext, event, ContactPropertiesExpressionHolder.class.getDeclaredField("_industryType").getGenericType(), null, holder.getIndustry()));
            result.setIndustry(_transformedIndustry);
            final String _transformedTwitterhandle = ((String) evaluateAndTransform(this.muleContext, event, ContactPropertiesExpressionHolder.class.getDeclaredField("_twitterhandleType").getGenericType(), null, holder.getTwitterhandle()));
            result.setTwitterhandle(_transformedTwitterhandle);
            final String _transformedTwitterprofilephoto = ((String) evaluateAndTransform(this.muleContext, event, ContactPropertiesExpressionHolder.class.getDeclaredField("_twitterprofilephotoType").getGenericType(), null, holder.getTwitterprofilephoto()));
            result.setTwitterprofilephoto(_transformedTwitterprofilephoto);
            final Map<String, String> _transformedCustomProperties = ((Map<String, String> ) evaluateAndTransform(this.muleContext, event, ContactPropertiesExpressionHolder.class.getDeclaredField("_customPropertiesType").getGenericType(), null, holder.getCustomProperties()));
            result.setCustomProperties(_transformedCustomProperties);
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
