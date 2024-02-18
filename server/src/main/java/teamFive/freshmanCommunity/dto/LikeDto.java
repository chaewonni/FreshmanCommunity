package teamFive.freshmanCommunity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import teamFive.freshmanCommunity.entity.LikeComment;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LikeDto {
    private String message;
    private boolean status;

    public static LikeDto createLikeDto(String message, LikeComment likeComment) {
        return new LikeDto(
                message,
                likeComment.isStatus()
        );
    }
}
