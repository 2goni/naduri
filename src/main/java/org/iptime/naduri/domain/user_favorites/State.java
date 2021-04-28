package org.iptime.naduri.domain.user_favorites;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

//상태정보
@Getter
@RequiredArgsConstructor
public enum State {
    찜, 즐겨찾기, 완료
}
