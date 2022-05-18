## 권한
INSERT IGNORE INTO  permission (permission_id, name, use_flag, created_at, updated_at)
VALUES (1, 'ROLE_USER', 1, NOW(), NOW());
INSERT IGNORE INTO  permission (permission_id, name, use_flag, created_at, updated_at)
VALUES (2, 'ROLE_ATELIER', 1, NOW(), NOW());
INSERT IGNORE INTO  permission (permission_id, name, use_flag, created_at, updated_at)
VALUES (3, 'ROLE_ADMIN', 1, NOW(), NOW());

## 카테고리
INSERT IGNORE INTO  category (category_id, name, use_flag, created_at, updated_at)
VALUES (1, '수공예', 1, NOW(), NOW());
INSERT IGNORE INTO  category (category_id, name, use_flag, created_at, updated_at)
VALUES (2, '요리', 1, NOW(), NOW());
INSERT IGNORE INTO  category (category_id, name, use_flag, created_at, updated_at)
VALUES (3, '액티비티', 1, NOW(), NOW());
INSERT IGNORE INTO  category (category_id, name, use_flag, created_at, updated_at)
VALUES (4, '미술', 1, NOW(), NOW());
INSERT IGNORE INTO  category (category_id, name, use_flag, created_at, updated_at)
VALUES (5, '음악/춤', 1, NOW(), NOW());
INSERT IGNORE INTO  category (category_id, name, use_flag, created_at, updated_at)
VALUES (6, '라이프스타일', 1, NOW(), NOW());
INSERT IGNORE INTO  category (category_id, name, use_flag, created_at, updated_at)
VALUES (7, '뷰티', 1, NOW(), NOW());
INSERT IGNORE INTO  category (category_id, name, use_flag, created_at, updated_at)
VALUES (8, '기타', 1, NOW(), NOW());

## 주소
INSERT IGNORE INTO  address (address_id, city_id, region_id, city_name, region_name, use_flag, created_at, updated_at)
VALUES (1, 1, 1, '서울시', '강남구', 1, NOW(), NOW());
INSERT IGNORE INTO  address (address_id, city_id, region_id, city_name, region_name, use_flag, created_at, updated_at)
VALUES (2, 1, 2, '서울시', '강동구', 1, NOW(), NOW());
INSERT IGNORE INTO  address (address_id, city_id, region_id, city_name, region_name, use_flag, created_at, updated_at)
VALUES (3, 1, 3, '서울시', '강북구', 1, NOW(), NOW());
INSERT IGNORE INTO  address (address_id, city_id, region_id, city_name, region_name, use_flag, created_at, updated_at)
VALUES (4, 1, 4, '서울시', '강서구', 1, NOW(), NOW());
INSERT IGNORE INTO  address (address_id, city_id, region_id, city_name, region_name, use_flag, created_at, updated_at)
VALUES (5, 1, 5, '서울시', '성동구', 1, NOW(), NOW());
INSERT IGNORE INTO  address (address_id, city_id, region_id, city_name, region_name, use_flag, created_at, updated_at)
VALUES (6, 1, 6, '서울시', '송파구', 1, NOW(), NOW());
INSERT IGNORE INTO  address (address_id, city_id, region_id, city_name, region_name, use_flag, created_at, updated_at)
VALUES (7, 1, 7, '서울시', '용산구', 1, NOW(), NOW());
INSERT IGNORE INTO  address (address_id, city_id, region_id, city_name, region_name, use_flag, created_at, updated_at)
VALUES (8, 1, 8, '서울시', '종로구', 1, NOW(), NOW());

## 사용자
INSERT IGNORE INTO  `member` (member_id, name, provider, provider_id, profile_image_url, address_id, permission_id, use_flag, created_at, updated_at)
VALUES (1, '김진태', 'kakao', '2019948492', 'https://dayz-s3.s3.ap-northeast-2.amazonaws.com/e6c6194d-93e1-4d39-b0c4-8ab2bc8b71e7-KakaoTalk_20210616_220854417.jpg', 1, 1, 1, NOW(), NOW());
INSERT IGNORE INTO  `member` (member_id, name, provider, provider_id, profile_image_url, address_id, permission_id, use_flag, created_at, updated_at)
VALUES (2, '김희진', 'kakao', '2019911111', 'https://dayz-s3.s3.ap-northeast-2.amazonaws.com/atelier-image-1.jpg', 2, 2, 1, NOW(), NOW());
INSERT IGNORE INTO  `member` (member_id, name, provider, provider_id, profile_image_url, address_id, permission_id, use_flag, created_at, updated_at)
VALUES (3, '도공방', 'kakao', '2019922222', 'https://dayz-s3.s3.ap-northeast-2.amazonaws.com/memberProfile_2.png', 3, 2, 1, NOW(), NOW());
INSERT IGNORE INTO  `member` (member_id, name, provider, provider_id, profile_image_url, address_id, permission_id, use_flag, created_at, updated_at)
VALUES (4, '관리자', 'kakao', '2012343333', 'https://dayz-s3.s3.ap-northeast-2.amazonaws.com/e6c6194d-93e1-4d39-b0c4-8ab2bc8b71e7-KakaoTalk_20210616_220854417.jpg', 5, 3, 1, NOW(), NOW());
INSERT IGNORE INTO  `member` (member_id, name, provider, provider_id, profile_image_url, address_id, permission_id, use_flag, created_at, updated_at)
VALUES (5, '김공방', 'kakao', '5346222222', 'https://dayz-s3.s3.ap-northeast-2.amazonaws.com/memberProfile_3.jpeg', 3, 2, 1, NOW(), NOW());
INSERT IGNORE INTO  `member` (member_id, name, provider, provider_id, profile_image_url, address_id, permission_id, use_flag, created_at, updated_at)
VALUES (6, '이공방', 'kakao', '2034526882', 'https://dayz-s3.s3.ap-northeast-2.amazonaws.com/memberProfile_5.png', 4, 2, 1, NOW(), NOW());
INSERT IGNORE INTO  `member` (member_id, name, provider, provider_id, profile_image_url, address_id, permission_id, use_flag, created_at, updated_at)
VALUES (7, '최공방', 'kakao', '2019922009', 'https://dayz-s3.s3.ap-northeast-2.amazonaws.com/memberProfile_6.jpeg', 1, 2, 1, NOW(), NOW());
INSERT IGNORE INTO  `member` (member_id, name, provider, provider_id, profile_image_url, address_id, permission_id, use_flag, created_at, updated_at)
VALUES (8, '나공방', 'kakao', '1258912220', 'https://dayz-s3.s3.ap-northeast-2.amazonaws.com/memberProfile_7.jpeg', 6, 2, 1, NOW(), NOW());
INSERT IGNORE INTO  `member` (member_id, name, provider, provider_id, profile_image_url, address_id, permission_id, use_flag, created_at, updated_at)
VALUES (9, '박공방', 'kakao', '2199223425', 'https://dayz-s3.s3.ap-northeast-2.amazonaws.com/memberProfile_8.jpeg', 3, 2, 1, NOW(), NOW());
INSERT IGNORE INTO  `member` (member_id, name, provider, provider_id, profile_image_url, address_id, permission_id, use_flag, created_at, updated_at)
VALUES (10, '가공방', 'kakao', '1719922002', 'https://dayz-s3.s3.ap-northeast-2.amazonaws.com/atelier-image-1.jpg', 1, 2, 1, NOW(), NOW());
INSERT IGNORE INTO  `member` (member_id, name, provider, provider_id, profile_image_url, address_id, permission_id, use_flag, created_at, updated_at)
VALUES (11, '다공방', 'kakao', '4241992452', 'https://dayz-s3.s3.ap-northeast-2.amazonaws.com/atelier-image-2.jpg', 1, 2, 1, NOW(), NOW());
INSERT IGNORE INTO  `member` (member_id, name, provider, provider_id, profile_image_url, address_id, permission_id, use_flag, created_at, updated_at)
VALUES (12, '라공방', 'kakao', '1169928142', 'https://dayz-s3.s3.ap-northeast-2.amazonaws.com/atelier-image-3.jpg', 2, 2, 1, NOW(), NOW());
INSERT IGNORE INTO  `member` (member_id, name, provider, provider_id, profile_image_url, address_id, permission_id, use_flag, created_at, updated_at)
VALUES (13, '마공방', 'kakao', '1198967229', 'https://dayz-s3.s3.ap-northeast-2.amazonaws.com/memberProfile_100.jpeg', 1, 2, 1, NOW(), NOW());
INSERT IGNORE INTO  `member` (member_id, name, provider, provider_id, profile_image_url, address_id, permission_id, use_flag, created_at, updated_at)
VALUES (14, '바공방', 'kakao', '1256907982', 'https://dayz-s3.s3.ap-northeast-2.amazonaws.com/memberProfile_101.jpeg', 4, 2, 1, NOW(), NOW());
INSERT IGNORE INTO  `member` (member_id, name, provider, provider_id, profile_image_url, address_id, permission_id, use_flag, created_at, updated_at)
VALUES (15, '사공방', 'kakao', '5089044856', 'https://dayz-s3.s3.ap-northeast-2.amazonaws.com/memberProfile_102.jpeg', 5, 2, 1, NOW(), NOW());
INSERT IGNORE INTO  `member` (member_id, name, provider, provider_id, profile_image_url, address_id, permission_id, use_flag, created_at, updated_at)
VALUES (16, '아공방', 'kakao', '1108904815', 'https://dayz-s3.s3.ap-northeast-2.amazonaws.com/memberProfile_103.jpeg', 1, 2, 1, NOW(), NOW());
INSERT IGNORE INTO  `member` (member_id, name, provider, provider_id, profile_image_url, address_id, permission_id, use_flag, created_at, updated_at)
VALUES (17, '자공방', 'kakao', '1509965165', 'https://dayz-s3.s3.ap-northeast-2.amazonaws.com/memberProfile_104.jpeg', 8, 2, 1, NOW(), NOW());
INSERT IGNORE INTO  `member` (member_id, name, provider, provider_id, profile_image_url, address_id, permission_id, use_flag, created_at, updated_at)
VALUES (18, '차공방', 'kakao', '4891506042', 'https://dayz-s3.s3.ap-northeast-2.amazonaws.com/memberProfile_105.png', 5, 2, 1, NOW(), NOW());
INSERT IGNORE INTO  `member` (member_id, name, provider, provider_id, profile_image_url, address_id, permission_id, use_flag, created_at, updated_at)
VALUES (19, '카공방', 'kakao', '9118956000', 'https://dayz-s3.s3.ap-northeast-2.amazonaws.com/memberProfile_106.jpeg', 8, 2, 1, NOW(), NOW());
INSERT IGNORE INTO  `member` (member_id, name, provider, provider_id, profile_image_url, address_id, permission_id, use_flag, created_at, updated_at)
VALUES (20, '타공방', 'kakao', '4988008940', 'https://dayz-s3.s3.ap-northeast-2.amazonaws.com/memberProfile_107.jpeg', 7, 2, 1, NOW(), NOW());
INSERT IGNORE INTO  `member` (member_id, name, provider, provider_id, profile_image_url, address_id, permission_id, use_flag, created_at, updated_at)
VALUES (21, '파공방', 'kakao', '4981156046', 'https://dayz-s3.s3.ap-northeast-2.amazonaws.com/memberProfile_118.jpeg', 4, 2, 1, NOW(), NOW());
INSERT IGNORE INTO  `member` (member_id, name, provider, provider_id, profile_image_url, address_id, permission_id, use_flag, created_at, updated_at)
VALUES (22, '하공방', 'kakao', '4891054645', 'https://dayz-s3.s3.ap-northeast-2.amazonaws.com/memberProfile_109.jpeg', 4, 2, 1, NOW(), NOW());
INSERT IGNORE INTO  `member` (member_id, name, provider, provider_id, profile_image_url, address_id, permission_id, use_flag, created_at, updated_at)
VALUES (23, '아공방', 'kakao', '9781123640', 'https://dayz-s3.s3.ap-northeast-2.amazonaws.com/memberProfile_110.jpeg', 2, 2, 1, NOW(), NOW());

INSERT IGNORE INTO  `member` (member_id, name, provider, provider_id, profile_image_url, address_id, permission_id, use_flag, created_at, updated_at)
VALUES (24, '이익순', 'kakao', '9823749221', 'https://dayz-s3.s3.ap-northeast-2.amazonaws.com/memberProfile_100.jpeg', 1, 1, 1, NOW(), NOW());
INSERT IGNORE INTO  `member` (member_id, name, provider, provider_id, profile_image_url, address_id, permission_id, use_flag, created_at, updated_at)
VALUES (25, '이익준', 'kakao', '0298374249', 'https://dayz-s3.s3.ap-northeast-2.amazonaws.com/memberProfile_101.jpeg', 2, 1, 1, NOW(), NOW());
INSERT IGNORE INTO  `member` (member_id, name, provider, provider_id, profile_image_url, address_id, permission_id, use_flag, created_at, updated_at)
VALUES (26, '채송화', 'kakao', '1203103490', 'https://dayz-s3.s3.ap-northeast-2.amazonaws.com/memberProfile_102.jpeg', 3, 1, 1, NOW(), NOW());
INSERT IGNORE INTO  `member` (member_id, name, provider, provider_id, profile_image_url, address_id, permission_id, use_flag, created_at, updated_at)
VALUES (27, '양석형', 'kakao', '3020430259', 'https://dayz-s3.s3.ap-northeast-2.amazonaws.com/memberProfile_103.jpeg', 4, 1, 1, NOW(), NOW());
INSERT IGNORE INTO  `member` (member_id, name, provider, provider_id, profile_image_url, address_id, permission_id, use_flag, created_at, updated_at)
VALUES (28, '김준완', 'kakao', '4910924105', 'https://dayz-s3.s3.ap-northeast-2.amazonaws.com/memberProfile_104.jpeg', 5, 1, 1, NOW(), NOW());
INSERT IGNORE INTO  `member` (member_id, name, provider, provider_id, profile_image_url, address_id, permission_id, use_flag, created_at, updated_at)
VALUES (29, '안정원', 'kakao', '4938582711', 'https://dayz-s3.s3.ap-northeast-2.amazonaws.com/memberProfile_105.png', 6, 1, 1, NOW(), NOW());

