package com.android.uiclone

object Data {
    val chatData = mutableListOf<Chat>(
        Chat(R.drawable.user, "사람이름","천호동","1달전","안녕하세요 ㅎㅎ",R.drawable.angel),
        Chat(R.drawable.user, "김경식2","천호동","1달전","안녕하세요 ㅎㅎ",R.drawable.angel),
        Chat(R.drawable.user, "김경식3","천호동","1달전","안녕하세요 ㅎㅎ",R.drawable.angel)
    )
    val chatDetail = mutableListOf(
        ChatDetail("사람이름","52.6℃", "거래 완료","자전거","625,000d원",R.drawable.background),
        ChatDetail("김경식2","62.6℃", "거래 완료","고구마","15,000원",R.drawable.background),
        ChatDetail("김경식3","82.6℃", "예약 중","시계","320,000d원",R.drawable.background)
    )
    val chatLogs = mutableListOf(
         arrayListOf(
            ChatLog("채팅1","오후 12:12",1,R.drawable.background),
            ChatLog("채팅2","오후 12:12",2,R.drawable.background),
            ChatLog("채팅3","오후 12:12",1,R.drawable.background),
            ChatLog("채팅4","오후 12:12",2,R.drawable.background)
        ),
        arrayListOf(
            ChatLog("채팅1","오후 12:12",2,R.drawable.background),
            ChatLog("채팅2","오후 12:12",1,R.drawable.background),
            ChatLog("채팅3","오후 12:12",1,R.drawable.background),
            ChatLog("채팅4","오후 12:12",2,R.drawable.background)
        ),
        arrayListOf(
            ChatLog("채팅1","오후 12:12",2,R.drawable.background),
            ChatLog("채팅2","오후 12:12",2,R.drawable.background),
            ChatLog("채팅3","오후 12:12",2,R.drawable.background),
            ChatLog("채팅4","오후 12:12",2,R.drawable.background)
        )
    )
    val communityData = mutableListOf<Community>(
        Community("모임이름1",R.drawable.psa),
        Community("모임이름2",R.drawable.psa),
        Community("모임이름3",R.drawable.psa),
        Community("모임이름4",R.drawable.psa),
        Community("모임이름5",R.drawable.psa),
        Community("모임이름6",R.drawable.psa),
        Community("모임이름7",R.drawable.psa),
        Community("모임이름8",R.drawable.psa),
        Community("모임이름9",R.drawable.psa),
        Community("모임이름10",R.drawable.psa),
        Community("모임이름11",R.drawable.psa),
        Community("모임이름12",R.drawable.psa),
        Community("모임이름13",R.drawable.psa)
    )
    val localLifePostData = mutableListOf<LocalLifePost>(
        LocalLifePost("이름1","2040 배드민턴 소모임",R.drawable.ic_entp, listOf("인기","잡담"),"1에이블짐 천호점 다니시는 분 계시나요~ 같이 운동해요! 같이 다닐 사람이 없어서 심심하네요.","천호동","한달전",35),
        LocalLifePost("이름2","2040 배드민턴 소모임2",R.drawable.ic_entp, listOf("인기","잡담"),"2에이블짐 천호점 다니시는 분 계시나요~ 같이 운동해요! 같이 다닐 사람이 없어서 심심하네요.","천호동","한달전",35),
        LocalLifePost("이름3","2040 배드민턴 소모임3",R.drawable.ic_entp, listOf("인기","잡담"),"3에이블짐 천호점 다니시는 분 계시나요~ 같이 운동해요! 같이 다닐 사람이 없어서 심심하네요.","천호동","한달전",35),
        LocalLifePost("이름4","2040 배드민턴 소모임4",R.drawable.ic_entp, listOf("인기","잡담"),"4에이블짐 천호점 다니시는 분 계시나요~ 같이 운동해요! 같이 다닐 사람이 없어서 심심하네요.","천호동","한달전",35),
        LocalLifePost("이름5","2040 배드민턴 소모임5",R.drawable.ic_entp,listOf("인기","잡담"),"5에이블짐 천호점 다니시는 분 계시나요~ 같이 운동해요! 같이 다닐 사람이 없어서 심심하네요.","천호동","한달전",35),
        LocalLifePost("이름6","2040 배드민턴 소모임6",R.drawable.ic_entp, listOf("인기","잡담"),"6에이블짐 천호점 다니시는 분 계시나요~ 같이 운동해요! 같이 다닐 사람이 없어서 심심하네요.","천호동","한달전",35),
        LocalLifePost("이름7","2040 배드민턴 소모임7",R.drawable.ic_entp, listOf("인기","잡담"),"7에이블짐 천호점 다니시는 분 계시나요~ 같이 운동해요! 같이 다닐 사람이 없어서 심심하네요.","천호동","한달전",35),
        LocalLifePost("이름8","2040 배드민턴 소모임8",R.drawable.ic_entp, listOf("인기","잡담"),"8에이블짐 천호점 다니시는 분 계시나요~ 같이 운동해요! 같이 다닐 사람이 없어서 심심하네요.","천호동","한달전",35)
    )

