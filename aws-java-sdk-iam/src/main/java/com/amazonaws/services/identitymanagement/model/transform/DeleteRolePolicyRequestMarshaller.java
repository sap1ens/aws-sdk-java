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
package com.amazonaws.services.identitymanagement.model.transform;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.amazonaws.SdkClientException;
import com.amazonaws.Request;
import com.amazonaws.DefaultRequest;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.services.identitymanagement.model.*;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;
import com.amazonaws.util.IdempotentUtils;

/**
 * DeleteRolePolicyRequest Marshaller
 */

public class DeleteRolePolicyRequestMarshaller implements Marshaller<Request<DeleteRolePolicyRequest>, DeleteRolePolicyRequest> {

    public Request<DeleteRolePolicyRequest> marshall(DeleteRolePolicyRequest deleteRolePolicyRequest) {

        if (deleteRolePolicyRequest == null) {
            throw new SdkClientException("Invalid argument passed to marshall(...)");
        }

        Request<DeleteRolePolicyRequest> request = new DefaultRequest<DeleteRolePolicyRequest>(deleteRolePolicyRequest, "AmazonIdentityManagement");
        request.addParameter("Action", "DeleteRolePolicy");
        request.addParameter("Version", "2010-05-08");
        request.setHttpMethod(HttpMethodName.POST);

        if (deleteRolePolicyRequest.getRoleName() != null) {
            request.addParameter("RoleName", StringUtils.fromString(deleteRolePolicyRequest.getRoleName()));
        }

        if (deleteRolePolicyRequest.getPolicyName() != null) {
            request.addParameter("PolicyName", StringUtils.fromString(deleteRolePolicyRequest.getPolicyName()));
        }

        return request;
    }

}
