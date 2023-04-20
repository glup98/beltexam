package com.augusto.beltexam.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.augusto.beltexam.models.Board;
import com.augusto.beltexam.models.Waitstaff;

@Repository
public interface BoardRepository extends BaseRepository<Board>{
    List<Board> findByWaitstaff(Waitstaff waitstaff);
    
    @Query("SELECT b FROM Board b WHERE b.waitstaff IS NULL")
    List<Board> findBoardsWithoutWaitstaff();
}
