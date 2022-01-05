package com.dayz.comment.converter;

import com.dayz.comment.domain.Comment;
import com.dayz.comment.dto.ReadCommentsResult;
import com.dayz.member.domain.Member;
import com.dayz.post.domain.Post;
import org.springframework.stereotype.Component;

@Component
public class CommentConverter {

    public Comment convertToComment(String content, Post post, Member member) {
        return Comment.of(content, post, member);
    }

    public ReadCommentsResult convertToReadCommentsResult(Comment comment) {
        return ReadCommentsResult.of(comment.getContent(), comment.getCreatedAt(),
            convertToMemberResult(comment.getMember()));
    }

    public ReadCommentsResult.MemberResult convertToMemberResult(Member member) {
        return ReadCommentsResult.MemberResult.of(
            member.getUsername(),
            member.getProfileImageUrl()
        );
    }

}
