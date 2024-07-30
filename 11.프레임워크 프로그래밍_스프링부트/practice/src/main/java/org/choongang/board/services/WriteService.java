package org.choongang.board.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.choongang.board.controllers.RequestBoard;
import org.choongang.board.entities.BoardData;
import org.choongang.board.repositories.BoardDataRepository;
import org.choongang.member.entities.Member;
import org.choongang.member.repositories.MemberRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Slf4j
@Service
@RequiredArgsConstructor
public class WriteService {

    private final BoardDataRepository boardDataRepository;

    public void write(RequestBoard form) {
        Long seq = form.getSeq();
        BoardData boardData = new ModelMapper().map(form, BoardData.class);
        //Member member = memberRepository.findAllById();
        //멤버 테이블과 조인해서 mSeq를 같이 저장하고 싶다..
        //조회를 해오면 영속성 상태임

        boardDataRepository.saveAndFlush(boardData);
//        boardDataRepository.flush();
    }
}
