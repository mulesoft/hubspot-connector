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