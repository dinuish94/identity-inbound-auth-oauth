package org.wso2.carbon.identity.oauth.dcrm.model;

import org.wso2.carbon.identity.application.authentication.framework.inbound.FrameworkClientException;
import org.wso2.carbon.identity.application.authentication.framework.inbound.FrameworkRuntimeException;
import org.wso2.carbon.identity.application.authentication.framework.inbound.IdentityRequest;
import org.wso2.carbon.identity.oauth.dcr.model.RegistrationRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by dinukshakandasamanage on 4/13/17.
 */
public class RegistrationManagementRequest extends IdentityRequest {

    public RegistrationManagementRequest(RegistrationRequestBuilder builder) throws FrameworkClientException {

        super(builder);

    }

    public static class RegistrationRequestBuilder extends IdentityRequestBuilder {

        public RegistrationRequestBuilder(HttpServletRequest request,
                                          HttpServletResponse response) {
            super(request, response);
        }

        @Override
        public RegistrationManagementRequest build() throws FrameworkRuntimeException, FrameworkClientException {
            return new RegistrationManagementRequest(this);
        }
    }
}
