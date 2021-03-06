/*
 * Copyright 2014-2019 Amazon.com, Inc. or its affiliates. All Rights Reserved.
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
package com.amazonaws.services.accessanalyzer.model;

import java.io.Serializable;
import javax.annotation.Generated;

import com.amazonaws.AmazonWebServiceRequest;

/**
 * <p>
 * Deletes an archive rule.
 * </p>
 * 
 * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/accessanalyzer-2019-11-01/DeleteArchiveRule" target="_top">AWS
 *      API Documentation</a>
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public class DeleteArchiveRuleRequest extends com.amazonaws.AmazonWebServiceRequest implements Serializable, Cloneable {

    /**
     * <p>
     * The name of the analyzer that was deleted.
     * </p>
     */
    private String analyzerName;
    /**
     * <p>
     * A client token.
     * </p>
     */
    private String clientToken;
    /**
     * <p>
     * The name of the rule to delete.
     * </p>
     */
    private String ruleName;

    /**
     * <p>
     * The name of the analyzer that was deleted.
     * </p>
     * 
     * @param analyzerName
     *        The name of the analyzer that was deleted.
     */

    public void setAnalyzerName(String analyzerName) {
        this.analyzerName = analyzerName;
    }

    /**
     * <p>
     * The name of the analyzer that was deleted.
     * </p>
     * 
     * @return The name of the analyzer that was deleted.
     */

    public String getAnalyzerName() {
        return this.analyzerName;
    }

    /**
     * <p>
     * The name of the analyzer that was deleted.
     * </p>
     * 
     * @param analyzerName
     *        The name of the analyzer that was deleted.
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public DeleteArchiveRuleRequest withAnalyzerName(String analyzerName) {
        setAnalyzerName(analyzerName);
        return this;
    }

    /**
     * <p>
     * A client token.
     * </p>
     * 
     * @param clientToken
     *        A client token.
     */

    public void setClientToken(String clientToken) {
        this.clientToken = clientToken;
    }

    /**
     * <p>
     * A client token.
     * </p>
     * 
     * @return A client token.
     */

    public String getClientToken() {
        return this.clientToken;
    }

    /**
     * <p>
     * A client token.
     * </p>
     * 
     * @param clientToken
     *        A client token.
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public DeleteArchiveRuleRequest withClientToken(String clientToken) {
        setClientToken(clientToken);
        return this;
    }

    /**
     * <p>
     * The name of the rule to delete.
     * </p>
     * 
     * @param ruleName
     *        The name of the rule to delete.
     */

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    /**
     * <p>
     * The name of the rule to delete.
     * </p>
     * 
     * @return The name of the rule to delete.
     */

    public String getRuleName() {
        return this.ruleName;
    }

    /**
     * <p>
     * The name of the rule to delete.
     * </p>
     * 
     * @param ruleName
     *        The name of the rule to delete.
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public DeleteArchiveRuleRequest withRuleName(String ruleName) {
        setRuleName(ruleName);
        return this;
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     *
     * @return A string representation of this object.
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getAnalyzerName() != null)
            sb.append("AnalyzerName: ").append(getAnalyzerName()).append(",");
        if (getClientToken() != null)
            sb.append("ClientToken: ").append(getClientToken()).append(",");
        if (getRuleName() != null)
            sb.append("RuleName: ").append(getRuleName());
        sb.append("}");
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;

        if (obj instanceof DeleteArchiveRuleRequest == false)
            return false;
        DeleteArchiveRuleRequest other = (DeleteArchiveRuleRequest) obj;
        if (other.getAnalyzerName() == null ^ this.getAnalyzerName() == null)
            return false;
        if (other.getAnalyzerName() != null && other.getAnalyzerName().equals(this.getAnalyzerName()) == false)
            return false;
        if (other.getClientToken() == null ^ this.getClientToken() == null)
            return false;
        if (other.getClientToken() != null && other.getClientToken().equals(this.getClientToken()) == false)
            return false;
        if (other.getRuleName() == null ^ this.getRuleName() == null)
            return false;
        if (other.getRuleName() != null && other.getRuleName().equals(this.getRuleName()) == false)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;

        hashCode = prime * hashCode + ((getAnalyzerName() == null) ? 0 : getAnalyzerName().hashCode());
        hashCode = prime * hashCode + ((getClientToken() == null) ? 0 : getClientToken().hashCode());
        hashCode = prime * hashCode + ((getRuleName() == null) ? 0 : getRuleName().hashCode());
        return hashCode;
    }

    @Override
    public DeleteArchiveRuleRequest clone() {
        return (DeleteArchiveRuleRequest) super.clone();
    }

}
