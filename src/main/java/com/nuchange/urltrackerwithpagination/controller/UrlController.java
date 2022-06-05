package com.nuchange.urltrackerwithpagination.controller;

import com.nuchange.urltrackerwithpagination.model.UrlCount;
import com.nuchange.urltrackerwithpagination.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UrlController {

    @Autowired
    UrlService service;
    @GetMapping("/storeurl")
    public ResponseEntity saveUrl(@RequestParam(required = true) String url) {
        return service.saveUrl(url);
    }

    @GetMapping("/get")
    public String getUrl(@RequestParam(required = true) String url) {
        return service.getUrl(url);
    }

    @GetMapping("/count")
    public int getCount(@RequestParam(required = true) String url) {
        return service.getCount(url);
    }

    @GetMapping("/list")
    public Page<UrlCount> getAllUrls(@RequestParam(required = true) int page, @RequestParam(required = true) int size){
        Pageable pageable = PageRequest.of(0, 10);
        Page<UrlCount> pageUrlCount = service.getAllUrls(pageable);
        return pageUrlCount;
    }
}
