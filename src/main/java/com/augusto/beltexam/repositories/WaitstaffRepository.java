package com.augusto.beltexam.repositories;

import org.springframework.stereotype.Repository;

import com.augusto.beltexam.models.Waitstaff;

@Repository
public interface WaitstaffRepository extends BaseRepository<Waitstaff>{
    Waitstaff findByEmail(String email);
}
