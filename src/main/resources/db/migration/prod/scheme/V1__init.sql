## Create Tables
CREATE TABLE address
(
    address_id  BIGINT   NOT NULL AUTO_INCREMENT,
    created_at  DATETIME NOT NULL,
    updated_at  DATETIME,
    use_flag    BIT      NOT NULL,
    city_id     BIGINT,
    city_name   VARCHAR(255),
    region_id   BIGINT,
    region_name VARCHAR(255),
    PRIMARY KEY (address_id)
) ENGINE = InnoDB;

CREATE TABLE atelier
(
    atelier_id      BIGINT       NOT NULL AUTO_INCREMENT,
    created_at      DATETIME     NOT NULL,
    updated_at      DATETIME,
    use_flag        BIT          NOT NULL,
    business_number VARCHAR(20)  NOT NULL,
    call_number     VARCHAR(20),
    address_detail  VARCHAR(255) NOT NULL,
    intro           VARCHAR(1000),
    name            VARCHAR(50)  NOT NULL,
    work_end_time   BIGINT,
    work_start_time BIGINT,
    address_id      BIGINT,
    member_id       BIGINT,
    PRIMARY KEY (atelier_id)
) ENGINE = InnoDB;

CREATE TABLE category
(
    category_id BIGINT      NOT NULL AUTO_INCREMENT,
    created_at  DATETIME    NOT NULL,
    updated_at  DATETIME,
    use_flag    BIT         NOT NULL,
    name        VARCHAR(50) NOT NULL,
    PRIMARY KEY (category_id)
) ENGINE = InnoDB;

CREATE TABLE comment
(
    comment_id BIGINT   NOT NULL AUTO_INCREMENT,
    created_at DATETIME NOT NULL,
    updated_at DATETIME,
    use_flag   BIT      NOT NULL,
    content    VARCHAR(1000),
    member_id  BIGINT,
    post_id    BIGINT,
    PRIMARY KEY (comment_id)
) ENGINE = InnoDB;

CREATE TABLE curriculum
(
    curriculum_id  BIGINT        NOT NULL AUTO_INCREMENT,
    created_at     DATETIME      NOT NULL,
    updated_at     DATETIME,
    use_flag       BIT           NOT NULL,
    content        VARCHAR(1000) NOT NULL,
    step           INTEGER       NOT NULL,
    onedayclass_id BIGINT,
    PRIMARY KEY (curriculum_id)
) ENGINE = InnoDB;

CREATE TABLE follow
(
    follow_id  BIGINT   NOT NULL AUTO_INCREMENT,
    created_at DATETIME NOT NULL,
    updated_at DATETIME,
    use_flag   BIT      NOT NULL,
    atelier_id BIGINT,
    member_id  BIGINT,
    PRIMARY KEY (follow_id)
) ENGINE = InnoDB;

CREATE TABLE member
(
    member_id         BIGINT   NOT NULL AUTO_INCREMENT,
    created_at        DATETIME NOT NULL,
    updated_at        DATETIME,
    use_flag          BIT      NOT NULL,
    profile_image_url VARCHAR(255),
    provider          VARCHAR(255),
    provider_id       VARCHAR(255),
    name              VARCHAR(255),
    address_id        BIGINT,
    permission_id     BIGINT   NOT NULL,
    PRIMARY KEY (member_id)
) ENGINE = InnoDB;

CREATE TABLE onedayclass
(
    onedayclass_id    BIGINT        NOT NULL AUTO_INCREMENT,
    created_at        DATETIME      NOT NULL,
    updated_at        DATETIME,
    use_flag          BIT           NOT NULL,
    intro             VARCHAR(1000) NOT NULL,
    max_people_number INTEGER       NOT NULL,
    name              VARCHAR(50)   NOT NULL,
    price             INTEGER       NOT NULL,
    required_time     BIGINT        NOT NULL,
    atelier_id        BIGINT,
    category_id       BIGINT,
    PRIMARY KEY (onedayclass_id)
) ENGINE = InnoDB;

