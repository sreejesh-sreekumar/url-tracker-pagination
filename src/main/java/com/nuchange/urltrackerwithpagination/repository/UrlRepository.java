package com.nuchange.urltrackerwithpagination.repository;

import com.nuchange.urltrackerwithpagination.model.UrlCount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UrlRepository extends JpaRepository<UrlCount, String> {
}
