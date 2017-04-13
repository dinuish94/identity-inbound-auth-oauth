package org.wso2.carbon.identity.oauth.dcrm.service;

import org.apache.commons.lang.StringUtils;
import org.wso2.carbon.identity.oauth.IdentityOAuthAdminException;
import org.wso2.carbon.identity.oauth.OAuthAdminService;
import org.wso2.carbon.identity.oauth.dcr.model.RegistrationResponseProfile;
import org.wso2.carbon.identity.oauth.dto.OAuthConsumerAppDTO;

import java.util.Arrays;

/**
 * Created by dinukshakandasamanage on 4/13/17.
 */
public class DCRMService {
    private static DCRMService dcrManagementService = new DCRMService();

    private DCRMService() {
    }

    public static DCRMService getInstance() {
        return DCRMService.dcrManagementService;
    }

    public RegistrationResponseProfile getApplicationData(String consumerKey){
        OAuthAdminService oAuthAdminService = new OAuthAdminService();
        RegistrationResponseProfile registrationResponseProfile = new RegistrationResponseProfile();
        try {
            OAuthConsumerAppDTO app = oAuthAdminService.getOAuthApplicationData(consumerKey);
            registrationResponseProfile.setClientId(app.getOauthConsumerKey());
            registrationResponseProfile.getRedirectUrls().add(app.getCallbackUrl());
            registrationResponseProfile.setClientSecret(app.getOauthConsumerSecret());
            registrationResponseProfile.setClientName(app.getApplicationName());
            if (StringUtils.isNotBlank(app.getGrantTypes())) {
                String[] split = app.getGrantTypes().split(" ");
                registrationResponseProfile.setGrantTypes(Arrays.asList(split));
            }
        } catch (IdentityOAuthAdminException e) {
            e.printStackTrace();
        }
        return registrationResponseProfile;
    }
}
