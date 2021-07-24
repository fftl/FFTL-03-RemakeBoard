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

    /** 게시글을 생성하는 saveBoard 입니다. */
    public Long saveBoard(SaveBoardDto saveBoardDto){
        Board board = boardRepository.save(saveBoardDto.toEntity());
        return board.getBoardId();
    }

    /** 게시글 하나의 정보를 가져오는 findByBoardId 입니다. */
    public Board findByBoardId(Long boardId){
        Board board = boardRepository.findById(boardId).orElseThrow();
        return board;
    }

    /** 모든 게시글의 정보를 가져오는 findAllBoard 입니다. (목록 부분에 사용)*/
    public List<Board> findAllBoard(){
        List<Board> boards = boardRepository.findAll();
        return boards;
    }

    /** 게시글을 수정하는 updateBoard 입니다.*/
    public Board updateBoard(Board board, SaveBoardDto saveBoardDto) {
        board.updateBoard(saveBoardDto);
        return board;
    }

    /** 게시글을 삭제하는 deleteBoard 입니다. */
    public void deleteBoard(Board board){
        boardRepository.delete(board);
    }

}
