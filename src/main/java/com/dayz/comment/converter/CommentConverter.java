package com.dayz.comment.converter;

import com.dayz.comment.domain.Comment;
import com.dayz.comment.dto.response.ReadCommentsResponse;
import com.dayz.member.domain.Member;
import com.dayz.post.domain.Post;
import org.springframework.stereotype.Component;

@Component
public class CommentConverter {

    public Comment convertToComment(String content, Post post, Member member) {
        return Comment.of(content, post, member);
    }

    public ReadCommentsResponse.CommentResult convertToReadCommentsResult(Comment comment) {
        return ReadCommentsResponse.CommentResult.of(
            comment.getContent(),
            comment.getCreatedAt(),
            convertToReadCommentsMemberResult(comment.getMember())
        );
    }

    public ReadCommentsResponse.MemberResult convertToReadCommentsMemberResult(Member member) {
        return ReadCommentsResponse.MemberResult.of(
            member.getUsername(),
            member.getProfileImageUrl()
        );
    }

}
