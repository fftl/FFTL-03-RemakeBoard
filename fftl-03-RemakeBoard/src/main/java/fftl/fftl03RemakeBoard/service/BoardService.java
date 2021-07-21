package fftl.fftl03RemakeBoard.service;

import fftl.fftl03RemakeBoard.entity.Board;
import fftl.fftl03RemakeBoard.repository.BoardRepository;
import fftl.fftl03RemakeBoard.request.SaveBoardDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardRepository boardRepository;

    public Board findByBoardId(Long boardId){
        Board board = boardRepository.findById(boardId).orElseThrow();
        return board;
    }

    public Long saveBoard(SaveBoardDto saveBoardDto){
        Board board = boardRepository.save(saveBoardDto.toEntity());
        return board.getBoardId();
    }

    public Long updateBoard(Board board, SaveBoardDto saveBoardDto) {
        board.updateBoard(saveBoardDto);
        return board.getBoardId();
    }

    public boolean deleteBoard(Board board){
        boardRepository.delete(board);
        return true;
    }

}