    val localDetailCommentData = mutableListOf(
        arrayListOf(
            LocalDetailComment("asdf","천호제3동 인증 11회- 19시간 전","이것은 댓글 내용입니다.",R.drawable.psa),
            LocalDetailComment("asdf","천호제3동 인증 11회- 19시간 전","이것은 댓글 내용입니다.",R.drawable.psa),
            LocalDetailComment("asdf","천호제3동 인증 11회- 19시간 전","이것은 댓글 내용입니다.",R.drawable.psa)
        ),
        arrayListOf(
            LocalDetailComment("asdf","천호제3동 인증 11회- 19시간 전","이것은 댓글 내용입니다.",R.drawable.psa),
            LocalDetailComment("asdf","천호제3동 인증 11회- 19시간 전","이것은 댓글 내용입니다.",R.drawable.psa),
            LocalDetailComment("asdf","천호제3동 인증 11회- 19시간 전","이것은 댓글 내용입니다.",R.drawable.psa)
        ),
        arrayListOf(
            LocalDetailComment("asdf","천호제3동 인증 11회- 19시간 전","이것은 댓글 내용입니다.",R.drawable.psa),
            LocalDetailComment("asdf","천호제3동 인증 11회- 19시간 전","이것은 댓글 내용입니다.",R.drawable.psa),
            LocalDetailComment("asdf","천호제3동 인증 11회- 19시간 전","이것은 댓글 내용입니다.",R.drawable.psa)
        ),
        arrayListOf(
            LocalDetailComment("asdf","천호제3동 인증 11회- 19시간 전","이것은 댓글 내용입니다.",R.drawable.psa),
            LocalDetailComment("asdf","천호제3동 인증 11회- 19시간 전","이것은 댓글 내용입니다.",R.drawable.psa),
            LocalDetailComment("asdf","천호제3동 인증 11회- 19시간 전","이것은 댓글 내용입니다.",R.drawable.psa)
        ),
        arrayListOf(
            LocalDetailComment("asdf","천호제3동 인증 11회- 19시간 전","이것은 댓글 내용입니다.",R.drawable.psa),
            LocalDetailComment("asdf","천호제3동 인증 11회- 19시간 전","이것은 댓글 내용입니다.",R.drawable.psa),
            LocalDetailComment("asdf","천호제3동 인증 11회- 19시간 전","이것은 댓글 내용입니다.",R.drawable.psa)
        ),
        arrayListOf(
            LocalDetailComment("asdf","천호제3동 인증 11회- 19시간 전","이것은 댓글 내용입니다.",R.drawable.psa),
            LocalDetailComment("asdf","천호제3동 인증 11회- 19시간 전","이것은 댓글 내용입니다.",R.drawable.psa),
            LocalDetailComment("asdf","천호제3동 인증 11회- 19시간 전","이것은 댓글 내용입니다.",R.drawable.psa)
        ),
        arrayListOf(
            LocalDetailComment("asdf","천호제3동 인증 11회- 19시간 전","이것은 댓글 내용입니다.",R.drawable.psa),
            LocalDetailComment("asdf","천호제3동 인증 11회- 19시간 전","이것은 댓글 내용입니다.",R.drawable.psa),
            LocalDetailComment("asdf","천호제3동 인증 11회- 19시간 전","이것은 댓글 내용입니다.",R.drawable.psa)
        ),
        arrayListOf(
            LocalDetailComment("asdf","천호제3동 인증 11회- 19시간 전","이것은 댓글 내용입니다.",R.drawable.psa),
            LocalDetailComment("asdf","천호제3동 인증 11회- 19시간 전","이것은 댓글 내용입니다.",R.drawable.psa),
            LocalDetailComment("asdf","천호제3동 인증 11회- 19시간 전","이것은 댓글 내용입니다.",R.drawable.psa)
        )

    )



}