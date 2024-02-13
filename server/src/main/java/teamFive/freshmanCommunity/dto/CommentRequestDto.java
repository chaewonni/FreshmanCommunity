package teamFive.freshmanCommunity.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class CommentRequestDto {    //댓글 요청시 들어오는 body
    private Long id;    //commentId
    private String content;
}
