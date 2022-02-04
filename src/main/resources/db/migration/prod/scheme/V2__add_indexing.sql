CREATE
INDEX index_address_city_id_region_id ON address (city_id, region_id);

CREATE
INDEX index_onedayclass_name ON onedayclass (name);

CREATE
INDEX index_curriculum_step ON curriculum (step);

CREATE
INDEX index_onedayclass_time_step ON onedayclass_time (class_date);


-- 각 이미지 테이블에 sequence 기준으로 Indexing
CREATE
INDEX index_onedayclass_iamge_sequence ON onedayclass_iamge (sequence);

CREATE
INDEX index_post_image_sequence ON post_image (sequence);

CREATE
INDEX index_review_image_sequence ON review_image (sequence);


-- createdAt 기준으로 Indexing
CREATE
INDEX index_atelier_created_at ON atelier (created_at);

CREATE
INDEX index_comment_created_at ON comment (created_at);

CREATE
INDEX index_follow_created_at ON follow (created_at);

CREATE
INDEX index_member_created_at ON member (created_at);

CREATE
INDEX index_onedayclass_created_at ON onedayclass (created_at);

CREATE
INDEX index_post_created_at ON post (created_at);

CREATE
INDEX index_reservation_created_at ON reservation (created_at);

CREATE
INDEX index_review_created_at ON review (created_at);
