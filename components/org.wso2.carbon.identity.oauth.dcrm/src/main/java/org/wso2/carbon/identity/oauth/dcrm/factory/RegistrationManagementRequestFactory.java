package org.wso2.carbon.identity.oauth.dcrm.factory;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.ss.formula.functions.Match;
import org.wso2.carbon.identity.application.authentication.framework.inbound.FrameworkClientException;
import org.wso2.carbon.identity.application.authentication.framework.inbound.FrameworkRuntimeException;
import org.wso2.carbon.identity.application.authentication.framework.inbound.HttpIdentityRequestFactory;
import org.wso2.carbon.identity.application.authentication.framework.inbound.IdentityRequest;
import org.wso2.carbon.identity.oauth.dcrm.model.RegistrationManagementRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.HttpMethod;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by dinukshakandasamanage on 4/13/17.
 */
public class RegistrationManagementRequestFactory extends HttpIdentityRequestFactory {

    private static Log log = LogFactory.getLog(RegistrationManagementRequestFactory.class);

    @Override
    public boolean canHandle(HttpServletRequest request, HttpServletResponse response) throws
            FrameworkRuntimeException {
        boolean canHandle = false;
        if (request != null) {
            Matcher matcher = Pattern.compile("(.*)/identity/register/(.+)").matcher(request.getRequestURI());
            if (matcher.matches() && HttpMethod.GET.equals(request.getMethod())) {
                canHandle = true;
            }
        }
        if (log.isDebugEnabled()) {
            log.debug("canHandle " + canHandle + " by RegistrationManagementRequestFactory.");
        }
        return canHandle;
    }

    @Override
    public RegistrationManagementRequest.RegistrationRequestBuilder create(HttpServletRequest request, HttpServletResponse response) throws FrameworkClientException {
        RegistrationManagementRequest.RegistrationRequestBuilder registerRequestBuilder = new
                RegistrationManagementRequest.RegistrationRequestBuilder();
        create(registerRequestBuilder, request, response);
        return registerRequestBuilder;
    }

    @Override
    public void create(IdentityRequest.IdentityRequestBuilder builder, HttpServletRequest request,
                       HttpServletResponse response) throws FrameworkClientException {

        RegistrationManagementRequest.RegistrationRequestBuilder registerRequestBuilder =
                (RegistrationManagementRequest.RegistrationRequestBuilder) builder;

        super.create(registerRequestBuilder, request, response);
        Matcher matcher = Pattern.compile("(.*)/identity/register/(.+)").matcher(request.getRequestURI());
        String consumerKey = null;
        if (matcher.find()) {
            consumerKey = matcher.group(2);
        }

        registerRequestBuilder.setConsumerKey(consumerKey);
    }
}
