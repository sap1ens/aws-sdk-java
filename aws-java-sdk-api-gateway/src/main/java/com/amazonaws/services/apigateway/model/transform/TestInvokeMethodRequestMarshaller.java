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
package com.amazonaws.services.apigateway.model.transform;

import static com.amazonaws.util.StringUtils.UTF8;
import static com.amazonaws.util.StringUtils.COMMA_SEPARATOR;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.regex.Pattern;

import com.amazonaws.SdkClientException;
import com.amazonaws.Request;
import com.amazonaws.DefaultRequest;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.services.apigateway.model.*;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.BinaryUtils;
import com.amazonaws.util.StringUtils;
import com.amazonaws.util.IdempotentUtils;
import com.amazonaws.util.StringInputStream;
import com.amazonaws.util.SdkHttpUtils;
import com.amazonaws.protocol.json.*;

/**
 * TestInvokeMethodRequest Marshaller
 */
public class TestInvokeMethodRequestMarshaller implements Marshaller<Request<TestInvokeMethodRequest>, TestInvokeMethodRequest> {

    private final SdkJsonProtocolFactory protocolFactory;

    public TestInvokeMethodRequestMarshaller(SdkJsonProtocolFactory protocolFactory) {
        this.protocolFactory = protocolFactory;
    }

    public Request<TestInvokeMethodRequest> marshall(TestInvokeMethodRequest testInvokeMethodRequest) {

        if (testInvokeMethodRequest == null) {
            throw new SdkClientException("Invalid argument passed to marshall(...)");
        }

        Request<TestInvokeMethodRequest> request = new DefaultRequest<TestInvokeMethodRequest>(testInvokeMethodRequest, "AmazonApiGateway");

        request.setHttpMethod(HttpMethodName.POST);

        String uriResourcePath = "/restapis/{restapi_id}/resources/{resource_id}/methods/{http_method}";

        uriResourcePath = uriResourcePath
                .replace(
                        "{restapi_id}",
                        (testInvokeMethodRequest.getRestApiId() != null) ? SdkHttpUtils.urlEncode(
                                StringUtils.fromString(testInvokeMethodRequest.getRestApiId()), false) : "");
        uriResourcePath = uriResourcePath.replace(
                "{resource_id}",
                (testInvokeMethodRequest.getResourceId() != null) ? SdkHttpUtils.urlEncode(StringUtils.fromString(testInvokeMethodRequest.getResourceId()),
                        false) : "");
        uriResourcePath = uriResourcePath.replace(
                "{http_method}",
                (testInvokeMethodRequest.getHttpMethod() != null) ? SdkHttpUtils.urlEncode(StringUtils.fromString(testInvokeMethodRequest.getHttpMethod()),
                        false) : "");
        request.setResourcePath(uriResourcePath);

        try {
            final StructuredJsonGenerator jsonGenerator = protocolFactory.createGenerator();
            jsonGenerator.writeStartObject();

            if (testInvokeMethodRequest.getPathWithQueryString() != null) {
                jsonGenerator.writeFieldName("pathWithQueryString").writeValue(testInvokeMethodRequest.getPathWithQueryString());
            }
            if (testInvokeMethodRequest.getBody() != null) {
                jsonGenerator.writeFieldName("body").writeValue(testInvokeMethodRequest.getBody());
            }

            java.util.Map<String, String> headersMap = testInvokeMethodRequest.getHeaders();
            if (headersMap != null) {
                jsonGenerator.writeFieldName("headers");
                jsonGenerator.writeStartObject();

                for (Map.Entry<String, String> headersMapValue : headersMap.entrySet()) {
                    if (headersMapValue.getValue() != null) {
                        jsonGenerator.writeFieldName(headersMapValue.getKey());

                        jsonGenerator.writeValue(headersMapValue.getValue());
                    }
                }
                jsonGenerator.writeEndObject();
            }
            if (testInvokeMethodRequest.getClientCertificateId() != null) {
                jsonGenerator.writeFieldName("clientCertificateId").writeValue(testInvokeMethodRequest.getClientCertificateId());
            }

            java.util.Map<String, String> stageVariablesMap = testInvokeMethodRequest.getStageVariables();
            if (stageVariablesMap != null) {
                jsonGenerator.writeFieldName("stageVariables");
                jsonGenerator.writeStartObject();

                for (Map.Entry<String, String> stageVariablesMapValue : stageVariablesMap.entrySet()) {
                    if (stageVariablesMapValue.getValue() != null) {
                        jsonGenerator.writeFieldName(stageVariablesMapValue.getKey());

                        jsonGenerator.writeValue(stageVariablesMapValue.getValue());
                    }
                }
                jsonGenerator.writeEndObject();
            }

            jsonGenerator.writeEndObject();

            byte[] content = jsonGenerator.getBytes();
            request.setContent(new ByteArrayInputStream(content));
            request.addHeader("Content-Length", Integer.toString(content.length));
            if (!request.getHeaders().containsKey("Content-Type")) {
                request.addHeader("Content-Type", protocolFactory.getContentType());
            }
        } catch (Throwable t) {
            throw new SdkClientException("Unable to marshall request to JSON: " + t.getMessage(), t);
        }

        return request;
    }

}
