/*
 * Copyright 2011-2016 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"). You may not use this file except in compliance with
 * the License. A copy of the License is located at
 * 
 * http://aws.amazon.com/apache2.0
 * 
 * or in the "license" file accompanying this file. This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
 * CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions
 * and limitations under the License.
 */
package com.amazonaws.services.elasticloadbalancing.model.transform;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.amazonaws.SdkClientException;
import com.amazonaws.Request;
import com.amazonaws.DefaultRequest;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.services.elasticloadbalancing.model.*;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;
import com.amazonaws.util.IdempotentUtils;

/**
 * ApplySecurityGroupsToLoadBalancerRequest Marshaller
 */

public class ApplySecurityGroupsToLoadBalancerRequestMarshaller implements
        Marshaller<Request<ApplySecurityGroupsToLoadBalancerRequest>, ApplySecurityGroupsToLoadBalancerRequest> {

    public Request<ApplySecurityGroupsToLoadBalancerRequest> marshall(ApplySecurityGroupsToLoadBalancerRequest applySecurityGroupsToLoadBalancerRequest) {

        if (applySecurityGroupsToLoadBalancerRequest == null) {
            throw new SdkClientException("Invalid argument passed to marshall(...)");
        }

        Request<ApplySecurityGroupsToLoadBalancerRequest> request = new DefaultRequest<ApplySecurityGroupsToLoadBalancerRequest>(
                applySecurityGroupsToLoadBalancerRequest, "AmazonElasticLoadBalancing");
        request.addParameter("Action", "ApplySecurityGroupsToLoadBalancer");
        request.addParameter("Version", "2012-06-01");
        request.setHttpMethod(HttpMethodName.POST);

        if (applySecurityGroupsToLoadBalancerRequest.getLoadBalancerName() != null) {
            request.addParameter("LoadBalancerName", StringUtils.fromString(applySecurityGroupsToLoadBalancerRequest.getLoadBalancerName()));
        }

        com.amazonaws.internal.SdkInternalList<String> securityGroupsList = (com.amazonaws.internal.SdkInternalList<String>) applySecurityGroupsToLoadBalancerRequest
                .getSecurityGroups();
        if (!securityGroupsList.isEmpty() || !securityGroupsList.isAutoConstruct()) {
            int securityGroupsListIndex = 1;

            for (String securityGroupsListValue : securityGroupsList) {
                if (securityGroupsListValue != null) {
                    request.addParameter("SecurityGroups.member." + securityGroupsListIndex, StringUtils.fromString(securityGroupsListValue));
                }
                securityGroupsListIndex++;
            }
        }

        return request;
    }

}
