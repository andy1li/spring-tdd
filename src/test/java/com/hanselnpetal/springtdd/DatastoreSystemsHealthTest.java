package com.hanselnpetal.springtdd;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import java.sql.DatabaseMetaData;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class DatastoreSystemsHealthTest {

	@Autowired
	DataSource dataSource;
	
	@Test
	public void dbPrimaryIsOk() {
		try {
			DatabaseMetaData metadata = dataSource.getConnection().getMetaData();
			String catalogName = dataSource.getConnection().getCatalog();
			
			assertThat(metadata, is(notNullValue()));
			assertThat(catalogName, is(equalTo("spring_tdd")));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
