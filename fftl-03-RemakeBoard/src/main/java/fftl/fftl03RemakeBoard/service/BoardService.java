package fftl.fftl03RemakeBoard.service;

import fftl.fftl03RemakeBoard.entity.Board;
import fftl.fftl03RemakeBoard.repository.BoardRepository;
import fftl.fftl03RemakeBoard.request.SaveBoardDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardRepository boardRepository;

    public Board findByBoardId(Long boardId){
        Board board = boardRepository.findById(boardId).orElseThrow();
        return board;
    }

    public List<Board> findAllBoard(){
        List<Board> boards = boardRepository.findAll();
        return boards;
    }

    public Long saveBoard(SaveBoardDto saveBoardDto){
        Board board = boardRepository.save(saveBoardDto.toEntity());
        return board.getBoardId();
    }

    public Board updateBoard(Board board, SaveBoardDto saveBoardDto) {
        board.updateBoard(saveBoardDto);
        return board;
    }

    public void deleteBoard(Board board){
        boardRepository.delete(board);
    }

}
