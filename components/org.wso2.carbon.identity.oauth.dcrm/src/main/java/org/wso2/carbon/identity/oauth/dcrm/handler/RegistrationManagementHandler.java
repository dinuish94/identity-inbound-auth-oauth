package org.wso2.carbon.identity.oauth.dcrm.handler;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.wso2.carbon.identity.application.authentication.framework.inbound.IdentityResponse;
import org.wso2.carbon.identity.oauth.dcr.context.DCRMessageContext;
import org.wso2.carbon.identity.oauth.dcr.model.RegistrationResponse;
import org.wso2.carbon.identity.oauth.dcr.model.RegistrationResponseProfile;
import org.wso2.carbon.identity.oauth.dcrm.model.RegistrationManagementRequest;
import org.wso2.carbon.identity.oauth.dcrm.service.DCRMService;

/**
 * Created by dinukshakandasamanage on 4/13/17.
 */
public class RegistrationManagementHandler {

    private static Log log = LogFactory.getLog(RegistrationManagementHandler.class);

    public IdentityResponse.IdentityResponseBuilder handle(DCRMessageContext dcrMessageContext){
        log.debug("Request processing started by RegistrationManagementHandler.");

        RegistrationManagementRequest registrationManagementRequest = (RegistrationManagementRequest) dcrMessageContext.getIdentityRequest();

        RegistrationResponse.DCRRegisterResponseBuilder dcrRegisterResponseBuilder = null;

        RegistrationResponseProfile registrationResponseProfile =
                DCRMService.getInstance().getApplicationData(registrationManagementRequest.getConsumerKey());

        dcrRegisterResponseBuilder = new RegistrationResponse.DCRRegisterResponseBuilder();
        dcrRegisterResponseBuilder.setRegistrationResponseProfile(registrationResponseProfile);

        return dcrRegisterResponseBuilder;
    }

}