## 공방
INSERT IGNORE INTO  atelier (atelier_id, name, intro, business_number, address_id, address_detail, call_number, work_start_time, work_end_time, member_id, use_flag, created_at, updated_at)
VALUES (1, '희진공방', '미모의 원데이 클래스 마스터가 운영하는 희진공방입니다. 연락주시면 커피 사드립니다. ^^', '5064319530', 1, '대륭 서초타워 2층', '01023456879', 32400, 68400, 2, 1, NOW(), NOW());
INSERT IGNORE INTO  atelier (atelier_id, name, intro, business_number, address_id, address_detail, call_number, work_start_time, work_end_time, member_id, use_flag, created_at, updated_at)
VALUES (2, '도예공방', '도자기, 컵, 그릇, 캐릭터 디자인 등 도예를 전문으로 하는 공방입니다.', '1216429133', 1, '테헤란로 204 3층', '01038490560', 32400, 68400, 3, 1, NOW(), NOW());
INSERT IGNORE INTO  atelier (atelier_id, name, intro, business_number, address_id, address_detail, call_number, work_start_time, work_end_time, member_id, use_flag, created_at, updated_at)
VALUES (3, '잠실짱공방', '잠실에서 제일 잘나가는 공방입니다.', '16-234-05021', 8, '올림픽로300 롯데타워 1203호', '01023456879', 32400, 68400, 6, 1, NOW(), NOW());
INSERT IGNORE INTO  atelier (atelier_id, name, intro, business_number, address_id, address_detail, call_number, work_start_time, work_end_time, member_id, use_flag, created_at, updated_at)
VALUES (4, '강남역공방', '강남역에서 제일가는 공방입니다. 오셔서 트렌트의 선두자가 되어보세요.', '6042058392', 1, '강남대로 21-5', '01023456879', 32400, 68400, 7, 1, NOW(), NOW());
INSERT IGNORE INTO  atelier (atelier_id, name, intro, business_number, address_id, address_detail, call_number, work_start_time, work_end_time, member_id, use_flag, created_at, updated_at)
VALUES (5, '신논현공방', '신논현에서 고급진 공방을 체험해보세요.', '0134512394', 1, '강남대로 1240-2 신논현빌딩 2층', '01023456879', 32400, 68400, 8, 1, NOW(), NOW());
INSERT IGNORE INTO  atelier (atelier_id, name, intro, business_number, address_id, address_detail, call_number, work_start_time, work_end_time, member_id, use_flag, created_at, updated_at)
VALUES (6, '서촌도자기공방', '아주 멋진 서촌에서 도자기를 체험해보세요.', '4251269345', 8, '서울숲 201-4 성동타워 5층', '01023456879', 32400, 68400, 9, 1, NOW(), NOW());
INSERT IGNORE INTO  atelier (atelier_id, name, intro, business_number, address_id, address_detail, call_number, work_start_time, work_end_time, member_id, use_flag, created_at, updated_at)
VALUES (7, '북촌향수공방', '나만의 향기를 간직할 수 있는 북촌의 향수공방입니다.', '8343523789', 7, '삼청로 30', '01023456879', 32400, 68400, 10, 1, NOW(), NOW());
INSERT IGNORE INTO  atelier (atelier_id, name, intro, business_number, address_id, address_detail, call_number, work_start_time, work_end_time, member_id, use_flag, created_at, updated_at)
VALUES (8, '글씨를배우자공방', '악필은 가라! 이제부터 나도 한석봉! 캘리그라피 공방입니다.', '8342318794', 8, '연희로 504', '01023456879', 32400, 68400, 11, 1, NOW(), NOW());
INSERT IGNORE INTO  atelier (atelier_id, name, intro, business_number, address_id, address_detail, call_number, work_start_time, work_end_time, member_id, use_flag, created_at, updated_at)
VALUES (9, '꽃꽂이공방', '아름다운 꽃을 꽂으며 마음의 안정을 찾아보세요.', '9231212398', 5, '녹사평대로 150', '01023456879', 32400, 68400, 12, 1, NOW(), NOW());
INSERT IGNORE INTO  atelier (atelier_id, name, intro, business_number, address_id, address_detail, call_number, work_start_time, work_end_time, member_id, use_flag, created_at, updated_at)
VALUES (10, '가구만들기공방', '내가 원하는 가구를 만들어 나만의 공간을 꾸며봐요!', '2347312834', 5, '국회의사당로 2123', '01023456879', 32400, 68400, 13, 1, NOW(), NOW());
INSERT IGNORE INTO  atelier (atelier_id, name, intro, business_number, address_id, address_detail, call_number, work_start_time, work_end_time, member_id, use_flag, created_at, updated_at)
VALUES (11, '간식만들기공방', '유기농으로 만드는 나의 간식!', '8502009194', 1, '서초대로 201-53', '01023456879', 32400, 68400, 14, 1, NOW(), NOW());
INSERT IGNORE INTO  atelier (atelier_id, name, intro, business_number, address_id, address_detail, call_number, work_start_time, work_end_time, member_id, use_flag, created_at, updated_at)
VALUES (12, '화가가되어보자공방', '당신도 피카소가 될 수 있습니다. 달려오세요', '4921823484', 1, '논현로 500', '01023456879', 32400, 68400, 15, 1, NOW(), NOW());
INSERT IGNORE INTO  atelier (atelier_id, name, intro, business_number, address_id, address_detail, call_number, work_start_time, work_end_time, member_id, use_flag, created_at, updated_at)
VALUES (13, '종이접기공방', '우리들의 코딱지들의 어린시절을 떠올리게 해줄 종이접기공방입니다! 종이로 용 만들기 절찬 진행중!', '9841223594', 1, '논현로 802', '01023456879', 32400, 68400, 16, 1, NOW(), NOW());
INSERT IGNORE INTO  atelier (atelier_id, name, intro, business_number, address_id, address_detail, call_number, work_start_time, work_end_time, member_id, use_flag, created_at, updated_at)
VALUES (14, '전통미술공방', '우리 고유의 전통미술의 계승자가 되어보세요. 전통미술 체험공방!', '8235845983', 8, '성수이로 82', '01023456879', 32400, 68400, 17, 1, NOW(), NOW());
INSERT IGNORE INTO  atelier (atelier_id, name, intro, business_number, address_id, address_detail, call_number, work_start_time, work_end_time, member_id, use_flag, created_at, updated_at)
VALUES (15, '한지공예공방', '한지로 이렇게까지 만들 수 있다구요?! 네! 그렇습니다 한지로 만드는 소품공방!', '9031323459', 8, '성수이로 51', '01023456879', 32400, 68400, 18, 1, NOW(), NOW());
INSERT IGNORE INTO  atelier (atelier_id, name, intro, business_number, address_id, address_detail, call_number, work_start_time, work_end_time, member_id, use_flag, created_at, updated_at)
VALUES (16, '화장품공방', '내 눈으로 나에게 맞는 화장품을 만들어써보자!', '0962425842', 2, '천호대로 2091 504호', '01023456879', 32400, 68400, 19, 1, NOW(), NOW());
INSERT IGNORE INTO  atelier (atelier_id, name, intro, business_number, address_id, address_detail, call_number, work_start_time, work_end_time, member_id, use_flag, created_at, updated_at)
VALUES (17, '요리만들기', '요알못 탈출을 도와드립니다 커몬요!', '2520455321', 2, '천호대로 952', '01023456879', 32400, 68400, 20, 1, NOW(), NOW());
INSERT IGNORE INTO  atelier (atelier_id, name, intro, business_number, address_id, address_detail, call_number, work_start_time, work_end_time, member_id, use_flag, created_at, updated_at)
VALUES (18, '쉐프네공방', '고든램지? 너두 할 수 있어!', '1455322360', 3, '송파대로 39길 12', '01023456879', 32400, 68400, 21, 1, NOW(), NOW());
INSERT IGNORE INTO  atelier (atelier_id, name, intro, business_number, address_id, address_detail, call_number, work_start_time, work_end_time, member_id, use_flag, created_at, updated_at)
VALUES (19, '한식요리의 대가', '대장금 납시오~ 홍시맛의 대가 대장금으로 만들어드립니다', '1962425842', 3, '삼청로 39길 15', '01023456879', 32400, 68400, 22, 1, NOW(), NOW());
INSERT IGNORE INTO  atelier (atelier_id, name, intro, business_number, address_id, address_detail, call_number, work_start_time, work_end_time, member_id, use_flag, created_at, updated_at)
VALUES (20, '디퓨저의 모든 것', '향기로움의 세계로 당신을 초대합니다.', '1341123511', 8, '성수이로 391 5층', '01023456879', 32400, 68400, 23, 1, NOW(), NOW());

