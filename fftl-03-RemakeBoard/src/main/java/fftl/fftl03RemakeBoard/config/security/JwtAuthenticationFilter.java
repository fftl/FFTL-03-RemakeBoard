package fftl.fftl03RemakeBoard.config.security;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class JwtAuthenticationFilter {
    private final JwtTokenProvider jwtTokenProvider;


}
