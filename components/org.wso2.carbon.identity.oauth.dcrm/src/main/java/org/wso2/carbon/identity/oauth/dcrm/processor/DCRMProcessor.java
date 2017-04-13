package org.wso2.carbon.identity.oauth.dcrm.processor;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.wso2.carbon.identity.application.authentication.framework.inbound.IdentityMessageContext;
import org.wso2.carbon.identity.application.authentication.framework.inbound.IdentityProcessor;
import org.wso2.carbon.identity.application.authentication.framework.inbound.IdentityRequest;
import org.wso2.carbon.identity.application.authentication.framework.inbound.IdentityResponse;
import org.wso2.carbon.identity.oauth.dcr.context.DCRMessageContext;
import org.wso2.carbon.identity.oauth.dcr.handler.RegistrationHandler;
import org.wso2.carbon.identity.oauth.dcr.model.RegistrationRequest;
import org.wso2.carbon.identity.oauth.dcr.model.UnregistrationRequest;
import org.wso2.carbon.identity.oauth.dcr.util.HandlerManager;
import org.wso2.carbon.identity.oauth.dcrm.handler.RegistrationManagementHandler;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DCRMProcessor extends IdentityProcessor {

    private static Log log = LogFactory.getLog(DCRMProcessor.class);

    @Override
    public IdentityResponse.IdentityResponseBuilder process(IdentityRequest identityRequest){

        log.debug("Request processing started by DCRMProcessor.");
        DCRMessageContext dcrMessageContext = new DCRMessageContext(identityRequest);
        IdentityResponse.IdentityResponseBuilder identityResponseBuilder = new RegistrationManagementHandler().handle(dcrMessageContext);
        return identityResponseBuilder;
    }

    @Override
    public String getCallbackPath(IdentityMessageContext context) {
        return null;
    }

    @Override
    public String getRelyingPartyId() {
        return null;
    }

    @Override
    public String getRelyingPartyId(IdentityMessageContext identityMessageContext) {
        return null;
    }

    @Override
    public boolean canHandle(IdentityRequest identityRequest) {
        boolean canHandle = false;
        if (identityRequest != null) {
            Matcher registerMatcher =
                    Pattern.compile("(.*)/identity/register/(.+)").matcher(identityRequest.getRequestURI());
            if (registerMatcher.matches() && identityRequest.getMethod().equals("GET")) {
                canHandle = true;
            }
        }
        log.debug("canHandle " + canHandle + " by DCRMProcessor.");

        return canHandle;
    }
}
