package com.augusto.beltexam.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.augusto.beltexam.models.Board;
import com.augusto.beltexam.models.Waitstaff;
import com.augusto.beltexam.repositories.BoardRepository;

@Service
public class BoardService extends BaseService<Board>{

    private final BoardRepository boardRepository;
    
    public BoardService(BoardRepository boardRepository) {
        super(boardRepository);
        this.boardRepository = boardRepository;
    }
    
    public List<Board> findBoardsByWaitstaff(Waitstaff waitstaff) {
        return boardRepository.findByWaitstaff(waitstaff);
    }

    //Borrar una mesa si encuentra el id
    public void deleteBoard(Long boardId) {
        Board board = findById(boardId);
        if (board !=null) {
            boardRepository.deleteById(boardId);
        }
    }

    //Editar una mesa
    public Board updateBoard(Long boardId, String guestName, int numberOfGuests, String note) {
        Optional <Board> board = boardRepository.findById(boardId);
        if(board.isPresent()) {
            board.get().setGuestName(guestName);
            board.get().setNumberOfGuests(numberOfGuests);
            board.get().setNote(note);    
        return boardRepository.save(board.get());
        }
        else{
            return null;        
        }
    }

    public Board pickUpBoard(Long boardId, Waitstaff waitstaff) {
        Optional <Board> board = boardRepository.findById(boardId);
        if(board.isPresent()) {
            board.get().setWaitstaff(waitstaff);  
        return boardRepository.save(board.get());
        }
        else{
            return null;        
        }
    }

    public List<Board> findBoardsWithoutWaitstaff(){
        return boardRepository.findBoardsWithoutWaitstaff();
    }
}
