package com.nuchange.urltrackerwithpagination;

import com.nuchange.urltrackerwithpagination.repository.UrlRepository;
import com.nuchange.urltrackerwithpagination.service.UrlService;
import com.nuchange.urltrackerwithpagination.service.impl.UrlServiceImpl;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class UrlTrackerWithPaginationApplicationTests {

	protected UrlService service;

	@Autowired
	UrlRepository repository;
	@BeforeEach
	public void setUp(){
		service = new UrlServiceImpl();
	}

}
