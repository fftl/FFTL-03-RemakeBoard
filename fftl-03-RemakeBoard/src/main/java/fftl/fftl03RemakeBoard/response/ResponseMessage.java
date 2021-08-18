package fftl.fftl03RemakeBoard.response;

public class ResponseMessage {

    /**
     * USER
     * */
    public static final String LOGIN_SUCCESS = "로그인 성공";
    public static final String LOGIN_FAIL = "로그인 실패";
    public static final String READ_USER = "회원 정보 조회 성공";
    public static final String NOT_FOUND_USER = "회원을 찾을 수 없습니다.";
    public static final String CREATED_USER = "회원 가입 성공";
    public static final String UPDATE_USER = "회원 정보 수정 성공";
    public static final String DELETE_USER = "회원 탈퇴 성공";

    /**
     * BOARD
     * */
    public static final String GET_ONE_BOARD = "게시글 정보 가져오기 성공";
    public static final String GET_ALL_BOARD = "게시글 모든 정보 가져오기 성공";
    public static final String UPDATE_BOARD = "게시글 정보 수정 성공";
    public static final String DELETE_BOARD = "게시글 삭제 성공";

    public static final String DB_ERROR = "데이터베이스 에러";
    public static final String INTERNAL_SERVER_ERROR = "서버 내부 에러";
}