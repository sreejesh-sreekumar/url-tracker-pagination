package com.nuchange.urltrackerwithpagination.service;

import com.nuchange.urltrackerwithpagination.model.UrlCount;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;



public interface UrlService {

    public ResponseEntity saveUrl(String url);

    public String getUrl(String url);

    public int getCount(String url);

    public Page<UrlCount> getAllUrls(Pageable pageable);
}
