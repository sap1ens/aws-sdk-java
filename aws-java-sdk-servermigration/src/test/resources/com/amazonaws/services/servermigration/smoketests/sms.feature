# language: en
 @smoke @sms
 Feature: AWS Server Migration Service

   Scenario: Making a request
     When I call the "GetConnectors" API
     Then the request should be successful

   Scenario: Handling errors
     When I attempt to call the "DeleteReplicationJob" API with:
         | ReplicationJobId | invalidId |
     Then I expect the response error code to be "InvalidParameterException"