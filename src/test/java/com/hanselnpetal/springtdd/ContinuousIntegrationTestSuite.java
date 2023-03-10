package com.hanselnpetal.springtdd;

import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SelectClasses;

import com.hanselnpetal.springtdd.controller.ContactsManagementControllerIntegrationTest;
import com.hanselnpetal.springtdd.data.repos.CustomerContactRepositoryIntegrationTest;
import com.hanselnpetal.springtdd.service.ContactsManagementServiceIntegrationTest;

@Suite
@SelectClasses({
	DatastoreSystemsHealthTest.class,
	ContactsManagementServiceIntegrationTest.class,
	ContactsManagementControllerIntegrationTest.class,
	CustomerContactRepositoryIntegrationTest.class
})
public class ContinuousIntegrationTestSuite {}
