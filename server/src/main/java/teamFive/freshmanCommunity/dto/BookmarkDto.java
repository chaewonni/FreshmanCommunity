package teamFive.freshmanCommunity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import teamFive.freshmanCommunity.entity.Bookmark;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookmarkDto {
    private String message;
    private boolean status;

    public static BookmarkDto createBookmarkDto(String message, Bookmark bookmark) {
        return new BookmarkDto(
                message,
                bookmark.isStatus()
        );
    }
}
