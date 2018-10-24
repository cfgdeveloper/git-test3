
package com.landonhotel.demo.data.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.landonhotel.demo.data.entity.Guest;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestRepository extends PagingAndSortingRepository<Guest, Long> {

}