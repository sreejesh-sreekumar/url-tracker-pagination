package com.nuchange.urltrackerwithpagination.service.impl;

import com.nuchange.urltrackerwithpagination.model.UrlCount;
import com.nuchange.urltrackerwithpagination.repository.UrlRepository;
import com.nuchange.urltrackerwithpagination.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UrlServiceImpl implements UrlService {

  @Autowired UrlRepository repository;

  @Override
  public ResponseEntity saveUrl(String url) {
    if (!url.contains(".")) {
      return new ResponseEntity("Invalid request parameter url", HttpStatus.BAD_REQUEST);
    }
    synchronized (repository) {
      String[] urlArray = url.split("[.]");
      UrlCount uc = new UrlCount(urlArray[0], 0);
      repository.save(uc);
      return new ResponseEntity(HttpStatus.OK);
    }
  }

  @Override
  public String getUrl(String url) {
    if (!url.contains(".")) {
      return "Invalid request parameter url";
    }
    synchronized (repository) {
      String[] urlArray = url.split("[.]");
      Optional<UrlCount> urlCount = repository.findById(urlArray[0]);
      if (urlCount.isPresent()) {
        repository.save(new UrlCount(urlArray[0], urlCount.get().getCount() + 1));
      }
      return urlArray[0];
    }
  }

  @Override
  public int getCount(String url) {

      if (!url.contains(".")) {
          return 0;
      }
      String[] urlArray = url.split("[.]");
      Optional<UrlCount> urlCount = repository.findById(urlArray[0]);
      if(urlCount.isPresent()){
          return urlCount.get().getCount();
      }
      else {
          return 0;
      }
  }

    @Override
    public Page<UrlCount> getAllUrls(Pageable pageable) {
        return repository.findAll(pageable);
    }

}
