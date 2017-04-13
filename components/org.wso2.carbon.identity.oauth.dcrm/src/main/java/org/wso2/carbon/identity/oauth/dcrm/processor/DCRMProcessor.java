package org.wso2.carbon.identity.oauth.dcrm.processor;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.wso2.carbon.identity.application.authentication.framework.inbound.IdentityMessageContext;
import org.wso2.carbon.identity.application.authentication.framework.inbound.IdentityProcessor;
import org.wso2.carbon.identity.application.authentication.framework.inbound.IdentityRequest;
import org.wso2.carbon.identity.application.authentication.framework.inbound.IdentityResponse;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DCRMProcessor extends IdentityProcessor {

    private static Log log = LogFactory.getLog(DCRMProcessor.class);

    @Override
    public IdentityResponse.IdentityResponseBuilder process(IdentityRequest identityRequest){

        log.debug("Request processing started by DCRMProcessor.");
        return null;
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
                    Pattern.compile("(.*)/register/?").matcher(identityRequest.getRequestURI());
            if (registerMatcher.matches()) {
                canHandle = true;
            }
        }
        log.debug("canHandle " + canHandle + " by DCRMProcessor.");

        return canHandle;
    }
}
