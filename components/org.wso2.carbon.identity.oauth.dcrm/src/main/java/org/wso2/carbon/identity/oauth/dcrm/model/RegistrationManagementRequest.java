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

    private String consumerKey;

    public RegistrationManagementRequest(RegistrationRequestBuilder builder) throws FrameworkClientException {

        super(builder);
        this.consumerKey = builder.consumerKey;
    }

    public String getConsumerKey() {
        return consumerKey;
    }

    public void setConsumerKey(String consumerKey) {
        this.consumerKey = consumerKey;
    }

    public static class RegistrationRequestBuilder extends IdentityRequestBuilder {

        private String consumerKey;

        public void setConsumerKey(String consumerKey) {
            this.consumerKey = consumerKey;
        }

        public RegistrationManagementRequest build() throws FrameworkClientException {
            return new RegistrationManagementRequest(this);
        }
//        public RegistrationRequestBuilder(HttpServletRequest request,
//                                          HttpServletResponse response) {
//            super(request, response);
//        }
//
//        @Override
//        public RegistrationManagementRequest build() throws FrameworkRuntimeException, FrameworkClientException {
//            return new RegistrationManagementRequest(this);
//        }
    }
}
