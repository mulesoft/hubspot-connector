Hubspot Connector Change Log
============================

## [3.0.0] - 2015-11-26
- Added new operation getAllContactsUpdatedAfter that returns all the recent contacts filtered by a waterMark
- Migrate connector to DevKit 3.7.2.

## [2.7] - 2013-04-25
- Added new operation getRecentContactsPaginated that implements Iterable and returns an iterator that handles the Pagination on the background

## [2.6.10] - 2013-04-17
- Added new version of the ObjectStore for Integration Tests. When an object is required from the OS the result is cloned and returned a new instance. This is to simulate the stateless OS from CloudHub.

## [2.6.9] - 2013-04-08
- Minor fix

## [2.6.8] - 2013-04-08
- Minor fix in refresh operation (passed object store instead credentials object)

## [2.6.7] - 2013-04-08
-  The new credentials in the refresh are stored in the ObjectStore

## [2.6.6] - 2013-04-08
-  Added log lines in refresh
- Added synchronization to the refresh operation

## [2.6.5] - 2013-04-03
-  Added new test to check that refresh token is not called again after a successful refresh operation	
- Minor fixes IT tests

## [2.6.4] - 2013-03-26
-  Fixed javadoc for scope. Use space character instead +.
- Added server error messages when operation call fails

## [2.6.3] - 2013-03-13
-  Added refresh token logic. (Requirement: offline scope) If some of the operations throws an HubSpotConnectorAccessTokenExpiredException the connector will try to get a new token using the refresh token and the refresh token endpoint 
- Added IT for the case
- Added new parameter for OAuthCredentials - offlineScope, to know if the scope enables the refresh token functionality

## [2.6.2] - 2013-03-05
- Added new operation createContactList from List API
	
## [2.6.1] - 2013-03-04
- Added new operation addExistingContactInAList form List API
- Added integration tests for new operation

## [2.6] - 2013-03-01
- Added hubId (PortalId) in all the Email API operations as @Optional parameter
- Added new email operation updateEmailSubscriptionStatusUnsubscribeFromAll

## [2.5.1] - 2013-02-28
- Added test for case ObjectStore serialization
- Moved client out of the ObjectStore and gestionated in memory
- Added clientId to the OAuthCredentials

## [2.5] - 2013-02-27
- Added config parameters to the authenticate operation in order to add more Multi Tenancy flexibility
- Minor modifications in the Integration Tests

## [2.4] - 2013-02-19
- Renamed operation from getAllProperties to getAllCustomProperties
- Addded opertaions for all the Custom Properties API

## [2.3.2] - 2013-02-18
- Added support for ObjectStore for storing the credentials. Also a configurable param for defining the Object Store to use (objectStore)

## [2.3.1] - 2013-02-15
- Create Contact returns a Contact entity instead of ContactProperties

## [2.3] - 2013-02-14
- Added operations for all the Email API

## [2.2.2] - 2013-02-14
- Added static method inside ContactPropertiesNumberOfEmployees getValueFrom

## [2.2.1] - 2013-02-06
- Added support for Custom Properties inside Contact. Added Map customProperties.

## [2.2] - 2013-02-06
- Added new Operation for the Contact Properties API: getAllProperties
- Added unit and integration tests

## [2.1] - 2013-02-06
- Added more unit and integration tests
-Changed log level from info to debug (require extra parameters in log4j)
- Changed signature in operations of the Lists API from Strings (JSON Format) to POJOs

## [2.0] - 2013-02-06
- Added integration test for all the Contacts API
- Changed signature in operations of the Contacts API from Strings (JSON Format) to POJOs

## [1.2.2] - 2013-02-06
- Added structure for Integration Tests

## [1.2.1] - 2013-02-05
- Added Unit Test for POJOs transformations

## [1.2] - 2013-02-05
- Created POJOs structure. Does not affect Connector Process signatures neither configuration
- Added custom Serializer/Deserializer for ContactProperties

## [1.1] - 2013-02-05
- Mass refactor. Does not affect Connector Process signatures neither configuration

## [1.0.1] - 2013-02-05
- Added new process Get Contacts in a List
	
## [1.0] - 2013-12-07
- First Release. Alpha version
- Implementation of the Contact API
- OAuth2 implementation through authenticate and authenticateResponse methods (see demo for a example flow)
- Exceptions hierarchy for a easy comprehension of the problems that may occur in the connector
- Responses of the process are in JSON format

