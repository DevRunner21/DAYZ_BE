package com.dayz.post.converter;

import com.dayz.member.domain.Member;
import com.dayz.onedayclass.domain.OneDayClass;
import com.dayz.post.domain.Post;
import com.dayz.post.domain.PostImage;
import com.dayz.post.dto.request.RegisterPostRequest;
import com.dayz.post.dto.request.RegisterPostRequest.PostImageParam;
import com.dayz.post.dto.response.ReadPostDetailResponse;
import com.dayz.post.dto.response.ReadPostDetailsResponse;
import com.dayz.post.dto.response.ReadPostsByAtelierResponse;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
@RequiredArgsConstructor
public class PostConverter {

    public Post convertToPost(RegisterPostRequest request, Member member, OneDayClass oneDayClass) {
        return Post.builder()
            .content(request.getContent())
            .member(member)
            .oneDayClass(oneDayClass)
            .postImages(
                request.getImages().stream()
                    .map(this::convertToPostImage)
                    .collect(Collectors.toList())
            )
            .build();
    }

    public PostImage convertToPostImage(PostImageParam postImageParam) {
        return PostImage.builder()
            .sequence(postImageParam.getSequence())
            .imageFileName(postImageParam.getImageUrl())
            .build();
    }

    public ReadPostDetailResponse convertToReadPostDetailResponse(Post post) {
        return ReadPostDetailResponse.of(
            post.getId(),
            post.getContent(),
            post.getPostImages().stream()
                .map(this::convertToReadPostDetailPostImageResult)
                .collect(Collectors.toList()),
            convertToReadPostDetailAtelierResult(post.getMember()),
            post.getOneDayClass().getId(),
            post.getCreatedAt()
        );
    }

    public ReadPostDetailResponse.PostImageResult convertToReadPostDetailPostImageResult(
        PostImage postImage) {
        return ReadPostDetailResponse.PostImageResult.of(
            postImage.getFullImageUrl(),
            postImage.getSequence()
        );
    }

    public ReadPostDetailResponse.AtelierResult convertToReadPostDetailAtelierResult(
        Member member) {
        return ReadPostDetailResponse.AtelierResult.of(
            member.getAtelier().getId(),
            member.getAtelier().getName(),
            member.getProfileImageUrl()
        );
    }

    public ReadPostDetailsResponse.PostDetailResult convertToReadPostDetailsResult(Post post) {
        return ReadPostDetailsResponse.PostDetailResult.of(
            post.getId(),
            post.getContent(),
            post.getPostImages().stream()
                .map(this::convertToReadPostDetailsPostImageResult)
                .collect(Collectors.toList()),
            convertToReadPostDetailsAtelierResult(post.getMember()),
            post.getOneDayClass().getId(),
            post.getCreatedAt()
        );
    }

    public ReadPostDetailsResponse.PostDetailResult.PostImageResult convertToReadPostDetailsPostImageResult(
        PostImage postImage
    ) {
        return ReadPostDetailsResponse.PostDetailResult.PostImageResult.of(
            postImage.getFullImageUrl(),
            postImage.getSequence()
        );
    }

    public ReadPostDetailsResponse.PostDetailResult.AtelierResult convertToReadPostDetailsAtelierResult(
        Member member
    ) {
        return ReadPostDetailsResponse.PostDetailResult.AtelierResult.of(
            member.getAtelier().getId(),
            member.getAtelier().getName(),
            member.getProfileImageUrl()
        );
    }

    public ReadPostsByAtelierResponse.PostResult convertToReadPostsByAtelierAtelierResult(Post post) {
        return ReadPostsByAtelierResponse.PostResult.of(
            post.getId(),
            getFirstImageUrl(post.getPostImages()),
            post.getCreatedAt()
        );
    }

    // TODO: 여러군데 중복코드 발생, 하나로 통합할 필요가 있음.. 이안에서 정렬도 하면 될듯..?
    private String getFirstImageUrl(List<PostImage> postImages) {
        if (Objects.isNull(postImages) || (postImages.size() <= 0)) {
            return null;
        }

        return postImages.get(0).getFullImageUrl();
    }

}
