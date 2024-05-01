package com.site.news;
import com.site.news.model.Comment;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CommentMapper {
    @Mapping(source = "user.username", target = "userMail")
    CommentDto toCommentDto(Comment comment);

    List<CommentDto> toCommentDto(List<Comment> comments);
}