CREATE TABLE onedayclass_iamge
(
    onedayclass_image_id BIGINT       NOT NULL AUTO_INCREMENT,
    created_at           DATETIME     NOT NULL,
    updated_at           DATETIME,
    use_flag             BIT          NOT NULL,
    image_file_name      VARCHAR(255) NOT NULL,
    sequence             INTEGER      NOT NULL,
    onedayclass_id       BIGINT,
    PRIMARY KEY (onedayclass_image_id)
) ENGINE = InnoDB;

CREATE TABLE onedayclass_time
(
    onedayclass_time_id BIGINT   NOT NULL AUTO_INCREMENT,
    created_at          DATETIME NOT NULL,
    updated_at          DATETIME,
    use_flag            BIT      NOT NULL,
    class_date          DATE     NOT NULL,
    end_time            BIGINT   NOT NULL,
    start_time          BIGINT   NOT NULL,
    status              VARCHAR(255),
    onedayclass_id      BIGINT,
    PRIMARY KEY (onedayclass_time_id)
) ENGINE = InnoDB;

CREATE TABLE permission
(
    permission_id BIGINT   NOT NULL AUTO_INCREMENT,
    created_at    DATETIME NOT NULL,
    updated_at    DATETIME,
    use_flag      BIT      NOT NULL,
    name          VARCHAR(255),
    PRIMARY KEY (permission_id)
) ENGINE = InnoDB;

CREATE TABLE post
(
    post_id        BIGINT        NOT NULL AUTO_INCREMENT,
    created_at     DATETIME      NOT NULL,
    updated_at     DATETIME,
    use_flag       BIT           NOT NULL,
    content        VARCHAR(1000) NOT NULL,
    member_id      BIGINT,
    onedayclass_id BIGINT,
    PRIMARY KEY (post_id)
) ENGINE = InnoDB;

CREATE TABLE post_image
(
    post_image_id   BIGINT       NOT NULL AUTO_INCREMENT,
    created_at      DATETIME     NOT NULL,
    updated_at      DATETIME,
    use_flag        BIT          NOT NULL,
    image_file_name VARCHAR(255) NOT NULL,
    sequence        INTEGER,
    post_id         BIGINT,
    PRIMARY KEY (post_image_id)
) ENGINE = InnoDB;

CREATE TABLE reservation
(
    reservation_id      BIGINT       NOT NULL AUTO_INCREMENT,
    created_at          DATETIME     NOT NULL,
    updated_at          DATETIME,
    use_flag            BIT          NOT NULL,
    people_number       INTEGER,
    price               INTEGER,
    reservation_date    DATE         NOT NULL,
    status              VARCHAR(255) NOT NULL,
    member_id           BIGINT,
    onedayclass_time_id BIGINT,
    PRIMARY KEY (reservation_id)
) ENGINE = InnoDB;

CREATE TABLE review
(
    review_id      BIGINT        NOT NULL AUTO_INCREMENT,
    created_at     DATETIME      NOT NULL,
    updated_at     DATETIME,
    use_flag       BIT           NOT NULL,
    content        VARCHAR(1000) NOT NULL,
    score          INTEGER,
    member_id      BIGINT,
    onedayclass_id BIGINT,
    PRIMARY KEY (review_id)
) ENGINE = InnoDB;

CREATE TABLE review_image
(
    review_image_id BIGINT       NOT NULL AUTO_INCREMENT,
    created_at      DATETIME     NOT NULL,
    updated_at      DATETIME,
    use_flag        BIT          NOT NULL,
    image_file_name VARCHAR(255) NOT NULL,
    sequence        INTEGER,
    review_id       BIGINT,
    PRIMARY KEY (review_image_id)
) ENGINE = InnoDB;

## Add Unique Constraint
ALTER TABLE atelier
    ADD CONSTRAINT uk_business_number UNIQUE (business_number);