## 원데이 클래스
INSERT IGNORE INTO  onedayclass (name, intro, price, max_people_number, required_time, category_id, atelier_id, use_flag, created_at, updated_at)
VALUES ('도예가 첫걸음', '도자기에 처음 입문하시는 분들을 위한 클래스 입니다', 28000, 4, 2400, 1, 1, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass (name, intro, price, max_people_number, required_time, category_id, atelier_id, use_flag, created_at, updated_at)
VALUES ('도예가 마스터', '도자기에 어느정도 감각이 생긴 분들이 조금더 난이도 있는 도예를 할 수 있는 클래스입니다', 36000, 5, 3600, 1, 2, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass (name, intro, price, max_people_number, required_time, category_id, atelier_id, use_flag, created_at, updated_at)
VALUES ('내 손으로 만드는 도자기', '누구나 쉽게 도전해보는 도자기 만들기!', 31000, 4, 2400, 1, 1, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass (name, intro, price, max_people_number, required_time, category_id, atelier_id, use_flag, created_at, updated_at)
VALUES ('물레로 도자기 입문하기', '처음이라도 당황하지 마세요 친절한 멘토가 함께합니다', 36000, 3, 3600, 1, 2, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass (name, intro, price, max_people_number, required_time, category_id, atelier_id, use_flag, created_at, updated_at)
VALUES ('도자기 핸드페인팅', '내 감각으로 색칠하는 예쁜 도자기', 24000, 5, 3600, 1, 1, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass (name, intro, price, max_people_number, required_time, category_id, atelier_id, use_flag, created_at, updated_at)
VALUES ('클레이를 이용한 리미티드 디자인 도자기 만들기', '알록달록 클레이로 예쁜 도자기를 만들어보세요', 29000, 4, 3600, 1, 2, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass (name, intro, price, max_people_number, required_time, category_id, atelier_id, use_flag, created_at, updated_at)
VALUES ('캐릭터 접시 만들기', '좋아하는 캐릭터가 접시로 탄생한다! 나만의 캐릭터 접시를 만들어 좋은 추억을 만드는건 어떨까요?', 35000, 4, 3600, 1, 4, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass (name, intro, price, max_people_number, required_time, category_id, atelier_id, use_flag, created_at, updated_at)
VALUES ('강남역 도자기체험 원데이 클래스', '접근성 좋은 강남역에서 퇴근 후 만들어보는 도자기체험! 데이트 코스로도 좋습니다', 35000, 4, 3600, 1, 2, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass (name, intro, price, max_people_number, required_time, category_id, atelier_id, use_flag, created_at, updated_at)
VALUES ('도자기 소수잔 세트 만들기 클래스', '알코올 러버 커플이나 친구끼리 딱맞는 소주잔 세트로 더 맛있는 술자리!', 33000, 5, 3600, 1, 4, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass (name, intro, price, max_people_number, required_time, category_id, atelier_id, use_flag, created_at, updated_at)
VALUES ('크리스마스 도자기 클래스', '크리스마스의 행운이 찾아올 것만 같은 크리스마스 도자기 꾸미기로 오세요', 37000, 4, 2400, 1, 4, 1, NOW(), NOW());


## 원데이 클래스 시간
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (1, DATE(NOW()), 43200, 46800, 'PROCESS', 1, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (2, DATE(NOW()), 50400, 54000, 'PROCESS', 1, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (3, DATE(NOW()), 57600, 61200, 'PROCESS', 1, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (4, DATE(DATE_SUB(NOW(), INTERVAL -1 DAY)), 43200, 46800, 'PROCESS', 1, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (5, DATE(DATE_SUB(NOW(), INTERVAL -1 DAY)), 50400, 54000, 'PROCESS', 1, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (6, DATE(DATE_SUB(NOW(), INTERVAL -1 DAY)), 57600, 61200, 'PROCESS', 1, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (7, DATE(DATE_SUB(NOW(), INTERVAL -2 DAY)), 43200, 46800, 'PROCESS', 1, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (8, DATE(DATE_SUB(NOW(), INTERVAL -2 DAY)), 50400, 54000, 'PROCESS', 1, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (9, DATE(DATE_SUB(NOW(), INTERVAL -2 DAY)), 57600, 61200, 'PROCESS', 1, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (10, DATE(DATE_SUB(NOW(), INTERVAL -3 DAY)), 43200, 46800, 'PROCESS', 1, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (11, DATE(DATE_SUB(NOW(), INTERVAL -3 DAY)), 50400, 54000, 'PROCESS', 1, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (12, DATE(DATE_SUB(NOW(), INTERVAL -3 DAY)), 57600, 61200, 'PROCESS', 1, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (13, DATE(DATE_SUB(NOW(), INTERVAL -4 DAY)), 43200, 46800, 'PROCESS', 1, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (14, DATE(DATE_SUB(NOW(), INTERVAL -4 DAY)), 50400, 54000, 'PROCESS', 1, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (15, DATE(DATE_SUB(NOW(), INTERVAL -4 DAY)), 57600, 61200, 'PROCESS', 1, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (16, DATE(DATE_SUB(NOW(), INTERVAL -5 DAY)), 43200, 46800, 'PROCESS', 1, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (17, DATE(DATE_SUB(NOW(), INTERVAL -5 DAY)), 50400, 54000, 'PROCESS', 1, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (18, DATE(DATE_SUB(NOW(), INTERVAL -5 DAY)), 57600, 61200, 'PROCESS', 1, 1, NOW(), NOW());

INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (19, DATE(NOW()), 43200, 46800, 'PROCESS', 2, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (20, DATE(NOW()), 50400, 54000, 'PROCESS', 2, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (21, DATE(NOW()), 57600, 61200, 'PROCESS', 2, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (22, DATE(DATE_SUB(NOW(), INTERVAL -1 DAY)), 43200, 46800, 'PROCESS', 2, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (23, DATE(DATE_SUB(NOW(), INTERVAL -1 DAY)), 50400, 54000, 'PROCESS', 2, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (24, DATE(DATE_SUB(NOW(), INTERVAL -1 DAY)), 57600, 61200, 'PROCESS', 2, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (25, DATE(DATE_SUB(NOW(), INTERVAL -2 DAY)), 43200, 46800, 'PROCESS', 2, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (26, DATE(DATE_SUB(NOW(), INTERVAL -2 DAY)), 50400, 54000, 'PROCESS', 2, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (27, DATE(DATE_SUB(NOW(), INTERVAL -2 DAY)), 57600, 61200, 'PROCESS', 2, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (28, DATE(DATE_SUB(NOW(), INTERVAL -3 DAY)), 43200, 46800, 'PROCESS', 2, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (29, DATE(DATE_SUB(NOW(), INTERVAL -3 DAY)), 50400, 54000, 'PROCESS', 2, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (30, DATE(DATE_SUB(NOW(), INTERVAL -3 DAY)), 57600, 61200, 'PROCESS', 2, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (31, DATE(DATE_SUB(NOW(), INTERVAL -4 DAY)), 43200, 46800, 'PROCESS', 2, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (32, DATE(DATE_SUB(NOW(), INTERVAL -4 DAY)), 50400, 54000, 'PROCESS', 2, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (33, DATE(DATE_SUB(NOW(), INTERVAL -4 DAY)), 57600, 61200, 'PROCESS', 2, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (34, DATE(DATE_SUB(NOW(), INTERVAL -5 DAY)), 43200, 46800, 'PROCESS', 2, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (35, DATE(DATE_SUB(NOW(), INTERVAL -5 DAY)), 50400, 54000, 'PROCESS', 2, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (36, DATE(DATE_SUB(NOW(), INTERVAL -5 DAY)), 57600, 61200, 'PROCESS', 2, 1, NOW(), NOW());

INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (37, DATE(NOW()), 43200, 46800, 'PROCESS', 3, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (38, DATE(NOW()), 50400, 54000, 'PROCESS', 3, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (39, DATE(NOW()), 57600, 61200, 'PROCESS', 3, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (40, DATE(DATE_SUB(NOW(), INTERVAL -1 DAY)), 43200, 46800, 'PROCESS', 3, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (41, DATE(DATE_SUB(NOW(), INTERVAL -1 DAY)), 50400, 54000, 'PROCESS', 3, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (42, DATE(DATE_SUB(NOW(), INTERVAL -1 DAY)), 57600, 61200, 'PROCESS', 3, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (43, DATE(DATE_SUB(NOW(), INTERVAL -2 DAY)), 43200, 46800, 'PROCESS', 3, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (44, DATE(DATE_SUB(NOW(), INTERVAL -2 DAY)), 50400, 54000, 'PROCESS', 3, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (45, DATE(DATE_SUB(NOW(), INTERVAL -2 DAY)), 57600, 61200, 'PROCESS', 3, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (46, DATE(DATE_SUB(NOW(), INTERVAL -3 DAY)), 43200, 46800, 'PROCESS', 3, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (47, DATE(DATE_SUB(NOW(), INTERVAL -3 DAY)), 50400, 54000, 'PROCESS', 3, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (48, DATE(DATE_SUB(NOW(), INTERVAL -3 DAY)), 57600, 61200, 'PROCESS', 3, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (49, DATE(DATE_SUB(NOW(), INTERVAL -4 DAY)), 43200, 46800, 'PROCESS', 3, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (50, DATE(DATE_SUB(NOW(), INTERVAL -4 DAY)), 50400, 54000, 'PROCESS', 3, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (51, DATE(DATE_SUB(NOW(), INTERVAL -4 DAY)), 57600, 61200, 'PROCESS', 3, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (52, DATE(DATE_SUB(NOW(), INTERVAL -5 DAY)), 43200, 46800, 'PROCESS', 3, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (53, DATE(DATE_SUB(NOW(), INTERVAL -5 DAY)), 50400, 54000, 'PROCESS', 3, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (54, DATE(DATE_SUB(NOW(), INTERVAL -5 DAY)), 57600, 61200, 'PROCESS', 3, 1, NOW(), NOW());

INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (55, DATE(NOW()), 43200, 46800, 'PROCESS', 4, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (56, DATE(NOW()), 50400, 54000, 'PROCESS', 4, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (57, DATE(NOW()), 57600, 61200, 'PROCESS', 4, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (58, DATE(DATE_SUB(NOW(), INTERVAL -1 DAY)), 43200, 46800, 'PROCESS', 4, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (59, DATE(DATE_SUB(NOW(), INTERVAL -1 DAY)), 50400, 54000, 'PROCESS', 4, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (60, DATE(DATE_SUB(NOW(), INTERVAL -1 DAY)), 57600, 61200, 'PROCESS', 4, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (61, DATE(DATE_SUB(NOW(), INTERVAL -2 DAY)), 43200, 46800, 'PROCESS', 4, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (62, DATE(DATE_SUB(NOW(), INTERVAL -2 DAY)), 50400, 54000, 'PROCESS', 4, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (63, DATE(DATE_SUB(NOW(), INTERVAL -2 DAY)), 57600, 61200, 'PROCESS', 4, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (64, DATE(DATE_SUB(NOW(), INTERVAL -3 DAY)), 43200, 46800, 'PROCESS', 4, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (65, DATE(DATE_SUB(NOW(), INTERVAL -3 DAY)), 50400, 54000, 'PROCESS', 4, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (66, DATE(DATE_SUB(NOW(), INTERVAL -3 DAY)), 57600, 61200, 'PROCESS', 4, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (67, DATE(DATE_SUB(NOW(), INTERVAL -4 DAY)), 43200, 46800, 'PROCESS', 4, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (68, DATE(DATE_SUB(NOW(), INTERVAL -4 DAY)), 50400, 54000, 'PROCESS', 4, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (69, DATE(DATE_SUB(NOW(), INTERVAL -4 DAY)), 57600, 61200, 'PROCESS', 4, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (70, DATE(DATE_SUB(NOW(), INTERVAL -5 DAY)), 43200, 46800, 'PROCESS', 4, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (71, DATE(DATE_SUB(NOW(), INTERVAL -5 DAY)), 50400, 54000, 'PROCESS', 4, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (72, DATE(DATE_SUB(NOW(), INTERVAL -5 DAY)), 57600, 61200, 'PROCESS', 4, 1, NOW(), NOW());

INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (73, DATE(NOW()), 43200, 46800, 'PROCESS', 5, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (74, DATE(NOW()), 50400, 54000, 'PROCESS', 5, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (75, DATE(NOW()), 57600, 61200, 'PROCESS', 5, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (76, DATE(DATE_SUB(NOW(), INTERVAL -1 DAY)), 43200, 46800, 'PROCESS', 5, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (77, DATE(DATE_SUB(NOW(), INTERVAL -1 DAY)), 50400, 54000, 'PROCESS', 5, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (78, DATE(DATE_SUB(NOW(), INTERVAL -1 DAY)), 57600, 61200, 'PROCESS', 5, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (79, DATE(DATE_SUB(NOW(), INTERVAL -2 DAY)), 43200, 46800, 'PROCESS', 5, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (80, DATE(DATE_SUB(NOW(), INTERVAL -2 DAY)), 50400, 54000, 'PROCESS', 5, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (81, DATE(DATE_SUB(NOW(), INTERVAL -2 DAY)), 57600, 61200, 'PROCESS', 5, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (82, DATE(DATE_SUB(NOW(), INTERVAL -3 DAY)), 43200, 46800, 'PROCESS', 5, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (83, DATE(DATE_SUB(NOW(), INTERVAL -3 DAY)), 50400, 54000, 'PROCESS', 5, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (84, DATE(DATE_SUB(NOW(), INTERVAL -3 DAY)), 57600, 61200, 'PROCESS', 5, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (85, DATE(DATE_SUB(NOW(), INTERVAL -4 DAY)), 43200, 46800, 'PROCESS', 5, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (86, DATE(DATE_SUB(NOW(), INTERVAL -4 DAY)), 50400, 54000, 'PROCESS', 5, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (87, DATE(DATE_SUB(NOW(), INTERVAL -4 DAY)), 57600, 61200, 'PROCESS', 5, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (88, DATE(DATE_SUB(NOW(), INTERVAL -5 DAY)), 43200, 46800, 'PROCESS', 5, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (89, DATE(DATE_SUB(NOW(), INTERVAL -5 DAY)), 50400, 54000, 'PROCESS', 5, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (90, DATE(DATE_SUB(NOW(), INTERVAL -5 DAY)), 57600, 61200, 'PROCESS', 5, 1, NOW(), NOW());

INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (91, DATE(NOW()), 43200, 46800, 'PROCESS', 6, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (92, DATE(NOW()), 50400, 54000, 'PROCESS', 6, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (93, DATE(NOW()), 57600, 61200, 'PROCESS', 6, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (94, DATE(DATE_SUB(NOW(), INTERVAL -1 DAY)), 43200, 46800, 'PROCESS', 6, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (95, DATE(DATE_SUB(NOW(), INTERVAL -1 DAY)), 50400, 54000, 'PROCESS', 6, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (96, DATE(DATE_SUB(NOW(), INTERVAL -1 DAY)), 57600, 61200, 'PROCESS', 6, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (97, DATE(DATE_SUB(NOW(), INTERVAL -2 DAY)), 43200, 46800, 'PROCESS', 6, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (98, DATE(DATE_SUB(NOW(), INTERVAL -2 DAY)), 50400, 54000, 'PROCESS', 6, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (99, DATE(DATE_SUB(NOW(), INTERVAL -2 DAY)), 57600, 61200, 'PROCESS', 6, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (100, DATE(DATE_SUB(NOW(), INTERVAL -3 DAY)), 43200, 46800, 'PROCESS', 6, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (101, DATE(DATE_SUB(NOW(), INTERVAL -3 DAY)), 50400, 54000, 'PROCESS', 6, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (102, DATE(DATE_SUB(NOW(), INTERVAL -3 DAY)), 57600, 61200, 'PROCESS', 6, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (103, DATE(DATE_SUB(NOW(), INTERVAL -4 DAY)), 43200, 46800, 'PROCESS', 6, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (104, DATE(DATE_SUB(NOW(), INTERVAL -4 DAY)), 50400, 54000, 'PROCESS', 6, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (105, DATE(DATE_SUB(NOW(), INTERVAL -4 DAY)), 57600, 61200, 'PROCESS', 6, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (106, DATE(DATE_SUB(NOW(), INTERVAL -5 DAY)), 43200, 46800, 'PROCESS', 6, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (107, DATE(DATE_SUB(NOW(), INTERVAL -5 DAY)), 50400, 54000, 'PROCESS', 6, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (108, DATE(DATE_SUB(NOW(), INTERVAL -5 DAY)), 57600, 61200, 'PROCESS', 6, 1, NOW(), NOW());

INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (109, DATE(NOW()), 43200, 46800, 'PROCESS', 7, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (110, DATE(NOW()), 50400, 54000, 'PROCESS', 7, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (111, DATE(NOW()), 57600, 61200, 'PROCESS', 7, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (112, DATE(DATE_SUB(NOW(), INTERVAL -1 DAY)), 43200, 46800, 'PROCESS', 7, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (113, DATE(DATE_SUB(NOW(), INTERVAL -1 DAY)), 50400, 54000, 'PROCESS', 7, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (114, DATE(DATE_SUB(NOW(), INTERVAL -1 DAY)), 57600, 61200, 'PROCESS', 7, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (115, DATE(DATE_SUB(NOW(), INTERVAL -2 DAY)), 43200, 46800, 'PROCESS', 7, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (116, DATE(DATE_SUB(NOW(), INTERVAL -2 DAY)), 50400, 54000, 'PROCESS', 7, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (117, DATE(DATE_SUB(NOW(), INTERVAL -2 DAY)), 57600, 61200, 'PROCESS', 7, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (118, DATE(DATE_SUB(NOW(), INTERVAL -3 DAY)), 43200, 46800, 'PROCESS', 7, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (119, DATE(DATE_SUB(NOW(), INTERVAL -3 DAY)), 50400, 54000, 'PROCESS', 7, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (120, DATE(DATE_SUB(NOW(), INTERVAL -3 DAY)), 57600, 61200, 'PROCESS', 7, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (121, DATE(DATE_SUB(NOW(), INTERVAL -4 DAY)), 43200, 46800, 'PROCESS', 7, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (122, DATE(DATE_SUB(NOW(), INTERVAL -4 DAY)), 50400, 54000, 'PROCESS', 7, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (123, DATE(DATE_SUB(NOW(), INTERVAL -4 DAY)), 57600, 61200, 'PROCESS', 7, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (124, DATE(DATE_SUB(NOW(), INTERVAL -5 DAY)), 43200, 46800, 'PROCESS', 7, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (125, DATE(DATE_SUB(NOW(), INTERVAL -5 DAY)), 50400, 54000, 'PROCESS', 7, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (126, DATE(DATE_SUB(NOW(), INTERVAL -5 DAY)), 57600, 61200, 'PROCESS', 7, 1, NOW(), NOW());

INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (127, DATE(NOW()), 43200, 46800, 'PROCESS', 8, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (128, DATE(NOW()), 50400, 54000, 'PROCESS', 8, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (129, DATE(NOW()), 57600, 61200, 'PROCESS', 8, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (130, DATE(DATE_SUB(NOW(), INTERVAL -1 DAY)), 43200, 46800, 'PROCESS', 8, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (131, DATE(DATE_SUB(NOW(), INTERVAL -1 DAY)), 50400, 54000, 'PROCESS', 8, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (132, DATE(DATE_SUB(NOW(), INTERVAL -1 DAY)), 57600, 61200, 'PROCESS', 8, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (133, DATE(DATE_SUB(NOW(), INTERVAL -2 DAY)), 43200, 46800, 'PROCESS', 8, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (134, DATE(DATE_SUB(NOW(), INTERVAL -2 DAY)), 50400, 54000, 'PROCESS', 8, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (135, DATE(DATE_SUB(NOW(), INTERVAL -2 DAY)), 57600, 61200, 'PROCESS', 8, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (136, DATE(DATE_SUB(NOW(), INTERVAL -3 DAY)), 43200, 46800, 'PROCESS', 8, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (137, DATE(DATE_SUB(NOW(), INTERVAL -3 DAY)), 50400, 54000, 'PROCESS', 8, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (138, DATE(DATE_SUB(NOW(), INTERVAL -3 DAY)), 57600, 61200, 'PROCESS', 8, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (139, DATE(DATE_SUB(NOW(), INTERVAL -4 DAY)), 43200, 46800, 'PROCESS', 8, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (140, DATE(DATE_SUB(NOW(), INTERVAL -4 DAY)), 50400, 54000, 'PROCESS', 8, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (141, DATE(DATE_SUB(NOW(), INTERVAL -4 DAY)), 57600, 61200, 'PROCESS', 8, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (142, DATE(DATE_SUB(NOW(), INTERVAL -5 DAY)), 43200, 46800, 'PROCESS', 8, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (143, DATE(DATE_SUB(NOW(), INTERVAL -5 DAY)), 50400, 54000, 'PROCESS', 8, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (144, DATE(DATE_SUB(NOW(), INTERVAL -5 DAY)), 57600, 61200, 'PROCESS', 8, 1, NOW(), NOW());

INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (145, DATE(NOW()), 43200, 46800, 'PROCESS', 9, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (146, DATE(NOW()), 50400, 54000, 'PROCESS', 9, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (147, DATE(NOW()), 57600, 61200, 'PROCESS', 9, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (148, DATE(DATE_SUB(NOW(), INTERVAL -1 DAY)), 43200, 46800, 'PROCESS', 9, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (149, DATE(DATE_SUB(NOW(), INTERVAL -1 DAY)), 50400, 54000, 'PROCESS', 9, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (150, DATE(DATE_SUB(NOW(), INTERVAL -1 DAY)), 57600, 61200, 'PROCESS', 9, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (151, DATE(DATE_SUB(NOW(), INTERVAL -2 DAY)), 43200, 46800, 'PROCESS', 9, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (152, DATE(DATE_SUB(NOW(), INTERVAL -2 DAY)), 50400, 54000, 'PROCESS', 9, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (153, DATE(DATE_SUB(NOW(), INTERVAL -2 DAY)), 57600, 61200, 'PROCESS', 9, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (154, DATE(DATE_SUB(NOW(), INTERVAL -3 DAY)), 43200, 46800, 'PROCESS', 9, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (155, DATE(DATE_SUB(NOW(), INTERVAL -3 DAY)), 50400, 54000, 'PROCESS', 9, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (156, DATE(DATE_SUB(NOW(), INTERVAL -3 DAY)), 57600, 61200, 'PROCESS', 9, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (157, DATE(DATE_SUB(NOW(), INTERVAL -4 DAY)), 43200, 46800, 'PROCESS', 9, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (158, DATE(DATE_SUB(NOW(), INTERVAL -4 DAY)), 50400, 54000, 'PROCESS', 9, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (159, DATE(DATE_SUB(NOW(), INTERVAL -4 DAY)), 57600, 61200, 'PROCESS', 9, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (160, DATE(DATE_SUB(NOW(), INTERVAL -5 DAY)), 43200, 46800, 'PROCESS', 9, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (161, DATE(DATE_SUB(NOW(), INTERVAL -5 DAY)), 50400, 54000, 'PROCESS', 9, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (162, DATE(DATE_SUB(NOW(), INTERVAL -5 DAY)), 57600, 61200, 'PROCESS', 9, 1, NOW(), NOW());

INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (163, DATE(NOW()), 43200, 46800, 'PROCESS', 10, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (164, DATE(NOW()), 50400, 54000, 'PROCESS', 10, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (165, DATE(NOW()), 57600, 61200, 'PROCESS', 10, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (166, DATE(DATE_SUB(NOW(), INTERVAL -1 DAY)), 43200, 46800, 'PROCESS', 10, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (167, DATE(DATE_SUB(NOW(), INTERVAL -1 DAY)), 50400, 54000, 'PROCESS', 10, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (168, DATE(DATE_SUB(NOW(), INTERVAL -1 DAY)), 57600, 61200, 'PROCESS', 10, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (169, DATE(DATE_SUB(NOW(), INTERVAL -2 DAY)), 43200, 46800, 'PROCESS', 10, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (170, DATE(DATE_SUB(NOW(), INTERVAL -2 DAY)), 50400, 54000, 'PROCESS', 10, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (171, DATE(DATE_SUB(NOW(), INTERVAL -2 DAY)), 57600, 61200, 'PROCESS', 10, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (172, DATE(DATE_SUB(NOW(), INTERVAL -3 DAY)), 43200, 46800, 'PROCESS', 10, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (173, DATE(DATE_SUB(NOW(), INTERVAL -3 DAY)), 50400, 54000, 'PROCESS', 10, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (174, DATE(DATE_SUB(NOW(), INTERVAL -3 DAY)), 57600, 61200, 'PROCESS', 10, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (175, DATE(DATE_SUB(NOW(), INTERVAL -4 DAY)), 43200, 46800, 'PROCESS', 10, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (176, DATE(DATE_SUB(NOW(), INTERVAL -4 DAY)), 50400, 54000, 'PROCESS', 10, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (177, DATE(DATE_SUB(NOW(), INTERVAL -4 DAY)), 57600, 61200, 'PROCESS', 10, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (178, DATE(DATE_SUB(NOW(), INTERVAL -5 DAY)), 43200, 46800, 'PROCESS', 10, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (179, DATE(DATE_SUB(NOW(), INTERVAL -5 DAY)), 50400, 54000, 'PROCESS', 10, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_time (class_time_id, class_date, start_time, end_time, status, class_id, use_flag, created_at, updated_at)
VALUES (180, DATE(DATE_SUB(NOW(), INTERVAL -5 DAY)), 57600, 61200, 'PROCESS', 10, 1, NOW(), NOW());

## 원데이 클래스 이미지
INSERT IGNORE INTO  onedayclass_image (image_file_name, sequence, class_id, use_flag, created_at, updated_at)
VALUES ('dojaki_1_1.jpeg', 1, 1, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_image (image_file_name, sequence, class_id, use_flag, created_at, updated_at)
VALUES ('dojaki_1_2.jpeg', 2, 1, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_image (image_file_name, sequence, class_id, use_flag, created_at, updated_at)
VALUES ('dojaki_1_3.jpeg', 3, 1, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_image (image_file_name, sequence, class_id, use_flag, created_at, updated_at)
VALUES ('dojaki_1_4.jpeg', 4, 1, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_image (image_file_name, sequence, class_id, use_flag, created_at, updated_at)
VALUES ('dojaki_2_1.jpeg', 1, 2, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_image (image_file_name, sequence, class_id, use_flag, created_at, updated_at)
VALUES ('dojaki_2_2.jpeg', 2, 2, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_image (image_file_name, sequence, class_id, use_flag, created_at, updated_at)
VALUES ('dojaki_2_3.jpeg', 3, 2, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_image (image_file_name, sequence, class_id, use_flag, created_at, updated_at)
VALUES ('dojaki_2_4.jpeg', 4, 2, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_image (image_file_name, sequence, class_id, use_flag, created_at, updated_at)
VALUES ('dojaki_3_1.jpeg', 1, 3, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_image (image_file_name, sequence, class_id, use_flag, created_at, updated_at)
VALUES ('dojaki_3_2.jpeg', 2, 3, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_image (image_file_name, sequence, class_id, use_flag, created_at, updated_at)
VALUES ('dojaki_3_3.jpeg', 3, 3, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_image (image_file_name, sequence, class_id, use_flag, created_at, updated_at)
VALUES ('dojaki_3_4.jpeg', 4, 3, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_image (image_file_name, sequence, class_id, use_flag, created_at, updated_at)
VALUES ('dojaki_4_1.jpeg', 1, 4, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_image (image_file_name, sequence, class_id, use_flag, created_at, updated_at)
VALUES ('dojaki_4_2.jpg', 2, 4, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_image (image_file_name, sequence, class_id, use_flag, created_at, updated_at)
VALUES ('dojaki_4_3.jpeg', 3, 4, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_image (image_file_name, sequence, class_id, use_flag, created_at, updated_at)
VALUES ('dojaki_4_4.png', 4, 4, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_image (image_file_name, sequence, class_id, use_flag, created_at, updated_at)
VALUES ('dojaki_5_1.jpeg', 1, 5, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_image (image_file_name, sequence, class_id, use_flag, created_at, updated_at)
VALUES ('dojaki_5_2.jpeg', 2, 5, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_image (image_file_name, sequence, class_id, use_flag, created_at, updated_at)
VALUES ('dojaki_5_3.jpeg', 3, 5, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_image (image_file_name, sequence, class_id, use_flag, created_at, updated_at)
VALUES ('dojaki_5_4.jpeg', 4, 5, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_image (image_file_name, sequence, class_id, use_flag, created_at, updated_at)
VALUES ('dojaki_6_1.jpeg', 1, 6, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_image (image_file_name, sequence, class_id, use_flag, created_at, updated_at)
VALUES ('dojaki_6_2.jpeg', 2, 6, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_image (image_file_name, sequence, class_id, use_flag, created_at, updated_at)
VALUES ('dojaki_6_3.png', 3, 6, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_image (image_file_name, sequence, class_id, use_flag, created_at, updated_at)
VALUES ('dojaki_6_4.png', 4, 6, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_image (image_file_name, sequence, class_id, use_flag, created_at, updated_at)
VALUES ('dojaki_7_1.jpeg', 1, 7, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_image (image_file_name, sequence, class_id, use_flag, created_at, updated_at)
VALUES ('dojaki_7_2.jpeg', 2, 7, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_image (image_file_name, sequence, class_id, use_flag, created_at, updated_at)
VALUES ('dojaki_7_3.jpeg', 3, 7, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_image (image_file_name, sequence, class_id, use_flag, created_at, updated_at)
VALUES ('dojaki_7_4.jpeg', 4, 7, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_image (image_file_name, sequence, class_id, use_flag, created_at, updated_at)
VALUES ('dojaki_8_1.jpeg', 1, 8, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_image (image_file_name, sequence, class_id, use_flag, created_at, updated_at)
VALUES ('dojaki_8_2.jpeg', 2, 8, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_image (image_file_name, sequence, class_id, use_flag, created_at, updated_at)
VALUES ('dojaki_8_3.jpeg', 3, 8, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_image (image_file_name, sequence, class_id, use_flag, created_at, updated_at)
VALUES ('dojaki_8_4.jpeg', 4, 8, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_image (image_file_name, sequence, class_id, use_flag, created_at, updated_at)
VALUES ('dojaki_9_1.jpeg', 1, 9, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_image (image_file_name, sequence, class_id, use_flag, created_at, updated_at)
VALUES ('dojaki_9_2.jpeg', 2, 9, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_image (image_file_name, sequence, class_id, use_flag, created_at, updated_at)
VALUES ('dojaki_9_3.jpeg', 3, 9, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_image (image_file_name, sequence, class_id, use_flag, created_at, updated_at)
VALUES ('dojaki_9_4.jpeg', 4, 9, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_image (image_file_name, sequence, class_id, use_flag, created_at, updated_at)
VALUES ('dojaki_10_1.jpeg', 1, 10, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_image (image_file_name, sequence, class_id, use_flag, created_at, updated_at)
VALUES ('dojaki_10_2.png', 2, 10, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_image (image_file_name, sequence, class_id, use_flag, created_at, updated_at)
VALUES ('dojaki_10_3.jpeg', 3, 10, 1, NOW(), NOW());
INSERT IGNORE INTO  onedayclass_image (image_file_name, sequence, class_id, use_flag, created_at, updated_at)
VALUES ('dojaki_10_4.jpeg', 4, 10, 1, NOW(), NOW());

## 커리큘럼
INSERT IGNORE INTO  curriculum (step, content, class_id, use_flag, created_at, updated_at)
VALUES (1, '도예가 첫걸음 1단계 : 반죽을 만들어줍니다.', 1, 1, NOW(), NOW());
INSERT IGNORE INTO  curriculum (step, content, class_id, use_flag, created_at, updated_at)
VALUES (2, '도예가 첫걸음 2단계 : 도구를 이용해 반죽을 펼쳐주세요.', 1, 1, NOW(), NOW());
INSERT IGNORE INTO  curriculum (step, content, class_id, use_flag, created_at, updated_at)
VALUES (3, '도예가 첫걸음 3단계 : 컵을 만들고 싶다면 컵 모양을 만들어줍니다.', 1, 1, NOW(), NOW());
INSERT IGNORE INTO  curriculum (step, content, class_id, use_flag, created_at, updated_at)
VALUES (4, '도예가 첫걸음 4단계 : 접시를 원한다면 테두리와 하단을 만들어주세요.', 1, 1, NOW(), NOW());
INSERT IGNORE INTO  curriculum (step, content, class_id, use_flag, created_at, updated_at)
VALUES (5, '도예가 첫걸음 5단계 : 완성된 모양을 구워주면 완성!', 1, 1, NOW(), NOW());
INSERT IGNORE INTO  curriculum (step, content, class_id, use_flag, created_at, updated_at)
VALUES (1, '도예가 마스터 1단계 : 반죽과 물을 준비해주세요.', 2, 1, NOW(), NOW());
INSERT IGNORE INTO  curriculum (step, content, class_id, use_flag, created_at, updated_at)
VALUES (2, '도예가 마스터 2단계 : 기본적인 물레 사용법을 습득합니다.', 2, 1, NOW(), NOW());
INSERT IGNORE INTO  curriculum (step, content, class_id, use_flag, created_at, updated_at)
VALUES (3, '도예가 마스터 3단계 : 물레에 반죽을 올려 지시에 따라 모양을 잡습니다.', 2, 1, NOW(), NOW());
INSERT IGNORE INTO  curriculum (step, content, class_id, use_flag, created_at, updated_at)
VALUES (4, '도예가 마스터 4단계 : 원하는 모양을 잡아 만들어 줍니다.', 2, 1, NOW(), NOW());
INSERT IGNORE INTO  curriculum (step, content, class_id, use_flag, created_at, updated_at)
VALUES (5, '도예가 마스터 5단계 : 반죽을 구워 완성합니다.', 2, 1, NOW(), NOW());


## 리뷰
INSERT IGNORE INTO  review (content, score, member_id, class_id, use_flag, created_at, updated_at)
VALUES ('처음 만들어보는데 친절하게 가르쳐주셔서 잘 다녀왔습니다! 최고예요', 5, 24, 1, 1, NOW(), NOW());
INSERT IGNORE INTO  review (content, score, member_id, class_id, use_flag, created_at, updated_at)
VALUES ('처음 배우기에 좋습니다 다만 조금 어수선해서 그부분은 아쉬워요 ㅜㅜ', 4, 25, 1, 1, NOW(), NOW());
INSERT IGNORE INTO  review (content, score, member_id, class_id, use_flag, created_at, updated_at)
VALUES ('가격이 좀 비싸요 그점만 빼면 좋을거 같아요', 3, 26, 1, 1, NOW(), NOW());
INSERT IGNORE INTO  review (content, score, member_id, class_id, use_flag, created_at, updated_at)
VALUES ('사람이 많아서 좀 어수선했어요', 3, 27, 1, 1, NOW(), NOW());
INSERT IGNORE INTO  review (content, score, member_id, class_id, use_flag, created_at, updated_at)
VALUES ('강사님도 친절하시고 위치도 좋아서 정말 잘 만들었어요', 5, 28, 1, 1, NOW(), NOW());
INSERT IGNORE INTO  review (content, score, member_id, class_id, use_flag, created_at, updated_at)
VALUES ('주변에도 소개해줄거예요 친절하시고 시설 깨끗해서 너무 좋습니다', 5, 29, 1, 1, NOW(), NOW());
INSERT IGNORE INTO  review (content, score, member_id, class_id, use_flag, created_at, updated_at)
VALUES ('친구랑 정말 좋은 추억 쌓고 왔어요 최곱니다! 또 방문할게요!', 4, 24, 1, 1, NOW(), NOW());
INSERT IGNORE INTO  review (content, score, member_id, class_id, use_flag, created_at, updated_at)
VALUES ('잘 다녀왔습니다', 3, 25, 1, 1, NOW(), NOW());
INSERT IGNORE INTO  review (content, score, member_id, class_id, use_flag, created_at, updated_at)
VALUES ('강사님이 정말 친절하게 알려주셔서 좋았어요', 5, 26, 1, 1, NOW(), NOW());
INSERT IGNORE INTO  review (content, score, member_id, class_id, use_flag, created_at, updated_at)
VALUES ('또 방문할게요!', 4, 27, 1, 1, NOW(), NOW());
INSERT IGNORE INTO  review (content, score, member_id, class_id, use_flag, created_at, updated_at)
VALUES ('실력이 중급 이상은 되어야 괜찮을거 같아요', 4, 28, 2, 1, NOW(), NOW());
INSERT IGNORE INTO  review (content, score, member_id, class_id, use_flag, created_at, updated_at)
VALUES ('조금 어려웠어요 ㅜㅜ 강사님은 친절하셔서 좋았습니다', 4, 29, 2, 1, NOW(), NOW());
INSERT IGNORE INTO  review (content, score, member_id, class_id, use_flag, created_at, updated_at)
VALUES ('어렵지만 재밌었어요 ㅎㅎ', 5, 24, 2, 1, NOW(), NOW());
INSERT IGNORE INTO  review (content, score, member_id, class_id, use_flag, created_at, updated_at)
VALUES ('또 가고싶어요 재밌게 다녀왔습니다~', 4, 25, 2, 1, NOW(), NOW());
INSERT IGNORE INTO  review (content, score, member_id, class_id, use_flag, created_at, updated_at)
VALUES ('점점 고수가 되어가는 기분입니다 최고최고', 5, 26, 2, 1, NOW(), NOW());
INSERT IGNORE INTO  review (content, score, member_id, class_id, use_flag, created_at, updated_at)
VALUES ('너무 어려워서 조금 힘들었어요ㅜㅜ', 5, 27, 2, 1, NOW(), NOW());
INSERT IGNORE INTO  review (content, score, member_id, class_id, use_flag, created_at, updated_at)
VALUES ('좋은 체험하고 왔습니다 또 방문할게요~', 4, 28, 2, 1, NOW(), NOW());
INSERT IGNORE INTO  review (content, score, member_id, class_id, use_flag, created_at, updated_at)
VALUES ('어렵지만 친절하게 알려주셔서 따라갈 수 있었습니다.', 4, 29, 2, 1, NOW(), NOW());
INSERT IGNORE INTO  review (content, score, member_id, class_id, use_flag, created_at, updated_at)
VALUES ('재밌게 하고왔습니다 ^^', 5, 24, 2, 1, NOW(), NOW());
INSERT IGNORE INTO  review (content, score, member_id, class_id, use_flag, created_at, updated_at)
VALUES ('시설 깔끔하고 좋았어요', 4, 25, 2, 1, NOW(), NOW());
INSERT IGNORE INTO  review (content, score, member_id, class_id, use_flag, created_at, updated_at)
VALUES ('다양한 도안들이 있었으면 좋겠어요 아쉬워요', 3, 26, 2, 1, NOW(), NOW());
INSERT IGNORE INTO  review (content, score, member_id, class_id, use_flag, created_at, updated_at)
VALUES ('쉽게 도자기 만들어볼 수 있어서 좋아요!', 5, 27, 3, 1, NOW(), NOW());
INSERT IGNORE INTO  review (content, score, member_id, class_id, use_flag, created_at, updated_at)
VALUES ('친구들이랑 재밌게 같이 만들었더니 추억도 생기고 그릇도 생겼어요 ㅎㅎ', 5, 28, 3, 1, NOW(), NOW());
INSERT IGNORE INTO  review (content, score, member_id, class_id, use_flag, created_at, updated_at)
VALUES ('데이트 코스로 추천합니다! 어렵지 않고 적당히 쉽게 할 수 있어요', 5, 29, 3, 1, NOW(), NOW());
INSERT IGNORE INTO  review (content, score, member_id, class_id, use_flag, created_at, updated_at)
VALUES ('혼자서 갔는데 친절하게 알려주셔서 재밌게 했어요 ㅎㅎ', 4, 24, 3, 1, NOW(), NOW());
INSERT IGNORE INTO  review (content, score, member_id, class_id, use_flag, created_at, updated_at)
VALUES ('수업 분위기가 좋아요 ㅎㅎ 친절하셔서 잘 따라갔습니다', 5, 25, 3, 1, NOW(), NOW());
INSERT IGNORE INTO  review (content, score, member_id, class_id, use_flag, created_at, updated_at)
VALUES ('굿굿 재밌게 체험했어요!!! 또 갈래요', 5, 26, 3, 1, NOW(), NOW());
INSERT IGNORE INTO  review (content, score, member_id, class_id, use_flag, created_at, updated_at)
VALUES ('강남이라 접근성 좋아서 좋아요', 4, 27, 3, 1, NOW(), NOW());
INSERT IGNORE INTO  review (content, score, member_id, class_id, use_flag, created_at, updated_at)
VALUES ('제가 갔던 시간대는 사람이 많아서 좀 복잡했어요', 3, 28, 3, 1, NOW(), NOW());
INSERT IGNORE INTO  review (content, score, member_id, class_id, use_flag, created_at, updated_at)
VALUES ('가격이 좀 비싸요 ㅜㅜ', 3, 29, 3, 1, NOW(), NOW());
INSERT IGNORE INTO  review (content, score, member_id, class_id, use_flag, created_at, updated_at)
VALUES ('잘 다녀왔습니다 ㅎㅎ', 4, 24, 3, 1, NOW(), NOW());
INSERT IGNORE INTO  review (content, score, member_id, class_id, use_flag, created_at, updated_at)
VALUES ('짱짱! 재밌었어요! 또 갈래요', 5, 25, 3, 1, NOW(), NOW());
INSERT IGNORE INTO  review (content, score, member_id, class_id, use_flag, created_at, updated_at)
VALUES ('재밌게 체험 했습니다', 5, 26, 4, 1, NOW(), NOW());
INSERT IGNORE INTO  review (content, score, member_id, class_id, use_flag, created_at, updated_at)
VALUES ('선생님들이 너무 친절하게 해주시고 시간도 여유롭게 주셔서 재밌게 시간 보내고 왔습니다~', 5, 27, 4, 1, NOW(), NOW());
INSERT IGNORE INTO  review (content, score, member_id, class_id, use_flag, created_at, updated_at)
VALUES ('조물조물 반죽 만지는데, 스트레스도 풀리고 재미있었습니다! ', 5, 28, 4, 1, NOW(), NOW());
INSERT IGNORE INTO  review (content, score, member_id, class_id, use_flag, created_at, updated_at)
VALUES ('아늑한 공간에서 제대로 힐링 하고 갑니다 다음번에 또 신청할게요', 4, 29, 4, 1, NOW(), NOW());
INSERT IGNORE INTO  review (content, score, member_id, class_id, use_flag, created_at, updated_at)
VALUES ('혼자 하러 가서 걱정 되게 많았는데 오히려 혼자 갔기 때문에 더 자세하고 집중적으로 배울 수 있고 더 세세하게 알려주셔서 너무 좋았던 것 같아요', 5, 24, 4, 1, NOW(), NOW());
INSERT IGNORE INTO  review (content, score, member_id, class_id, use_flag, created_at, updated_at)
VALUES ('칭찬도 아끼지 않고 잘한다 하셔서 더 열정적으로 배울 수 있는 계기가 됐어요', 5, 25, 4, 1, NOW(), NOW());
INSERT IGNORE INTO  review (content, score, member_id, class_id, use_flag, created_at, updated_at)
VALUES ('원데이클래스 이것저것 많이 해봤는데 가장 재미있고 추천드리고 싶은 클래스입니당ㅎㅎ', 4, 26, 4, 1, NOW(), NOW());
INSERT IGNORE INTO  review (content, score, member_id, class_id, use_flag, created_at, updated_at)
VALUES ('친구랑 둘이 갔는데 오랜만에 이런 이색적인 경험을 하니 너무 좋았어요~ 날도 추운데 따뜻한 곳에서 점토를 만지며 내가 사용할 그릇들을 직접 만드니 정말 뿌듯했어요!', 5, 27, 4, 1, NOW(), NOW());
INSERT IGNORE INTO  review (content, score, member_id, class_id, use_flag, created_at, updated_at)
VALUES ('선생님이 엄청엄청 친절하십니다!', 5, 28, 4, 1, NOW(), NOW());
INSERT IGNORE INTO  review (content, score, member_id, class_id, use_flag, created_at, updated_at)
VALUES ('친절한 설명 덕분에 재미있고 집중도 높은 원데이 클래스였습니다.', 4, 29, 4, 1, NOW(), NOW());
INSERT IGNORE INTO  review (content, score, member_id, class_id, use_flag, created_at, updated_at)
VALUES ('편하게 잘 다녀왔습니다 좋았어요', 4, 24, 4, 1, NOW(), NOW());
INSERT IGNORE INTO  review (content, score, member_id, class_id, use_flag, created_at, updated_at)
VALUES ('간단히 물감만 팅겨줘도 너무 에쁜 그릇이 완성돼요 짱짱!', 5, 25, 5, 1, NOW(), NOW());
INSERT IGNORE INTO  review (content, score, member_id, class_id, use_flag, created_at, updated_at)
VALUES ('제가 이렇게 미적 감각이 있는줄이야 ㅎㅎㅎ 뿌듯하네요', 5, 26, 5, 1, NOW(), NOW());
INSERT IGNORE INTO  review (content, score, member_id, class_id, use_flag, created_at, updated_at)
VALUES ('친절해서 좋았어요', 5, 27, 5, 1, NOW(), NOW());
INSERT IGNORE INTO  review (content, score, member_id, class_id, use_flag, created_at, updated_at)
VALUES ('어떻게 해야할지 막막했는데 선생님이 도와주셔서 잘 했습니다 :) 감사해요!', 5, 28, 5, 1, NOW(), NOW());
INSERT IGNORE INTO  review (content, score, member_id, class_id, use_flag, created_at, updated_at)
VALUES ('완전 즐거웠어요 또 방문하겠습니다', 5, 29, 5, 1, NOW(), NOW());
INSERT IGNORE INTO  review (content, score, member_id, class_id, use_flag, created_at, updated_at)
VALUES ('좋은 공간에서 편하게 만들고 결과물까지 예뻐서 좋아요! 추천추천', 5, 24, 5, 1, NOW(), NOW());
INSERT IGNORE INTO  review (content, score, member_id, class_id, use_flag, created_at, updated_at)
VALUES ('친구들한테도 추천 하려구요! 최고입니다', 5, 25, 5, 1, NOW(), NOW());
INSERT IGNORE INTO  review (content, score, member_id, class_id, use_flag, created_at, updated_at)
VALUES ('구석에 방치된 먼지가 보여서 조금 그랬어요', 3, 26, 5, 1, NOW(), NOW());
INSERT IGNORE INTO  review (content, score, member_id, class_id, use_flag, created_at, updated_at)
VALUES ('친절하신 선생님 덕분에 잘 체험했어요!', 3, 27, 5, 1, NOW(), NOW());
INSERT IGNORE INTO  review (content, score, member_id, class_id, use_flag, created_at, updated_at)
VALUES ('도자기 만들기 어렵지만 재밌었습니다', 4, 28, 5, 1, NOW(), NOW());
INSERT IGNORE INTO  review (content, score, member_id, class_id, use_flag, created_at, updated_at)
VALUES ('저는 그저 그랬어요', 3, 29, 5, 1, NOW(), NOW());
INSERT IGNORE INTO  review (content, score, member_id, class_id, use_flag, created_at, updated_at)
VALUES ('좋은 경험이었어요', 5, 24, 6, 1, NOW(), NOW());
INSERT IGNORE INTO  review (content, score, member_id, class_id, use_flag, created_at, updated_at)
VALUES ('아이가 와도 재밌게 할 수 있을거 같아요 또 올게요', 5, 25, 6, 1, NOW(), NOW());
INSERT IGNORE INTO  review (content, score, member_id, class_id, use_flag, created_at, updated_at)
VALUES ('최고로 좋아요', 5, 26, 6, 1, NOW(), NOW());
INSERT IGNORE INTO  review (content, score, member_id, class_id, use_flag, created_at, updated_at)
VALUES ('아주 좋았어요', 4, 27, 6, 1, NOW(), NOW());
INSERT IGNORE INTO  review (content, score, member_id, class_id, use_flag, created_at, updated_at)
VALUES ('좋은 경험이었어요', 4, 28, 6, 1, NOW(), NOW());
INSERT IGNORE INTO  review (content, score, member_id, class_id, use_flag, created_at, updated_at)
VALUES ('클레이로 편하고 쉽게 예쁜 디자인을 만들 수 있다니 너무 좋아요!', 5, 29, 6, 1, NOW(), NOW());
INSERT IGNORE INTO  review (content, score, member_id, class_id, use_flag, created_at, updated_at)
VALUES ('잘 배우고 갑니다', 4, 24, 6, 1, NOW(), NOW());
INSERT IGNORE INTO  review (content, score, member_id, class_id, use_flag, created_at, updated_at)
VALUES ('가격에 비해 조금 아쉬워요', 3, 25, 6, 1, NOW(), NOW());
INSERT IGNORE INTO  review (content, score, member_id, class_id, use_flag, created_at, updated_at)
VALUES ('조금만 저렴했으면 좋겠어요', 4, 26, 6, 1, NOW(), NOW());
INSERT IGNORE INTO  review (content, score, member_id, class_id, use_flag, created_at, updated_at)
VALUES ('재밌게 하고왔습니다', 5, 27, 6, 1, NOW(), NOW());
INSERT IGNORE INTO  review (content, score, member_id, class_id, use_flag, created_at, updated_at)
VALUES ('제 캐릭터 접시 너무너무 귀엽고 짱이에요!!!', 5, 28, 7, 1, NOW(), NOW());
INSERT IGNORE INTO  review (content, score, member_id, class_id, use_flag, created_at, updated_at)
VALUES ('다음에 또 가서 다음엔 피카츄 접시 만들거예요!', 5, 29, 7, 1, NOW(), NOW());
INSERT IGNORE INTO  review (content, score, member_id, class_id, use_flag, created_at, updated_at)
VALUES ('전에도 와서 올라프 접시 만들어서 잘 쓰고 있는데 이번엔 곰돌이 만들었어요!', 5, 24, 7, 1, NOW(), NOW());
INSERT IGNORE INTO  review (content, score, member_id, class_id, use_flag, created_at, updated_at)
VALUES ('진짜 너무너무 귀여워요 ㅜㅜㅜ', 5, 25, 7, 1, NOW(), NOW());
INSERT IGNORE INTO  review (content, score, member_id, class_id, use_flag, created_at, updated_at)
VALUES ('친구들한테 추천해줄거예요 커플로 와도 좋을거 같아요!', 5, 26, 7, 1, NOW(), NOW());
INSERT IGNORE INTO  review (content, score, member_id, class_id, use_flag, created_at, updated_at)
VALUES ('너무 친절하시고 어렵지 않게 제가 좋아하는 캐릭터 모양을 만들 수 있어서 좋은 클래스였어요', 5, 27, 7, 1, NOW(), NOW());
INSERT IGNORE INTO  review (content, score, member_id, class_id, use_flag, created_at, updated_at)
VALUES ('긴말 않겠습니다. 최곱니다.', 5, 28, 7, 1, NOW(), NOW());
INSERT IGNORE INTO  review (content, score, member_id, class_id, use_flag, created_at, updated_at)
VALUES ('쉽게 다양한 캐릭터들을 제시해주시니 좋았네요', 4, 29, 7, 1, NOW(), NOW());
INSERT IGNORE INTO  review (content, score, member_id, class_id, use_flag, created_at, updated_at)
VALUES ('위치가 골목이라 조금 헤맸어요 잘 만들고 갑니다~', 4, 24, 7, 1, NOW(), NOW());
INSERT IGNORE INTO  review (content, score, member_id, class_id, use_flag, created_at, updated_at)
VALUES ('선생님이 친절하셔서 좋았어요', 5, 25, 7, 1, NOW(), NOW());
INSERT IGNORE INTO  review (content, score, member_id, class_id, use_flag, created_at, updated_at)
VALUES ('공방이 감각적이고 친절하셔소 좋아요', 5, 26, 8, 1, NOW(), NOW());
INSERT IGNORE INTO  review (content, score, member_id, class_id, use_flag, created_at, updated_at)
VALUES ('데이트 코스로 딱이에요 여자친구가 좋아해요 ㅎㅎ', 5, 27, 8, 1, NOW(), NOW());
INSERT IGNORE INTO  review (content, score, member_id, class_id, use_flag, created_at, updated_at)
VALUES ('부모님이랑 다녀왔는데 친절하셔서 부모님도 좋아하셨어요! 처음인데도 잘 가르쳐주져서 잘 만들고 왔습니다 ㅎㅎㅎ', 5, 28, 8, 1, NOW(), NOW());
INSERT IGNORE INTO  review (content, score, member_id, class_id, use_flag, created_at, updated_at)
VALUES ('굿굿 좋아요', 5, 29, 8, 1, NOW(), NOW());
INSERT IGNORE INTO  review (content, score, member_id, class_id, use_flag, created_at, updated_at)
VALUES ('첫 도자기체험이었고, 예약도 혼자 진행한거라서 수업을 못따라가거나 혼자여서 소외될까 걱정했었어요.공방도 큰길가에 있어서 금방 찾을수있었고, 공방도 크고 무척이나 넓고 깨끗하고 선생님도 무척이나 친절하셨어요.', 5, 24, 8, 1, NOW(), NOW());
INSERT IGNORE INTO  review (content, score, member_id, class_id, use_flag, created_at, updated_at)
VALUES ('넓고 쾌적한 공간에, 배경음악도 좋아서 만드는 내내 분위기가 좋았어요.', 5, 25, 8, 1, NOW(), NOW());
INSERT IGNORE INTO  review (content, score, member_id, class_id, use_flag, created_at, updated_at)
VALUES ('평일이라 그런지 저랑 남자친구밖에 없어서 편하게 만들었어요', 5, 26, 8, 1, NOW(), NOW());
INSERT IGNORE INTO  review (content, score, member_id, class_id, use_flag, created_at, updated_at)
VALUES ('선생님이 멋지고 도자기가 친절해요', 5, 27, 8, 1, NOW(), NOW());
INSERT IGNORE INTO  review (content, score, member_id, class_id, use_flag, created_at, updated_at)
VALUES ('도자기가 친절해요 좋아요', 5, 28, 8, 1, NOW(), NOW());
INSERT IGNORE INTO  review (content, score, member_id, class_id, use_flag, created_at, updated_at)
VALUES ('좋은 경험이었습니다 감사합니다~', 5, 29, 8, 1, NOW(), NOW());
INSERT IGNORE INTO  review (content, score, member_id, class_id, use_flag, created_at, updated_at)
VALUES ('술쟁이 친구랑 커플 소주잔 만들었어요 ㅋㅋㅋ', 5, 24, 9, 1, NOW(), NOW());
INSERT IGNORE INTO  review (content, score, member_id, class_id, use_flag, created_at, updated_at)
VALUES ('다음엔 맥주잔 클래스 만들어주세요!!!', 5, 25, 9, 1, NOW(), NOW());
INSERT IGNORE INTO  review (content, score, member_id, class_id, use_flag, created_at, updated_at)
VALUES ('비즈도 있어서 예쁜거 선택해서 장식하면 아주 반짝반짝해요', 5, 26, 9, 1, NOW(), NOW());
INSERT IGNORE INTO  review (content, score, member_id, class_id, use_flag, created_at, updated_at)
VALUES ('모든 면에 참 좋은시간 보냈습니다^^', 4, 27, 9, 1, NOW(), NOW());
INSERT IGNORE INTO  review (content, score, member_id, class_id, use_flag, created_at, updated_at)
VALUES ('나중에 기회되면 가족과 같이 가고싶어요>.<', 5, 28, 9, 1, NOW(), NOW());
INSERT IGNORE INTO  review (content, score, member_id, class_id, use_flag, created_at, updated_at)
VALUES ('또 이용하고 싶어요', 5, 29, 9, 1, NOW(), NOW());
INSERT IGNORE INTO  review (content, score, member_id, class_id, use_flag, created_at, updated_at)
VALUES ('알차고 재밌는 수업이었습니다!', 4, 24, 9, 1, NOW(), NOW());
INSERT IGNORE INTO  review (content, score, member_id, class_id, use_flag, created_at, updated_at)
VALUES ('좋았지만 조금 비싼거 같아요', 3, 25, 9, 1, NOW(), NOW());
INSERT IGNORE INTO  review (content, score, member_id, class_id, use_flag, created_at, updated_at)
VALUES ('그저그랬어요', 3, 26, 9, 1, NOW(), NOW());
INSERT IGNORE INTO  review (content, score, member_id, class_id, use_flag, created_at, updated_at)
VALUES ('올해 제일 하고싶었던 일 중에 하나였는데 기대했던만큼 너무너무 좋았어요!', 5, 27, 9, 1, NOW(), NOW());
INSERT IGNORE INTO  review (content, score, member_id, class_id, use_flag, created_at, updated_at)
VALUES ('별로였어요', 4, 28, 9, 1, NOW(), NOW());
INSERT IGNORE INTO  review (content, score, member_id, class_id, use_flag, created_at, updated_at)
VALUES ('진부한 크리스마스 데이트가 아니라 색다른 경험이었어요 ㅎㅎ', 5, 29, 10, 1, NOW(), NOW());
INSERT IGNORE INTO  review (content, score, member_id, class_id, use_flag, created_at, updated_at)
VALUES ('모두 메리크리스마스~!', 5, 24, 10, 1, NOW(), NOW());
INSERT IGNORE INTO  review (content, score, member_id, class_id, use_flag, created_at, updated_at)
VALUES ('시설이 좋아요', 5, 25, 10, 1, NOW(), NOW());
INSERT IGNORE INTO  review (content, score, member_id, class_id, use_flag, created_at, updated_at)
VALUES ('잘 체험 했어요', 4, 26, 10, 1, NOW(), NOW());
INSERT IGNORE INTO  review (content, score, member_id, class_id, use_flag, created_at, updated_at)
VALUES ('만들기가 이렇게 재밌다니 새로운 취미가 생긴거 같아요', 5, 27, 10, 1, NOW(), NOW());
INSERT IGNORE INTO  review (content, score, member_id, class_id, use_flag, created_at, updated_at)
VALUES ('최고예요! 크리스마스임에도 사람이 많지 않아서 쾌적하게 했어요', 5, 28, 10, 1, NOW(), NOW());
INSERT IGNORE INTO  review (content, score, member_id, class_id, use_flag, created_at, updated_at)
VALUES ('크리스마스 말고도 다른 클래스도 해보고싶어요', 4, 29, 10, 1, NOW(), NOW());
INSERT IGNORE INTO  review (content, score, member_id, class_id, use_flag, created_at, updated_at)
VALUES ('너무 예뻐요 다른 것도 만들고 싶어요 ㅎㅎ', 5, 24, 10, 1, NOW(), NOW());
INSERT IGNORE INTO  review (content, score, member_id, class_id, use_flag, created_at, updated_at)
VALUES ('분위기가 좋아서 즐겁게 했습니다!', 5, 25, 10, 1, NOW(), NOW());
INSERT IGNORE INTO  review (content, score, member_id, class_id, use_flag, created_at, updated_at)
VALUES ('친절하게 알려주셨어요', 5, 26, 10, 1, NOW(), NOW());

## 리뷰 이미지
INSERT IGNORE INTO  review_image (image_file_name, sequence, review_id, use_flag, created_at, updated_at)
VALUES ('dojaki_review_1_1.jpeg', 1, 1, 1, NOW(), NOW());
INSERT IGNORE INTO  review_image (image_file_name, sequence, review_id, use_flag, created_at, updated_at)
VALUES ('dojaki_review_1_2.jpeg', 1, 2, 1, NOW(), NOW());
INSERT IGNORE INTO  review_image (image_file_name, sequence, review_id, use_flag, created_at, updated_at)
VALUES ('dojaki_review_1_3.jpeg', 1, 3, 1, NOW(), NOW());
INSERT IGNORE INTO  review_image (image_file_name, sequence, review_id, use_flag, created_at, updated_at)
VALUES ('dojaki_review_1_4.jpeg', 1, 4, 1, NOW(), NOW());
INSERT IGNORE INTO  review_image (image_file_name, sequence, review_id, use_flag, created_at, updated_at)
VALUES ('dojaki_review_1_5.jpeg', 1, 5, 1, NOW(), NOW());
INSERT IGNORE INTO  review_image (image_file_name, sequence, review_id, use_flag, created_at, updated_at)
VALUES ('dojaki_review_1_6.jpeg', 1, 6, 1, NOW(), NOW());
INSERT IGNORE INTO  review_image (image_file_name, sequence, review_id, use_flag, created_at, updated_at)
VALUES ('dojaki_review_1_7.jpeg', 1, 7, 1, NOW(), NOW());
INSERT IGNORE INTO  review_image (image_file_name, sequence, review_id, use_flag, created_at, updated_at)
VALUES ('dojaki_review_1_8.jpeg', 1, 8, 1, NOW(), NOW());
INSERT IGNORE INTO  review_image (image_file_name, sequence, review_id, use_flag, created_at, updated_at)
VALUES ('dojaki_review_1_9.jpeg', 1, 9, 1, NOW(), NOW());
INSERT IGNORE INTO  review_image (image_file_name, sequence, review_id, use_flag, created_at, updated_at)
VALUES ('dojaki_review_1_10.jpeg', 1, 10, 1, NOW(), NOW());
INSERT IGNORE INTO  review_image (image_file_name, sequence, review_id, use_flag, created_at, updated_at)
VALUES ('dojaki_review_2_1_1.jpeg', 1, 11, 1, NOW(), NOW());
INSERT IGNORE INTO  review_image (image_file_name, sequence, review_id, use_flag, created_at, updated_at)
VALUES ('dojaki_review_2_1.jpeg', 2, 11, 1, NOW(), NOW());
INSERT IGNORE INTO  review_image (image_file_name, sequence, review_id, use_flag, created_at, updated_at)
VALUES ('dojaki_review_2_2.jpeg', 1, 12, 1, NOW(), NOW());
INSERT IGNORE INTO  review_image (image_file_name, sequence, review_id, use_flag, created_at, updated_at)
VALUES ('dojaki_review_2_3.jpeg', 1, 13, 1, NOW(), NOW());
INSERT IGNORE INTO  review_image (image_file_name, sequence, review_id, use_flag, created_at, updated_at)
VALUES ('dojaki_review_2_4.jpeg', 1, 14, 1, NOW(), NOW());
INSERT IGNORE INTO  review_image (image_file_name, sequence, review_id, use_flag, created_at, updated_at)
VALUES ('dojaki_review_2_5.jpeg', 1, 15, 1, NOW(), NOW());
INSERT IGNORE INTO  review_image (image_file_name, sequence, review_id, use_flag, created_at, updated_at)
VALUES ('dojaki_review_2_6.jpeg', 1, 16, 1, NOW(), NOW());
INSERT IGNORE INTO  review_image (image_file_name, sequence, review_id, use_flag, created_at, updated_at)
VALUES ('dojaki_review_2_7.jpeg', 1, 17, 1, NOW(), NOW());
INSERT IGNORE INTO  review_image (image_file_name, sequence, review_id, use_flag, created_at, updated_at)
VALUES ('dojaki_review_2_8.jpeg', 1, 18, 1, NOW(), NOW());
INSERT IGNORE INTO  review_image (image_file_name, sequence, review_id, use_flag, created_at, updated_at)
VALUES ('dojaki_review_2_9.jpeg', 1, 19, 1, NOW(), NOW());
INSERT IGNORE INTO  review_image (image_file_name, sequence, review_id, use_flag, created_at, updated_at)
VALUES ('dojaki_review_2_10.jpeg', 1, 20, 1, NOW(), NOW());
INSERT IGNORE INTO  review_image (image_file_name, sequence, review_id, use_flag, created_at, updated_at)
VALUES ('dojaki_review_2_11.jpeg', 1, 21, 1, NOW(), NOW());
INSERT IGNORE INTO  review_image (image_file_name, sequence, review_id, use_flag, created_at, updated_at)
VALUES ('dojaki_review_3_1.jpeg', 1, 22, 1, NOW(), NOW());
INSERT IGNORE INTO  review_image (image_file_name, sequence, review_id, use_flag, created_at, updated_at)
VALUES ('dojaki_review_3_2.jpeg', 1, 23, 1, NOW(), NOW());
INSERT IGNORE INTO  review_image (image_file_name, sequence, review_id, use_flag, created_at, updated_at)
VALUES ('dojaki_review_3_3.jpeg', 1, 24, 1, NOW(), NOW());
INSERT IGNORE INTO  review_image (image_file_name, sequence, review_id, use_flag, created_at, updated_at)
VALUES ('dojaki_review_3_4.jpeg', 1, 25, 1, NOW(), NOW());
INSERT IGNORE INTO  review_image (image_file_name, sequence, review_id, use_flag, created_at, updated_at)
VALUES ('dojaki_review_3_5.jpeg', 1, 26, 1, NOW(), NOW());
INSERT IGNORE INTO  review_image (image_file_name, sequence, review_id, use_flag, created_at, updated_at)
VALUES ('dojaki_review_3_6.jpeg', 1, 27, 1, NOW(), NOW());
INSERT IGNORE INTO  review_image (image_file_name, sequence, review_id, use_flag, created_at, updated_at)
VALUES ('dojaki_review_3_7.jpeg', 1, 28, 1, NOW(), NOW());
INSERT IGNORE INTO  review_image (image_file_name, sequence, review_id, use_flag, created_at, updated_at)
VALUES ('dojaki_review_3_8.jpeg', 1, 29, 1, NOW(), NOW());
INSERT IGNORE INTO  review_image (image_file_name, sequence, review_id, use_flag, created_at, updated_at)
VALUES ('dojaki_review_3_9.jpeg', 1, 30, 1, NOW(), NOW());
INSERT IGNORE INTO  review_image (image_file_name, sequence, review_id, use_flag, created_at, updated_at)
VALUES ('dojaki_review_3_10.jpeg', 1, 31, 1, NOW(), NOW());
INSERT IGNORE INTO  review_image (image_file_name, sequence, review_id, use_flag, created_at, updated_at)
VALUES ('dojaki_review_3_11.jpeg', 1, 32, 1, NOW(), NOW());
INSERT IGNORE INTO  review_image (image_file_name, sequence, review_id, use_flag, created_at, updated_at)
VALUES ('dojaki_review_4_1.jpeg', 1, 33, 1, NOW(), NOW());
INSERT IGNORE INTO  review_image (image_file_name, sequence, review_id, use_flag, created_at, updated_at)
VALUES ('dojaki_review_4_2.jpeg', 1, 34, 1, NOW(), NOW());
INSERT IGNORE INTO  review_image (image_file_name, sequence, review_id, use_flag, created_at, updated_at)
VALUES ('dojaki_review_4_3.jpeg', 1, 35, 1, NOW(), NOW());
INSERT IGNORE INTO  review_image (image_file_name, sequence, review_id, use_flag, created_at, updated_at)
VALUES ('dojaki_review_4_4.jpeg', 1, 36, 1, NOW(), NOW());
INSERT IGNORE INTO  review_image (image_file_name, sequence, review_id, use_flag, created_at, updated_at)
VALUES ('dojaki_review_4_5.jpeg', 1, 37, 1, NOW(), NOW());
INSERT IGNORE INTO  review_image (image_file_name, sequence, review_id, use_flag, created_at, updated_at)
VALUES ('dojaki_review_4_6.jpeg', 1, 38, 1, NOW(), NOW());
INSERT IGNORE INTO  review_image (image_file_name, sequence, review_id, use_flag, created_at, updated_at)
VALUES ('dojaki_review_4_7.jpeg', 1, 39, 1, NOW(), NOW());
INSERT IGNORE INTO  review_image (image_file_name, sequence, review_id, use_flag, created_at, updated_at)
VALUES ('dojaki_review_4_8.jpeg', 1, 40, 1, NOW(), NOW());
INSERT IGNORE INTO  review_image (image_file_name, sequence, review_id, use_flag, created_at, updated_at)
VALUES ('dojaki_review_4_9.jpeg', 1, 41, 1, NOW(), NOW());
INSERT IGNORE INTO  review_image (image_file_name, sequence, review_id, use_flag, created_at, updated_at)
VALUES ('dojaki_review_4_10.jpeg', 1, 42, 1, NOW(), NOW());
INSERT IGNORE INTO  review_image (image_file_name, sequence, review_id, use_flag, created_at, updated_at)
VALUES ('dojaki_review_4_11.jpeg', 1, 43, 1, NOW(), NOW());
INSERT IGNORE INTO  review_image (image_file_name, sequence, review_id, use_flag, created_at, updated_at)
VALUES ('dojaki_review_5_1.jpeg', 1, 44, 1, NOW(), NOW());
INSERT IGNORE INTO  review_image (image_file_name, sequence, review_id, use_flag, created_at, updated_at)
VALUES ('dojaki_review_5_2.jpeg', 1, 45, 1, NOW(), NOW());
INSERT IGNORE INTO  review_image (image_file_name, sequence, review_id, use_flag, created_at, updated_at)
VALUES ('dojaki_review_5_3.jpeg', 1, 46, 1, NOW(), NOW());
INSERT IGNORE INTO  review_image (image_file_name, sequence, review_id, use_flag, created_at, updated_at)
VALUES ('dojaki_review_5_3_2.jpeg', 2, 46, 1, NOW(), NOW());
INSERT IGNORE INTO  review_image (image_file_name, sequence, review_id, use_flag, created_at, updated_at)
VALUES ('dojaki_review_5_4.jpeg', 1, 47, 1, NOW(), NOW());
INSERT IGNORE INTO  review_image (image_file_name, sequence, review_id, use_flag, created_at, updated_at)
VALUES ('dojaki_review_5_5.jpeg', 1, 48, 1, NOW(), NOW());
INSERT IGNORE INTO  review_image (image_file_name, sequence, review_id, use_flag, created_at, updated_at)
VALUES ('dojaki_review_5_5_2.jpeg', 2, 48, 1, NOW(), NOW());
INSERT IGNORE INTO  review_image (image_file_name, sequence, review_id, use_flag, created_at, updated_at)
VALUES ('dojaki_review_5_6.jpeg', 1, 49, 1, NOW(), NOW());
INSERT IGNORE INTO  review_image (image_file_name, sequence, review_id, use_flag, created_at, updated_at)
VALUES ('dojaki_review_5_7.jpeg', 1, 50, 1, NOW(), NOW());
INSERT IGNORE INTO  review_image (image_file_name, sequence, review_id, use_flag, created_at, updated_at)
VALUES ('dojaki_review_5_8.jpeg', 1, 51, 1, NOW(), NOW());
INSERT IGNORE INTO  review_image (image_file_name, sequence, review_id, use_flag, created_at, updated_at)
VALUES ('dojaki_review_5_9.jpeg', 1, 52, 1, NOW(), NOW());
INSERT IGNORE INTO  review_image (image_file_name, sequence, review_id, use_flag, created_at, updated_at)
VALUES ('dojaki_review_5_10.jpeg', 1, 53, 1, NOW(), NOW());
INSERT IGNORE INTO  review_image (image_file_name, sequence, review_id, use_flag, created_at, updated_at)
VALUES ('dojaki_review_5_11.jpeg', 1, 54, 1, NOW(), NOW());
INSERT IGNORE INTO  review_image (image_file_name, sequence, review_id, use_flag, created_at, updated_at)
VALUES ('dojaki_review_6_1.jpeg', 1, 55, 1, NOW(), NOW());
INSERT IGNORE INTO  review_image (image_file_name, sequence, review_id, use_flag, created_at, updated_at)
VALUES ('dojaki_review_6_2.jpeg', 1, 56, 1, NOW(), NOW());
INSERT IGNORE INTO  review_image (image_file_name, sequence, review_id, use_flag, created_at, updated_at)
VALUES ('dojaki_review_6_3.jpeg', 1, 57, 1, NOW(), NOW());
INSERT IGNORE INTO  review_image (image_file_name, sequence, review_id, use_flag, created_at, updated_at)
VALUES ('dojaki_review_6_4.jpeg', 1, 58, 1, NOW(), NOW());
INSERT IGNORE INTO  review_image (image_file_name, sequence, review_id, use_flag, created_at, updated_at)
VALUES ('dojaki_review_6_4_2.jpeg', 2, 58, 1, NOW(), NOW());
INSERT IGNORE INTO  review_image (image_file_name, sequence, review_id, use_flag, created_at, updated_at)
VALUES ('dojaki_review_6_5.jpeg', 1, 59, 1, NOW(), NOW());
INSERT IGNORE INTO  review_image (image_file_name, sequence, review_id, use_flag, created_at, updated_at)
VALUES ('dojaki_review_6_6.jpeg', 1, 60, 1, NOW(), NOW());
INSERT IGNORE INTO  review_image (image_file_name, sequence, review_id, use_flag, created_at, updated_at)
VALUES ('dojaki_review_6_7.jpeg', 1, 61, 1, NOW(), NOW());
INSERT IGNORE INTO  review_image (image_file_name, sequence, review_id, use_flag, created_at, updated_at)
VALUES ('dojaki_review_6_8.jpeg', 1, 62, 1, NOW(), NOW());
INSERT IGNORE INTO  review_image (image_file_name, sequence, review_id, use_flag, created_at, updated_at)
VALUES ('dojaki_review_6_9.jpeg', 1, 63, 1, NOW(), NOW());
INSERT IGNORE INTO  review_image (image_file_name, sequence, review_id, use_flag, created_at, updated_at)
VALUES ('dojaki_review_6_10.jpeg', 1, 64, 1, NOW(), NOW());
INSERT IGNORE INTO  review_image (image_file_name, sequence, review_id, use_flag, created_at, updated_at)
VALUES ('dojaki_review_7_1.jpeg', 1, 65, 1, NOW(), NOW());
INSERT IGNORE INTO  review_image (image_file_name, sequence, review_id, use_flag, created_at, updated_at)
VALUES ('dojaki_review_7_2.jpeg', 1, 66, 1, NOW(), NOW());
INSERT IGNORE INTO  review_image (image_file_name, sequence, review_id, use_flag, created_at, updated_at)
VALUES ('dojaki_review_7_3.jpeg', 1, 67, 1, NOW(), NOW());
INSERT IGNORE INTO  review_image (image_file_name, sequence, review_id, use_flag, created_at, updated_at)
VALUES ('dojaki_review_7_4.jpeg', 1, 68, 1, NOW(), NOW());
INSERT IGNORE INTO  review_image (image_file_name, sequence, review_id, use_flag, created_at, updated_at)
VALUES ('dojaki_review_7_5.jpeg', 1, 69, 1, NOW(), NOW());
INSERT IGNORE INTO  review_image (image_file_name, sequence, review_id, use_flag, created_at, updated_at)
VALUES ('dojaki_review_7_6.jpeg', 1, 70, 1, NOW(), NOW());
INSERT IGNORE INTO  review_image (image_file_name, sequence, review_id, use_flag, created_at, updated_at)
VALUES ('dojaki_review_7_7.jpeg', 1, 71, 1, NOW(), NOW());
INSERT IGNORE INTO  review_image (image_file_name, sequence, review_id, use_flag, created_at, updated_at)
VALUES ('dojaki_review_7_8.jpeg', 1, 72, 1, NOW(), NOW());
INSERT IGNORE INTO  review_image (image_file_name, sequence, review_id, use_flag, created_at, updated_at)
VALUES ('dojaki_review_7_9.jpeg', 1, 73, 1, NOW(), NOW());
INSERT IGNORE INTO  review_image (image_file_name, sequence, review_id, use_flag, created_at, updated_at)
VALUES ('dojaki_review_7_10.jpeg', 1, 74, 1, NOW(), NOW());
INSERT IGNORE INTO  review_image (image_file_name, sequence, review_id, use_flag, created_at, updated_at)
VALUES ('dojaki_review_8_1.jpeg', 1, 75, 1, NOW(), NOW());
INSERT IGNORE INTO  review_image (image_file_name, sequence, review_id, use_flag, created_at, updated_at)
VALUES ('dojaki_review_8_2.jpeg', 1, 76, 1, NOW(), NOW());
INSERT IGNORE INTO  review_image (image_file_name, sequence, review_id, use_flag, created_at, updated_at)
VALUES ('dojaki_review_8_3.jpeg', 1, 77, 1, NOW(), NOW());
INSERT IGNORE INTO  review_image (image_file_name, sequence, review_id, use_flag, created_at, updated_at)
VALUES ('dojaki_review_8_4.jpeg', 1, 78, 1, NOW(), NOW());
INSERT IGNORE INTO  review_image (image_file_name, sequence, review_id, use_flag, created_at, updated_at)
VALUES ('dojaki_review_8_5.jpeg', 1, 79, 1, NOW(), NOW());
INSERT IGNORE INTO  review_image (image_file_name, sequence, review_id, use_flag, created_at, updated_at)
VALUES ('dojaki_review_8_6.jpeg', 1, 80, 1, NOW(), NOW());
INSERT IGNORE INTO  review_image (image_file_name, sequence, review_id, use_flag, created_at, updated_at)
VALUES ('dojaki_review_8_7.png', 1, 81, 1, NOW(), NOW());
INSERT IGNORE INTO  review_image (image_file_name, sequence, review_id, use_flag, created_at, updated_at)
VALUES ('dojaki_review_8_8.jpeg', 1, 82, 1, NOW(), NOW());
INSERT IGNORE INTO  review_image (image_file_name, sequence, review_id, use_flag, created_at, updated_at)
VALUES ('dojaki_review_8_9.jpeg', 1, 83, 1, NOW(), NOW());
INSERT IGNORE INTO  review_image (image_file_name, sequence, review_id, use_flag, created_at, updated_at)
VALUES ('dojaki_review_8_10.jpeg', 1, 84, 1, NOW(), NOW());
INSERT IGNORE INTO  review_image (image_file_name, sequence, review_id, use_flag, created_at, updated_at)
VALUES ('dojaki_review_9_1.png', 1, 85, 1, NOW(), NOW());
INSERT IGNORE INTO  review_image (image_file_name, sequence, review_id, use_flag, created_at, updated_at)
VALUES ('dojaki_review_9_2.png', 1, 86, 1, NOW(), NOW());
INSERT IGNORE INTO  review_image (image_file_name, sequence, review_id, use_flag, created_at, updated_at)
VALUES ('dojaki_review_9_3.png', 1, 87, 1, NOW(), NOW());
INSERT IGNORE INTO  review_image (image_file_name, sequence, review_id, use_flag, created_at, updated_at)
VALUES ('dojaki_review_9_4.jpeg', 1, 88, 1, NOW(), NOW());
INSERT IGNORE INTO  review_image (image_file_name, sequence, review_id, use_flag, created_at, updated_at)
VALUES ('dojaki_review_9_5.png', 1, 89, 1, NOW(), NOW());
INSERT IGNORE INTO  review_image (image_file_name, sequence, review_id, use_flag, created_at, updated_at)
VALUES ('dojaki_review_9_6.png', 1, 90, 1, NOW(), NOW());
INSERT IGNORE INTO  review_image (image_file_name, sequence, review_id, use_flag, created_at, updated_at)
VALUES ('dojaki_review_9_7.png', 1, 91, 1, NOW(), NOW());
INSERT IGNORE INTO  review_image (image_file_name, sequence, review_id, use_flag, created_at, updated_at)
VALUES ('dojaki_review_9_8.png', 1, 92, 1, NOW(), NOW());
INSERT IGNORE INTO  review_image (image_file_name, sequence, review_id, use_flag, created_at, updated_at)
VALUES ('dojaki_review_9_9.png', 1, 93, 1, NOW(), NOW());
INSERT IGNORE INTO  review_image (image_file_name, sequence, review_id, use_flag, created_at, updated_at)
VALUES ('dojaki_review_9_10.png', 1, 94, 1, NOW(), NOW());
INSERT IGNORE INTO  review_image (image_file_name, sequence, review_id, use_flag, created_at, updated_at)
VALUES ('dojaki_review_9_11.png', 1, 95, 1, NOW(), NOW());
INSERT IGNORE INTO  review_image (image_file_name, sequence, review_id, use_flag, created_at, updated_at)
VALUES ('dojaki_review_10_1.jpeg', 1, 96, 1, NOW(), NOW());
INSERT IGNORE INTO  review_image (image_file_name, sequence, review_id, use_flag, created_at, updated_at)
VALUES ('dojaki_review_10_2.jpeg', 1, 97, 1, NOW(), NOW());
INSERT IGNORE INTO  review_image (image_file_name, sequence, review_id, use_flag, created_at, updated_at)
VALUES ('dojaki_review_10_3.jpeg', 1, 98, 1, NOW(), NOW());
INSERT IGNORE INTO  review_image (image_file_name, sequence, review_id, use_flag, created_at, updated_at)
VALUES ('dojaki_review_10_4.jpeg', 1, 99, 1, NOW(), NOW());
INSERT IGNORE INTO  review_image (image_file_name, sequence, review_id, use_flag, created_at, updated_at)
VALUES ('dojaki_review_10_5.jpeg', 1, 100, 1, NOW(), NOW());
INSERT IGNORE INTO  review_image (image_file_name, sequence, review_id, use_flag, created_at, updated_at)
VALUES ('dojaki_review_10_6.jpeg', 1, 101, 1, NOW(), NOW());
INSERT IGNORE INTO  review_image (image_file_name, sequence, review_id, use_flag, created_at, updated_at)
VALUES ('dojaki_review_10_7.png', 1, 102, 1, NOW(), NOW());
INSERT IGNORE INTO  review_image (image_file_name, sequence, review_id, use_flag, created_at, updated_at)
VALUES ('dojaki_review_10_8.png', 1, 103, 1, NOW(), NOW());
INSERT IGNORE INTO  review_image (image_file_name, sequence, review_id, use_flag, created_at, updated_at)
VALUES ('dojaki_review_10_9.png', 1, 104, 1, NOW(), NOW());
INSERT IGNORE INTO  review_image (image_file_name, sequence, review_id, use_flag, created_at, updated_at)
VALUES ('dojaki_review_10_10.jpeg', 1, 105, 1, NOW(), NOW());

## 게시글
INSERT IGNORE INTO  post (post_id, content, member_id, class_id, use_flag, created_at, updated_at)
VALUES (1, '도예공방의 고객님들 입니다 ^^ 다같이 즐겁게 체험하는 우리 고객님들과 함께 즐거운 도자기 만들기 어떠세요?', 3, 1, 1, NOW(), NOW());
INSERT IGNORE INTO  post (post_id, content, member_id, class_id, use_flag, created_at, updated_at)
VALUES (2, '도예가 마스터 클래스입니다. 저희 첫걸음 클래스를 넘어 보다 자유자재로 원하는 모양을 만들 수 있는 실력에 도전해보세요!', 3, 2, 1, NOW(), NOW());
INSERT IGNORE INTO  post (post_id, content, member_id, class_id, use_flag, created_at, updated_at)
VALUES (3, '희진공방의 내 손으로 만드는 도자기 클래스를 통해 멋진 도자기를 만들어보세요! :)', 2, 3, 1, NOW(), NOW());
INSERT IGNORE INTO  post (post_id, content, member_id, class_id, use_flag, created_at, updated_at)
VALUES (4, '물레를 이용해 화병, 컵, 청자 같은 다양한 소품을 만들 수 있답니다', 3, 4, 1, NOW(), NOW());
INSERT IGNORE INTO  post (post_id, content, member_id, class_id, use_flag, created_at, updated_at)
VALUES (5, '희진공방의 감각적이고 트렌디한 클래스로 예쁜 핸드페인팅 도자기를 만들었답니다', 2, 5, 1, NOW(), NOW());
INSERT IGNORE INTO  post (post_id, content, member_id, class_id, use_flag, created_at, updated_at)
VALUES (6, '클레이로 도자기를 꾸밀 수 있다? 어릴적 가지고 놀던 클레이에서 벗어나 나만의 예쁜 도자기로 탈바꿈 해보자!', 3, 6, 1, NOW(), NOW());
INSERT IGNORE INTO  post (post_id, content, member_id, class_id, use_flag, created_at, updated_at)
VALUES (7, '좋아하는 캐릭터를 접시로 만들어보자! 원하는 어떤 캐릭터든 도자기로 만들 수 있답니다. 핫한 강남역 공방으로 오세요!', 7, 7, 1, NOW(), NOW());
INSERT IGNORE INTO  post (post_id, content, member_id, class_id, use_flag, created_at, updated_at)
VALUES (8, '간단한 그릇부터 컵, 도자기까지 특별한 데이트를 원한다면 도예공방입니다!', 3, 8, 1, NOW(), NOW());
INSERT IGNORE INTO  post (post_id, content, member_id, class_id, use_flag, created_at, updated_at)
VALUES (9, '알코올 러버들을 위한 나만의 소주잔 세트 만들기! 너무 예쁘지 않나요? 선물로도 딱인 소주잔 세트! 이번 주말엔 소주잔 세트 만들기 어떠세요?', 7, 9, 1, NOW(), NOW());
INSERT IGNORE INTO  post (post_id, content, member_id, class_id, use_flag, created_at, updated_at)
VALUES (10, '연말을 장식할 연인과의 데이트. 뻔한 코스가 싫다면 함께 간직할 크리스마스 도자기 클래스가 있답니다. 둘만의 추억을 도자기로 빚어보세요', 7, 10, 1, NOW(), NOW());


## 게시글 이미지
INSERT IGNORE INTO  post_image (image_file_name, sequence, post_id, use_flag, created_at, updated_at)
VALUES ('dojaki_1_1_post.jpeg', 1, 1, 1, NOW(), NOW());
INSERT IGNORE INTO  post_image (image_file_name, sequence, post_id, use_flag, created_at, updated_at)
VALUES ('dojaki_2_3.jpeg', 1, 2, 1, NOW(), NOW());
INSERT IGNORE INTO  post_image (image_file_name, sequence, post_id, use_flag, created_at, updated_at)
VALUES ('dojaki_3_1.jpeg', 1, 3, 1, NOW(), NOW());
INSERT IGNORE INTO  post_image (image_file_name, sequence, post_id, use_flag, created_at, updated_at)
VALUES ('dojaki_3_2_post.png', 2, 3, 1, NOW(), NOW());
INSERT IGNORE INTO  post_image (image_file_name, sequence, post_id, use_flag, created_at, updated_at)
VALUES ('dojaki_4_2_post.jpeg', 1, 4, 1, NOW(), NOW());
INSERT IGNORE INTO  post_image (image_file_name, sequence, post_id, use_flag, created_at, updated_at)
VALUES ('dojaki_4_3_post.jpeg', 2, 4, 1, NOW(), NOW());
INSERT IGNORE INTO  post_image (image_file_name, sequence, post_id, use_flag, created_at, updated_at)
VALUES ('dojaki_4_4.png', 3, 4, 1, NOW(), NOW());
INSERT IGNORE INTO  post_image (image_file_name, sequence, post_id, use_flag, created_at, updated_at)
VALUES ('dojaki_5_1_post.jpeg', 1, 5, 1, NOW(), NOW());
INSERT IGNORE INTO  post_image (image_file_name, sequence, post_id, use_flag, created_at, updated_at)
VALUES ('dojaki_5_3.jpeg', 2, 5, 1, NOW(), NOW());
INSERT IGNORE INTO  post_image (image_file_name, sequence, post_id, use_flag, created_at, updated_at)
VALUES ('dojaki_5_4.jpeg', 3, 5, 1, NOW(), NOW());
INSERT IGNORE INTO  post_image (image_file_name, sequence, post_id, use_flag, created_at, updated_at)
VALUES ('dojaki_5_4_post.jpeg', 4, 5, 1, NOW(), NOW());
INSERT IGNORE INTO  post_image (image_file_name, sequence, post_id, use_flag, created_at, updated_at)
VALUES ('dojaki_6_1_post.jpeg', 1, 6, 1, NOW(), NOW());
INSERT IGNORE INTO  post_image (image_file_name, sequence, post_id, use_flag, created_at, updated_at)
VALUES ('dojaki_6_2_post.jpeg', 2, 6, 1, NOW(), NOW());
INSERT IGNORE INTO  post_image (image_file_name, sequence, post_id, use_flag, created_at, updated_at)
VALUES ('dojaki_6_3_post.jpeg', 3, 6, 1, NOW(), NOW());
INSERT IGNORE INTO  post_image (image_file_name, sequence, post_id, use_flag, created_at, updated_at)
VALUES ('dojaki_7_1_post.jpeg', 1, 7, 1, NOW(), NOW());
INSERT IGNORE INTO  post_image (image_file_name, sequence, post_id, use_flag, created_at, updated_at)
VALUES ('dojaki_7_2_post.jpeg', 2, 7, 1, NOW(), NOW());
INSERT IGNORE INTO  post_image (image_file_name, sequence, post_id, use_flag, created_at, updated_at)
VALUES ('dojaki_7_3_post.jpeg', 3, 7, 1, NOW(), NOW());
INSERT IGNORE INTO  post_image (image_file_name, sequence, post_id, use_flag, created_at, updated_at)
VALUES ('dojaki_7_4_post.jpeg', 4, 7, 1, NOW(), NOW());
INSERT IGNORE INTO  post_image (image_file_name, sequence, post_id, use_flag, created_at, updated_at)
VALUES ('dojaki_8_1_post.jpeg', 1, 8, 1, NOW(), NOW());
INSERT IGNORE INTO  post_image (image_file_name, sequence, post_id, use_flag, created_at, updated_at)
VALUES ('dojaki_8_2_post.jpeg', 2, 8, 1, NOW(), NOW());
INSERT IGNORE INTO  post_image (image_file_name, sequence, post_id, use_flag, created_at, updated_at)
VALUES ('dojaki_9_3.jpeg', 1, 9, 1, NOW(), NOW());
INSERT IGNORE INTO  post_image (image_file_name, sequence, post_id, use_flag, created_at, updated_at)
VALUES ('dojaki_9_2.jpeg', 2, 9, 1, NOW(), NOW());
INSERT IGNORE INTO  post_image (image_file_name, sequence, post_id, use_flag, created_at, updated_at)
VALUES ('dojaki_10_4.jpeg', 1, 10, 1, NOW(), NOW());
INSERT IGNORE INTO  post_image (image_file_name, sequence, post_id, use_flag, created_at, updated_at)
VALUES ('dojaki_10_2_post.jpeg', 2, 10, 1, NOW(), NOW());
INSERT IGNORE INTO  post_image (image_file_name, sequence, post_id, use_flag, created_at, updated_at)
VALUES ('dojaki_10_3_post.jpeg', 3, 10, 1, NOW(), NOW());
