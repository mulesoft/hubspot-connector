2.6.9
=====
	* Minor fix

2.6.8
=====
	* Minor fix in refresh operation (passed object store instead credentials object)

2.6.7
=====
	* The new credentials in the refresh are stored in the ObjectStore

2.6.6
=====
	* Added log lines in refresh
	* Added synchronization to the refresh operation

2.6.5
=====
	* Added new test to check that refresh token is not called again after a successful refresh operation	
	* Minor fixes IT tests

2.6.4
=====
	* Fixed javadoc for scope. Use space character instead +.
	* Added server error messages when operation call fails

2.6.3
=====
	* Added refresh token logic. (Requirement: offline scope) If some of the operations throws an HubSpotConnectorAccessTokenExpiredException the connector will try to get a new token using the refresh token and the refresh token endpoint 
	* Added IT for the case
	* Added new parameter for OAuthCredentials - offlineScope, to know if the scope enables the refresh token functionality

2.6.2
=====
	* Added new operation createContactList from List API
	
2.6.1
=====
	* Added new operation addExistingContactInAList form List API
	* Added integration tests for new operation

2.6
===
	* Added hubId (PortalId) in all the Email API operations as @Optional parameter
	* Added new email operation updateEmailSubscriptionStatusUnsubscribeFromAll

2.5.1
=====
	* Added test for case ObjectStore serialization
	* Moved client out of the ObjectStore and gestionated in memory
	* Added clientId to the OAuthCredentials

2.5
===
	* Added config parameters to the authenticate operation in order to add more Multi Tenancy flexibility
	* Minor modifications in the Integration Tests

2.4
===
	* Renamed operation from getAllProperties to getAllCustomProperties
	* Addded opertaions for all the Custom Properties API

2.3.2
=====
	* Added support for ObjectStore for storing the credentials. Also a configurable param for defining the Object Store to use (objectStore)

2.3.1
=====
	* Create Contact returns a Contact entity instead of ContactProperties

2.3
===
	* Added operations for all the Email API

2.2.2
=====
	* Added static method inside ContactPropertiesNumberOfEmployees getValueFrom

2.2.1
=====
	* Added support for Custom Properties inside Contact. Added Map customProperties.

2.2
===
	* Added new Operation for the Contact Properties API: getAllProperties
	* Added unit and integration tests

2.1
===
	* Added more unit and integration tests
	* Changed log level from info to debug (require extra parameters in log4j)
	* Changed signature in operations of the Lists API from Strings (JSON Format) to POJOs

2.0
===
	* Added integration test for all the Contacts API
	* Changed signature in operations of the Contacts API from Strings (JSON Format) to POJOs

1.2.2 Beta
==========
	* Added structure for Integration Tests

1.2.1 Beta
==========
	* Added Unit Test for POJOs transformations

1.2 Alpha
=========
	* Created POJOs structure. Does not affect Connector Process signatures neither configuration
	* Added custom Serializer/Deserializer for ContactProperties

1.1 Alpha
=========
	* Mass refactor. Does not affect Connector Process signatures neither configuration

1.0.1 Alpha
===========
	* Added new process Get Contacts in a List
	
1.0 Alpha
=========
    * First Release. Alpha version
    * Implementation of the Contact API
    * OAuth2 implementation through authenticate and authenticateResponse methods (see demo for a example flow)
    * Exceptions hierarchy for a easy comprehension of the problems that may occur in the connector
    * Responses of the process are in JSON format