ALTER TABLE category
    ADD CONSTRAINT uk_category_name UNIQUE (name);

## Add Foreign Key Constraint
ALTER TABLE atelier
    ADD CONSTRAINT fk_atelier_to_address
        FOREIGN KEY (address_id)
            REFERENCES address (address_id);

ALTER TABLE atelier
    ADD CONSTRAINT fk_atelier_to_member
        FOREIGN KEY (member_id)
            REFERENCES member (member_id);

ALTER TABLE comment
    ADD CONSTRAINT fk_comment_to_member
        FOREIGN KEY (member_id)
            REFERENCES member (member_id);

ALTER TABLE comment
    ADD CONSTRAINT fk_comment_to_post
        FOREIGN KEY (post_id)
            REFERENCES post (post_id);

ALTER TABLE curriculum
    ADD CONSTRAINT fk_curriculum_to_onedayclass
        FOREIGN KEY (onedayclass_id)
            REFERENCES onedayclass (onedayclass_id);

ALTER TABLE follow
    ADD CONSTRAINT fk_follow_to_atelier
        FOREIGN KEY (atelier_id)
            REFERENCES atelier (atelier_id);

ALTER TABLE follow
    ADD CONSTRAINT fk_follow_to_member
        FOREIGN KEY (member_id)
            REFERENCES member (member_id);

ALTER TABLE member
    ADD CONSTRAINT fk_member_to_address
        FOREIGN KEY (address_id)
            REFERENCES address (address_id);

ALTER TABLE member
    ADD CONSTRAINT fk_member_to_permission
        FOREIGN KEY (permission_id)
            REFERENCES permission (permission_id);

ALTER TABLE onedayclass
    ADD CONSTRAINT fk_onedayclass_to_atelier
        FOREIGN KEY (atelier_id)
            REFERENCES atelier (atelier_id);

ALTER TABLE onedayclass
    ADD CONSTRAINT fk_onedayclass_to_category
        FOREIGN KEY (category_id)
            REFERENCES category (category_id);

ALTER TABLE onedayclass_iamge
    ADD CONSTRAINT fk_onedayclass_image_to_onedayclass
        FOREIGN KEY (onedayclass_id)
            REFERENCES onedayclass (onedayclass_id);

ALTER TABLE onedayclass_time
    ADD CONSTRAINT fk_onedayclass_time_to_onedayclass
        FOREIGN KEY (onedayclass_id)
            REFERENCES onedayclass (onedayclass_id);

ALTER TABLE post
    ADD CONSTRAINT fk_post_to_member
        FOREIGN KEY (member_id)
            REFERENCES member (member_id);

ALTER TABLE post
    ADD CONSTRAINT fk_post_to_onedayclass
        FOREIGN KEY (onedayclass_id)
            REFERENCES onedayclass (onedayclass_id);

ALTER TABLE post_image
    ADD CONSTRAINT fk_post_image_to_post
        FOREIGN KEY (post_id)
            REFERENCES post (post_id);

ALTER TABLE reservation
    ADD CONSTRAINT fk_reservation_to_member
        FOREIGN KEY (member_id)
            REFERENCES member (member_id);

ALTER TABLE reservation
    ADD CONSTRAINT fk_reservation_to_onedayclass_time
        FOREIGN KEY (onedayclass_time_id)
            REFERENCES onedayclass_time (onedayclass_time_id);

ALTER TABLE review
    ADD CONSTRAINT fk_review_to_member
        FOREIGN KEY (member_id)
            REFERENCES member (member_id);

ALTER TABLE review
    ADD CONSTRAINT fk_review_to_onedayclass
        FOREIGN KEY (onedayclass_id)
            REFERENCES onedayclass (onedayclass_id);

ALTER TABLE review_image
    ADD CONSTRAINT fk_review_image_to_review
        FOREIGN KEY (review_id)
            REFERENCES review (review_id);
